<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/2/9
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../js/jquery-3.6.0.min.js"></script>
    <script>
        $(function (){
            $.ajax({
                url:"../stu?m=getCourse",
                dataType:"json",
                success:function (course){
                    for (const x of course) {
                        $("#course").append("<input type='checkbox' name='cids' class='cids' value="+x.id+">"+x.name);
                    }
                }
            })
            $(".btn").click(function (){
                $.ajax({
                    url: "../stu?m=insert",
                    data:$("#f").serialize(),
                    dataType: "json",
                    success:function (resp){
                        if (resp){
                            location = "../stu?m=queryAll";
                        }
                    }
                })
            })
        })
    </script>
</head>
<body>
    <form id="f">
        <table>
            <tr>
                <td>姓名</td>
                <td>
                    <input type="hidden" id="id" name="id">
                    <input type="text" id="name" name="name">
                </td>
            </tr>
            <tr>
                <td>性别</td>
                <td>
                    <input type="radio" class="sex" name="sex" value="男">男
                    <input type="radio" class="sex" name="sex" value="女">女
                </td>
            </tr>
            <tr>
                <td>年龄</td>
                <td>
                    <input type="text" id="age" name="age">
                </td>
            </tr>
            <tr>
                <td>课程</td>
                <td id="course">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="button" class="btn" value="确定">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
