<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>应用管理 </title>

    <!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="new_admin/vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="new_admin/vendors/iCheck/green.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="new_admin/builde/css/custom.min.css" rel="stylesheet">
        <!-- jQuery -->
        <script src="js/jquery-1.11.1.min.js"></script>  
</head>

<body class="nav-md">
    <div class="container body">
        <div class="main_container">

            <!-- sidebar menu -->
            <style>
                .tags_new{
        -webkit-border-radius:2px;
        display:block;
        float: left;
        padding: 5px 9px;
        margin-right: 5px;
        font-weight: 500;
        margin-bottom: 5px;
        font-family: Helvetica;
        line-height:1;
        color: white;
    }
    .tag-default{
       background: grey!important;
    }
    .tag-success{
       background: #1ABB9C!important;
    }
    .tag-danger{
       background: #d43f3a!important;
    }
    .tag-warning{
       background: #eea236!important;
    }
    .tag-info {
        background: #46b8da!important;
    }
    .qrcode{height:5rem;
    width:5rem}
    img:-webkit-full-screen{
            width: 100%;
            height: 100%;
        }

        img:-ms-fullscreen {
            width: 100%;
            height: 100%;
        }
</style>
            <div class="col-md-3 left_col">
                <div class="left_col scroll-view">
                    <div class="navbar nav_title" style="border: 0;">
                        <a href="index.html" class="site_title"><i class="fa fa-paw"></i> <span>挂机宝</span></a>
                    </div>

                    <div class="clearfix"></div>
                    <!-- menu profile quick info -->
                    <div class="profile clearfix">
                        <div class="profile_pic">
                            <img src="img/noavatar_middle.gif" alt="..." class="img-circle profile_img">
                        </div>
                        <div class="profile_info">
                            <span>Welcome </span>
                            <h2 id="username">用户名</h2>
                        </div>
                    </div>
                    <!-- /menu profile quick info -->

                    <br />
                    <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                        <div class="menu_section">
                            <ul class="nav side-menu">
                                <li><a><i class="fa fa-home"></i> 应用管理 <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu">
                                        <li><a href="admin.php">
                                                应用列表 </a></li>
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-home"></i> 管理员管理 <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu">
                                        <li><a href="administrator.php">
                                                管理员列表 </a></li>
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-home"></i> 会员管理 <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu">
                                        <li><a href="memberlist.php">
                                                会员列表 </a></li>
                                        <li><a href="withdraw.php">
                                                会员提现 </a></li>
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-home"></i> 平台管理 <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu">
                                        <li><a href="platformlist.php">
                                                平台管理 </a></li>
                                    </ul>
                                </li>
                                <li><a><i class="fa fa-home"></i> 系统设置 <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu">
                                        <li><a href="systemsetting.php">
                                                系统设置 </a></li>
                                    </ul>
                                </li>
                            </ul>
                        </div>

                    </div>
                    <!-- /menu footer buttons -->
                    <div class="sidebar-footer hidden-small">
                        <a data-toggle="tooltip" data-placement="top" title="Settings">
                            <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                        </a>
                        <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                            <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
                        </a>
                        <a data-toggle="tooltip" data-placement="top" title="Lock">
                            <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
                        </a>
                        <a data-toggle="tooltip" data-placement="top" title="Logout" href="#" onclick="app.logout()">
                            <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
                        </a>
                    </div>
                    <!-- /menu footer buttons -->
                </div>
            </div>
            <!-- top navigation -->
            <div class="top_nav">
                <div class="nav_menu">
                    <nav>
                        <div class="nav toggle">
                            <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                        </div>

                        <ul class="nav navbar-nav navbar-right">
                            <li class="">
                                <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown"
                                    aria-expanded="false">
                                    <img src="img/noavatar_middle.gif" alt=""><span id="usernamedis"> <span class=" fa fa-angle-down"></span>
                                </a>
                                <ul class="dropdown-menu  pull-right">
                                    <li><a href="#" onclick="app.logout()"><i class="fa fa-sign-out pull-right"></i> 退出</a></li>
                                </ul>
                            </li>


                            <ul id="menu1" class="dropdown-menu list-unstyled msg_list" role="menu">
                                <li>
                                    <a>
                                        <span class="image"><img src="new_admin/production/images/img.jpg" alt="Profile Image" /></span>
                                        <span>
                                            <span>John Smith</span>
                                            <span class="time">3 mins ago</span>
                                        </span>
                                        <span class="message">
                                            Film festivals used to be do-or-die moments for movie makers. They were
                                            where...
                                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a>
                                        <span class="image"><img src="new_admin/production/images/img.jpg" alt="Profile Image" /></span>
                                        <span>
                                            <span>John Smith</span>
                                            <span class="time">3 mins ago</span>
                                        </span>
                                        <span class="message">
                                            Film festivals used to be do-or-die moments for movie makers. They were
                                            where...
                                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a>
                                        <span class="image"><img src="new_admin/production/images/img.jpg" alt="Profile Image" /></span>
                                        <span>
                                            <span>John Smith</span>
                                            <span class="time">3 mins ago</span>
                                        </span>
                                        <span class="message">
                                            Film festivals used to be do-or-die moments for movie makers. They were
                                            where...
                                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a>
                                        <span class="image"><img src="new_admin/production/images/img.jpg" alt="Profile Image" /></span>
                                        <span>
                                            <span>John Smith</span>
                                            <span class="time">3 mins ago</span>
                                        </span>
                                        <span class="message">
                                            Film festivals used to be do-or-die moments for movie makers. They were
                                            where...
                                        </span>
                                    </a>
                                </li>
                                <li>
                                    <div class="text-center">
                                        <a>
                                            <strong>See All Alerts</strong>
                                            <i class="fa fa-angle-right"></i>
                                        </a>
                                    </div>
                                </li>
                            </ul>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
            <!-- /top navigation -->
            <!-- /sidebar menu -->
            <!-- page content -->
            <div class="right_col" role="main">
                <!-- top tiles -->
                <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>会员提现
                                <small>会员提现列表</small>
                            </h2>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>搜索内容
                                </h2>
                                <span style="float: right;color: white" class="tags_new tag-warning"
                                      onclick="isHidden(this)">展开<i
                                        class="fa fa-arrow-down"></i>                                </span>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content" id="isHidden"
                            style="display: none"                            >

                            <!-- start form for validation -->
                            <form id="demo-form" method="get" action="/Admin/members/withdraw">
                                <div class="search">
                                    <label>手机号码 :</label>
                                    <input type="text" class="form-control" name="mobile"
                                           value=""/>
                                    <div class="clearfix"></div>
                                    <br/>
                                </div>

                                <div class="search">
                                    <div class="form-group">
                                        <label>提现状态</label>
                                        <select name="status" class="form-control">
                                            <option
                                            selected                                            value="0">全部</option>
                                            <option
                                                                                        value="5">待审核</option>
                                            <option
                                                                                        value="2">已拨款</option>
                                            <option
                                                                                        value="-1">已驳回</option>
                                        </select>
                                    </div>
                                    <div class="clearfix"></div>
                                    <br/>
                                </div>

                                <div class="search">
                                    <label style="float: left">申请时间 :</label>
                                    <input type="text" name="create_time" class="form-control config-demo"
                                           value=""
                                           class="form-control">
                                    <div class="clearfix"></div>
                                    <br/>
                                </div>
                                <div class="search">
                                    <label style="float: left">提现时间 :</label>
                                    <input type="text" name="finish_time" class="form-control config-demo"
                                           value=""
                                           class="form-control">
                                    <div class="clearfix"></div>
                                    <br/>
                                </div>
                                <div class="clearfix"></div>
                                <button class="btn btn-primary">搜索</button>
                                <a href="/Admin/Members/withdraw" class="btn btn-warning">取消搜索</a>
                            </form>
                            <!-- end form for validations -->

                        </div>
                        <div class="x_content">

                            <div class="table-responsive" id="listDiv">
                                <table class="table table-striped jambo_table bulk_action">
                        
                                    <thead>
                                    <tr class="headings">
                                        <th class="column-title">编号</th>
                                        <th class="column-title">账号</th>
                                        <th class="column-title">用户姓名</th>
                                        <th class="column-title">打款账户信息</th>
                                        <th class="column-title">提现金额</th>
                                        <th class="column-title">申请时间</th>
                                        <th class="column-title">提现状态</th>
                                        <th class="column-title">操作</th>
                                    </tr>
                                    </thead>

                                    <tbody>
                                    <?php
                                    include('../api/connect.php');
                                    
                                    if (empty($_GET['page'])) {
                                        $page='1';
                                    } else {
                                        $page=$_GET['page'];
                                    }
                                    $page=($page-1)*10;
                                    $data=[];
                                    $sql ="select count(*) c from withdraw_record";
                                    $res = $mysqli->query($sql);
                                    $row= $res->fetch_assoc();
                                    $count=$row['c'];
                                    $sql = "select * from withdraw_record order by id desc limit $page,10;";
                                    $res = $mysqli->query($sql);
                                    if (!$res) {
                                        die("sql error:\n" . $mysqli->error);
                                    }
                                    while ($row= $res->fetch_assoc()) {
                                        ?>
                                    <tr class="even pointer">
                                            <td><?php echo $row['id'] ?></td>
                                            <td><?php echo $row['username'] ?></td>
                                            <td><?php echo $row['name'] ?></td>
                                            <td>
                                                
                                                支付宝账户：<?php echo $row['alipay'] ?><br/>
                                                账户名：<?php echo $row['name'] ?><br/>
                                                银行开户地：<?php echo $row['bankplace'] ?><br />
                                                银行账户：<?php echo $row['bankaccount'] ?><br/>
                                                微&nbsp&nbsp信二维码：
                                                <img src ="..<?php echo $row['wechatqrcode']   ?>" class="qrcode"  onclick="displayphoto(this)"/><br/>
                                                支付宝二维码：<img src ="..<?php echo $row['alipayqrcode']   ?>"  class="qrcode" onclick="displayphoto(this)"/>
                                                    <!--付款码：-->
                                                    <!---->                                            </td>
                                            <td><?php echo $row['amount'] ?>                                                元                                            </td>
                                            <td><?php echo $row['time'] ?></td>
                                            <td>
                                                <span class='tags_new <?php
                                                if($row['state']==0)
                                                echo "tag-info";
                                                else if($row['state']==1)
                                                echo "tag-success";
                                                else{
                                                    echo "tag-danger";
                                                }
                                                ?>'><?php 
                                                if($row['state']==0)
                                                echo "待审核";
                                                else if($row['state']==1)
                                                echo "已拨款";
                                                else{
                                                    echo "已拒绝";
                                                }
                                                 ?></span>
                                                                                                </td>
                                            <td>
                                            <div <?php
                                             if($row['state']==1)
                                             echo "hidden";
                                             else if($row['state']==3){
                                                 echo "hidden";
                                             }
                                            ?>>
                                                <a href="javascript:;"
                                                       class="btn btn-success btn-xs" data-id="<?php echo $row['id'] ?>" onclick="bokuan(this)"><i class="fa fa-check" ></i>拨款
                                                    </a>
                                                    <a href="javascript:;"
                                                       class="btn btn-danger btn-xs" data-id="<?php echo $row['id'] ?>" onclick="jujue(this)"><i class="fa fa-remove"  ></i>拒绝
                                                    </a>
                                            </div>   
                                            </td>
                                        </tr>                  </tbody>
                                    <tr>
                                    <?php }?>
                                        <td colspan="12">
                                            <div class="f-right"style="float: right" id="page_go_url" data-url="">
    总共<span style="font-weight:bold;margin:3px 3px 3px 3px;"> <?php echo $count ?>  </span>个记录&nbsp;&nbsp;&nbsp;
    分为<span style="font-weight:bold;margin: 3px 3px 3px 3px;"> <?php echo (int)(($count-1)/10)+1 ?> </span>页&nbsp;&nbsp;&nbsp;
    当前<span style="font-weight:bold;margin: 3px 3px 3px 3px;">  <?php echo $page/10+1?> </span>页&nbsp;&nbsp;&nbsp;
    <button type="button" class="btn btn-white" onclick="gotoPageFirst();">第一页
    </button>
    <button type="button" class="btn btn-white" onclick="gotoPagePrev();">上一页
    </button>
    <button type="button" class="btn btn-white" onclick="gotoPageNext();">
        下一页
    </button>
    <button type="button" class="btn btn-white" onclick="gotoPageLast();">
        最后页
    </button>
