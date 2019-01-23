<?php
include('connect.php');
if(!empty($_POST['username']))
{
$appname=addslashes($_POST['appname']);
$price=addslashes($_POST['price']);
$username=addslashes($_POST['username']);
$sql = "insert into commission_record(id,appname,price,username,`time`) values (null,'$appname','$price','$username',now());";
$res= $mysqli->query($sql);
echo $res;}
else
echo "erro";
$mysqli->close();
?>
