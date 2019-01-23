<?php
//header("Content-type:text/html;charset=utf-8");
$mysql_conf = array(
    'host'    => '127.0.0.1', 
    'db'      => 'Hanging-treasure', //数据库名称
    'db_user' => 'root', //用户名
    'db_pwd'  => '2ea7cf2b89bc5830', //密码
    );
$mysqli = @new mysqli($mysql_conf['host'], $mysql_conf['db_user'], $mysql_conf['db_pwd']);
if ($mysqli->connect_errno) {
    die("could not connect to the database:\n" . $mysqli->connect_error);//诊断连接错误
}
$mysqli->query("set names 'utf8';");//编码转化
$select_db = $mysqli->select_db($mysql_conf['db']);
if (!$select_db) {
    die("could not connect to the db:\n" .  $mysqli->error);
}
?>