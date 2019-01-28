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
$sql = "select sum(a.price) tuijian from commission_record a,relationship  b where b.superior='$username' and a.subordinate=b.subordinate;";
$res= $mysqli->query($sql);
$row=$res->fetch_assoc();
$obj['tuijian']=$row['tuijian'];
if($row['tuijian']==null){
    $obj['tuijian']=0;
}

$obj['withdrawed']=$withdrawed;
$obj['balance']=$amount-$withdrawed;
echo json_encode($obj);
?>