/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi3a.exemploweb;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fernando.tsuda
 */
@WebServlet(name = "SalvarProdutoServlet", urlPatterns = {"/cadastro-produto"})
public class SalvarProdutoServlet extends HttpServlet {

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
    HttpSession sessao = request.getSession();
    Produto p = (Produto) sessao.getAttribute("novoProd");
    String destino;
    if (p != null) { // usuario veio do redirecionamento
      request.setAttribute("novoProd", p);
      sessao.removeAttribute("novoProd");
      destino = "resposta.jsp";
    } else { // usuario acessou normalmente
      destino = "formulario.jsp";
    }
    RequestDispatcher dispatcher = 
	    request.getRequestDispatcher(destino);
    dispatcher.forward(request, response);
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
    String nome = request.getParameter("nome");
    String descricao = request.getParameter("descricao");
    String vlCompra = request.getParameter("vlcompra");
    String vlVenda = request.getParameter("vlvenda");
    String[] categorias = request.getParameterValues("categorias");

    Produto p = new Produto(nome, descricao,
	    new BigDecimal(vlCompra), new BigDecimal(vlVenda),
	    categorias[0], new Date());
    
    HttpSession sessao = request.getSession();
    sessao.setAttribute("novoProd", p);
    
    response.sendRedirect(request.getContextPath() + "/cadastro-produto");
  }

}
