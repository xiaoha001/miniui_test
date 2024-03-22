<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        用户信息
    </title>
</head>

<body>
<table>

    <thead>
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>地址</th>
        <th>电话号码</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${users}" var="obj">
        <tr>
            <th>${obj.id}</th>
            <th>${obj.username}</th>
            <th>${obj.address}</th>
            <th>${obj.phone}</th>
        </tr>
    </c:forEach>
    </tbody>

</table>
</body>
</html>

