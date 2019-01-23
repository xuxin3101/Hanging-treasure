<?php
include('connect.php');
$sql = "select * from minwithdraw";
$res= $mysqli->query($sql);
$row=$res->fetch_assoc();
echo json_encode($row);
$mysqli->close();
?>
