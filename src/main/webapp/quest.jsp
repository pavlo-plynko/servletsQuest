<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Servlet Quest</title>
</head>
<body>
<section>
    <a href="index.html">Начать заново</a>
    <h3>${step.description}</h3>

    <form action="${step.win || step.dead ? 'auth' : 'quest'}" method="get">
        <c:forEach items="${step.options}" var="option">
            <jsp:useBean id="option" type="com.codegym.servletTask.model.Step"/>
            <input type="radio" name="option" value="${option.id}">${option.answer}<br>
        </c:forEach>
        <button type="submit">${step.win || step.dead ? 'Сыграть еще' : 'Ответить'}</button>
    </form>
</section>
<br>
<br>
<br>
<br>
<br>
Статистика:<br>
Имя в игре: <i>${userName}</i><br>
IP address: <i>${ip}</i><br>
Количество игр: <i>${attempt}</i><br>
</body>
</html>