<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>
<%request.setAttribute("path", request.getContextPath());%>
<!DOCTYPE html>
<html>
<head>
    <title>emplist</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${path}/css/style.css"/>
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
                Welcome&nbsp;&nbsp;&nbsp;&nbsp;<span style="color: red;">${loginuser.username}</span>!
            </h1>
            <table class="table">
                <tr class="table_header">
                    <td>
                        ID
                    </td>
                    <td>
                        Name
                    </td>
                    <td>
                        Operation(删除部门员工一并删除)
                    </td>
                </tr>
                <c:forEach items="${vo.depts}" var="dept">
                    <tr class="row1">
                        <td>
                                ${dept.id}
                        </td>
                        <td>
                                ${dept.name}
                        </td>
                        <td>
                            <a href="${path}/dept/delete?id=${dept.id}">delete dept</a>&nbsp;<a
                                href="${path}/dept/show?id=${dept.id}">update dept</a>&nbsp;<a
                                href="${path}/emp/findAll?did=${dept.id}">show emps</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <p>
                <input type="button" class="button" value="Add Dept" onclick="location='${path}/dept/addDept.jsp'"/>
            </p>
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
