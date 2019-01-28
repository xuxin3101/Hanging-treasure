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
                                <h2>管理员列表
                                    <small>管理员列表</small>
                                </h2>
                               
                                <div class="clearfix"></div>

                            </div>
                            <div class="x_title">
                                <form action="/Admin/Article/articleList" method="get">
                                    <div class="input-group">
                                        <input type="text" class="form-control" name="title" value="" placeholder="搜索">
                                        <span class="input-group-btn">
                                            <button class="btn btn-default" type="submit">搜索</button>
                                        </span>
                                    </div>
                                </form>
                                <div class="clearfix"></div>
                            </div>
                            <?php
                            include('../api/connect.php');
                            if(empty($_GET['page'])) {
                                $data=[];
                                $sql = "select * from adminusers;";
                                $res = $mysqli->query($sql);
                                if (!$res) {
                                    die("sql error:\n" . $mysqli->error);
                                }
                                ?>
                                
                                  
                                
                            

                            <div class="x_content">
                                <div class="table-responsive">
                                    <table class="table table-striped jambo_table bulk_action">
                                        <thead>
                                            <tr class="headings">
                                                <!--<th>-->
                                                <!--<input type="checkbox" id="check-all" class="flat">-->
                                                <!--</th>-->
                                                <th class="column-title" width="5%">编号</th>
                                                <th class="column-title" width="20%">用户名</th>
                                                <th class="column-title">操作</th>
                                            </tr>
                                        </thead>

                                        <tbody>
                                            <?php 
                                            while ($row= $res->fetch_assoc()) {
                                                ?>
                                            <tr class="even pointer">
                                                <td><?php echo $row['id']; ?></td>
                                                <td><?php echo $row['username']; ?></td>
                                                <td>
                                                    <a href="editadmin.php?id=<?php echo $row['id'];?>" class="btn btn-info btn-xs"><i
                                                            class="fa fa-pencil"></i> 编辑 </a>
                                                </td>
                                            </tr>
                                            <?php
                                            }}?>
                                        </tbody>
                                        <tr>
                                            <td colspan="10">
                                         
                                                <div class="f-right" style="float: right" id="page_go_url" data-url="/Admin/article/articleList">
                                                    总共<span style="font-weight:bold;margin:3px 3px 3px 3px;"> 1 </span>个记录&nbsp;&nbsp;&nbsp;
                                                    分为<span style="font-weight:bold;margin: 3px 3px 3px 3px;"> 1 </span>页&nbsp;&nbsp;&nbsp;
                                                    当前<span style="font-weight:bold;margin: 3px 3px 3px 3px;"> 1 </span>页&nbsp;&nbsp;&nbsp;
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
                                                    var recordCount = 114;
                                                    var pageCount = 8;
                                                    var page = 1;
                                                    var url = "admin.php";
                                                    var filter_new = [];
                                                    filter_new.status = '0';
                                                    filter_new.title = '';
                                                    filter_new.record_count = '114';
                                                    filter_new.page_size = '15';
                                                    filter_new.page = '1';
                                                    filter_new.page_count = '8';
                                                    filter_new.start = '0';
                                                    console.log(filter_new);
                                                    /**
                                                     * 第一页
                                                     */
                                                    function gotoPageFirst() {
                                                        if (page == 1) {
                                                            alert("已经是第一页了哦");
                                                            return;
                                                        } else {
                                                            filter_new.start = 0;
                                                            filter_new.page = 1;
                                                            goSelect(filter_new);
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
                                                            filter_new['start'] = Math.floor(filter_new['start'] -
                                                                filter_new['page_size']);
                                                            filter_new['page'] = Math.floor(filter_new['page']) - 1;
                                                            goSelect(filter_new);

                                                        }
                                                    }

                                                    /**
                                                     * 下一页
                                                     */
                                                    function gotoPageNext() {

                                                        if (pageCount == 1) {
                                                            alert("总共就一页数据哦");
                                                            return;
                                                        } else if (page == pageCount) {
                                                            alert("已经是最后一页");
                                                            return;
                                                        } else {
                                                            filter_new['start'] = Math.floor(filter_new['start'] +
                                                                filter_new['page_size']);
                                                            filter_new['page'] = Math.floor(filter_new['page']) + 1;
                                                            goSelect(filter_new);
                                                        }
                                                    }
                                                    /**
                                                     * 最后一页
                                                     */
                                                    function gotoPageLast() {
                                                        if (pageCount == 1) {
                                                            alert("总共就一页数据哦");
                                                            return;
                                                        } else if (page == pageCount) {
                                                            alert("已经是最后一页");
                                                            return;
                                                        } else {
                                                            filter_new['start'] = Math.floor(filter_new['page_size'] *
                                                                (filter_new['page_count'] - 1));
                                                            filter_new['page'] = Math.floor(filter_new['page_count']);
                                                            goSelect(filter_new);
                                                        }
                                                    }

                                                    /**
                                                     * 开始查询
                                                     * @param filter_new
                                                     */
                                                    function goSelect(filter_new) {
                                                        var args = dealSearch(filter_new);
                                                        location.href = url + "?" + args;
                                                    }

                                                    function dealSearch(filter_new) {
                                                        var args = '';
                                                        for (var i in filter_new) {
                                                            if (typeof (filter_new[i]) != "function" && typeof (
                                                                    filter_new[i]) != "undefined") {
                                                                args += "&" + i + "=" + encodeURIComponent(filter_new[i]);
                                                            }
                                                        }
                                                        return args;
                                                    }

                                                    function deleteArticle(e) {
                                                        var url = "../api/deleteapp.php";
                                                        if (confirm("确定删除吗")) {
                                                            $.post(url,"id="+$(e).data('id'),function(res,statue){
                                                                res=res.trim();
                                                                if(res=="1"){
                                                                    ShowSuccess("删除成功..")
                                                                    location.href="admin.php"
                                                                }else{
                                                                    ShowFailure("删除失败")
                                                                    }

                                                            })
                                                           
                                                        }
                                                    }
                                                </script>
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


    <!-- jQuery -->
    <script src="js/jquery-1.11.1.min.js"></script>
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
</script>

</html>