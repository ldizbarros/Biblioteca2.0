package bilbioteca2.metodos;

import bilbioteca2.aplicacion.*;
import bilbioteca2.datos.ConexionBD;
import libreria.Biblioteca;

public class MetodosGUI {
    
    public static void login(String login, String contraseña){
        String [] result = ConexionBD.login(login, contraseña);
        if (result.length==0){
            Biblioteca.mostrarMensaje("El usuario o la contraseña introducidos no son correctos.");
        }else{
            if (result[1].equalsIgnoreCase("true")){
                VentanaAdmin admin = new VentanaAdmin();
                admin.setVisible(true);
                PaginaPrincipal main = new PaginaPrincipal();
                main.setVisible(false);
            }else{
                VentanaUsuario usuario = new VentanaUsuario();
                usuario.setVisible(true);
                PaginaPrincipal main = new PaginaPrincipal();
                main.setVisible(false);
            }
        }
    }
}
