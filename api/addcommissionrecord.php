<?php
include('connect.php');
if (!empty($_POST['username'])) {
    $appname=addslashes($_POST['appname']);
    $price=addslashes($_POST['price']);
    $username=addslashes($_POST['username']);
    //先检查距离上次的任务记录的时间
    $sql="select * from commission_record where username='$username' order by id desc;";
    $res=$mysqli->query($sql);
    $row=$res->fetch_assoc();//上面倒叙查找，第一条就是最后一条插入的
    $pretime=$row['time'];
    $pretime=strtotime($pretime);
    //取出间隔时间
    $sql = "select * from cricletime";
    $res= $mysqli->query($sql);
    $row=$res->fetch_assoc();
    $cricletime=(int)$row['cricletime']*60;
    $nowtime=strtotime('now');
    if ($nowtime>=$pretime+$cricletime) {//合法的记录插入
        //判断是否在工作区间之内
        $sql="select * from noincometime";
        $res=$mysqli->query($sql);
        $row=$res->fetch_assoc();
        $starttime=$row['starttime'];
        $endtime=$row['endtime'];
        if (checkIsBetweenTime($starttime, $endtime)==0) {//等于0 不在无收益时间，允许收益
            //查询自己是否有上级
            $sql="select * from relationship where subordinate='$username'";
            $res=$mysqli->query($sql);
            $row=$res->fetch_assoc();
            if ($row) {//有上级
                $superior=$row['superior'];
                $sql = "insert into commission_record(id,appname,price,username,`time`) values (null,'$appname',$price,'$username',now());";
                $re= $mysqli->query($sql);
                //查询收益比率，并给上级加上
                $sql="select * from incomerate";
                $res = $mysqli->query($sql);
                $row=$res->fetch_assoc();
                $incomerate=$row['incomerate'];
                $price=(float)$price*(float)$incomerate;
                $sql="insert into  commission_record(id,appname,price,username,`time`,subordinate) values (null,'$appname',$price,'$superior',now(),'$username');";
                $res = $mysqli->query($sql);
                echo $re;
            } else {//无上级
                $sql = "insert into commission_record(id,appname,price,username,`time`) values (null,'$appname',$price,'$username',now());";
                $res= $mysqli->query($sql);
                echo $res;
            }
        } else {
            echo 'erro';
            return;
        }
    } else {//非法的记录插入，连续插入多条
        echo "erro";
    }
} else {
    echo "erro";
}
$mysqli->close();
function checkIsBetweenTime($start, $end)
{
    $date= date('H:i:S');
    $curTime = strtotime($date);//当前时分
    $assignTime1 = strtotime($start);//获得指定分钟时间戳，00:00
    $assignTime2 = strtotime($end);//获得指定分钟时间戳，01:00
    $time24=strtotime('23:59:59');
    $result = 0;
    if (($curTime < $time24 && $curTime >$assignTime1) || ($curTime>strtotime('00:00:00')&&$curTime<$assignTime2)) {
        return 1;
    }
    return $result;
}
