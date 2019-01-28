<?php
include('connect.php');
$file = $_FILES['file'];
$name = $file['name'];
$username=addslashes($_POST['username']);
$token=addslashes($_POST['token']);
$picname1='';
for ($i=1;$i<=6;$i++) {
    $picname1.=chr(rand(97, 122));
}
$name=$picname1."".$name;

$type = strtolower(substr($name, strrpos($name, '.')+1));
$allow_type = array('jpg','jpeg','gif','png');
if (!in_array($type, $allow_type)) {
    return ;
}
if (!is_uploaded_file($file['tmp_name'])) {
    return ;
}
$upload_path =  dirname(dirname(__FILE__))."/qrcode/";
if (move_uploaded_file($file['tmp_name'], $upload_path.$name)) {
        $url='/qrcode/'.$name;
        $sql="update users set alipayqrcode='$url' where username='$username' and token='$token' and alipayqrcode is NULL";
        $res=$mysqli->query($sql);
        $data=[];
        if(mysqli_affected_rows($mysqli)){
            $data['result']="Success";
            $data['url']=$url;
        }else{
            $data['result']="failed";
            $data['url']="";
        }
        echo json_encode($data);
    
} else {
    echo "Failed!";
}
