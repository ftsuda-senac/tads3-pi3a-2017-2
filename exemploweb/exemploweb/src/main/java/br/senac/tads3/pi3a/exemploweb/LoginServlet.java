/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi3a.exemploweb;

import br.senac.tads3.pi3a.exemploweb.autenticacao.UsuarioService;
import br.senac.tads3.pi3a.exemploweb.autenticacao.UsuarioSistema;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fernando.tsuda
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    // Verifica se usuario ja esta logado
    HttpSession sessao = request.getSession();
    UsuarioSistema usuario = (UsuarioSistema) sessao.getAttribute("usuario");
    if (usuario != null) {
      // Usuario já está logado - redireciona para tela inicial
      response.sendRedirect(request.getContextPath() + "/protegido/home");
      return; // Forca a saida do método doGet
    }

    // Usuario nao logado
    // Antes verifica se tem msg do logout na sessao
    String msgLogout = (String) sessao.getAttribute("msgLogout");
    sessao.removeAttribute("msgLogout");
    if (msgLogout != null) {
      request.setAttribute("msgLogout", msgLogout);
    }

    RequestDispatcher dispatcher
            = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
    dispatcher.forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String username = request.getParameter("username");
    String senha = request.getParameter("senha");

    UsuarioService service = new UsuarioService();
    UsuarioSistema usuario = service.autenticar(username, senha);

    if (usuario != null) {
      // Sucesso - usuario autenticado
      HttpSession sessao = request.getSession();
      sessao.setAttribute("usuario", usuario);
      response.sendRedirect(request.getContextPath()
              + "/protegido/home");
    } else {
      // Erro - reapresenta tela de login
      request.setAttribute("msgErro", "Erro no login");
      RequestDispatcher dispatcher
              = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
      dispatcher.forward(request, response);
    }
  }

}
