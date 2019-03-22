<?php
include('connect.php');
header("Access-Control-Allow-Origin: *");
$username=$_POST['username'];
$password=$_POST['password'];
    $sql = "select * from adminusers where username='$username' and password='$password';";
    $res = $mysqli->query($sql);
    if (!$res) {
        die("sql error:\n" . $mysqli->error);
    }
$row= $res->fetch_assoc();
if($row){
    echo '1';
}
else{
    echo '0';
}
    

?>

