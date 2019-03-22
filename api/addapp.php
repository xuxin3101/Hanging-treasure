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
$sql = "insert into apps(id,title,appname,price,img,readtime,logo,content,`time`) values (null,'$title','$appname',$price,'$img',10,'$logo','$content',now());";
$res= $mysqli->query($sql);
echo $res;}
else
echo "erro";
?>
