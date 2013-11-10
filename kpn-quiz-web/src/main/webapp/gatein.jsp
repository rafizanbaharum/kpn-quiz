<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">


<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Test</title>
    <meta name="gwt:property" content="locale=en">
    <link rel="SHORTCUT ICON" href="favicon.ico"/>

    <style type="text/css">
        body 	{
                margin-top: 0px;
                background-repeat: repeat-x;
             	}
    
    	form, p {
                margin: 0;
                padding: 0;
            	}
    
    
        div#logo h1 span {
                display: none;
            	}
    
        h1, h2 	{
                margin: 0;
                padding: 0;
            	}
    
        #container {
                width: 1000px;
                margin: 0 auto;
                padding-top: 19px;
                height: 220px
            	}
    
        label.smallInput {
                /*background: url(images/bg_s_input.gif) no-repeat;*/
                width: 168px;
            	}
    
        label.smallInput, label.mediumInput, label.largeInput {
                padding: 4px 6px 0px 6px;
                height: 23px;
                display: block;
                margin: 5px 0 0 0;
            	}
    
        label.smallInput input, label.mediumInput input, label.largeInput {
                background: none;
                border: none;
                font-size: 0.9em;
                color: #666;
            	}
    
         #loginForm {
                /*background: url(images/fs_login_bg.png) no-repeat;*/
                width: 460px;
                height: 160px;
                margin: 0 auto 0 auto;
                padding: 10px
            	}
    
         #loginForm h2 {
                color: #fff;
                display: block;
                width: 180px;
                float: left;
                font-size: 14pt;
                padding-left: 15px
            	}
    
    	  div#loginContainer {
                clear: both;
                width: 100%;
                padding-top: 25px;
                color: #666;
                padding-left: 15px
            	}
    
          p#user, p#pass, p#remember, p#submit {
                float: left;
                margin-right: 30px;
                margin-bottom: 20px
            	};
        </style>
    </head>
    <body background="images/headerGradient.png" >
    <table align="center" border="0" cellpadding="0" cellspacing="0" width="81%" bgcolor="#FFFFFF">
    <tr><td>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" >
        <tr background="images/headerGradient.png">
            <td align="left" ><img src="images/utm_ru_230.gif" width="280" height="100" /></td>
            <td align="right" valign="bottom">
                <table width="635">
                    <tr background="images/headerStripe.png" style="background-repeat:no-repeat ">
                        <td align="center" valign="top" height="30"><font size="3" face="Gill Sans MT" color="#FFFFFF"><b><u>U</u>niversiti  <u>T</u>eknologi  <u>M</u>alaysia  <u>F</u>inancial  <u>S</u>ystem  </b></font></td>
                    </tr>
                    <tr >
                        <td align="right" valign="middle" height="55"><font size="7" color="#5c001f"><b>QUIZ</b></font></td>
                    </tr>
                    <tr>
                        <td height="33" align="right" valign="bottom"><img src="images/inspiring-(2).png" width="370" height="31" /></td>
                    </tr>
                </table>
              </td>
        </tr>
        <tr background="images/backgroundMenu.png">
            <td colspan="2" height="52">&nbsp</td>
        </tr>
    </table>
    <div id="container">
    <div id="logo">
    </div>
    <form id="loginForm" action="/login" method="post">
        <h2>Login</h2>
        <div id="loginContainer">
	     <center><blink><font color="red" size="2">Id pengguna atau kata laluan salah</font></blink></center>
            <p id="user">Id pengguna :<br/>
                <label class="smallInput">
                    <input name="j_username" type="text" size="20" maxlength="20" value=""/>
                </label>
            </p>
            <p id="pass">Kata Laluan :<br/>
                <label class="smallInput">
                    <input name="j_password" type="password" size="20" maxlength="20" value=""/>
                </label>
            </p>
            <p id="remember" style="width:275px;"></p>
            <p id="submit">
                <label>
                    <input type="submit" value="Masuk" name="submit"/>
                </label>
            </p>
        </div>
    </form>
    </div>
    <table background="images/headerGradient.png" width="100%">
        <tr>
                <%--<td align="center" valign="middle" height="30"><font size="1" face="Arial" color="black">Copyright © 2012 Universiti Teknologi Malaysia--%>
        <%--Disclaimer :<br> This website has been updated to the best of our knowledge to be accurate. However, Universiti Teknologi Malaysia shall not be liable for any loss or damage caused by the usage of any information obtained from this web site</font></td>--%>
        </tr>
    </table></td></tr>
    </table>
    
    </body>
    </html>
    
    
    
