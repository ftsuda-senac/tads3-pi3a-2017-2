/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi3a.exemploweb.autenticacao;

/**
 *
 * @author fernando.tsuda
 */
public class UsuarioSistema {
  
  private String nomeCompleto;
  
  private String username;
  
  private String hashSenha;
  
  public UsuarioSistema() {
    
  }

  public UsuarioSistema(String nomeCompleto, String username, String senha) {
    this.nomeCompleto = nomeCompleto;
    this.username = username;
    this.hashSenha = senha;
  }

  public String getNomeCompleto() {
    return nomeCompleto;
  }

  public void setNomeCompleto(String nomeCompleto) {
    this.nomeCompleto = nomeCompleto;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getHashSenha() {
    return hashSenha;
  }

  public void setHashSenha(String hashSenha) {
    this.hashSenha = hashSenha;
  }
  
}
