<?php
include('connect.php');
if (!empty($_POST['username'])) {
    $username=addslashes($_POST['username']);
    $amount=addslashes($_POST['amount']);
    $alipay=addslashes($_POST['alipay']);
    $name=addslashes($_POST['name']);
    $bankplace=addslashes($_POST['bankplace']);
    $bankaccount=addslashes($_POST['bankaccount']);
    $alipayqrcode=addslashes($_POST['alipayqrcode']);
    $wechatqrcode=addslashes($_POST['wechatqrcode']);
    if (empty($alipayqrcode)) {
        $alipayqrcode="";
    }
    if (empty($wechatqrcode)) {
        $wechatqrcode="";
    }
    
    $sql = "begin;";
    $res= $mysqli->query($sql);
    $sql="select minwithwraw from minwithdraw";
    $res= $mysqli->query($sql);
    $row=$res->fetch_assoc();
    $minvalue=$row['minwithwraw'];
    if ($amount % 50 !=0) {
        echo '抱歉，只能体现50的倍数';
        return;
    }
    if ($amount<$minvalue) {
        echo 'toolittle';
        return;
    }
    $balance=getbalance($username, $mysqli);
    if ($amount>$balance || $balance <=0) {
        echo 'notvalid';
        return;
    }
    $sql = "insert into withdraw_record(id,username,amount,alipay,name,state,`time`,bankplace,bankaccount,alipayqrcode,wechatqrcode) values (null,'$username',$amount,'$alipay','$name',0,now(),'$bankplace','$bankaccount','$alipayqrcode','$wechatqrcode');";
    $res= $mysqli->query($sql);
    $sql = "commit";
    $res= $mysqli->query($sql);
    echo $res;
} else {
    echo "erro";
}
function getbalance($u, $mysqli)
{
    $sql="select sum(price) price from commission_record where username='$u'";
    $res= $mysqli->query($sql);
    $row=$res->fetch_assoc();
    $amount=$row['price'];
    $sql="select a.balance balance from wallet a,users b where b.username='$u' and b.id=a.userid";
    $res = $mysqli->query($sql);
    $row= $res->fetch_assoc();
    $amount=$amount+$row['balance'];
    $sql="select sum(amount) amount from withdraw_record where username='$u' for update";
    $res= $mysqli->query($sql);
    $row=$res->fetch_assoc();
    $withdrawed=$row['amount'];
    $vaild=$amount-$withdrawed;
    return $vaild;
}
