/*
 * The MIT License
 *
 * Copyright 2017 fernando.tsuda.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package br.senac.tads3.pi3a.gereprod;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author fernando.tsuda
 */
public class Produto {

  private long id;

  private String nome;

  private String descricao;

  private BigDecimal valorCompra;

  private BigDecimal valorVenda;

  private String categorias;

  private Date dtCadastro;
  
  public Produto() {
    
  }

  public Produto(long id, String nome, String descricao, BigDecimal valorCompra, BigDecimal valorVenda, String categorias, Date dtCadastro) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.valorCompra = valorCompra;
    this.valorVenda = valorVenda;
    this.categorias = categorias;
    this.dtCadastro = dtCadastro;
  }

  public Produto(String nome, String descricao, BigDecimal valorCompra, BigDecimal valorVenda, String categorias, Date dtCadastro) {
    this.nome = nome;
    this.descricao = descricao;
    this.valorCompra = valorCompra;
    this.valorVenda = valorVenda;
    this.categorias = categorias;
    this.dtCadastro = dtCadastro;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public BigDecimal getValorCompra() {
    return valorCompra;
  }

  public void setValorCompra(BigDecimal valorCompra) {
    this.valorCompra = valorCompra;
  }

  public BigDecimal getValorVenda() {
    return valorVenda;
  }

  public void setValorVenda(BigDecimal valorVenda) {
    this.valorVenda = valorVenda;
  }

  public String getCategorias() {
    return categorias;
  }

  public void setCategorias(String categorias) {
    this.categorias = categorias;
  }

  public Date getDtCadastro() {
    return dtCadastro;
  }

  public void setDtCadastro(Date dtCadastro) {
    this.dtCadastro = dtCadastro;
  }

}
