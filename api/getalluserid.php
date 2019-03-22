<?php
include('connect.php');
$sql="select id from users";
$res=$mysqli->query($sql);
$data=[];
while($row=$res->fetch_assoc()){
array_push($data,$row);
}
echo json_encode($data);

