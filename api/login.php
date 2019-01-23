<?php
include('connect.php');
header("Access-Control-Allow-Origin: *");
$username=$_POST['username'];
$password=$_POST['password'];
    $sql = "select * from users where username='$username' and password='$password';";
    $res = $mysqli->query($sql);
    if (!$res) {
        die("sql error:\n" . $mysqli->error);
    }
$row= $res->fetch_assoc();
if($row){
    if($row['state']=='2'){
        echo '2';
        return;
    }
    $uniqid = md5(uniqid(microtime(true),true));
    $sql="update users set token='$uniqid' where username='$username';";
    $res = $mysqli->query($sql);
    $row['token']=$uniqid;
    echo json_encode($row);
  

}
else{
    echo "failed";
}

    
$mysqli->close();

?>

