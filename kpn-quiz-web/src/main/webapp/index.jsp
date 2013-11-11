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
</head>

<body>

<!-- Begin of #height-wrapper -->
<div id="height-wrapper">
    <!-- Begin of header -->
    <header>
        <!-- Begin of the header toolbar -->
        <div id="header_toolbar">
            <div class="container_12">
                <h1 class="grid_8">ASEAN QUIZ</h1>

                <div class="grid_4">
                    <div class="toolbar_large">
                        <div class="toolbutton">
                            <div class="toolicon">
                                <img src="/resources/img/icons/16x16/user.png" width="16" height="16" alt="user">
                            </div>
                            <div class="toolmenu">
                                <div class="toolcaption">
                                    <span>Internal</span>
                                </div>
                                <!-- Start of menu -->
                                <div class="dropdown">
                                    <ul>
                                        <li>
                                            <a href="/gate/in">Login</a>
                                        </li>
                                    </ul>
                                </div>
                                <!-- End of menu -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End of the header toolbar -->

        <!-- Start of the main header bar -->
        <nav id="header_main">
            <div class="container_12">
                <ul id="nav_main">
                    <li class="current">
                        <a href="#"> <img src="resources/img/icons/25x25/dark/computer-imac.png" width=25 height=25
                                          alt="">
                            Home</a>
                        <ul>
                            <li class="current">
                                <a href="/index">Dashboard</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">
                            <img src="resources/img/icons/25x25/dark/address-book.png" width=25 height=25 alt="">
                            Literatures</a>
                        <ul>
                            <li>
                                <a href="/literature/about">About</a>
                            </li>
                            <li>
                                <a href="/literature/faq">FAQ</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">
                            <img src="resources/img/icons/25x25/dark/book-large.png" width=25 height=25 alt=""> Register</a>
                        <ul>
                            <li>
                                <a href="/register">Register</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
        <div id="nav_sub"></div>
    </header>

    <!-- Start of the content -->
    <div role="main" class="container_12" id="content-wrapper">
        <!-- Start of the sidebar -->
        <aside>
            <div id="sidebar_content">
                <p></p></div>
            <div class="divider"></div>
            <nav>
                <ul class="menu">
                    <li class="first-child current">
                        <a href="/index">Home</a>
                    </li>
                    <li>
                        <a href="/literature/about">About LLP</a>
                    </li>
                    <li class="last-child">
                        <a href="/register">Register</a>
                    </li>
                </ul>
            </nav>

        </aside>
        <!-- End of the sidebar-->

        <!-- Start of the main content -->
        <div id="main_content" style="min-height: 100%">
            <h2 class="grid_12">Search Your LLP Name</h2>

            <div class="clean"></div>


            <div class="grid_12">

                <c:choose>
                    <c:when test="${context.valid eq true}">
                        <div class="alert success">
                            Your choice of LLP name ${name} is available.
                            <ul>
                                <li>If you want RESERVE the name please login <a href="/gate/in">here </a> and reserve
                                    the name.
                                </li>
                                <li>
                                    Login is required.
                                </li>
                            </ul>
                        </div>
                    </c:when>
                    <c:when test="${context.valid eq false}">
                        <div class="alert error">
                            <strong>Sorry!</strong> Please pick a different name.
                            <p>${context.error}</p>
                        </div>
                    </c:when>
                    <c:otherwise>
                    </c:otherwise>
                </c:choose>


                <div class="box">
                    <div class="header">
                        <img src="/resources/img/icons/packs/fugue/16x16/application-search-result.png" alt=""
                             width="16"
                             height="16">

                        <h3>Search Form</h3>
                        <span></span>
                    </div>
                    <form action="/validate" class="validate">
                        <div class="content no-padding">
                            <div class="section _100">
                                <label for="name">
                                    Name
                                </label>

                                <div>
                                    <input class="required" name="name" id="name" value="${name}"
                                           style="text-transform: uppercase">
                                </div>
                            </div>
                            <div class="section _100">
                                <label for="type">
                                    Type
                                </label>

                                <div>
                                    <select name="type" id="type" class="required">
                                        <option selected>LLP</option>
                                        <option>ROB</option>
                                        <option>ROC</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <!-- End of .content -->
                        <div class="actions">
                            <div class="actions-right">
                                <input type="submit" value="Search"/>
                            </div>
                        </div>
                        <!-- End of .actions -->
                    </form>
                </div>
                <!-- End of .box -->
            </div>

            <div class="clear"></div>

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
<footer>
    <div class="container_12">
        Copyright &copy; 2013 ASEAN Quiz, all rights reserved.
        <div id="button_bar">
            <ul>
                <li>
                    <span><a href="/secure/dashboard.jsp">Dashboard</a></span>
                </li>
                <li>
                    <span><a href="/gate/in">Login</a></span>
                </li>
            </ul>
        </div>
    </div>
</footer>
<!-- End of footer-->

<!-- JavaScript at the bottom for fast page loading -->
<!-- Grab Google CDN's jQuery + jQueryUI, with a protocol relative URL; fall back to local -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.js"></script>
<script>window.jQuery || document.write('<script src="resources/js/libs/jquery-1.7.1.js"><\/script>')</script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/jquery-ui.min.js"></script>
<script>window.jQuery.ui || document.write('<script src="resources/js/libs/jquery-ui-1.8.16.min.js"><\/script>')</script>

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
</body>
</html>
