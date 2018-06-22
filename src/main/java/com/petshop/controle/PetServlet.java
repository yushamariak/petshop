/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petshop.controle;

import com.petshop.modelo.Pet;
import com.petshop.modelo.dao.DAOFactory;
import com.petshop.modelo.dao.PetDAO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yusha
 */
public class PetServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String caminho = request.getServletPath();

        if (caminho.equals("/pet/novo")) {
            System.out.println("############Entrou NOVO");
            Pet casa = new Pet();
            casa.setNome(request.getParameter("nome"));
            casa.setRaca(request.getParameter("raca"));
            casa.setEspecie(request.getParameter("especie"));
            int sex = parseInt(request.getParameter("sexo"));
            if(sex== 1){
                casa.setSexo("M");
            } else {
                casa.setSexo("F");
            }
            
            casa.setData_nascimento(request.getParameter("data_nascimento"));
            casa.setCliente_id(Integer.parseInt(request.getParameter("dono")));
//            System.out.println("njsdjkanasda"+ casa);
            DAOFactory factory = new DAOFactory();
            try {
                factory.abrirConexao();
                PetDAO dao = factory.criarPetDAO();
                dao.gravar(casa);
            } catch (SQLException ex) {
                DAOFactory.mostrarSQLException(ex);
            } finally {
                try {
                    factory.fecharConexao();
                } catch (SQLException ex) {
                    DAOFactory.mostrarSQLException(ex);
                }
            }
            RequestDispatcher rd = request.getRequestDispatcher("/mensagem.jsp");
            request.setAttribute("mensagem", "Pet Inserido com Sucesso.");
            rd.forward(request, response);
        } else  if (caminho.equals("/pet/listar")){
            DAOFactory factory = new DAOFactory();
            try {
                factory.abrirConexao();
                PetDAO dao = factory.criarPetDAO();
                List<Pet> casas = dao.buscarTodos();
                request.setAttribute("pets", casas);
                System.out.println("##### AQUI MANO     :: "+ casas);
                RequestDispatcher rd = request.getRequestDispatcher("/petTodos.jsp");
                rd.forward(request, response);
            } catch (SQLException ex) {
                DAOFactory.mostrarSQLException(ex);
            } finally {
                try {
                    factory.fecharConexao();
                } catch (SQLException ex) {
                    DAOFactory.mostrarSQLException(ex);
                }
            }
        }else if (caminho.equals("/pet/excluir")) {
        
            Pet pet = new Pet();
            pet.setIdPet(Long.parseLong(request.getParameter("idPet")));
            DAOFactory factory = new DAOFactory();
            try {
                factory.abrirConexao();
                PetDAO dao = factory.criarPetDAO();
                dao.remover(pet);
            } catch (SQLException ex) {
                DAOFactory.mostrarSQLException(ex);
            } finally {
                try {
                    factory.fecharConexao();
                } catch (SQLException ex) {
                    DAOFactory.mostrarSQLException(ex);
                }
            }
            RequestDispatcher rd = request.getRequestDispatcher("/mensagem.jsp");
            request.setAttribute("mensagem", "Pet removido com Sucesso.");
            rd.forward(request, response);
            
        }else if (caminho.equals("/pet/buscar")) {
            
            Pet pet = new Pet();
            pet.setIdPet(Long.parseLong(request.getParameter("idPet")));
            DAOFactory factory = new DAOFactory();
            try {
                factory.abrirConexao();
                PetDAO dao = factory.criarPetDAO();
                Pet objPet = dao.buscar(Long.parseLong(request.getParameter("idPet")));
                request.setAttribute("pet", objPet);
                System.out.println("##### AQUI MANO     :: "+ objPet);
                RequestDispatcher rd = request.getRequestDispatcher("/petEditar.jsp");
                rd.forward(request, response);
            } catch (SQLException ex) {
                DAOFactory.mostrarSQLException(ex);
            } finally {
                try {
                    factory.fecharConexao();
                } catch (SQLException ex) {
                    DAOFactory.mostrarSQLException(ex);
                }
            }
        }else if (caminho.equals("/pet/alterar")) {
            System.out.println("############Entrou Alterar");
            Pet casa = new Pet();
            casa.setIdPet(Long.parseLong(request.getParameter("idPet")));
            casa.setNome(request.getParameter("nome"));
            casa.setRaca(request.getParameter("raca"));
            casa.setEspecie(request.getParameter("especie"));
            int sex = parseInt(request.getParameter("sexo"));
            if(sex== 1){
                casa.setSexo("M");
            } else {
                casa.setSexo("F");
            }
            casa.setData_nascimento(request.getParameter("data_nascimento"));
            casa.setCliente_id(Integer.parseInt(request.getParameter("dono")));
//            System.out.println("njsdjkanasda"+ casa);
            DAOFactory factory = new DAOFactory();
            try {
                factory.abrirConexao();
                PetDAO dao = factory.criarPetDAO();
                dao.atualizar(casa);
            } catch (SQLException ex) {
                DAOFactory.mostrarSQLException(ex);
            } finally {
                try {
                    factory.fecharConexao();
                } catch (SQLException ex) {
                    DAOFactory.mostrarSQLException(ex);
                }
            }
            RequestDispatcher rd = request.getRequestDispatcher("/mensagem.jsp");
            request.setAttribute("mensagem", "Pet Alterado com Sucesso.");
            rd.forward(request, response);
        }
           
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
