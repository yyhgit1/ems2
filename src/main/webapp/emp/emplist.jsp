<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>
<%request.setAttribute("path", request.getContextPath());%>
<!DOCTYPE html>
<html>
<head>
    <title>emplist</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${path}/css/style.css"/>
    <link href="${path}/css/common.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="${path}/js/jquery-1.8.3.js"></script>
    <%--<script type="text/javascript">
        function msg() {
            return window.confirm("您确定要删除码?");

        }
    </script>--%>
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
                    <a href="${path}/dept/findAll">main</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                Welcome (当前登陆用户:${loginuser.username})!
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
                        Salary
                    </td>
                    <td>
                        Age
                    </td>
                    <td>
                        Bir
                    </td>
                    <td>
                        Dept
                    </td>
                    <td>
                        Operation(处理删除的友情提醒)
                    </td>
                </tr>
                <c:forEach items="${vo.emps}" var="emp">
                    <tr class="row1">
                        <td>
                                ${emp.id}
                        </td>
                        <td>
                                ${emp.name}
                        </td>
                        <td>
                                ${emp.salary}
                        </td>
                        <td>
                                ${emp.age}
                        </td>
                        <td>
                            <fmt:formatDate value="${emp.bir}" pattern="yyyy-MM-dd"/>
                        </td>
                        <td>
                                ${emp.dept.name}
                        </td>
                        <td>
                            <a href="${path}/emp/delete?id=${emp.id}&did=${emp.dept.id}"
                               onclick="return window.confirm('您确定要删除码？')">delete emp</a>&nbsp;<a
                                href="${path}/emp/showemp?id=${emp.id}">update emp</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <div class="pagination">
                <span class="firstPage">&nbsp;</span> <span class="previousPage">&nbsp;</span>
                <span class="currentPage">1</span> <a
                    href="javascript:$.pageSkip(2);">2</a> <a
                    href="javascript:$.pageSkip(3);">3</a> <span class="pageBreak">...</span>
                <a class="nextPage" href="javascript: $.pageSkip(2);">&nbsp;</a>
                <a class="lastPage" href="javascript: $.pageSkip(6);">&nbsp;</a>
                <span class="pageSkip"> 共6页 到第<input id="pageNumber"
                                                     name="pageNumber" value="1" maxlength="9"
                                                     onpaste="return false;">页
								<button type="submit">&nbsp;</button>
						</span>(请在全部功能完成后在处理分页)
            </div>
            <p>
                <input type="button" class="button" value="Add Employee" onclick="location='${path}/emp/addEmp.jsp'"/>
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
