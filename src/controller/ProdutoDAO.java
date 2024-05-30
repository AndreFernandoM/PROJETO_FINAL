/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Andre Fernando Machado - 837864
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Produto;

public class ProdutoDAO {
    
    private Connection con;
    private PreparedStatement cmd;

    public ProdutoDAO() {
        this.con = Conexao.conectar();
    }

   public boolean criarProduto(Produto produto) {
        try {
            String SQL = "INSERT INTO tb_produto (quant, disponivel, preco, nome, descricao) VALUES (?, ?, ?, ?, ?)";
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, produto.getQuant());
            cmd.setBoolean(2, produto.isDisponivel());
            cmd.setDouble(3, produto.getPreco());
            cmd.setString(4, produto.getNome());
            cmd.setString(5, produto.getDescricao());

            int rowsAffected = cmd.executeUpdate();

            return rowsAffected > 0;
        } catch (Exception e) {
            System.err.println("Erro ao criar produto: " + e.getMessage());
            return false;
        } finally {
            Conexao.desconectar(con);
        }
    }
}