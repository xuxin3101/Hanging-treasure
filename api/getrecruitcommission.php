<?php
include('connect.php');
$username=addslashes($_POST['username']);
$data=[];
$sql = "select a.subordinate subordinate,sum(a.price) amount from commission_record a,relationship  b where b.superior='$username' and a.subordinate=b.subordinate;";
    $res = $mysqli->query($sql);
    if (!$res) {
        die("sql error:\n" . $mysqli->error);
    }
    while ($row= $res->fetch_assoc()) {
        array_push($data, $row);
    }
    echo json_encode($data);
$mysqli->close();
