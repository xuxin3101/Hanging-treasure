<?php
include('connect.php');
    $id=$_POST['id'];
    $sql = "update users set state=1 where id =$id";
    $res = $mysqli->query($sql);
    if (!$res) {
        die("sql error:\n" . $mysqli->error);
    }
    echo $res;
$mysqli->close();
?>

