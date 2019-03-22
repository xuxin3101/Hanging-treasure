<?php
include('connect.php');
$data=[];
    $sql = "select * from platforms ORDER BY  id desc";
    $res = $mysqli->query($sql);
    if (!$res) {
        die("sql error:\n" . $mysqli->error);
    }
    while ($row= $res->fetch_assoc()) {
        array_push($data, $row);
    }
    echo json_encode($data);
