<?php
include('connect.php');
header("Access-Control-Allow-Origin: *");
$username=$_POST['username'];
$token=$_POST['token'];
    $sql = "select * from users where username='$username' and token='$token';";
    $res = $mysqli->query($sql);
    if (!$res) {
        die("sql error:\n" . $mysqli->error);
    }
$row= $res->fetch_assoc();
if($row){
    if($row['state']=='2'){
        echo '2';
    }
   echo '1';
}
else{
    echo "failed";
}

    

?>

