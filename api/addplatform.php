<?php
include('connect.php');
if (!empty($_POST['title'])) {
    $title=addslashes($_POST['title']);
    $logo=addslashes($_POST['logo']);
    $content=addslashes($_POST['content']);
    $sql = "insert into platforms(id,title,img,content) values (null,'$title','$logo','$content');";
    $res= $mysqli->query($sql);
    echo $res;
} else {
    echo "erro";
}
$mysqli->close();
