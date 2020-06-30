<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Cadastro de Containers</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a class="navbar-brand"> Terminal Santos </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Containers</a></li>
                        <li><a href="<%=request.getContextPath()%>/listMov" class="nav-link">Movimentação</a></li>
                        
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        
                        
                        <caption>
                            <h3>
                                <a href="<%=request.getContextPath()%>/new"> Inserir Container </a>
                            </h3>
                        	<br></br>    
                            <h3>
                                <a href="<%=request.getContextPath()%>/newMov"> Inserir Movimentação </a>
                            </h3>
                            <br></br>    
                            <h3>
                                <a href="<%=request.getContextPath()%>/relatorio"> Gerar Relatório </a>
                            </h3>
                        </caption>

						
						
                        
                        
                    </div>
                </div>
            </div>
        </body>

        </html>