<?php
include('connect.php');
$sql = "select * from announcement order by id desc limit 0,1;";
$res= $mysqli->query($sql);
$row=$res->fetch_assoc();
echo json_encode($row);
$mysqli->close();
?>
