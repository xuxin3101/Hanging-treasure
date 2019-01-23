<?php
include('connect.php');
    $id=$_POST['id'];
    $sql = "select * from apps where id=$id";
    $res = $mysqli->query($sql);
    if (!$res) {
        die("sql error:\n" . $mysqli->error);
    }
    $row= $res->fetch_assoc();
    echo json_encode($row);
$mysqli->close();
?>
