<?php
include('connect.php');


    $userid=$_POST['userid'];
    $tmpsql="insert into wallet(id,userid,balance) values(null,$userid,0)";
    $mysqli->query($tmpsql);
    //更新餘額
    /**
     * 總收益=餘額+已提現
     * 餘額=總收益-已提現
     */
    $tmpsql="select sum(a.price) price from commission_record a,users c where c.id=$userid and c.username=a.username";
    $tmpres= $mysqli->query($tmpsql);
    $tmprow=$tmpres->fetch_assoc();
    $amount=$tmprow['price'];//總收益
    $tmpsql="select balance from wallet where userid=$userid";
    $tmpres= $mysqli->query($tmpsql);
    $tmprow=$tmpres->fetch_assoc();
    $amount=$amount+$tmprow['balance'];
    $withdrawed=$tmprow['amount'];//已提現
    $balance=$amount-$withdrawed;
    $tmpsql="update wallet set balance=$balance where userid=$userid";
    $tmpres=$mysqli->query($tmpsql);
        //刪除操作
        if($tmpres){
            $tmpsql="delete a.* from commission_record a,users b where b.id=$userid and a.username=b.username and a.price!=0";
            $tmpres= $mysqli->query($tmpsql);
        }
    echo $userid;
   



