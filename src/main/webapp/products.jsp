<%@page import="ru.svetlov.webapp.domain.Product"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
caption   {
    font-size: 300%;
    margin: 20px;
    height:50px
}
table {
    width: 50%;
}
table, th, td {
  border: 2px solid black;
  border-collapse: collapse;
}
th, td {
  padding: 5px;
}
</style>
</head>
<body>
    <table>
        <caption>Products</caption>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Cost</th>
        </tr>
        <c:forEach var="p" items="${productList}">
            <tr>
                <td style="background-color:LightGray; text-align: center">${p.id}</td>
                <td style="background-color:LightSeaGreen">${p.name}</td>
                <td style="background-color:LightSalmon">${p.cost}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>