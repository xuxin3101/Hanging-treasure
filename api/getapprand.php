<?php
include('connect.php');
//先检查今天的总收益是否到达阈值
$username=$_POST['username'];
    $sql="select sum(price) amount from commission_record where to_days(time) = to_days(now()) and username='$username';";
    $res = $mysqli->query($sql);
    $row= $res->fetch_assoc();
    $amount=$row['amount'];
    //获取每日最大金额minamount
    $sql="select * from minamount";
    $res = $mysqli->query($sql);
    $row= $res->fetch_assoc();
    $maxamount=$row['minamount'];
    if ($maxamount>$amount) {
        //判断是否在工作区间之内
        $sql="select * from noincometime";
        $res=$mysqli->query($sql);
        $row=$res->fetch_assoc();
        $starttime=$row['starttime'];
        $endtime=$row['endtime'];
        if (checkIsBetweenTime($starttime, $endtime)==0){
            $sql = "select * from apps ORDER BY  RAND() LIMIT 1";
            $res = $mysqli->query($sql);
            if (!$res) {
                die("sql error:\n" . $mysqli->error);
            }
            $row= $res->fetch_assoc();
            echo json_encode($row);

        }else{
            echo 'too many to failed get apps';

        }
      
    } else {//满足每日最大额
        echo 'too many to failed get apps';
    }
   
function checkIsBetweenTime($start, $end)
{
     $curTime = strtotime('now');//当前时分
    $assignTime1 = strtotime($start);//获得指定分钟时间戳，00:00
    $assignTime2 = strtotime($end);//获得指定分钟时间戳，01:00
    $assignTime1=$assignTime1-86400;
    $result = 0;
    if ($curTime > $assignTime1 && $curTime <$assignTime2) {
        return 1;
    }
    return $result;
}