</div>


<script type="text/javascript">

    // 分页数据 处理------------------------------开始----------------------
    
    function getpara() {
	var url = location.search
	var theRequest = new Object();
	if (url.indexOf("?") != -1) {
		var str = url.substr(1);
		strs = str.split("&");
		for (var i = 0; i < strs.length; i++) {
			theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
		}
	}
	return theRequest;
	}
    var page=getpara().page;
     if(page==undefined){
         page=1;
     }
     if(typeof page=='string'){
         page=parseInt(page);
     }
     var pageCount=<?php echo (int)(($count-1)/10)+1;  ?>
    /**
     * 第一页
     */
    function gotoPageFirst() {
        if (page == 1) {
            alert("已经是第一页了哦");
            return;
        } else {
            location.href="withdraw.php?page=1"
        }
    }

    /**
     * 上一页
     */
    function gotoPagePrev() {
        if (page == 1) {
            alert("已经是第一页了哦");
            return;
        } else {
         location.href="withdraw.php?page="+(page-1);

        }
    }

    /**
     * 下一页
     */
    function gotoPageNext() {

        if (pageCount == 1) {
            alert("总共就一页数据哦");
            return;
        }else if(page==pageCount){
            alert("已经是最后一页");
            return;
        }else {
            location.href="withdraw.php?page="+(page+1);
        }
    }
    /**
     * 最后一页
     */
    function  gotoPageLast() {
        if (pageCount == 1) {
            alert("总共就一页数据哦");
            return;
        }else if(page==pageCount){
            alert("已经是最后一页");
            return;
        }else {
            location.href="withdraw.php?page="+pageCount;
        }
    }

    /**
     * 开始查询
     * @param filter_new
     */
    function goSelect(filter_new) {
        var  args = dealSearch(filter_new);
        location.href = url + "?" + args;
    }
    function dealSearch(filter_new) {
        var args = '';
        for (var i in filter_new) {
            if (typeof(filter_new[i]) != "function" && typeof(filter_new[i]) != "undefined") {
                args += "&" + i + "=" + encodeURIComponent(filter_new[i]);
            }
        }
        return args;
    }
    function deleteArticle(e) {
        var url = "/Admin/article/deleteArticle";
        if(confirm("确定删除吗")){
            location.href=url+"?id="+$(e).data('id');
        }
    }
    function displayphoto(e){
        if (hasFullScreenElement()) {
            if (document.exitFullscreen) {
                document.exitFullscreen();
            }
            if (document.webkitExitFullscreen) {
                document.webkitExitFullscreen();
            }
            if (document.mozCancelFullScreen) {
                document.mozCancelFullScreen();
            }
            if (document.msExitFullscreen) {
                document.msExitFullscreen();
            }
        
                    } else {
                        if(e.requestFullscreen)
                        e.requestFullscreen();
                        if(e.webkitRequestFullscreen)
                        e.webkitRequestFullscreen();
                        if(e.mozRequestFullScreen)
                        e.mozRequestFullScreen()
                        if(e.msRequestFullscreen)
                        e.msRequestFullscreen();

                    }
    

    }
    function hasFullScreenElement() {
            return document.fullscreenElement || document.webkitFullscreenElement || document.mozFullScreenElement || document.msFullscreenElement
        }

