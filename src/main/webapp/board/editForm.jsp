<%@ page contentType="text/html;charset=UTF-8" language="java" import="board.*"
         isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="dao" class="board.BoardDao"/>
<%
    int num = Integer.parseInt(request.getParameter("num"));
    BoardVo vo = dao.selectOne(num);
    pageContext.setAttribute("vo", vo);
%>

<html>
    <head>
        <title>글 수정</title>
    </head>
    <body>
    <h3>수정하기</h3>
    <form action="edit.jsp" method="post">
        <input type="hidden" name="num" value="${vo.num}">
        <input type="text" name="title" value="${vo.title}" required/> <br>
        <input type="text" name="writer" value="${vo.writer}" required disabled/> <br>
        <textarea rows="4" cols="17" type="text" name="content"
                  placeholder="내용">${vo.content}</textarea>
        <input type="submit" value="수정"/>
    </form>
    </body>
</html>
