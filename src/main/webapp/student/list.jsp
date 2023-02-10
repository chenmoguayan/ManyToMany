<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/2/9
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
    <script>
        $(function (){
            $("#insert").click(function (){
                location = "student/insert.jsp";
            })
            $(".update").click(function (){
                location = "student/update.jsp?id=" + $(this).next().val();
            })
            $(".delete").click(function (){
                $.ajax({
                    url:"<%=request.getContextPath()%>/stu?m=delete",
                    data:{id:$(this).prev().val()},
                    dataType:"json",
                    success:function (resp){
                        if (resp){
                            location = "<%=request.getContextPath()%>/stu?m=queryAll";
                        }
                    }
                })
            })
        })
    </script>
</head>
<body>
    <table>
        <tr>
            <td></td>
            <td>学号</td>
            <td>姓名</td>
            <td>性别</td>
            <td>年龄</td>
            <td>课程</td>
            <td>
                <input type="button" value="添加" id="insert">
            </td>
        </tr>
        <c:forEach var="s" items="${list}">
            <tr>
                <td></td>
                <td>${s.id}</td>
                <td>${s.name}</td>
                <td>${s.sex}</td>
                <td>${s.age}</td>
                <td>
                    <c:forEach var="sc" items="${s.sc}">
                        ${sc.course.name}
                    </c:forEach>
                </td>
                <td>
                    <input type="button" value="修改" class="update">
                    <input type="hidden" value="${s.id}">
                    <input type="button" value="删除" class="delete">
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
