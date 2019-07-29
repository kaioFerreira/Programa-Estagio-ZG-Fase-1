package Model;

import ModeloItem.ItemCaixa;
import ModeloItem.ItemEstoque;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CaixaModel {
    static String url = "jdbc:mysql://localhost:3306/rocambole";
    static String user = "root";
    static String password = "";
    
    public static boolean verificaExisteEstoque(String nomeProduto) {
         String codigo_produto = null;
         int quantidade_produto = 0;
          try {
           
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
           
            PreparedStatement st = connection.prepareStatement(
                    "SELECT codigo_produto,quantidade FROM estoque WHERE nome_produto = ?;"
            );

            st.setString(1, nomeProduto);

            ResultSet resultSet = st.executeQuery();
            
            resultSet.next();
            
            codigo_produto = resultSet.getString("codigo_produto");
            quantidade_produto = resultSet.getInt("quantidade");
              
            st.close();
            
            connection.close();
            
        } catch (Exception e) {
            
        }
        
        if(codigo_produto == null || (quantidade_produto == 0)){
            return false;
        }
        return true;
    }

    public static void addCaixaBanco(String nomeProduto) {
        ItemEstoque produtoEstoque = new ItemEstoque();
        
        produtoEstoque = EstoqueModel.recuperaProduto(nomeProduto);
        String codigo = EstoqueModel.recuperaCodigoProduto(nomeProduto);
        
        try {
           
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
          
            PreparedStatement st = connection.prepareStatement(
                    "INSERT INTO caixa (codigo_produto,nome_produto,valor_unitario,quantidade) " +
                            "VALUES (?,?,?,?);"
            );
            
            st.setObject(1, codigo);
            st.setString(2, produtoEstoque.getNome());
            st.setObject(3, produtoEstoque.getValorVenda());
            st.setObject(4, 1);

            st.executeUpdate();
            st.close();

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static ItemCaixa recuperaProdutoCaixaBanco(String nomeProduto) {
       ItemCaixa produto = new ItemCaixa();
        try {
           
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            //Criar o insert
           
            PreparedStatement st = connection.prepareStatement(
                    "SELECT * FROM caixa WHERE nome_produto = ?;"
            );
            
            //Adiciona os parametros no insert
            st.setString(1, nomeProduto);

           
            ResultSet resultSet = st.executeQuery();
            resultSet.next();
            
            produto.setCodigoProduto(resultSet.getInt("codigo_produto"));
            produto.setNomeProduto(resultSet.getString("nome_produto"));
            produto.setValorUnitario(resultSet.getDouble("valor_unitario"));
            produto.setQuantidade(resultSet.getInt("quantidade"));
          
            st.close();
            
            connection.close();
            
        } catch (Exception e) {
           e.printStackTrace();
        }
        return produto;
    }

    public static String verificaExisteCaixa(String nomeProduto) {
        String codigo_produto = null;
        
          try {
           
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);

            PreparedStatement st = connection.prepareStatement(
                    "SELECT codigo_produto FROM caixa WHERE nome_produto = ?;"
            );

            st.setString(1, nomeProduto);

            ResultSet resultSet = st.executeQuery();
            
            resultSet.next();
            
            codigo_produto = resultSet.getString("codigo_produto");
            st.close();
            
            connection.close();
            
        } catch (Exception e) {
            
        }
        return codigo_produto;
    }

    public static void removeCaixaBanco(String nomeProduto) {
        String codigo_produto = verificaExisteCaixa(nomeProduto);
        
         try {
           
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            
            PreparedStatement st = connection.prepareStatement(
                    "DELETE FROM caixa WHERE codigo_produto = ?;"
            );
            
            st.setString(1, codigo_produto);
            
            st.executeUpdate();
            st.close();

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<ItemCaixa> ItensCaixa() {
        List<ItemCaixa> ItensCaixa = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);

            PreparedStatement st = connection.prepareStatement(
                            "SELECT * FROM caixa"
            );

            ResultSet resultSet = st.executeQuery();

            while (resultSet.next()) {

                    ItemCaixa itemCaixa = new ItemCaixa();
                    itemCaixa.setCodigoProduto(resultSet.getInt("codigo_produto"));
                    itemCaixa.setNomeProduto(resultSet.getString("nome_produto"));
                    itemCaixa.setValorUnitario(resultSet.getDouble("valor_unitario"));
                    itemCaixa.setQuantidade(resultSet.getInt("quantidade"));
                    ItensCaixa.add(itemCaixa);
            }
            st.close();
            resultSet.close();
            connection.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
         return ItensCaixa;
    }
    
    public static void addMaisUmCaixaBanco(String nomeProduto) {
        ItemCaixa produto = new ItemCaixa();
        produto = recuperaProdutoCaixaBanco(nomeProduto);
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            
            PreparedStatement st = connection.prepareStatement(
                    "UPDATE caixa SET quantidade = ? WHERE codigo_produto = ?;"
            );
            
            st.setString(1, Integer.toString(produto.getQuantidade() + 1));
            st.setString(2, Integer.toString(produto.getCodigoProduto()));
            
            st.executeUpdate();
            st.close();

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
