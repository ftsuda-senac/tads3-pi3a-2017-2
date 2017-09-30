/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi3a.exemploweb;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fernando.tsuda
 */
@WebServlet(name = "ProdutoServlet", urlPatterns = {"/produtos"})
public class ProdutoServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
    Produto p1 = new Produto(1L, "Água mineral",
	    "água", new BigDecimal(0.5), new BigDecimal(2.0),
	    "Bebidas, Alimentos", new Date());
    Produto p2 = new Produto(2L, "Cerveja",
	    "cerveja", new BigDecimal(1.5), new BigDecimal(5.99),
	    "Bebidas, Alimentos, Alcolico", new Date());
    Produto p3 = new Produto(3L, "Suco de uva",
	    "suco de uva natural", new BigDecimal(2.49), new BigDecimal(8.99),
	    "Bebidas", new Date());
    List<Produto> listaProdutos = new ArrayList<Produto>();
    listaProdutos.add(p1);
    listaProdutos.add(p2);
    listaProdutos.add(p3);
    
    request.setAttribute("produtos", listaProdutos);
    RequestDispatcher dispatcher = 
	    request.getRequestDispatcher("produtos.jsp");
    dispatcher.forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

  }

}
