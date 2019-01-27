<?php
include('connect.php');
    $id=$_POST['id'];
    
    $sql = "select username,idcard,alipayaccount,alipayname,bankaccount,bankplace,dailymaxincome maxincome from users where id=$id";
    $res = $mysqli->query($sql);
    if (!$res) {
        die("sql error:\n" . $mysqli->error);
    }
    $row= $res->fetch_assoc();
    $data=$row;
    $username=$data['username'];
    $sql="select sum(amount) amount from withdraw_record where username='$username' and state=1";
    $res = $mysqli->query($sql);
    $row= $res->fetch_assoc();
    $data['withdrawed']=$row['amount'];
    if(!$data['withdrawed']){
        $data['withdrawed']=0;
    }
    $sql="select sum(price) price from commission_record where username='$username'";
    $res = $mysqli->query($sql);
    $row= $res->fetch_assoc();
    $data['income']=$row['price'];
    $sql="select sum(amount) amount from withdraw_record where username='$username'";
    $res = $mysqli->query($sql);
    $row= $res->fetch_assoc();
    $data['notwithdraw']=$data['income']-$row['amount'];
    if($data['maxincome']==null){
        $data['maxincome']=0;
    }
    echo json_encode($data);
$mysqli->close();
?>
