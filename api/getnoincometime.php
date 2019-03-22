<?php
include('connect.php');
$sql = "select * from noincometime";
$res= $mysqli->query($sql);
$row=$res->fetch_assoc();
echo json_encode($row);
?>
