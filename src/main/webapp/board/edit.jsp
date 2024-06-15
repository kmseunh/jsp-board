<%@ page contentType="text/html;charset=UTF-8" language="java" import="board.*"
         isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="vo" class="board.BoardVo"/>
<jsp:useBean id="dao" class="board.BoardDao"/>
<jsp:setProperty name="vo" property="*"/>
<%
    dao.update(vo);
    pageContext.setAttribute("vo", vo);
%>
<c:redirect url="boardDetail.jsp?num=${vo.num}"></c:redirect>
