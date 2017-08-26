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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fernando.tsuda
 */
public class ProdutoDAO extends ConexaoBD {

  public List<Produto> listar() {

    String query = "SELECT id, nome, descricao, "
	    + "vl_compra, vl_venda, categoria, "
	    + "dt_cadastro FROM produto";

    List<Produto> lista = null;
    try (Connection conn = obterConexao();
	    PreparedStatement stmt = conn.prepareStatement(query);
	    ResultSet resultados = stmt.executeQuery()) {

      lista = new ArrayList<Produto>();
      while (resultados.next()) {
	Produto p = new Produto();
	p.setId(resultados.getLong("id"));
	p.setNome(resultados.getString("nome"));
	p.setDescricao(resultados.getString("descricao"));
	p.setValorCompra(resultados.getBigDecimal("vl_compra"));
	p.setValorVenda(resultados.getBigDecimal("vl_venda"));
	p.setDescricao(resultados.getString("categoria"));
	p.setDtCadastro(resultados.getTimestamp("dt_cadastro"));
	lista.add(p);
      }
    } catch (SQLException ex) {
      System.err.println(ex.getMessage());
    } catch (ClassNotFoundException ex) {
      System.err.println(ex.getMessage());
    }
    return lista;
  }

  public Produto obter(long id) {
    String query = "SELECT id, nome, descricao, "
	    + "vl_compra, vl_venda, categoria, "
	    + "dt_cadastro FROM produto "
	    + "WHERE id = ?";

    Produto prod = null;
    try (Connection conn = obterConexao();
	    PreparedStatement stmt = conn.prepareStatement(query)) {

      stmt.setLong(1, id);
      try (ResultSet resultados = stmt.executeQuery()) {

	if (resultados.next()) {
	  prod = new Produto();
	  prod.setId(resultados.getLong("id"));
	  prod.setNome(resultados.getString("nome"));
	  prod.setDescricao(resultados.getString("descricao"));
	  prod.setValorCompra(resultados.getBigDecimal("vl_compra"));
	  prod.setValorVenda(resultados.getBigDecimal("vl_venda"));
	  prod.setDescricao(resultados.getString("categoria"));
	  prod.setDtCadastro(resultados.getTimestamp("dt_cadastro"));
	}
      }
    } catch (SQLException ex) {
      System.err.println(ex.getMessage());
    } catch (ClassNotFoundException ex) {
      System.err.println(ex.getMessage());
    }
    return prod;
  }

// http://stackoverflow.com/questions/17459094/getting-id-after-insert-within-a-transaction-oracle
// http://www.mkyong.com/jdbc/jdbc-transaction-example/
  public void incluirComTransacao(Produto p) {

    String query = "INSERT INTO produto "
	    + "(nome, descricao, vl_compra, vl_venda, "
	    + "categoria, dt_cadastro) "
	    + "VALUES (?, ?, ?, ?, ?, ?)";

    try (Connection conn = obterConexao()) {
      conn.setAutoCommit(false); // Permite usar transacoes para multiplos comandos no banco de dados
      try (PreparedStatement stmt
	      = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
	stmt.setString(1, p.getNome());
	stmt.setString(2, p.getDescricao());
	stmt.setBigDecimal(3, p.getValorCompra());
	stmt.setBigDecimal(4, p.getValorVenda());
	stmt.setString(5, p.getCategorias());
	stmt.setTimestamp(6, new java.sql.Timestamp(System.currentTimeMillis()));

	stmt.executeUpdate();

	// ResultSet para recuperar o ID gerado automaticamente no banco de dados.
	// Neste exemplo, o ID é gerado automaticamente.
	try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
	  if (generatedKeys.next()) {
	    long idNovo = generatedKeys.getLong(1);
	    p.setId(idNovo);
	    System.out.println("***** ID NOVO CADASTRADO: " + String.valueOf(idNovo));

	    // Executar próximos INSERTs USANDO O ID novo.
	  }

	}
	conn.commit();
      } catch (SQLException ex) {
	conn.rollback();
	System.err.println(ex.getMessage());
      }

    } catch (SQLException ex) {
      System.err.println(ex.getMessage());
    } catch (ClassNotFoundException ex) {
      System.err.println(ex.getMessage());
    }

  }
}
