/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi3a.exemploweb.autenticacao;

import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author fernando.tsuda
 */
public final class UsuarioSistema {

  private String nomeCompleto;

  private String username;

  private String hashSenha;

  private List<String> papeis;

  public UsuarioSistema() {

  }

  public UsuarioSistema(String nomeCompleto, String username, String senha) {
    this.nomeCompleto = nomeCompleto;
    this.username = username;
    setSenha(senha);
  }

  public UsuarioSistema(String nomeCompleto, String username, String senha, List<String> papeis) {
    this.nomeCompleto = nomeCompleto;
    this.username = username;
    setSenha(senha);
    this.papeis = papeis;
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

  public void setSenha(String senhaAberta) {
    this.hashSenha = BCrypt.hashpw(senhaAberta, BCrypt.gensalt());
  }

  public List<String> getPapeis() {
    return papeis;
  }

  public void setPapeis(List<String> papeis) {
    this.papeis = papeis;
  }
  
  public boolean verificarSenha(String senhaAberta) {
    return BCrypt.checkpw(senhaAberta, hashSenha);
  }

  public boolean temPapel(String papel) {
    return papeis.contains(papel);
  }
}
