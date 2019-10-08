<%--
  Created by IntelliJ IDEA.
  User: Diego
  Date: 21/09/2019
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <title>Eventos</title>
</head>

<body>
<div class="jumbotron jumbotron-fluid bg-info text-white ">
    <div class="container">
        <h1 class="display-4"> Eventos </h1>
        </div>
</div>


<table class="table">

    <thead>
    <tr>
        <th scope="col"></th>
        <th scope="col">Actividades</th>
        <th scope="col">Lugar</th>
        <th scope="col"></th>
    </tr>
    </thead>

<tbody>

<c:forEach items="${eventos}" var="evento">
    </tr>
        <td>${evento.nombre}</td>
        <td>${evento.descripcion}</td>
        <td>${evento.lugar}</td>
        <td><img src="${evento.urlImagen}" width="300" class="rounded"></td>
    </tr>
</c:forEach>
</tbody>
</table>

</body>
</html>
