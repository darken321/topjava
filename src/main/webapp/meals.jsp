<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html lang="ru">
<head>
    <title>Users</title>
    <style>
        table {
            border-collapse: collapse;
        }
        table, th, td {
            padding: 5px; /*Отступы внутри ячейки*/
            border: 2px solid black;
        }
    </style>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>meals jsp</h2>

<table style="padding: 10px;">
    <tr>
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach var="meal" items="${userMealWithExcess}">
            <tr style="color: ${meal.excess? 'red' : 'green' }">
            <td>${fn:replace(meal.dateTime,"T"," ")}</td>
            <td>${meal.description}</td>
            <td>${meal.calories}</td>
            <td>Изменить</td>
            <td>Удалить</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>