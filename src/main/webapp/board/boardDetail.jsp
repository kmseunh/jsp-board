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
        <title>Title</title>
    </head>
    <body>
    <h3>글 정보</h3>
    <p>번호: ${vo.num}</p>
    <p>제목: ${vo.title}</p>
    <p>작성자: ${vo.writer}</p>
    <p>내용: ${vo.content}</p>
    <p>등록일자: ${vo.regdate}</p>
    <p>조회수: ${vo.cnt}</p>
    <a href="<c:url value="editForm.jsp?num=${vo.num}"/> ">
        <button>수정</button>
    </a>
    <a href="<c:url value="deleteForm.jsp?num=${vo.num}"/> ">
        <button>삭제</button>
    </a>
    </body>
</html>
