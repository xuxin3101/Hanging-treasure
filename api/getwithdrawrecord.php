<?php
include('connect.php');
$username=addslashes($_POST['username']);
$data=[];
$sql = "select * from withdraw_record where username ='$username' order by id desc";
    $res = $mysqli->query($sql);
    if (!$res) {
        die("sql error:\n" . $mysqli->error);
    }
    while ($row= $res->fetch_assoc()) {
        array_push($data, $row);
    }
echo json_encode($data);
