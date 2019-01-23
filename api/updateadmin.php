<?php
include('connect.php');
if(!empty($_POST['username']))
{
$username=addslashes($_POST['username']);
$password=addslashes($_POST['password']);
$id=addslashes($_POST['id']);
$sql = "update adminusers set username='$username',password='$password' where id=$id;";
$res= $mysqli->query($sql);
echo $res;}
else
echo "erro";
$mysqli->close();
?>
