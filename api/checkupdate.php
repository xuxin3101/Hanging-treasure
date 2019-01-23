<?php
include('connect.php');
$appkey=$_GET['appkey'];
$version=$_GET['version'];
    $sql = "select * from checkupdate order by id desc  ";
    $res = $mysqli->query($sql);
    if (!$res) {
        die("sql error:\n" . $mysqli->error);
    }
$row= $res->fetch_assoc();
$data=[];
    $data['Code']=0;
    $data['Msg']="";
    if($version==$row['new_version']){
        $data['UpdateStatus']=0;

    }else{
        $data['UpdateStatus']=2;

    }
    $data['VersionCode']=2; 
    $data['VersionName']=$row['new_version']; 
    $data['DownloadUrl']=$row['apk_file_url']; 
    $data['ModifyContent']=$row['update_log']; 
    $data['ApkSize']=(int)$row['target_size']; 
    $data['ApkMd5']=""; 

echo json_encode($data);

$mysqli->close();

?>

