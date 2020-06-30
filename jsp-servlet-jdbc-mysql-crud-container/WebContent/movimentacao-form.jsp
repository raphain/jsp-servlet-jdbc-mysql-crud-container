<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
        <html>

        <head>
            <title>Cadastro de Movimentação</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
            <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
            
        </head>

        <body>
	
            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="<%=request.getContextPath()%>/" class="navbar-brand"> Cadastro de Movimentação </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/listMov" class="nav-link">Movimentações</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${movimentacao.navio != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${movimentacao.navio == null}">
                            <form action="insert" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${movimentacao.navio != null}">
                                    Alterar Movimentação
                                </c:if>
                                <c:if test="${movimentacao.navio == null}">
                                    Inserir Movimentação
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${movimentacao.navio != null}">
                            <input type="hidden" name="idmovimentacao" value="<c:out value='${movimentacao.idmovimentacao}' />" />
                        </c:if>

                        <fieldset class="form-group">
                            <label>Navio</label> <input type="text" value="<c:out value='${movimentacao.navio}' />" class="form-control" name="navio">
                        </fieldset>

                        <fieldset class="form-group">
                        	<label>Tipo</label> <select id="cboTipoMov"> <option value="Embarque">Embarque</option> <option value="Descarga">Descarga</option> <option value="Gate In">Gate In</option> <option value="Gate Out">Gate Out</option> <option value="Posicionamento Pilha">Posicionamento Pilha</option> <option value="Pesagem">Pesagem</option> <option value="Scanner">Scanner</option> </select>
    					</fieldset>	
    					
						<fieldset class="form-group"> <label>Data Início</label> <input type="text" class="form-control" onkeypress="$(this).mask('00/00/0000')">
						</fieldset>
						 <fieldset class="form-group"><label>Data Fim</label> <input type="text" class="form-control" onkeypress="$(this).mask('00/00/0000')"> 
						</fieldset>
						<fieldset class="form-group"> <label>Categoria</label>	<select id="cboCategoria"> <option value="<c:out value='${container.categoria}' />">Importação</option> <option value="<c:out value='${container.categoria}' />">Exportação</option> </select>
						</fieldset>	

						<br></br>
						
						
                        <button type="submit" class="btn btn-success">Salvar</button>
                        
                        <button type ="reset" >Limpar</button>
                        
                        
                        
                        </form>
                        <a href="<%=request.getContextPath()%>/" class="navbar-brand"> Voltar </a>
                    </div>
                </div>
            </div>
        </body>

        </html>