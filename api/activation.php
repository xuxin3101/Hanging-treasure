<?php
include('connect.php');
if(!empty($_POST['code']))
{
$code=addslashes($_POST['code']);
//查询是否存在
$sql="select * from activation where code='$code';";
$res= $mysqli->query($sql);
$row= $res->fetch_assoc();
if($row){
    $sql="delete from activation where code='$code';";
    $res= $mysqli->query($sql);
    echo $res;
}else{
    echo 'invaild';
    }

}
else
echo "erro";
$mysqli->close();
?>
