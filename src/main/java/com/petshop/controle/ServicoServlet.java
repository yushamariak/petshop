/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petshop.controle;


import com.petshop.modelo.Pet;
import com.petshop.modelo.Servico;
import com.petshop.modelo.Usuario;
import com.petshop.modelo.dao.DAOFactory;
import com.petshop.modelo.dao.PetDAO;
import com.petshop.modelo.dao.ServicoDAO;
import com.petshop.modelo.dao.UsuarioDAO;
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
public class ServicoServlet extends HttpServlet {

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
         if (caminho.equals("/servico/prepara")) {
             DAOFactory factory = new DAOFactory();
            try {
                factory.abrirConexao();
                
                PetDAO dao = factory.criarPetDAO();
                List<Pet> casas = dao.buscarTodos();
                request.setAttribute("pets", casas);
                System.out.println("MAMNANANOAONAONAOANNA :::: " + casas);
                ServicoDAO daoServico = factory.criarServicoDAO();
                List<Servico> servicos = daoServico.buscarTodos();
                request.setAttribute("servicos", servicos);
                System.out.println("MAMNANANOAONAONAOANNA :::: " + servicos);
                UsuarioDAO daoUsuario = factory.criarUsuarioDAO();
                List<Usuario> usuarios = daoUsuario.buscarTodos();
                request.setAttribute("usuarios", usuarios);
                RequestDispatcher rd = request.getRequestDispatcher("/newServico.jsp");
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
         }else if(caminho.equals("/servico/novo")) {
             System.out.println("MANOLO REIS::: " + Integer.parseInt(request.getParameter("servico")) +" || "+ parseInt(request.getParameter("pet")) +" || "+ parseInt(request.getParameter("pet")));
            int servico = Integer.parseInt(request.getParameter("servico"));
            int pet = Integer.parseInt(request.getParameter("pet"));
            String data = request.getParameter("data_servico");
            int funcionario = Integer.parseInt(request.getParameter("user"));

            DAOFactory factory = new DAOFactory();
            try {
                factory.abrirConexao();
                ServicoDAO dao = factory.criarServicoDAO();

                dao.gravar(pet, servico, funcionario, data);

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
            request.setAttribute("mensagem", "Servico Registrado com Sucesso.");
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
