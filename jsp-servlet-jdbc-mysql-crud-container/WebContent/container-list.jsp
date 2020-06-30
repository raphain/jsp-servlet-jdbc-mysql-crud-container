<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Lista de Containers</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a class="navbar-brand"> Containers </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Lista de Containers</a></li>
                    </ul>
                </nav>
            </header>
            <br>

            <div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">Lista de Containers</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="<%=request.getContextPath()%>/" class="btn btn-success">Voltar</a>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                            	<th>ID</th>
                                <th>Número</th>
                                <th>Cliente</th>
                                <th>Tipo</th>
                                <th>Status</th>
                                <th>Categoria</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="container" items="${listContainer}">

                                <tr>
                                    <td>
                                        <c:out value="${container.idcontainer}" />
                                    </td>
                                    <td>
                                        <c:out value="${container.numero}" />
                                    </td>
                                    <td>
                                        <c:out value="${container.cliente}" />
                                    </td>
                                    <td>
                                        <c:out value="${container.tipo}" />
                                    </td>
                                    <td>
                                        <c:out value="${container.status}" />
                                    </td>
                                    <td>
                                        <c:out value="${container.categoria}" />
                                    </td>
                                    <td><a href="edit?idcontainer=<c:out value='${container.idcontainer}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?idcontainer=<c:out value='${container.idcontainer}' />">Delete</a></td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
            </div>
        </body>

        </html>