<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>KPN:Quiz</title>
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <script>
    </script>
</head>

<body>

<!-- Begin of #height-wrapper -->
<div id="height-wrapper">
    <!-- Start of the content -->
    <div role="main" class="container_12" id="content-wrapper">
        <!-- Start of the main content -->
        <div id="main_content">
            <h2 class="grid_12">Register</h2>

            <div class="clean"></div>

            <div class="grid_12">
                <div class="box">
                    <div class="header">
                        <img src="resources/img/icons/packs/fugue/16x16/task-select-first.png" alt="" width="16"
                             height="16">

                        <h3>Registration Form</h3>
                        <span></span>
                    </div>
                    <form method="post" name="loginForm" id="loginForm" action="register" class="validate">
                        <div class="content">
                            <fieldset>
                                <legend>
                                    Login Information
                                </legend>
                                <div class="_50">
                                    <p>
                                        <label for="nameTxt">
                                            Name
                                        </label>
                                        <input type="text" id="nameTxt" value="" class="required fullname"
                                               name="fullName"
                                               class="text">
                                    </p>
                                </div>
                                <div class="_50">
                                    <p>
                                        <label for="nricNo">
                                            NRIC
                                        </label>
                                        <input type="text" value="" id="nricNo" class="required nric" name="nricNo"
                                               class="text">
                                    </p>
                                </div>
                                <div class="_50">
                                    <p>
                                        <label for="username">
                                            Username
                                        </label>
                                        <input type="text" value="" id="username" class="required username"
                                               maxlength="16"
                                               name="username" class="text">
                                    </p>
                                </div>
                                <div class="_50">
                                    <p>
                                        <label for="emailTxt">
                                            Email
                                        </label>
                                        <input type="text" value="" id="emailTxt" class="required email" name="email"
                                               class="text">
                                    </p>
                                </div>
                                <div class="_50">
                                    <p>
                                        <label for="password">
                                            Password
                                        </label>
                                        <input type="password" value="" id="password" class="required"
                                               name="password" class="text">
                                    </p>
                                </div>
                                <div class="_50">
                                    <p>
                                        <label for="passwordAgain">
                                            Password Again
                                        </label>
                                        <input type="password" value="" equalto="#password" id="passwordAgain"
                                               class="required" name="passwordAgain" class="text">
                                    </p>
                                </div>
                            </fieldset>
                            <fieldset>
                                <legend>
                                    Contact Information
                                </legend>
                                <div class="_50">
                                    <p>
                                        <label for="phone">
                                            Phone
                                        </label>
                                        <input type="text" value="" id="phone" name="phone" class="required phone text">
                                    </p>
                                </div>
                                <div class="_50">
                                    <p>
                                        <label for="fax">
                                            Fax
                                        </label>
                                        <input type="text" value="" id="fax" name="fax" class="required fax text">
                                    </p>
                                </div>
                            </fieldset>
                            <%--<fieldset>--%>
                                <%--<legend>--%>
                                    <%--Address Information--%>
                                <%--</legend>--%>
                                <%--<p class="inline-small-label">--%>
                                    <%--<label for="address1">--%>
                                        <%--Address--%>
                                    <%--</label>--%>
                                    <%--<input type="text" id="address1" name="address1" class="required text">--%>
                                <%--</p>--%>

                                <%--<p class="inline-small-label">--%>
                                    <%--<input type="text" name="address2" class="required text">--%>
                                <%--</p>--%>

                                <%--<p class="inline-small-label">--%>
                                    <%--<input type="text" name="address3" class="required text">--%>
                                <%--</p>--%>
                            <%--</fieldset>--%>
                        </div>
                        <div>
                            <fieldset>
                                <legend>
                                    State Information
                                </legend>
                                <p class="inline-small-label">
                                    <label for="stateId">
                                        State
                                    </label>
                                    <input type="text" id="stateId" name="stateId" class="required text"
                                           value="0">
                                </p>
                            </fieldset>
                        </div>
                        <div>
                            <fieldset>
                                <legend>
                                    District Information
                                </legend>
                                <p class="inline-small-label">
                                    <label for="districtId">
                                        District
                                    </label>
                                    <input type="text" id="districtId" name="districtId" class="required text"
                                           value="0">
                                </p>
                            </fieldset>
                        </div>
                        <div>
                            <fieldset>
                                <legend>
                                    School Information
                                </legend>
                                <p class="inline-small-label">
                                    <label for="schoolName">
                                        School
                                    </label>
                                    <input type="text" id="schoolName" name="schoolName" class="required text"
                                           value="0">
                                </p>
                            </fieldset>
                        </div>                        <div class="actions">
                            <div class="actions-left">
                                <input type="reset">
                            </div>
                            <div class="actions-right">
                                <input type="submit">
                            </div>
                        </div>
                    </form>
                </div>
                <!-- End of .box -->
            </div>
            <!-- End of .grid_6 -->

            <div class="clear"></div>

        </div>
        <!-- End of #main_content -->
        <div class="push clear"></div>

    </div>
    <!-- End of #content-wrapper -->
    <div class="clear"></div>
    <div class="push"></div>
</div>
<!-- End of #height-wrapper -->
</body>
</html>
