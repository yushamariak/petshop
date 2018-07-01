<%-- 
    Document   : newServico
    Created on : 25/06/2018, 12:47:15
    Author     : adryell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Petshop - Home</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light" style="background: rgba(235, 245, 50, 1) !important;">
            <a class="navbar-brand" href="/PetShop/index.html">PetShop</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="navbar-nav mr-auto">
  
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Pets <span class="sr-only">(current)</span>
                  </a>
                  <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <form action="/PetShop/inserir.html">                
                      <button type="submit" class="btn btn-default dropdown-item">Novo</button>
                    </form>
                    <a class="dropdown-item" href="/PetShop/pet/listar">Listar</a>
                    <a class="dropdown-item" href="/PetShop/pet/relatorio">Relatorio</a>
                  </div>
                </li>
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Serviços
                  </a>
                  <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/PetShop/servico/prepara">Novo</a>
                    <a class="dropdown-item" href="#">Listar</a>
                  </div>
                </li>

              </ul>

            </div>
          </nav>

          <div class="row text-center" style=" padding-top: 100px !important;">
            <div class="col-sm-12" style="font-size: 50px;">
              <span style="color: #787878">Novo</span> <span style="color: rgba(235, 245, 50, 1)">Servico </span>
            </div>
            <div class="col-md-3"></div>
            <div class="col-md-6" >
              <form class="" action="/PetShop/servico/novo" method="post">
                <div class="row">
                
              <div class="form-group col-sm-12">
                <div class="col-sm-12">
                  <input type="date" class="form-control form-control-lg" name="data_servico" id="data_servico" placeholder="Data de Nascimento">
                </div>
              </div>  
              <div class="form-group col-sm-12" style="padding-left: 30px;padding-right: 30px;">
                <select class="form-control form-control-lg" name="servico" id="servico">
                    <c:forEach var="ser" items="${servicos}">
                   <option value="${ser.idServico}">${ser.descricao}</option>
                  
                   </c:forEach>
                 </select>
             </div>
             <div class="form-group col-sm-12" style="padding-left: 30px;padding-right: 30px;">
               <select class="form-control form-control-lg" name="pet" id="pet">
                 <c:forEach var="pet" items="${pets}">
                   <option value="${pet.idPet}">${pet.nome}</option>
                  
                   </c:forEach>
                </select>
            </div>
            <div class="form-group col-sm-12" style="padding-left: 30px;padding-right: 30px;">
               <select class="form-control form-control-lg" name="user" id="user">
                 <c:forEach var="user" items="${usuarios}">
                   <option value="${user.idUsuario}">${user.nome}</option>
                  
                   </c:forEach>
                </select>
            </div>
            <div class="col-sm-12" style="padding-left: 30px;padding-right: 30px;">
              <div class="row">
                <div class="col-sm-6">
                  <a href="/PetShop/index.html"  class="btn btn-primary" style="background: rgb(129, 129, 129); width: 100% !important; border: none;">Cancelar</a>
                </div>
                <div class="col-sm-6">
                  <button type="submit" class="btn btn-primary" style="background: rgba(235, 245, 50, 1); color: #fff; width: 100% !important; border: none;">Salvar</button>
                </div>
              </div>
            </div>
             </div>
              </form>
            </div>
            <div class="col-md-3"></div>
          </div>
    </body>
</html>
