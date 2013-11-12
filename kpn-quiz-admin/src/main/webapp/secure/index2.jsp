<%--
  Created by IntelliJ IDEA.
  User: Faizal Abdul Manan
  Date: 11/10/13
  Time: 1:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Simple jsp page</title></head>
<body>

<table>
    <tr>
        <th>Student List</th>
    </tr>
    <tr>
        <td>Name</td>
        <td>:</td>
        <td>Student Name</td>
    </tr>
    <tr>
        <td>NRIC</td>
        <td>:</td>
        <td>Student NRIC</td>
    </tr>
    <tr>
        <td>Username</td>
        <td>:</td>
        <td>Student Username</td>
    </tr>
</table>

<form action="/register/add/student" method="POST">

    <input type="hidden" value="${instructorId}" name="instructorId"/>

    <table>
        <tr>
            <th>Register new student</th>
        </tr>
        <tr>
            <td>Name</td>
            <td>:</td>
            <td><input type="text" name="studentName" id="studentName"/></td>
        </tr>
        <tr>
            <td>NRIC</td>
            <td>:</td>
            <td><input type="text" name="studentNric" id="studentNric"/></td>
        </tr>
        <tr>
            <td>Username</td>
            <td>:</td>
            <td><input type="text" name="studentUsername" id="studentUsername"/></td>
        </tr>
        <tr>
            <td colspan="3"><input type="submit"/></td>
        </tr>
    </table>

</form>

<form action="regsiter/resetStudentPassword" method="POST">
    <input type="hidden" value="${instructorId}" name="instructorId"/>

    <table>
        <tr>
            <th>Change default password for all student</th>
        </tr>
        <tr>
            <td>New password</td>
            <td>:</td>
            <td><input type="password" name="password" id="password"/></td>
        </tr>
        <tr>
            <td>New password agamain</td>
            <td>:</td>
            <td><input type="password" name="passwordAgain" id="passwordAgain"/></td>
        </tr>
        <tr>
            <td colspan="3"><input type="submit"/></td>
        </tr>
    </table>

</form>

</body>
</html>