<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>삭제 확인</title>
    </head>
    <body>
    <%
        int num = Integer.parseInt(request.getParameter("num"));
    %>
    <form action="delete.jsp">
        <input type="hidden" value="<%=num%>" name="num">
        삭제 하시겠습니까? <br>
        <input type="submit" value="예">
    </form>
    </body>
</html>