</script>                                        </td>
                                        </td>
                                    </tr>
                                </table>
                            </div>


                        </div>
                    </div>
                </div>
            </div>

                <!-- /top tiles -->


                <br />

            </div>
            <!-- /page content -->

            <!-- footer content -->
            <!-- /footer content -->
        </div>
    </div>



    
    <!-- Bootstrap -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <!-- Custom Theme Scripts -->
    <script src="new_admin/builde/js/custom.min.js"></script>
    

</body>
<script src="js/alert.js"></script>
<script src="js/app.js"></script>
<script>
$(function () {
  app.checklogin();
  var username=app.getusername()
    $("#username").html(username)
    $("#usernamedis").html(username)
  })
  function bokuan(e){
    var url = "../api/bokuan.php";
    if (confirm("确定设置已拨款么")) {
    $.post(url,"id="+$(e).data('id'),function(res,statue){
     res=res.trim();
    if(res=="1"){
     ShowSuccess("设置成功..")
     location.href="withdraw.php"
   }else{
     ShowFailure("设置失败")
         }

     })
                                           
         }
  }
  function jujue(e){
    var url = "../api/jujue.php";
    if (confirm("确定设置拒绝么")) {
    $.post(url,"id="+$(e).data('id'),function(res,statue){
     res=res.trim();
    if(res=="1"){
     ShowSuccess("设置成功..")
     location.href="withdraw.php"
   }else{
     ShowFailure("设置失败")
         }

     })
                                           
         }
  }

</script>

</html>