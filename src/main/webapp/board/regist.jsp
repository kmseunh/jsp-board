<%@ page contentType="text/html;charset=UTF-8" language="java" import="board.*"
         isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="vo" class="board.BoardVo"/>
<jsp:useBean id="dao" class="board.BoardDao"/>
<jsp:setProperty name="vo" property="*"/>
<%
    dao.insert(vo);
    //response.sendRedirect(request.getContextPath() + "/board/list.jsp");
%>
<c:redirect url="list.jsp"></c:redirect>
