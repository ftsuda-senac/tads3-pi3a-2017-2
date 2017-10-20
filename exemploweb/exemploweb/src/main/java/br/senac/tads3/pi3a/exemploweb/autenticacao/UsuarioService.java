/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi3a.exemploweb.autenticacao;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author fernando.tsuda
 */
public class UsuarioService {
  
  private static final 
	  Map<String, UsuarioSistema> USUARIOS_CADASTRADOS;
  
  static {
    USUARIOS_CADASTRADOS = 
	    new LinkedHashMap<String, UsuarioSistema>();
    USUARIOS_CADASTRADOS.put("rale", 
	    new UsuarioSistema("Ralé da Silva", 
	    "rale", "abcd1234"));
    USUARIOS_CADASTRADOS.put("fodinha", 
	    new UsuarioSistema("Fodinha de Souza", 
	    "fodinha", "abcd1234"));
    USUARIOS_CADASTRADOS.put("fodao", 
	    new UsuarioSistema("Fodao di Caprio", 
	    "fodao", "abcd1234"));
  }
  
  public UsuarioSistema autenticar(String username, String senha) {
    // 1) Verifica se username existe
    UsuarioSistema usuario = USUARIOS_CADASTRADOS.get(username);
    if (usuario != null) {
      // 2) Verifica se senha esta correta
      if (senha != null && senha.equals(usuario.getHashSenha())) {
	return usuario;
      }
    }
    // Usuario nao existe ou senha esta incorreta
    return null;
  }
}
