<?php
include('connect.php');
if(!empty($_POST['username']))
{
$username=addslashes($_POST['username']);
$password=addslashes($_POST['password']);

$sql = "insert into users(id,username,password) values (null,'$username','$password')";
$res= $mysqli->query($sql);
echo $res;}
else
echo "erro";
$mysqli->close();
?>
