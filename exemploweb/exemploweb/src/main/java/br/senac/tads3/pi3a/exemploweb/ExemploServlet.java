/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi3a.exemploweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ExemploServlet",
	urlPatterns = { "/exemplo" })
public class ExemploServlet extends HttpServlet {
  
  @Override
  public void doGet(HttpServletRequest request, 
	  HttpServletResponse response) 
	  throws ServletException {
    try (PrintWriter out = response.getWriter()) {
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset=\"UTF-8\">");
      out.println("<title>Exemplo Servlet</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Exemplo Servlet</h1>");
      for (int i = 1; i < 100; i++) {
	if (i % 2 == 0) {
	  out.println("<p>" + i + "</p>");
	}
      }
      out.println("</body>");
      out.println("</html>");
      out.flush();
    } catch (IOException ex) {
      
    }
  }
  
}
