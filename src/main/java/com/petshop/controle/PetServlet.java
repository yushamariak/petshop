/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petshop.controle;

import java.io.IOException;
import java.io.PrintWriter;
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
//            Casa casa = new Casa();
//            casa.setCodigo(Long.parseLong(request.getParameter("codigo")));
//            casa.setEndereco(request.getParameter("endereco"));
//            casa.setDescricao(request.getParameter("descricao"));
//            casa.setDono(request.getParameter("dono"));
//            casa.setSituacao(Integer.parseInt(request.getParameter("situacao")));
//            casa.setValorAluguel(Double.parseDouble(request.getParameter("valorAluguel")));
//            casa.setNroVagasEstacionamento(Integer.parseInt(request.getParameter("numeroVagasEstacionamento")));
//            String temQuintal = request.getParameter("temQuintal");
//            if (temQuintal != null) {
//                casa.setTemQuintal(true);
//            } else {
//                casa.setTemQuintal(false);
//            }
//            casa.setNroAndares(Integer.parseInt(request.getParameter("numeroAndares")));
//            DAOFactory factory = new DAOFactory();
//            try {
//                factory.abrirConexao();
//                CasaDAO dao = factory.criarCasaDAO();
//                dao.gravar(casa);
//            } catch (SQLException ex) {
//                DAOFactory.mostrarSQLException(ex);
//            } finally {
//                try {
//                    factory.fecharConexao();
//                } catch (SQLException ex) {
//                    DAOFactory.mostrarSQLException(ex);
//                }
//            }
//            RequestDispatcher rd = request.getRequestDispatcher("/mensagem.jsp");
//            request.setAttribute("mensagem", "Casa inserida com sucesso.");
//            rd.forward(request, response);
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
