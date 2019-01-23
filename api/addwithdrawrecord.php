<?php
include('connect.php');
if(!empty($_POST['username']))
{
$username=addslashes($_POST['username']);
$amount=addslashes($_POST['amount']);
$alipay=addslashes($_POST['alipay']);
$name=addslashes($_POST['name']);
$bankplace=addslashes($_POST['bankplace']);
$bankaccount=addslashes($_POST['bankaccount']);
$sql = "begin;";
$res= $mysqli->query($sql);
$sql="select minwithwraw from minwithdraw";
$res= $mysqli->query($sql);
$row=$res->fetch_assoc();
$minvalue=$row['minwithwraw'];
if($amount<$minvalue){
    echo 'toolittle';
    return;
}

if($amount>getbalance($username,$mysqli)){
    echo 'notvalid';
    return;
}
$sql = "insert into withdraw_record(id,username,amount,alipay,name,state,`time`,bankplace,bankaccount) values (null,'$username',$amount,'$alipay','$name',0,now(),'$bankplace','$bankaccount');";
$res= $mysqli->query($sql);
$sql = "commit";
$res= $mysqli->query($sql);
echo $res;
}
else
echo "erro";
$mysqli->close();
function getbalance($u,$mysqli)
{
    $sql="select sum(price) price from commission_record where username='$u'";
    $res= $mysqli->query($sql);
    $row=$res->fetch_assoc();
    $amount=$row['price'];
    $sql="select sum(amount) amount from withdraw_record where username='$u'";
    $res= $mysqli->query($sql);
    $row=$res->fetch_assoc();
    $withdrawed=$row['amount'];
    $vaild=$amount-$withdrawed;
    return $vaild;
}
?>
