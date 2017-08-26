/*
 * The MIT License
 *
 * Copyright 2017 Senac TADS PI3B.
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
import java.util.List;

/**
 *
 * @author fernando.tsuda
 */
public class Principal {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    ProdutoDAO dao = new ProdutoDAO();

    Produto novo = new Produto();
    novo.setNome("Torta de maça");
    novo.setDescricao("Melhor torta");
    novo.setValorCompra(new BigDecimal(10.0));
    novo.setValorVenda(new BigDecimal(30.0));
    novo.setCategorias("torta, fruta, maça");
    dao.incluirComTransacao(novo);
    
    List<Produto> resultados = dao.listar();
    if (resultados != null) {
      for (Produto p: resultados) {
	System.out.println("Produto " + p.getId() + ": nome=" + p.getNome());
      }
    }
  }
  
}
