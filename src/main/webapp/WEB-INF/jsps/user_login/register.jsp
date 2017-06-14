<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>用户注册</title>
    </head>

    <body style="text-align: center;">
        <form action="/user/registerProcess" method="post">
            <table width="60%" border="1">
                <tr>
                    <td>用户名</td>
                    <td>

                        <input type="text" name="userName">
                    </td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td>
                        <input type="password" name="userPwd">
                    </td>
                </tr>
                <tr>
                    <td>确认密码</td>
                    <td>
                        <input type="password" name="confirmPwd">
                    </td>
                </tr>


                <tr>
                    <td>
                        <input type="reset" value="清空">
                    </td>
                    <td>
                        <input type="submit" value="注册">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>