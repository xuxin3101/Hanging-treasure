<?php
include('connect.php');
echo checkIsBetweenTime('23:59:58','06:00:00');
function checkIsBetweenTime($start, $end)
{
    $curTime = strtotime('now');//当前时分
    $assignTime1 = strtotime($start);//获得指定分钟时间戳，00:00
    $assignTime2 = strtotime($end);//获得指定分钟时间戳，01:00
    $assignTime1=$assignTime1-86400;
    $result = 0;
    if ($curTime > $assignTime1 && $curTime <$assignTime2) {
        return 1;
    }
    return $result;
}