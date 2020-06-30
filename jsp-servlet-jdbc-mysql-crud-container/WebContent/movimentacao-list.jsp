<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Lista de Movimentações</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a class="navbar-brand"> Movimentação </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/listMov" class="nav-link">Lista de Movimentações</a></li>
                    </ul>
                </nav>
            </header>
            <br>

            <div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">Lista de Movimentações</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="<%=request.getContextPath()%>/" class="btn btn-success">Voltar</a>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                            	<th>ID</th>
                                <th>Navio</th>
                                <th>Tipo de Movimentação</th>
                                <th>Data Início</th>
                                <th>Data Final</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="container" items="${listMovimentacao}">

                                <tr>
                                    <td>
                                        <c:out value="${movimentacao.idmovimentacao}" />
                                    </td>
                                    <td>
                                        <c:out value="${movimentacao.navio}" />
                                    </td>
                                    <td>
                                        <c:out value="${movimentacao.tipomovimentacao}" />
                                    </td>
                                    <td>
                                        <c:out value="${container.dt_inicio}" />
                                    </td>
                                    <td>
                                        <c:out value="${container.dt_fim}" />
                                    </td>
                                    <td><a href="edit?idmovimentacao=<c:out value='${movimentacao.idmovimentacao}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?idmovimentacao=<c:out value='${movimentacao.idmovimentacao}' />">Delete</a></td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
            </div>
        </body>

        </html>