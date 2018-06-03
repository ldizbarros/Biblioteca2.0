package bilbioteca2.datos;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import libreria.Biblioteca;

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
        String [] resultado = new String[3];
        ResultSet result = null;
        try {
            PreparedStatement st = connect.prepareStatement("SELECT nombre,admin,codUsuario FROM usuarios where login='"+usuario+"' and password='"+contraseña+"'");
            result = st.executeQuery();
            if (result.next()) {
                boolean admin = result.getBoolean("admin");
                String nombre = result.getString("nombre");
                String codUsuario = String.valueOf(result.getInt("codUsuario"));
                if (admin){
                    resultado[0]= nombre;
                    resultado[1]= "true";
                    resultado[2]= codUsuario;
                }else{
                    resultado[0]= nombre;
                    resultado[1]= "false";
                    resultado[2]= codUsuario;
                }
            }
        } catch(NullPointerException e) {
             Biblioteca.mostrarMensaje("El usuario o la contraseña introducidos no son correctos.");
        }
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        cerrarBD();
        return resultado;
    }
    
    public static int ejemplaresDisponibles(int codLibro){
        int ejemplares = 0;
        conectarBD();
        ResultSet result = null;
        try {
            PreparedStatement st = connect.prepareStatement("select count() as ejemplares from ejemplares where codLibro="+codLibro+" and prestado=0");
            result = st.executeQuery();
            if (result.next()) {
                ejemplares = result.getInt("ejemplares");
            }
        } catch(NullPointerException e) {
             Biblioteca.mostrarMensaje("El libro introducido no tiene ejemplares disponibles");
        }
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        cerrarBD();
        return ejemplares;
    }
    
    public static int calcularCodigos(String tabla){
        int codigo = 0;
        conectarBD();
        ResultSet result = null;
        try {
            PreparedStatement st = null;
            if (tabla.equalsIgnoreCase("libros")){
                st= connect.prepareStatement("select max(codLibro) as codigo from libros");
            }else if (tabla.equalsIgnoreCase("ejemplares")){
                st= connect.prepareStatement("select max(codEjemplar) as codigo from ejemplares");
            }else if (tabla.equalsIgnoreCase("autor")) {
                st= connect.prepareStatement("select max(codAutor) as codigo from autores");
            }else if(tabla.equalsIgnoreCase("usuarios")){
                st= connect.prepareStatement("select max(codUsuario) as codigo from usuarios");
            }   
            result = st.executeQuery();
            if (result.next()) {
                codigo = result.getInt("codigo")+1;
            }
        } catch(NullPointerException e) {
             Biblioteca.mostrarMensaje("El libro introducido no tiene ejemplares disponibles");
        }
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        cerrarBD();
        return codigo;
    }
    
    
    public static ArrayList <Libro> busqueda(String busqueda, String filtro){
        conectarBD();
        ArrayList <Libro> resultadosBusqueda = new ArrayList();
        ResultSet result1 = null;
        
        try {
            
            PreparedStatement st = null;
            if (filtro.equalsIgnoreCase("")){
                st = connect.prepareStatement("SELECT distinct libros.codLibro, titulo,autor,editorial,isbn,añoPublicacion,seccion"+
                " FROM libros INNER JOIN ejemplares " +
                "ON libros.codLibro=ejemplares.codLibro INNER JOIN autores ON libros.codAutor=autores.codAutor " +
                "INNER JOIN secciones ON libros.codSeccion=secciones.codSeccion " +
                "WHERE titulo like '%"+busqueda+"%' or argumento like '%"+busqueda+"%' or isbn like '%"+busqueda+"%' or editorial like '%"+busqueda+"%' or " +
                "añoPublicacion like '%"+busqueda+"%' or autor like '%"+busqueda+"%' or seccion like '%"+busqueda+"%'");
            }else if (filtro.equalsIgnoreCase("autor")){
                st = connect.prepareStatement("SELECT distinct libros.codLibro, titulo,autor,editorial,isbn,añoPublicacion,seccion"+
                " FROM libros INNER JOIN ejemplares " +
                "ON libros.codLibro=ejemplares.codLibro INNER JOIN autores ON libros.codAutor=autores.codAutor " +
                "INNER JOIN secciones ON libros.codSeccion=secciones.codSeccion " +
                "WHERE autor like '%"+busqueda+"%'");
            }else if (filtro.equalsIgnoreCase("titulo")){
                st = connect.prepareStatement("SELECT distinct libros.codLibro, titulo,autor,editorial,isbn,añoPublicacion,seccion"+
                " FROM libros INNER JOIN ejemplares " +
                "ON libros.codLibro=ejemplares.codLibro INNER JOIN autores ON libros.codAutor=autores.codAutor " +
                "INNER JOIN secciones ON libros.codSeccion=secciones.codSeccion " +
                "WHERE titulo like '%"+busqueda+"%'");
            }else if (filtro.equalsIgnoreCase("editorial")){
                st = connect.prepareStatement("SELECT distinct libros.codLibro, titulo,autor,editorial,isbn,añoPublicacion,seccion"+
                " FROM libros INNER JOIN ejemplares " +
                "ON libros.codLibro=ejemplares.codLibro INNER JOIN autores ON libros.codAutor=autores.codAutor " +
                "INNER JOIN secciones ON libros.codSeccion=secciones.codSeccion " +
                "WHERE editorial like '%"+busqueda+"%'");
            }else if (filtro.equalsIgnoreCase("isbn")){
                st = connect.prepareStatement("SELECT distinct libros.codLibro, titulo,autor,editorial,isbn,añoPublicacion,seccion"+
                " FROM libros INNER JOIN ejemplares " +
                "ON libros.codLibro=ejemplares.codLibro INNER JOIN autores ON libros.codAutor=autores.codAutor " +
                "INNER JOIN secciones ON libros.codSeccion=secciones.codSeccion " +
                "WHERE isbn like '%"+busqueda+"%'");
            }else if (filtro.equalsIgnoreCase("publicacion")){
                st = connect.prepareStatement("SELECT distinct libros.codLibro, titulo,autor,editorial,isbn,añoPublicacion,seccion"+
                " FROM libros INNER JOIN ejemplares " +
                "ON libros.codLibro=ejemplares.codLibro INNER JOIN autores ON libros.codAutor=autores.codAutor " +
                "INNER JOIN secciones ON libros.codSeccion=secciones.codSeccion " +
                "WHERE añoPublicacion like '%"+busqueda+"%'");
            }else if (filtro.equalsIgnoreCase("seccion")){
                st = connect.prepareStatement("SELECT distinct libros.codLibro, titulo,autor,editorial,isbn,añoPublicacion,seccion"+
                " FROM libros INNER JOIN ejemplares " +
                "ON libros.codLibro=ejemplares.codLibro INNER JOIN autores ON libros.codAutor=autores.codAutor " +
                "INNER JOIN secciones ON libros.codSeccion=secciones.codSeccion " +
                "WHERE seccion like '%"+busqueda+"%'");
            }
            result1 = st.executeQuery();
            while (result1.next()) {
                int ejemplares = ejemplaresDisponibles(result1.getInt("codLibro"));
                Libro nuevoLibro = new Libro(result1.getInt("codLibro"),result1.getString("titulo"),result1.getString("autor"),
                        result1.getString("editorial"),result1.getString("isbn"),result1.getString("añoPublicacion"),
                        result1.getString("seccion"),ejemplares);
                resultadosBusqueda.add(nuevoLibro);
            }
        } catch(NullPointerException e) {
             Biblioteca.mostrarMensaje("No se han encontrado coincidencias.");
        }
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        cerrarBD();
        return resultadosBusqueda;
    }
    
    public static ArrayList <Prestamos> prestamosUsuarios(int codUsuario){
        conectarBD();
        ArrayList <Prestamos> prestamosUsuario = new ArrayList();
        ResultSet result1 = null;
        try {
            PreparedStatement st = connect.prepareStatement("select * from prestamos inner join ejemplares on prestamos.codEjemplar=ejemplares.codEjemplar inner join "
                    + "libros on libros.codLibro=ejemplares.codLibro where devuelto=0 and prestamos.codUsuario="+codUsuario);
            result1 = st.executeQuery();
            while (result1.next()) {
                Prestamos nuevoPrestamo = new Prestamos(result1.getInt("codPrestamo"),codUsuario,result1.getString("titulo"),result1.getString("fechaInicio"),result1.getString("fechaFin")
                ,result1.getInt("aumento"));
                prestamosUsuario.add(nuevoPrestamo);
            }
        } catch(NullPointerException e) {
             Biblioteca.mostrarMensaje("No se han encontrado coincidencias.");
        }
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        cerrarBD();
        return prestamosUsuario;
    }
    
    public static String [] infoLibro(int codLibro){
        String [] libro = new String [7];
        conectarBD();
        ResultSet result = null;
        try {
            PreparedStatement st = connect.prepareStatement("select * from libros inner join autores on libros.codAutor=autores.codAutor inner join secciones "
                    + "on libro.codSeccion=secciones.codSeccion where codLibro="+codLibro);
            result = st.executeQuery();
            if (result.next()) {
                libro [0] = result.getString("titulo");
                libro [1] = result.getString("autor");
                libro [2] = result.getString("seccion");
                libro [3] = result.getString("zona");
                libro [4] = result.getString("argumento");
                libro [5] = result.getString("numEjemplares");
                libro [6] = result.getString(String.valueOf(ejemplaresDisponibles(codLibro)));
            }
        } catch(NullPointerException e) {
             Biblioteca.mostrarMensaje("No se han encontrado coincidencias.");
        }
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        cerrarBD();
        return libro;
    }
    
    public static void aumentarPrestamo(int codPrestamo){
        //cerrarBD();
        conectarBD();   
        int aumento=0,aumentos=0;
        String fecha="";
        ResultSet result = null;
        try {
            PreparedStatement st1 = connect.prepareStatement("select fechaFin,aumento from prestamos where codPrestamo="+codPrestamo);
            result = st1.executeQuery();
            if (result.next()) {
                fecha= result.getString("fechaFin");
                aumento = result.getInt("aumento");
               
            }
            String [] dias =  fecha.split("/");
            int dia = Integer.parseInt(dias[0]);
            int mes = Integer.parseInt(dias[1]);
            int año = Integer.parseInt(dias[2]);
            LocalDate fechaFin = LocalDate.of(año, mes, dia);
            LocalDate nueva = fechaFin.plusDays(15);
            String nuevaFecha = nueva.getDayOfMonth()+"/"+nueva.getMonthValue()+"/"+nueva.getYear();
            if (aumento==2){
                aumentos = aumento;
            }else{
                aumentos = aumento+1;
            }
            PreparedStatement st2 = connect.prepareStatement("UPDATE Prestamos SET fechaFin='"+nuevaFecha+"' , aumento = "+aumentos+"   where codPrestamo="+codPrestamo);
            st2.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        cerrarBD();
    }
}
