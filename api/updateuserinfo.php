<?php
include('connect.php');
if(!empty($_POST['username']))
{
$yuanmima=addslashes($_POST['yuanmima']);
$idcard=addslashes($_POST['idcard']);
$name=addslashes($_POST['name']);
$alipay=addslashes($_POST['alipay']);
$xiugaimima=addslashes($_POST['xiugaimima']);
$username=addslashes($_POST['username']);
$bankaccount=addslashes($_POST['bankaccount']);
$bankplace=addslashes($_POST['bankplace']);
//查询密码是否正确
$sql = "select * from users where username='$username' and password='$yuanmima';";
$res = $mysqli->query($sql);
$row= $res->fetch_assoc();
if($row){//密码验证正确
    //后续验证身份证号与姓名是否匹配
    if(!checkidandname($name,$idcard)){
        echo 'failed';
        return;
    }
    if(empty($xiugaimima)){
        $sql = "update users set idcard='$idcard',alipayaccount='$alipay',alipayname='$name',bankaccount='$bankaccount',bankplace='$bankplace' where username='$username';";
    }else{
        $sql = "update users set idcard='$idcard',alipayaccount='$alipay',alipayname='$name',password='$xiugaimima',bankaccount='$bankaccount',bankplace='$bankplace' where username='$username';";
    } 
    $res= $mysqli->query($sql);
    echo $res;
}else{
    echo 'password error';
    }
}
else
echo "erro";
$mysqli->close();

function checkidandname($_name,$_idcard){
    if(empty($_name)||empty($_idcard)){
        return false;
    }
    $host = "https://idenauthen.market.alicloudapi.com";
    $path = "/idenAuthentication";
    $method = "POST";
    $appcode = "00c14b3c24ab4187a92409743a421018";
    $headers = array();
    array_push($headers, "Authorization:APPCODE " . $appcode);
    //根据API的要求，定义相对应的Content-Type
    array_push($headers, "Content-Type".":"."application/x-www-form-urlencoded; charset=UTF-8");
    $querys = "";
    $bodys = "idNo=$_idcard&name=".urlencode($_name);
    $url = $host . $path;
    $curl = curl_init();
    curl_setopt($curl, CURLOPT_CUSTOMREQUEST, $method);
    curl_setopt($curl, CURLOPT_URL, $url);
    curl_setopt($curl, CURLOPT_HTTPHEADER, $headers);
    curl_setopt($curl, CURLOPT_FAILONERROR, false);
    curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
    curl_setopt($curl, CURLOPT_HEADER, false);
    if (1 == strpos("$".$host, "https://"))
    {
        curl_setopt($curl, CURLOPT_SSL_VERIFYPEER, false);
        curl_setopt($curl, CURLOPT_SSL_VERIFYHOST, false);
    }
    curl_setopt($curl, CURLOPT_POSTFIELDS, $bodys);
    $str=curl_exec($curl);
    $str=json_decode($str);
    $statue=$str->{'respCode'};
    if($statue=="0000")
    return true;
    else
    return false;
}
?>