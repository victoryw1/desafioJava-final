<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt_br">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Portfólio de Projetos</title>
        <link href="<c:url value="/static/node_modules/bootstrap/dist/css/bootstrap.min.css"/>" rel="stylesheet">

        
        <link rel="stylesheet" href="<c:url value="/static/node_modules/bootstrap-icons/font/bootstrap-icons.css"/>">
        <style>
            table.table td a.edit {
        color: #FFC107;
        }
        table.table td button.delete {
            color: #F44336;
        }
        </style>
    </head>
    <body>
        <%@ include file="/WEB-INF/includes/navbar.jsp"%>

        <div class="container">
            <div class="card">
                <div class="card-header">Listar</div>
                <div class="card-body">
                    <h5 class="card-title">Todos os projetos</h5>
                    <hr/>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th scope="col">Nome</th>
                            <th scope="col">Risco</th>
                            <th scope="col">Status</th>
                            <th scope="col">Gerente</th>
                            <th scope="col">Ações</th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listProjeto}" var="projeto">
                                <tr>
                                    <td>${projeto.nome}</td>
                                    <td>${projeto.risco.label}</td>
                                    <td>${projeto.status.label}</td>
                                    <td>${projeto.gerente.nome}</td>
                                    <td>
                                        <a href="/projeto/${projeto.id}" class="btn btn-link edit" ><i class="bi bi-pencil-square" data-toggle="tooltip" title="Edit"></i></a>
                                        <button type="button" class="btn btn-link delete" data-bs-toggle="modal" data-bs-target="#deleteModal" data-bs-whatever="${projeto.id}">
                                            <i class="bi bi-trash" data-toggle="tooltip" title="Delete"></i>
                                        </button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            
            <!-- Modal -->
            <div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                <div class="modal-content">
                    <div  const toastTrigger = document.getElementById('liveToastBtn'v class="modal-header">
                        <h5 class="modal-title" id="deleteModalLabel">Atenção!</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        Deseja realmente excluir o projeto?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Não</button>
                        <a href="/projeto/delete/0" class="btn btn-primary">Sim</a>
                    </div>
                </div>
                </div>
            </div>

            <script>

                const exampleModal = document.getElementById('deleteModal')
                exampleModal.addEventListener('show.bs.modal', event => {
                // Button that triggered the modal
                const button = event.relatedTarget
                // Extract info from data-bs-* attributes
                const recipient = button.getAttribute('data-bs-whatever')
                // If necessary, you could initiate an AJAX request here
                // and then do the updating in a callback.
                //
                // Update the modal's content.
                const modalTitle = exampleModal.querySelector('.modal-title')
                // const modalBodyInput = exampleModal.querySelector('.modal-body input')
                const modalADelete = exampleModal.querySelector('.modal-footer a')

                // modalTitle.textContent = `New message to ${recipient}`
                // modalBodyInput.value = recipient
                modalADelete.href= '/projeto/delete/' + recipient
                })

            </script>



            <c:if test="${addProjetoSuccess}">
                
                <div class="toast-container position-fixed bottom-0 end-0 p-3 ">
                    <div id="liveToast" class="toast show" role="alert" aria-live="assertive" aria-atomic="true">
                        <div class="toast-header ">
                            <svg class="bd-placeholder-img rounded me-2" width="20" height="20" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="#007aff"></rect></svg>
                            <strong class="me-auto">Informação</strong>
                            <small>${savedProjeto.nome}</small>
                            <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
                        </div>
                        <div class="toast-body">
                            Salvo com sucesso!
                        </div>
                    </div>
                </div>
                
            </c:if>

            <c:if test="${deleteProjeto}">
                
                <div class="toast-container position-fixed bottom-0 end-0 p-3 ">
                    <div id="liveToast" class="toast show" role="alert" aria-live="assertive" aria-atomic="true">
                        <div class="toast-header ">
                            <svg class="bd-placeholder-img rounded me-2" width="20" height="20" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="#ff0000"></rect></svg>
                            <strong class="me-auto">Informação</strong>
                            <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
                        </div>
                        <div class="toast-body">
                            Projeto com status "${statusProjeto}" não pode ser excluído.
                        </div>
                    </div>
                </div>
                
            </c:if>

    <script src="<c:url value="/static/node_modules/bootstrap/dist/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/static/node_modules/bootstrap/dist/js/bootstrap.bundle.min.js"/>"></script>

</html>