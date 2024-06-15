<%@ page contentType="text/html;charset=UTF-8" language="java" import="board.*"
         isELIgnored="false" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    BoardDao dao = new BoardDao();
    List<BoardVo> ls = dao.selectAll();
    pageContext.setAttribute("ls", ls);
%>

<html>
    <head>
        <title>게시글 목록</title>
    </head>
    <body>
    <h2>게시글 목록</h2>
    <table border="1">
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>조회수</th>
        </tr>
        <c:forEach var="board" items="${ls}">
            <tr>
                <td>${board.num}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/board/boardDetail.jsp?num=${board.num}">${board.title}
                </td>
                <td>${board.writer}</td>
                <td>${board.regdate}</td>
                <td>${board.cnt}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="<c:url value="registForm.jsp"/> ">
        <button>글 등록</button>
    </a>
    </body>
</html>
