package bilbioteca2.datos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBD {
    
    static String nombreBD = "Biblioteca.db";
    static Connection connect;
    
    public static void conectarBD(){
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:"+nombreBD);
            if (connect!=null) {
                System.out.println("Conectado");
            }
        }catch (SQLException ex) {
            System.err.println("No se ha podido conectar a la base de datos\n"+ex.getMessage());
        }
    }
    
    public static void cerrarBD(){
        try {
            connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String[] login(String usuario, String contraseña){
        conectarBD();
        String [] resultado = null;
        ResultSet result = null;
        try {
            PreparedStatement st = connect.prepareStatement("SELECT nombre,admin FROM usuarios where login='"+usuario+"' and password='"+contraseña+"'");
            result = st.executeQuery();
            if (result.next()) {
                boolean admin = result.getBoolean("admin");
                if (admin){
                    resultado[0]= result.getString("nombre");
                    resultado[1]= result.getString("true");
                }else{
                    resultado[0]= result.getString("nombre");
                    resultado[1]= result.getString("false");
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        cerrarBD();
        return resultado;
    }
}
