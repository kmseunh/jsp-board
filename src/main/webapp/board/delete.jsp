<%@ page contentType="text/html;charset=UTF-8" language="java" import="board.*"
         isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="dao" class="board.BoardDao"/>
<%
    int num = Integer.parseInt(request.getParameter("num"));
    dao.delete(num);
%>
<c:redirect url="list.jsp"></c:redirect>
