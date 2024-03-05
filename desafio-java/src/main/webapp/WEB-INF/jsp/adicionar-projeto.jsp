<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt_br">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Adicionar projeto</title>
        <link href="<c:url value="/static/node_modules/bootstrap/dist/css/bootstrap.min.css"/>"
          rel="stylesheet">
    </head>
    <body>
        <%@ include file="/WEB-INF/includes/navbar.jsp"%>

        <div class="container">

            <div class="card">
                <div class="card-header">
                  Novo Projeto 
                </div>
                <div class="card-body">
                    <h5 class="card-title">Preencha os campos abaixo:</h5>
                    <hr/>

                    <c:url var="add_projeto_url" value="/projeto/adicionar"/>
                    <form:form action="${add_projeto_url}" method="post" modelAttribute="projeto">
                        <form:hidden path="id" />
                        <div class="form-group mb-3">
                            <form:label path="nome" class="form-label">Nome: </form:label> 
                            <form:input type="text" class="form-control" path="nome" required="required"/>
                        </div>
                        <div class="form-group mb-3">
                            <form:label path="dataInicio" class="form-label">Data de início: </form:label> 
                            <form:input type="date" class="form-control" path="dataInicio" required="required"/>
                            <form:errors path="dataInicio" cssClass="error"/>
                        </div>
                        <div class="form-group mb-3">
                            <form:label path="idGerente" class="form-label">Gerente responsável: </form:label> 
                            <form:select class="form-select" path="idGerente" required="required">
                                <form:option value="" label="--- Selecione ---"/>
                                <form:options items="${listGerente}"  itemValue="id" itemLabel="nome"/>
                            </form:select>
                        </div>
                        <div class="form-group mb-3">
                            <form:label path="idGerente" class="form-label">Membro: </form:label> 
                            <form:select class="form-select" path="idGerente">
                                <form:option value="" label="--- Selecione ---"/>
                                <form:options items="${listFuncionario}"  itemValue="id" itemLabel="nome"/>
                            </form:select>
                        </div>
                        <div class="form-group mb-3">
                            <form:label path="dataPrevisaoFim" class="form-label">Previsão de término: </form:label> 
                            <form:input type="date" class="form-control" path="dataPrevisaoFim" required="required"/>
                        </div>
                        <div class="form-group mb-3">
                            <form:label path="dataFim" class="form-label">Data real de término: </form:label> 
                            <form:input type="date" class="form-control" path="dataFim" required="required"/>
                            <form:errors path="dataFim" cssClass="text-bg-danger"/>
                        </div>
                        <div class="form-group mb-3">
                            <form:label path="orcamentoTotal" class="form-label">Orçamento total: </form:label> 
                            <form:input type="text" class="form-control" path="orcamentoTotal" required="required"/>
                            <form:errors path="orcamentoTotal" cssClass="text-bg-danger"/>
                        </div>
                        <div class="form-group mb-3">
                            <form:label path="descricao" class="form-label">Descrição: </form:label> 
                            <form:textarea rows="3" class="form-control" path="descricao" required="required"/>
                        </div>
                        <div class="form-group mb-3">
                            <form:label path="status" class="form-label">Status: </form:label> 
                            <form:select class="form-select" path="status" required="required">
                                <form:option value="" label="--- Selecione ---"/>
                                <form:options items="${listStatus}"  itemValue="name" itemLabel="label"/>
                            </form:select>
                        </div>
                        <div class="form-group mb-3">
                            <form:label path="risco" class="form-label">Risco: </form:label> 
                            <form:select class="form-select" path="risco">
                                <form:option value="" label="--- Selecione ---"/>
                                <form:options items="${listRisco}"  itemValue="name" itemLabel="label"/>
                            </form:select>
                        </div>

                        <p class="card-text"></p>
                        <input type="submit" class="btn btn-primary"  value="Salvar"/>
                    </form:form>
                </div>
              </div>
        </div>
    </body>

    <script src="<c:url value="/static/node_modules/bootstrap/dist/js/bootstrap.min.js"/>"></script>
</html>