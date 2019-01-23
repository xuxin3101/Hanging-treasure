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
    if($maxamount>$amount){
        $sql = "select * from apps ORDER BY  RAND() LIMIT 1";
        $res = $mysqli->query($sql);
        if (!$res) {
            die("sql error:\n" . $mysqli->error);
        }
        $row= $res->fetch_assoc();
        echo json_encode($row);

    }else{//满足每日最大额
        echo 'too many to failed get apps';
        
    }
   
$mysqli->close();
?>