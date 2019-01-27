<?php
include('connect.php');
$username=$_POST['username'];
$sql="select sum(price) price from commission_record where to_days(`time`) = to_days(now()) and username='$username';";
$res = $mysqli->query($sql);
$row=$res->fetch_assoc();
$money=$row['price'];
$sql="select dailymaxincome maxincome from users where username='$username'";
$res = $mysqli->query($sql);
$row=$res->fetch_assoc();
$maxincome=$row['maxincome'];
if ($maxincome==null) {
    $sql="select * from minamount";
    $res = $mysqli->query($sql);
    $row=$res->fetch_assoc();
    $maxincome=$row['minamount'];
}
if($money>=$maxincome){
    echo '0';
}else{
    echo '1';
}