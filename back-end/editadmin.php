<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>更新信息 </title>

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
                                    <img src="img/noavatar_middle.gif" alt=""><span id="usernamedis"></span><span class=" fa fa-angle-down"  ></span>
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
                                <h2>应用管理
                                    <small>应用列表</small>
                                </h2>
                               
                                <div class="clearfix"></div>

                            </div>
                        <div class="x_content">

                         <form  data-parsley-validate=""   class="form-horizontal form-label-left"
                              novalidate="">

                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">用户名 <span
                                        class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="text" id="u" name="username" required="required"
                                           class="form-control col-md-7 col-xs-12">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">密码 <span
                                        class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="password" id="p" name="password" required="required"
                                           class="form-control col-md-7 col-xs-12">
                                </div>
                            </div>
                           
                            
                            <div class="ln_solid"></div>


                        </form>
                        <div class="form-group">
                                <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                    <button class="btn btn-success" onclick="updateadmin()">提交</button>
                                </div>
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
    $("#u").val(username);
    $("#p").val(password);

  })
  $.post("../api/getappdetaile.php","id=<?php echo $_GET['id']; ?>",function(res,statue){
      if(typeof res=='string')
      res=JSON.parse(res.trim());
    $("#title").val(res.title)
    $("#company").val(res.company);
    $("#link").val(res.link);
    $("#price").val(res.price);
  })
  function updateadmin(){
      var username=$("#u").val();
      var password=$("#p").val();
      if(username==""||username==undefined){
        ShowFailure("请填用户名");
        return;
      }
      if(password==""||password==undefined){
        ShowFailure("请填密码");
        return;
      }
 
    
      $.post("../api/updateadmin.php","username="+username+"&password="+password+"&id=<?php echo $_GET['id']; ?>",function(res,statue){
          res=res.trim();
          if(res=="1"){
            ShowSuccess("更新成功..")
            setTimeout(function() {
                location.href="admin.php"
            }, 1000);
          }else{
            ShowFailure("发布失败")
          }
      })
  }
</script>

</html>