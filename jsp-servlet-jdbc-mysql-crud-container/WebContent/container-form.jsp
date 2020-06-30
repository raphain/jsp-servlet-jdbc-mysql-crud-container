<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
        <meta charset="UTF-8">
            <title>Cadastro de Containers</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script>
    function getTipo()
    {
    	var t=document.getElementById("cboTipo");
    	var displaytext=t.options[t.selectedIndex].text;
    	document.getElementById("txtvalue").value=displaytext;
    	
    }
    function getStatus()
    {
    	var t=document.getElementById("cboStatus");
    	var displaytext=t.options[t.selectedIndex].text;
    	document.getElementById("txtvalue1").value=displaytext;
    	
    }
    function getCategoria()
    {
    	var t=document.getElementById("cboCategoria");
    	var displaytext=t.options[t.selectedIndex].text;
    	document.getElementById("txtvalue2").value=displaytext;
    	
    }
    </script>
    
        </head>

        <body>
	
            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="<%=request.getContextPath()%>/" class="navbar-brand"> Cadastro de Containers </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Containers</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${container.numero != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${container.numero == null}">
                            <form action="insert" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${container.numero != null}">
                                    Alterar Container
                                </c:if>
                                <c:if test="${container.numero == null}">
                                    Inserir Container
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${container.numero != null}">
                            <input type="hidden" name="idcontainer" value="<c:out value='${container.idcontainer}' />" />
                        </c:if>

                        <fieldset class="form-group">
                            <label>Número</label> <input type="text" value="<c:out value='${container.numero}' />" class="form-control" onkeypress="$(this).mask('AAAA999999-9')" name="numero" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Cliente</label> <input type="text" value="<c:out value='${container.cliente}' />" class="form-control" name="cliente">
                        </fieldset>
                        
                        
                        
                        <fieldset class="form-group">
                        	<label>Tipo</label> <select id="cboTipo" onchange="getTipo();"> <option>--Selecione--</option><option >20'</option> <option >40'</option> </select>
    					</fieldset>	
    					<input type="hidden" id="txtvalue" name=tipo value="<c:out value='${container.tipo}' />">
						<fieldset class="form-group"> <label>Status</label> <select id="cboStatus" onchange="getStatus();"> <option>--Selecione--</option><option value="<c:out value='${container.status}' />">Cheio</option> <option value="<c:out value='${container.status}' />">Vazio</option> </select>
						</fieldset>
						<input type="hidden" id="txtvalue1" name=status value="<c:out value='${container.status}' />">
						<fieldset class="form-group"> <label>Categoria</label>	<select id="cboCategoria" onchange="getCategoria();"><option>--Selecione--</option> <option value="<c:out value='${container.categoria}' />">Importação</option> <option value="<c:out value='${container.categoria}' />">Exportação</option> </select>
						</fieldset>	
						<input type="hidden" id="txtvalue2" name=categoria value="<c:out value='${container.categoria}' />">

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