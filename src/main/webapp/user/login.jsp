<%@ page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>
<%request.setAttribute("path", request.getContextPath());%>
<!DOCTYPE html>
<html>
<head>
    <title>login</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/css/style.css"/>
</head>

<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p>
                    2009/11/20
                    <br/>
                </p>
            </div>
            <div id="topheader">
                <h1 id="title">
                    <a href="#">main</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                <img src="${pageContext.request.contextPath}/img/header_logo.gif"/>
            </h1>
            <form action="${path}/user/login" method="post">
                <table cellpadding="0" cellspacing="0" border="0"
                       class="form_table">
                    <tr>
                        <td valign="middle" align="right">
                            username:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="username"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            password:(使用MD5+salt模式)
                        </td>
                        <td valign="middle" align="left">
                            <input type="password" class="inputgri" name="password"/>
                        </td>
                    </tr>
                </table>
                <p>
                    <input type="submit" class="button" value="Submit &raquo;"/>
                    <input type="button" value="注册"
                           onclick="location='${pageContext.request.contextPath}/user/regist.jsp'">
                </p>
            </form>
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">
            ABC@126.com
        </div>
    </div>
</div>
</body>
</html>
