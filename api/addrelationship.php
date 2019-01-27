<?php
include('connect.php');
if (!empty($_POST['superior'])) {
    $superior=addslashes($_POST['superior']);
    $subordinate=addslashes($_POST['subordinate']);
    $password=addslashes($_POST['password']);
    //上级与下级不允许相同
    if ($superior==$subordinate) {
        echo 'superior can not self';
        return ;
    }
    //先验证密码
    $sql="select * from users where username='$subordinate' and password='$password'";
    $res= $mysqli->query($sql);
    $row= $res->fetch_assoc();
    if ($row) {//密码验证通过
        $sql = "insert into relationship(id,superior,subordinate) values (null,'$superior','$subordinate');";
        $re= $mysqli->query($sql);
        $sql="insert into  commission_record(id,appname,price,username,`time`,subordinate) values (null,'收徒奖励',0.00,'$superior',now(),'$subordinate');";
        $res = $mysqli->query($sql);
        echo $re;
    } else {
        echo 'erro';
    }
} else {
    echo "erro";
}
$mysqli->close();
