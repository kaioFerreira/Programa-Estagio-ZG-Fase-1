package Model;

import ModeloItem.ItemEstoque;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.ResultSet;

public class EstoqueModel {
    static String url = "jdbc:mysql://localhost:3306/rocambole";
    static String user = "root";
    static String password = "";
    
    public static String recuperaCodigoProduto(String nomeProduto){
        String codigo_produto = null;
          try {
           
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            //Criar o insert
           
            PreparedStatement st = connection.prepareStatement(
                    "SELECT codigo_produto FROM estoque WHERE nome_produto = ?;"
            );
            //Adiciona os parametros no insert
            st.setString(1, nomeProduto);

            //Executa o insert
            ResultSet resultSet = st.executeQuery();
            resultSet.next();
            
            codigo_produto = resultSet.getString("codigo_produto");
            st.close();
            
            connection.close();
            
        } catch (Exception e) {
           e.printStackTrace();
        }
        return codigo_produto;
    }
    
    public static void cadastraProdutoBanco(ItemEstoque produto){

        try {
           
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
          
            PreparedStatement st = connection.prepareStatement(
                    "INSERT INTO estoque (nome_produto,valor_custo,valor_venda,quantidade,id_distribuidora) " +
                            "VALUES (?,?,?,?,?);"
            );
            //Adiciona os parametros no insert
            st.setString(1, produto.getNome());
            st.setObject(2, produto.getValorCusto());
            st.setObject(3, produto.getValorVenda());
            st.setObject(4, produto.getQuantidade());
            st.setObject(5, produto.getIdDistribuidora());

            //Executa o insert
            st.executeUpdate();
            st.close();

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void removerBanco(String nomeProduto) {
        String codigo_produto = recuperaCodigoProduto(nomeProduto);
        
         try {
           
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            
            PreparedStatement st = connection.prepareStatement(
                    "DELETE FROM estoque WHERE codigo_produto = ?;"
            );
            
            st.setString(1, codigo_produto);
            
            st.executeUpdate();
            st.close();

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void alterarNomeBanco(String nomeProduto, String novoNomeProduto) {
        String codigo_produto = recuperaCodigoProduto(nomeProduto);
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            
            PreparedStatement st = connection.prepareStatement(
                    "UPDATE estoque SET nome_produto = ? WHERE codigo_produto = ?;"
            );
            
            st.setString(1, novoNomeProduto);
            st.setString(2, codigo_produto);
            
            st.executeUpdate();
            st.close();

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public static void alterarValorCustoBanco(String nomeProduto, String novoValorCusto) {
         String codigo_produto = recuperaCodigoProduto(nomeProduto);
         
         try {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            
            PreparedStatement st = connection.prepareStatement(
                    "UPDATE estoque SET valor_custo = ? WHERE codigo_produto = ?;"
            );
            
            st.setString(1, novoValorCusto);
            st.setString(2, codigo_produto);
            
            st.executeUpdate();
            st.close();

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void alterarValorVendaBanco(String nomeProduto, String novoValorVenda) {
        String codigo_produto = recuperaCodigoProduto(nomeProduto);
         
         try {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            
            PreparedStatement st = connection.prepareStatement(
                    "UPDATE estoque SET valor_venda = ? WHERE codigo_produto = ?;"
            );
            
            st.setString(1, novoValorVenda);
            st.setString(2, codigo_produto);
            
            st.executeUpdate();
            st.close();

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String quantidadeNoBanco(String nomeProduto) {
        String quantidade = null;
          try {
           
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            //Criar o insert
           
            PreparedStatement st = connection.prepareStatement(
                    "SELECT quantidade FROM estoque WHERE nome_produto = ?;"
            );
            //Adiciona os parametros no insert
            st.setString(1, nomeProduto);

            //Executa o insert
            ResultSet resultSet = st.executeQuery();
            resultSet.next();
            
            quantidade = resultSet.getString("quantidade");
            st.close();
            
            connection.close();
            
        } catch (Exception e) {
           e.printStackTrace();
        }
        return quantidade;
    }

    public static void alterarQuantidadeBanco(String nomeProduto, String quantidadeFinal) {
        String codigo_produto = recuperaCodigoProduto(nomeProduto);
         
         try {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            
            PreparedStatement st = connection.prepareStatement(
                    "UPDATE estoque SET quantidade = ? WHERE codigo_produto = ?;"
            );
            
            st.setString(1, quantidadeFinal);
            st.setString(2, codigo_produto);
            
            st.executeUpdate();
            st.close();

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static ItemEstoque recuperaProduto(String nomeProduto) {
    
        ItemEstoque produto = new ItemEstoque();
        try {
           
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            //Criar o insert
           
            PreparedStatement st = connection.prepareStatement(
                    "SELECT * FROM estoque WHERE nome_produto = ?;"
            );
            //Adiciona os parametros no insert
            st.setString(1, nomeProduto);

            //Executa o insert
            ResultSet resultSet = st.executeQuery();
            resultSet.next();
            
            produto.setNome(resultSet.getString("nome_produto"));
            produto.setValorCusto(resultSet.getDouble("valor_custo"));
            produto.setValorVenda(resultSet.getDouble("valor_venda"));
            produto.setQuantidade(resultSet.getInt("quantidade"));
            produto.setIdDistribuidora(resultSet.getInt("id_distribuidora"));
            st.close();
            
            connection.close();
            
        } catch (Exception e) {
           e.printStackTrace();
        }
        return produto;
    }

}
