package Model;

import ModeloItem.ItemDistribuidora;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DistribuidoraModel {
    static String url = "jdbc:mysql://localhost:3306/rocambole";
    static String user = "root";
    static String password = "";

    public static void adicionaBanco(ItemDistribuidora itemDistribuidora) {
        try {
           
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
          
            PreparedStatement st = connection.prepareStatement(
                    "INSERT INTO distribuidora (nome,telefone,email) " +
                            "VALUES (?,?,?);"
            );

            st.setString(1, itemDistribuidora.getNome());
            st.setObject(2, itemDistribuidora.getTelefone());
            st.setObject(3, itemDistribuidora.getEmail());

            st.executeUpdate();
            st.close();

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
