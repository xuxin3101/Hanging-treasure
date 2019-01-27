<?php
include('connect.php');
if(!empty($_POST['username']))
{
$username=addslashes($_POST['username']);
$idcard=addslashes($_POST['idcard']);
$alipayaccount=addslashes($_POST['alipayaccount']);
$name=addslashes($_POST['name']);
$bankaccount=addslashes($_POST['bankaccount']);
$bankplace=addslashes($_POST['bankplace']);
$password=addslashes($_POST['password']);
$id=addslashes($_POST['id']);
$maxincome=addslashes($_POST['maxincome']);
if($maxincome=='0'){
    $maxincome='null';
}
if($password){
    $sql = "update users set username='$username',idcard='$idcard',alipayaccount=$alipayaccount,alipayname='$name',bankaccount='$bankaccount',bankplace='$bankplace',password='$password',dailymaxincome=$maxincome where id=$id;";
}
else{
    $sql = "update users set username='$username',idcard='$idcard',alipayaccount=$alipayaccount,alipayname='$name',bankaccount='$bankaccount',bankplace='$bankplace',dailymaxincome=$maxincome where id=$id;";
}
$res= $mysqli->query($sql);
echo $res;}
else
echo "erro";
$mysqli->close();
?>
