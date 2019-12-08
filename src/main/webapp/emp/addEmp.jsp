<%@ page pageEncoding="UTF-8" contentType="text/html; UTF-8" isELIgnored="false" %>
<%request.setAttribute("path", request.getContextPath());%>
<!DOCTYPE html>
<html>
<head>
    <title>add Emp</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${path}/css/style.css"/>
    <script type="text/javascript" src="${path}/js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        $(function () {
            //页面加载完成之后立即发送ajax请求查询所有班级类型标签
            $.post("${pageContext.request.contextPath}/emp/showdepts", function (result) {
                //遍历
                $.each(result, function (i, dept) {
                    //创建option
                    var option = $("<option/>").val(dept.id).text(dept.name);
                    //添加option
                    $("#d").append(option);
                });
            }, "JSON");
        });
    </script>
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
                    <a href="#">Main</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                add Emp info:
            </h1>
            <form action="${path}/emp/add" method="post">
                <table cellpadding="0" cellspacing="0" border="0"
                       class="form_table">
                    <tr>
                        <td valign="middle" align="right">
                            name:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="name"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            salary:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="salary"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            age:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="age"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            bir:
                        </td>
                        <td valign="middle" align="left">
                            <input type="date" class="inputgri" name="bir"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            请选择部门:
                        </td>
                        <td valign="middle" align="left">
                            <select id="d" name="dept.id" style="width:178px;">
                                <option>请选择</option>
                            </select>
                        </td>
                    </tr>
                </table>
                <p>
                    <input type="submit" class="button" value="Confirm"/>
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
