<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>글 등록</title>
    </head>
    <body>
    <h3>등록하기</h3>
    <form action="regist.jsp" method="post">
        <input type="text" name="title" placeholder="제목" required/> <br>
        <input type="text" name="writer" placeholder="작성자" required/> <br>
        <textarea rows="4" cols="17" type="text" name="content" placeholder="내용"></textarea>
        <input type="submit" value="등록"/>
    </form>
    </body>
</html>
