<?php
include('connect.php');
if (!empty($_POST['subordinate'])) {
    $subordinate=addslashes($_POST['subordinate']);
    //查询自己的上级
    $sql="select * from relationship where subordinate='$subordinate';";
    $res=$mysqli->query($sql);
    $row=$res->fetch_assoc();
    if($row){
        echo '1';
    }else{
        echo '0';
    }
  
} else {
    echo "erro";
}
$mysqli->close();
