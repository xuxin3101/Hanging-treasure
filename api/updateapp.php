<?php
include('connect.php');
if(!empty($_POST['title']))
{
$title=addslashes($_POST['title']);
$appname=addslashes($_POST['appname']);
$price=addslashes($_POST['price']);
$img=addslashes($_POST['img']);
$id=addslashes($_POST['id']);
$logo=addslashes($_POST['logo']);
$content=addslashes($_POST['content']);
$sql = "update apps set title='$title',appname='$appname',price=$price,img='$img',logo='$logo',content='$content' where id=$id;";
$res= $mysqli->query($sql);
echo $res;}
else
echo "erro";
$mysqli->close();
?>
