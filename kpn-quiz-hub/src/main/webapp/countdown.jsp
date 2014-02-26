<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>ASEAN QUIZ - KPN</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jbclock.css" type="text/css"
          media="all"/>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/images/favicon/favicon.ico">
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jbclock.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            JBCountDown({
                secondsColor: "#378cff",
                secondsGlow: "none",

                minutesColor: "#378cff",
                minutesGlow: "none",

                hoursColor: "#378cff",
                hoursGlow: "none",

                daysColor: "#378cff",
                daysGlow: "none",

                startDate: ${sessionScope.startDate},
                endDate: ${sessionScope.endDate},
                now: ${sessionScope.now}
            });
        });
    </script>
    <style type="text/css">
        .image_container {
            width: 300px;
            text-align: center;
            line-height: 3;
            position: relative;
            left: 33%;
        }

        .image_container img {
            vertical-align: middle;
            float: left;
            opacity: 0.7;
        }

        .h1_title {
            color: #808080;
            font-family: 'Raleway', sans-serif;
            font-size: 30px;
            font-weight: normal;
            text-align: center;
            text-transform: uppercase;
        }
    </style>
</head>

<body>
<div class="wrapper" style="margin-top: 80px">
    <div class="image_container">
        <img src="assets/images/logo/header_with_ssm_logo.png" alt="ASEAN Quiz logo"/>

        <h1 class="h1_title">ASEAN QUIZ</h1>
    </div>
    <h4>We will be live in:</h4>

    <div class="clock">
        <div class="clock_days">
            <canvas id="canvas_days" height="190px" width="190px" id="canvas_days"></canvas>
            <div class="text">
                <p class="val">0</p>

                <p class="type_days">Days</p>
            </div>
        </div>
        <div class="clock_hours">
            <canvas height="190px" width="190px" id="canvas_hours"></canvas>
            <div class="text">
                <p class="val">0</p>

                <p class="type_hours">Hours</p>
            </div>
        </div>
        <div class="clock_minutes">
            <canvas height="190px" width="190px" id="canvas_minutes"></canvas>
            <div class="text">
                <p class="val">0</p>

                <p class="type_minutes">Minutes</p>
            </div>
        </div>
        <div class="clock_seconds">
            <canvas height="190px" width="190px" id="canvas_seconds"></canvas>
            <div class="text">
                <p class="val">0</p>

                <p class="type_seconds">Seconds</p>
            </div>
        </div>

    </div>
    <!--/clock -->
</div>
<!--/wrapper -->
</body>
</html>
