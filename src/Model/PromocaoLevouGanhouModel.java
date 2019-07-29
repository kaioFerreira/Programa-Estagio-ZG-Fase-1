package Model;

import ModeloItem.ItemPromocaoLevouGanhou;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PromocaoLevouGanhouModel {
    static String url = "jdbc:mysql://localhost:3306/rocambole";
    static String user = "root";
    static String password = "";

    public static String verificaExistePromocao(String nomePromocao) {
        String codigo = null;
         
          try {
           
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
           
            PreparedStatement st = connection.prepareStatement(
                    "SELECT codigo FROM promocao_levou_ganhou WHERE nome_promocao = ?;"
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
    
    public static void adicionaPromocaoBanco(ItemPromocaoLevouGanhou promocao) {
        
        try {
           
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
          
            PreparedStatement st = connection.prepareStatement(
                    "INSERT INTO promocao_levou_ganhou (nome_promocao,produto_relacionado,quantidade_leva,quantidade_paga) " +
                            "VALUES (?,?,?,?);"
            );
            st.setString(1, promocao.getNomePromocao());
            st.setObject(2, promocao.getProdutoRelacionado());
            st.setObject(3, promocao.getQuantidadeLeva());
            st.setObject(4, promocao.getQuantidadePaga());
            
            st.executeUpdate();
            st.close();

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void removePromocaoBanco(String codigoProduto) {
        
        try {
           
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            
            PreparedStatement st = connection.prepareStatement(
                    "DELETE FROM promocao_levou_ganhou WHERE codigo = ?;"
            );
            
            st.setString(1, codigoProduto);
            
            st.executeUpdate();
            st.close();

            connection.close();
        } catch (Exception e) {
            
        }
    }

    public static List<ItemPromocaoLevouGanhou> itensPromocao() {
        List<ItemPromocaoLevouGanhou> itensPromocao = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);

            PreparedStatement st = connection.prepareStatement(
                            "SELECT * FROM promocao_levou_ganhou ORDER BY quantidade_leva desc"
            );

            ResultSet resultSet = st.executeQuery();

            while (resultSet.next()) {
                    ItemPromocaoLevouGanhou itemPromocao = new ItemPromocaoLevouGanhou();
                    itemPromocao.setNomePromocao(resultSet.getString("nome_promocao"));
                    itemPromocao.setProdutoRelacionado(resultSet.getInt("produto_relacionado"));
                    itemPromocao.setQuantidadeLeva(resultSet.getInt("quantidade_leva"));
                    itemPromocao.setQuantidadePaga(resultSet.getInt("quantidade_paga"));
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
