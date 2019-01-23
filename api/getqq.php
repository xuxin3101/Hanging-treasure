<?php
include('connect.php');
$sql="select * from qq";
$res = $mysqli->query($sql);
$row=$res->fetch_assoc();
$qq=$row['qq'];
echo $qq;
?>