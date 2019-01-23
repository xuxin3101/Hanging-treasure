<?php
include('connect.php');
$sql = "select * from cricletime";
$res= $mysqli->query($sql);
$row=$res->fetch_assoc();
echo json_encode($row);
$mysqli->close();
?>
