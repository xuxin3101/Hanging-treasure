<?php
include('connect.php');
    $id=$_POST['id'];
    $sql = "delete from apps where id =$id";
    $res = $mysqli->query($sql);
    if (!$res) {
        die("sql error:\n" . $mysqli->error);
    }
    echo $res;
?>

