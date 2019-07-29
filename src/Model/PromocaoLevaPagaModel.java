package Model;

import ModeloItem.ItemPromocaoLevaPaga;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PromocaoLevaPagaModel {
    static String url = "jdbc:mysql://localhost:3306/rocambole";
    static String user = "root";
    static String password = "";
    
    public static void adicionaPromocaoBanco(ItemPromocaoLevaPaga promocao) {
        
        try {
           
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
          
            PreparedStatement st = connection.prepareStatement(
                    "INSERT INTO promocao_leva_paga (nome_promocao,produto_relacionado,quantidade_leva,valor_que_paga) " +
                            "VALUES (?,?,?,?);"
            );
            st.setString(1, promocao.getNomePromocao());
            st.setObject(2, promocao.getProdutoRelacionado());
            st.setObject(3, promocao.getQuantidadeLeva());
            st.setObject(4, promocao.getValorPaga());
            
            st.executeUpdate();
            st.close();

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String verificaExisteEstoque(int produtoRelacionado) {
        String codigo_produto = null;
         
          try {
           
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            //Criar o insert
           
            PreparedStatement st = connection.prepareStatement(
                    "SELECT codigo_produto FROM estoque WHERE codigo_produto = ?;"
            );
            //Adiciona os parametros no insert
            st.setObject(1, produtoRelacionado);

            //Executa o insert
            ResultSet resultSet = st.executeQuery();
            
            resultSet.next();
            
            codigo_produto = resultSet.getString("codigo_produto");
              
            st.close();
            
            connection.close();
            
        } catch (Exception e) {
            
        }
        
        return codigo_produto;
    }

    
    public static boolean removePromocaoBanco(String codigo_produto) {
        
        try {
           
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            
            PreparedStatement st = connection.prepareStatement(
                    "DELETE FROM promocao_leva_paga WHERE codigo = ?;"
            );
            
            st.setString(1, codigo_produto);
            
            st.executeUpdate();
            st.close();

            connection.close();
        } catch (Exception e) {
            
        }
        return codigo_produto == null ? false : true;
    }

    public static String verificaExistePromocao(String nomePromocao) {
        String codigo = null;
         
          try {
           
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
           
            PreparedStatement st = connection.prepareStatement(
                    "SELECT codigo FROM promocao_leva_paga WHERE nome_promocao = ?;"
            );

            st.setObject(1, nomePromocao);

            ResultSet resultSet = st.executeQuery();
            
            resultSet.next();
            
            codigo = resultSet.getString("codigo");
              
            st.close();
            
            connection.close();
            
        } catch (Exception e) {
            
        }
        
        return codigo;
    }

    public static List<ItemPromocaoLevaPaga> itensPromocao() {
        List<ItemPromocaoLevaPaga> itensPromocao = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);

            PreparedStatement st = connection.prepareStatement(
                            "SELECT * FROM promocao_leva_paga ORDER BY quantidade_leva desc"
            );

            ResultSet resultSet = st.executeQuery();

            while (resultSet.next()) {
                    ItemPromocaoLevaPaga itemPromocao = new ItemPromocaoLevaPaga();
                    itemPromocao.setNomePromocao(resultSet.getString("nome_promocao"));
                    itemPromocao.setProdutoRelacionado(resultSet.getInt("produto_relacionado"));
                    itemPromocao.setQuantidadeLeva(resultSet.getInt("quantidade_leva"));
                    itemPromocao.setValorPaga(resultSet.getDouble("valor_que_paga"));
                    itensPromocao.add(itemPromocao);
            }
            st.close();
            resultSet.close();
            connection.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
         return itensPromocao;
    }
    
 
}
