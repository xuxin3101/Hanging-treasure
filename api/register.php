<?php
include('connect.php');
if(!empty($_POST['username']))
{
$username=addslashes($_POST['username']);
$name=addslashes($_POST['name']);
$idcard=addslashes($_POST['idcard']);
$alipay=addslashes($_POST['alipay']);
$password=addslashes($_POST['password']);
$bankaccount=addslashes($_POST['bankaccount']);
$bankplace=addslashes($_POST['bankplace']);
if(empty($idcard)){
    echo 'idcard is empty';
    return;
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
    $bodys = "idNo=$idcard&name=".urlencode($name);
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
    if($statue=="0000"){//身份匹配
        $sql="insert into users(id,username,password,idcard,alipayaccount,alipayname,bankaccount,bankplace) values(null,'$username','$password','$idcard','$alipay','$name','$bankaccount','$bankplace')";
        $res= $mysqli->query($sql);
        echo $res;

    }else{
        echo "notinvaild";
    }

}
else
echo "erro";
$mysqli->close();
?>
