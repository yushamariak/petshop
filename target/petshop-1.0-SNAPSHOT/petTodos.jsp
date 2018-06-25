<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    Pets
                  </a>
                  <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    
                    <form action="/PetShop/inserir.html">                
                      <button type="submit" class="btn btn-default dropdown-item">Novo</button>
                    </form>
                    <a class="dropdown-item" href="#">Listar</a>
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
           <div class="row text-center" style="background-color: #fff !important; color: rgba(235, 245, 50, 1);  padding-top: 50px !important; font-size: 40px;">
            <div class="col-sm-12">
              Pets
            </div>
          </div>
        <div class="row" style="padding-left: 20px; padding-right: 20px; padding-top: 15px;">
          <c:forEach var="pet" items="${pets}">            
            <div class="col-sm-3 col-md-3 text-center" style="margin-top: 20px;">
                <div style="width: 100%;background: #dedede; border-radius: 25px; padding-top: 25px; padding-bottom: 25px;"> 
                    <strong><h4 style="color: #787878; font-weight: bold;"> ${pet.nome}</h4></strong>
                    <i style="color: #909090;">
                        <strong>id: &nbsp;</strong> ${pet.idPet}</br>
                        <strong>Especie: &nbsp;</strong> ${pet.especie}</br>
                        <strong>Raca:&nbsp; </strong> ${pet.raca}</br>
                        <strong>Sexo: &nbsp;</strong> ${pet.sexo == 'M' ? 'Macho' : "Femea"}</br>
                        <strong>Dt Nascimento: &nbsp;</strong> ${pet.data_nascimento}</br>
                    </i>
                    <div clas="row" style="padding-top: 15px;"> 
                        <div clss="col-md-12">
                            <div class="row"> 
                                <div class="col-md-3"></div>
                                <div class="col-md-3">
                                    <form  style="width: 50% !important;" action="/PetShop/pet/excluir" method="post">
                                        <input type="hidden" name="idPet" value="${pet.idPet}">
                                       <button type="submit"  class="btn btn-primary" style="background: rgb(129, 129, 129);  border: none;">Excluir</button>
                                    </form>
                                </div>
                                <div class="col-md-3">
                                    <form  style="width: 50% !important; " action="/PetShop/pet/buscar" method="post">
                                        <input type="hidden" name="idPet" value="${pet.idPet}">
                                        <button type="submit" class="btn btn-primary" style="background: rgba(235, 245, 50, 1); color: rgb(129, 129, 129); border: none;">Editar</button>

                                    </form>
                                </div>
                                <div class="col-md-3"></div>
                            </div>
                          
                        
                            
                        
                        </div>
                         

                    </div>
                </div>
            </div>
           </c:forEach>
        </div>
          
                
<!--                <div class="row text-center" style="background-color: #fff !important; color: rgba(235, 245, 50, 1);  padding-top: 300px !important; font-size: 70px;">
                    <div class="col-sm-12">
                      
                    </div>
                  </div>-->
             
    </body>
</html>

