<?php
include('connect.php');
$obj=array();
$username=addslashes($_POST['username']);
$sql="select sum(a.price) price from commission_record a where a.username='$username' ";
$res= $mysqli->query($sql);
$row=$res->fetch_assoc();
$amount=$row['price'];
$tmpsql="select a.balance from wallet a,users b where b.username='$username' and b.id=a.userid";
$tmpres= $mysqli->query($tmpsql);
$tmprow=$tmpres->fetch_assoc();
$amount=(double)$amount+(double)$tmprow['balance'];
$obj['amount']=round($amount,3);
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
$obj['balance']=round($obj['balance'],3);
echo json_encode($obj);
?>