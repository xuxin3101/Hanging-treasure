<?php
include('connect.php');
if (!empty($_POST['username'])) {
    $appname=addslashes($_POST['appname']);
    $price=addslashes($_POST['price']);
    $username=addslashes($_POST['username']);
    //先检查距离上次的任务记录的时间
    $sql="select * from commission_record where username='$username' order by id desc;";
    $res=$mysqli->query($sql);
    $row=$res->fetch_assoc();//上面倒叙查找，第一条就是最后一条插入的
    $pretime=$row['time'];
    $pretime=strtotime($pretime);
    //取出间隔时间
    $sql = "select * from cricletime";
    $res= $mysqli->query($sql);
    $row=$res->fetch_assoc();
    $cricletime=(int)$row['cricletime']*60;
    $nowtime=strtotime('now');
    if ($nowtime>=$pretime+$cricletime) {//合法的记录插入
        $sql = "insert into commission_record(id,appname,price,username,`time`) values (null,'$appname','$price','$username',now());";
        $res= $mysqli->query($sql);
        echo $res;
    } else {//非法的记录插入，连续插入多条
        echo "erro";
    }
} else {
    echo "erro";
}
$mysqli->close();
