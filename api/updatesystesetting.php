<?php
include('connect.php');
if(!empty($_POST['announce']))
{
$announce=addslashes($_POST['announce']);
$qq=addslashes($_POST['qq']);
$minwithdraw=addslashes($_POST['minwithdraw']);
$cricletime=addslashes($_POST['cricletime']);
$starttime=addslashes($_POST['starttime']);
$endtime=addslashes($_POST['endtime']);
$minamount=addslashes($_POST['minamount']);
$incomerate=addslashes($_POST['incomerate']);
$sql = "update announcement set content='$announce'";
$res= $mysqli->query($sql);
$sql ="update qq set qq='$qq'";
$res= $mysqli->query($sql);
$sql ="update minwithdraw set minwithwraw=$minwithdraw";
$res= $mysqli->query($sql);
$sql ="update cricletime set cricletime=$cricletime";
$res= $mysqli->query($sql);
$sql ="update noincometime set starttime='$starttime',endtime='$endtime'";
$res= $mysqli->query($sql);
$sql ="update minamount set minamount=$minamount";
$res= $mysqli->query($sql);
$sql ="update incomerate set incomerate=$incomerate";
$res= $mysqli->query($sql);
echo $res;}
else
echo "erro";
$mysqli->close();
?>
