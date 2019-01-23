<?php
include('connect.php');
$obj=array();
$username=addslashes($_POST['username']);
$sql="select sum(price) price from commission_record where username='$username'";
$res= $mysqli->query($sql);
$row=$res->fetch_assoc();
$amount=$row['price'];
$obj['amount']=$amount;
$sql="select sum(amount) amount from withdraw_record where username='$username'";
$res= $mysqli->query($sql);
$row=$res->fetch_assoc();
$withdrawed=$row['amount'];
$obj['withdrawed']=$withdrawed;
$obj['tuijian']=0;
$obj['balance']=$amount-$withdrawed;
echo json_encode($obj);
?>