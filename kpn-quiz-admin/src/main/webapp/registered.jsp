<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <link rel=dns-prefetch href="//fonts.googleapis.com">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>ASEAN Quiz - KPN</title>
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link rel="icon" type="image/png" href="/resources/img/favicon/favicon.ico">

    <!-- CSS -->
    <link rel="stylesheet" href="resources/css/960gs/fluid.css">
    <link rel="stylesheet" href="resources/css/h5bp/normalize.css">
    <link rel="stylesheet" href="resources/css/h5bp/non-semantic.helper.classes.css">
    <link rel="stylesheet" href="resources/css/h5bp/print.styles.css">
    <link rel="stylesheet" href="resources/css/sprites.css">
    <link rel="stylesheet" href="resources/css/header.css">
    <link rel="stylesheet" href="resources/css/navigation.css">
    <link rel="stylesheet" href="resources/css/sidebar.css">
    <link rel="stylesheet" href="resources/css/content.css">
    <link rel="stylesheet" href="resources/css/footer.css">
    <link rel="stylesheet" href="resources/css/typographics.css">
    <link rel="stylesheet" href="resources/css/ie.fixes.css">
    <link rel="stylesheet" href="resources/css/sprite.forms.css">
    <link rel="stylesheet" href="resources/css/sprite.lists.css">
    <link rel="stylesheet" href="resources/css/icons.css">
    <link rel="stylesheet" href="resources/css/external/jquery-ui-1.8.16.custom.css">
    <link rel="stylesheet" href="resources/css/sidebar.css">

    <script>


    </script>
</head>

<body>

<!-- Begin of #height-wrapper -->
<div id="height-wrapper">
    <!-- Begin of header -->
    <header>
        <!-- Begin of the header toolbar -->
        <jsp:include page="toolbar.jsp"/>
        <!-- End of the header toolbar -->

        <!-- Start of the main header bar -->
        <jsp:include page="header.jsp"/>
        <div id="nav_sub"></div>
    </header>

    <!-- Start of the content -->
    <div role="main" class="container_12" id="content-wrapper">


        <!-- Start of the main content -->
        <div id="main_content">

            <h2 class="grid_12">Registration Successful - Congratulations!</h2>

            <div class="clean"></div>

            <div class="grid_12">
                <div class="box wizard" data-step="1">
                    <div class="header">
                        <img src="resources/img/icons/packs/fugue/16x16/application--arrow.png" alt="" width="16"
                             height="16">

                        <h3>Thank You!</h3>
                        <span></span>
                    </div>
                    <div class="content">
                        You have successfully completed your registration <br>
                        Please check your email as we have sent you all your right registration details.
                    </div>
                    <%--<div class="actions">
                        <div class="actions-left">
                            <button class="prev">
                                &laquo; Back
                            </button>
                        </div>
                        <div class="actions-right">
                            <button class="next">
                                Forward &raquo;
                            </button>
                        </div>
                    </div>--%>
                    <!-- End of .content -->
                    <div class="clear"></div>
                </div>
                <!-- End of .box -->
            </div>
            <!-- End of .grid_12 -->


        </div>
        <!-- End of #main_content -->
        <div class="push clear"></div>

    </div>
    <!-- End of #content-wrapper -->
    <div class="clear"></div>
    <div class="push"></div>
    <!-- BUGFIX if problems with sidebar in Chrome -->

</div>
<!-- End of #height-wrapper -->

<!-- Start of footer-->
<%--<footer>
    <div class="container_12">
        Copyright &copy; 2013 SSM, all rights reserved.
        <div id="button_bar">
            <ul>
                <li>
                    <span><a href="secure/dashboard.jsp">Dashboard</a></span>
                </li>
                <li>
                    <span><a href="/gate/in">Login</a></span>
                </li>
            </ul>
        </div>
    </div>
</footer>--%>
<!-- End of footer-->

<!-- JavaScript at the bottom for fast page loading -->
<!-- Grab Google CDN's jQuery + jQueryUI, with a protocol relative URL; fall back to local -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.js"></script>
<script>window.jQuery || document.write('<script src="resources/js/libs/jquery-1.7.1.js"><\/script>')</script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/jquery-ui.min.js"></script>
<script>window.jQuery.ui || document.write('<script src="resources/js/libs/jquery-ui-1.8.16.min.js"><\/script>')</script>

<script src="resources/js/libs/jquery-1.7.1.js"></script>

<!-- scripts concatenated and minified via build script -->
<script defer src="resources/js/plugins.js"></script>
<!-- REQUIRED: Different own jQuery plugnis -->
<script defer src="resources/js/mylibs/jquery.ba-resize.js"></script>
<!-- RECOMMENDED when using sidebar: page resizing -->
<script defer src="resources/js/mylibs/jquery.easing.1.3.js"></script>
<!-- RECOMMENDED: box animations -->
<script defer src="resources/js/mylibs/jquery.ui.touch-punch.js"></script>
<!-- RECOMMENDED: touch compatibility -->
<script defer src="resources/js/mylibs/jquery.chosen.js"></script>
<script defer src="resources/js/mylibs/jquery.validate.js"></script>
<script defer src="resources/js/script.js"></script>
<!-- REQUIRED: Generic scripts -->
<!-- end scripts -->

<script type="text/javascript">
    $(document).ready(function () {

        jQuery.validator.setDefaults({
            debug: true,
            success: "valid"
        });
        $("#loginForm").validate({

            messages: {
                passwordAgain: {
                    equalTo: "password fields have to match"
                }
            }
        });

        $('#username').blur(function () {

            var username = document.getElementById("username").value;
            var url = '<%=request.getContextPath() %>/register/validate/' + username;

            $('#username_status').html('<p>Validating username...</p>');
            $.ajax({
                url: url,
                success: function (data) {
                    $('#username_status').html(data);
                },
                error: function (data) {
                    $('#username_status').html('<p>An error occurred.</p>');
                }
            });
        });

    });

</script>

</body>
</html>
