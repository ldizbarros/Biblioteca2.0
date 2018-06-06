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

    public static void conectarBD() {
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:" + nombreBD);
            if (connect != null) {
                System.out.println("Conectado");
            }
        } catch (SQLException ex) {
            System.err.println("No se ha podido conectar a la base de datos\n" + ex.getMessage());
        }
    }

    public static void cerrarBD() {
        try {
            connect.close();
            System.out.println("cerrada");
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String[] login(String usuario, String contraseña) {
        String[] resultado = new String[3];
        ResultSet result = null;
        try {
            PreparedStatement st = connect.prepareStatement("SELECT nombre,admin,codUsuario FROM usuarios where login='" + usuario + "' and password='" + contraseña + "'");
            result = st.executeQuery();
            if (result.next()) {
                boolean admin = result.getBoolean("admin");
                String nombre = result.getString("nombre");
                String codUsuario = String.valueOf(result.getInt("codUsuario"));
                if (admin) {
                    resultado[0] = nombre;
                    resultado[1] = "true";
                    resultado[2] = codUsuario;
                } else {
                    resultado[0] = nombre;
                    resultado[1] = "false";
                    resultado[2] = codUsuario;
                }
            }
        } catch (NullPointerException e) {
            Biblioteca.mostrarMensaje("El usuario o la contraseña introducidos no son correctos.");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resultado;
    }

    public static int ejemplaresDisponibles(int codLibro) {
        int ejemplares = 0;
        ResultSet result = null;
        try {
            PreparedStatement st = connect.prepareStatement("select count() as ejemplares from ejemplares where codLibro=" + codLibro + " and prestado=0");
            result = st.executeQuery();
            if (result.next()) {
                ejemplares = result.getInt("ejemplares");
            }
        } catch (NullPointerException e) {
            Biblioteca.mostrarMensaje("El libro introducido no tiene ejemplares disponibles");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return ejemplares;
    }

    public static int calcularCodigos(String tabla) {
        int codigo = 0;
        ResultSet result = null;
        try {
            PreparedStatement st = null;
            if (tabla.equalsIgnoreCase("libros")) {
                st = connect.prepareStatement("select max(codLibro) as codigo from libros");
            } else if (tabla.equalsIgnoreCase("ejemplares")) {
                st = connect.prepareStatement("select max(codEjemplar) as codigo from ejemplares");
            } else if (tabla.equalsIgnoreCase("autor")) {
                st = connect.prepareStatement("select max(codAutor) as codigo from autores");
            } else if (tabla.equalsIgnoreCase("usuarios")) {
                st = connect.prepareStatement("select max(codUsuario) as codigo from usuarios");
            } else if (tabla.equalsIgnoreCase("prestamos")) {
                st = connect.prepareStatement("select max(codPrestamo) as codigo from prestamos");
            }
            result = st.executeQuery();
            if (result.next()) {
                codigo = result.getInt("codigo") + 1;
            }
        } catch (NullPointerException e) {
            Biblioteca.mostrarMensaje("El libro introducido no tiene ejemplares disponibles");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return codigo;
    }

    public static ArrayList<Libro> busqueda(String busqueda, String filtro) {
        ArrayList<Libro> resultadosBusqueda = new ArrayList();
        ResultSet result1 = null;
        try {
            PreparedStatement st = null;
            if (filtro.equalsIgnoreCase("")) {
                st = connect.prepareStatement("SELECT distinct libros.codLibro, titulo,autor,editorial,isbn,añoPublicacion,seccion"
                        + " FROM libros INNER JOIN ejemplares "
                        + "ON libros.codLibro=ejemplares.codLibro INNER JOIN autores ON libros.codAutor=autores.codAutor "
                        + "INNER JOIN secciones ON libros.codSeccion=secciones.codSeccion "
                        + "WHERE titulo like '%" + busqueda + "%' or argumento like '%" + busqueda + "%' or isbn like '%" + busqueda + "%' or editorial like '%" + busqueda + "%' or "
                        + "añoPublicacion like '%" + busqueda + "%' or autor like '%" + busqueda + "%' or seccion like '%" + busqueda + "%'");
            } else if (filtro.equalsIgnoreCase("autor")) {
                st = connect.prepareStatement("SELECT distinct libros.codLibro, titulo,autor,editorial,isbn,añoPublicacion,seccion"
                        + " FROM libros INNER JOIN ejemplares "
                        + "ON libros.codLibro=ejemplares.codLibro INNER JOIN autores ON libros.codAutor=autores.codAutor "
                        + "INNER JOIN secciones ON libros.codSeccion=secciones.codSeccion "
                        + "WHERE autor like '%" + busqueda + "%'");
            } else if (filtro.equalsIgnoreCase("titulo")) {
                st = connect.prepareStatement("SELECT distinct libros.codLibro, titulo,autor,editorial,isbn,añoPublicacion,seccion"
                        + " FROM libros INNER JOIN ejemplares "
                        + "ON libros.codLibro=ejemplares.codLibro INNER JOIN autores ON libros.codAutor=autores.codAutor "
                        + "INNER JOIN secciones ON libros.codSeccion=secciones.codSeccion "
                        + "WHERE titulo like '%" + busqueda + "%'");
            } else if (filtro.equalsIgnoreCase("editorial")) {
                st = connect.prepareStatement("SELECT distinct libros.codLibro, titulo,autor,editorial,isbn,añoPublicacion,seccion"
                        + " FROM libros INNER JOIN ejemplares "
                        + "ON libros.codLibro=ejemplares.codLibro INNER JOIN autores ON libros.codAutor=autores.codAutor "
                        + "INNER JOIN secciones ON libros.codSeccion=secciones.codSeccion "
                        + "WHERE editorial like '%" + busqueda + "%'");
            } else if (filtro.equalsIgnoreCase("isbn")) {
                st = connect.prepareStatement("SELECT distinct libros.codLibro, titulo,autor,editorial,isbn,añoPublicacion,seccion"
                        + " FROM libros INNER JOIN ejemplares "
                        + "ON libros.codLibro=ejemplares.codLibro INNER JOIN autores ON libros.codAutor=autores.codAutor "
                        + "INNER JOIN secciones ON libros.codSeccion=secciones.codSeccion "
                        + "WHERE isbn like '%" + busqueda + "%'");
            } else if (filtro.equalsIgnoreCase("publicacion")) {
                st = connect.prepareStatement("SELECT distinct libros.codLibro, titulo,autor,editorial,isbn,añoPublicacion,seccion"
                        + " FROM libros INNER JOIN ejemplares "
                        + "ON libros.codLibro=ejemplares.codLibro INNER JOIN autores ON libros.codAutor=autores.codAutor "
                        + "INNER JOIN secciones ON libros.codSeccion=secciones.codSeccion "
                        + "WHERE añoPublicacion like '%" + busqueda + "%'");
            } else if (filtro.equalsIgnoreCase("seccion")) {
                st = connect.prepareStatement("SELECT distinct libros.codLibro, titulo,autor,editorial,isbn,añoPublicacion,seccion"
                        + " FROM libros INNER JOIN ejemplares "
                        + "ON libros.codLibro=ejemplares.codLibro INNER JOIN autores ON libros.codAutor=autores.codAutor "
                        + "INNER JOIN secciones ON libros.codSeccion=secciones.codSeccion "
                        + "WHERE seccion like '%" + busqueda + "%'");
            }
            result1 = st.executeQuery();
            while (result1.next()) {
                int ejemplares = ejemplaresDisponibles(result1.getInt("codLibro"));
                Libro nuevoLibro = new Libro(result1.getInt("codLibro"), result1.getString("titulo"), result1.getString("autor"),
                        result1.getString("editorial"), result1.getString("isbn"), result1.getString("añoPublicacion"),
                        result1.getString("seccion"), ejemplares);
                resultadosBusqueda.add(nuevoLibro);
            }
        } catch (NullPointerException e) {
            Biblioteca.mostrarMensaje("No se han encontrado coincidencias.");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resultadosBusqueda;
    }

    public static ArrayList<Prestamos> prestamosUsuarios(int codUsuario) {
        ArrayList<Prestamos> prestamosUsuario = new ArrayList();
        ResultSet result1 = null;
        try {
            PreparedStatement st = connect.prepareStatement("select * from prestamos inner join ejemplares on prestamos.codEjemplar=ejemplares.codEjemplar inner join "
                    + "libros on libros.codLibro=ejemplares.codLibro where devuelto=0 and prestamos.codUsuario=" + codUsuario);
            result1 = st.executeQuery();
            while (result1.next()) {
                Prestamos nuevoPrestamo = new Prestamos(result1.getInt("codPrestamo"), codUsuario, result1.getString("titulo"), result1.getString("fechaInicio"), result1.getString("fechaFin"),
                        result1.getInt("aumento"));
                prestamosUsuario.add(nuevoPrestamo);
            }
        } catch (NullPointerException e) {
            Biblioteca.mostrarMensaje("No se han encontrado coincidencias.");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return prestamosUsuario;
    }

    public static String[] infoLibro(int codLibro) {
        String[] libro = new String[7];
        ResultSet result = null;
        try {
            PreparedStatement st = connect.prepareStatement("select * from libros inner join autores on libros.codAutor=autores.codAutor inner join secciones "
                    + "on libros.codSeccion=secciones.codSeccion where codLibro=" + codLibro);
            result = st.executeQuery();
            if (result.next()) {
                int ejemplares = ejemplaresDisponibles(codLibro);
                libro[0] = result.getString("titulo");
                libro[1] = result.getString("autor");
                libro[2] = result.getString("seccion");
                libro[3] = result.getString("zona");
                libro[4] = result.getString("argumento");
                libro[5] = result.getString("numEjemplares");
                libro[6] = String.valueOf(ejemplares);
            }
        } catch (NullPointerException e) {
            Biblioteca.mostrarMensaje("No se han encontrado coincidencias.");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return libro;
    }

    public static void aumentarPrestamo(int codPrestamo) {
        int aumento = 0, aumentos = 0;
        String fecha = "";
        ResultSet result = null;
        try {
            PreparedStatement st1 = connect.prepareStatement("select fechaFin,aumento from prestamos where codPrestamo=" + codPrestamo);
            result = st1.executeQuery();
            if (result.next()) {
                fecha = result.getString("fechaFin");
                aumento = result.getInt("aumento");

            }
            String[] dias = fecha.split("/");
            int dia = Integer.parseInt(dias[0]);
            int mes = Integer.parseInt(dias[1]);
            int año = Integer.parseInt(dias[2]);
            LocalDate fechaFin = LocalDate.of(año, mes, dia);
            LocalDate nueva = fechaFin.plusDays(15);
            String nuevaFecha = nueva.getDayOfMonth() + "/" + nueva.getMonthValue() + "/" + nueva.getYear();
            if (aumento == 2) {
                Biblioteca.mostrarMensaje("Ya ha hecho todos los aumentos permitidos.\nNo puede aumentar el prestamo");
            } else {
                aumentos = aumento + 1;
                PreparedStatement st2 = connect.prepareStatement("UPDATE Prestamos SET fechaFin='" + nuevaFecha + "' , aumento = " + aumentos + "   where codPrestamo=" + codPrestamo);
                st2.executeUpdate();
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static ArrayList<Ejemplares> cargarEjemplares(int codLibro) {
        ArrayList<Ejemplares> ejemplares = new ArrayList();
        ResultSet result1 = null;
        try {
            PreparedStatement st = connect.prepareStatement("select * from ejemplares where codLibro=" + codLibro);
            result1 = st.executeQuery();
            while (result1.next()) {
                Ejemplares nuevoEjemplar = new Ejemplares(result1.getInt("codEjemplar"), result1.getString("isbn"), result1.getString("editorial"), result1.getString("añoPublicacion"),
                        result1.getString("comentarios"), result1.getBoolean("prestado"));
                ejemplares.add(nuevoEjemplar);
            }
        } catch (NullPointerException e) {
            Biblioteca.mostrarMensaje("No se han encontrado ejemplares de el libro seleccionado");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return ejemplares;
    }

    public static String cargarComentario(int codEjemplar) {
        ResultSet result = null;
        String comentario = "";
        try {
            PreparedStatement st = connect.prepareStatement("select comentarios from ejemplares where codEjemplar=" + codEjemplar);
            result = st.executeQuery();
            if (result.next()) {
                comentario = result.getString("comentarios");
            }
        } catch (NullPointerException e) {
            Biblioteca.mostrarMensaje("No se han encontrado ejemplares de el libro seleccionado");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return comentario;
    }

    public static void guardarComentario(int codEjemplar, String comentarios) {
        try {
            PreparedStatement st = connect.prepareStatement("UPDATE ejemplares SET comentarios='" + comentarios + "'  where codEjemplar=" + codEjemplar);
            st.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void borrarEjemplar(int codEjemplar) {
        ResultSet result = null;
        int codLibro = 0, numEjemplares = 0;
        try {
            PreparedStatement st = connect.prepareStatement("select codLibro,numEjemplares from libros  where codLibro=(select codLibro from ejemplares where codEjemplar=" + codEjemplar + ")");
            result = st.executeQuery();
            if (result.next()) {
                codLibro = result.getInt("codLibro");
                numEjemplares = result.getInt("numEjemplares");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        try {
            PreparedStatement st2 = connect.prepareStatement("UPDATE libros SET numEjemplares=" + (numEjemplares - 1) + " where codLibro=" + codLibro);
            st2.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        try {
            PreparedStatement st3 = connect.prepareStatement("DELETE FROM ejemplares WHERE codEjemplar=" + codEjemplar);
            st3.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static boolean añadirSocio(Usuario usuario) {
        boolean correcto;
        int codUsuario = calcularCodigos("usuarios");
        try {
            PreparedStatement st = connect.prepareStatement("insert into usuarios (codUsuario, dni, nombre, apellidos,telefono, correo, login, password, admin) values (?,?,?,?,?,?,?,?,?)");
            st.setInt(1, codUsuario);
            st.setString(2, usuario.getDni());
            st.setString(3, usuario.getNombre());
            st.setString(4, usuario.getApellidos());
            st.setString(5, usuario.getTelefono());
            st.setString(6, usuario.getCorreo());
            st.setString(7, usuario.getLogin());
            st.setString(8, usuario.getPassword());
            st.setBoolean(9, usuario.isAdministrador());
            st.execute();
            correcto=true;
        } 
        catch (SQLException ex) {
            if (ex.getErrorCode()==19){
                Biblioteca.mostrarMensaje("El dni/login introducido ya exite en la base de datos");
                correcto=false;
            } else {
                System.err.println(ex.getMessage());
                correcto=false;
            }
        }
        return correcto;
    }

    public static void eliminarSocio(String dni) {
        try {
            PreparedStatement st = connect.prepareStatement("DELETE FROM usuarios WHERE dni=?");
            st.setString(1, dni);
            st.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<String> comprobarDni() {
        ArrayList<String> dnis = new ArrayList();
        ResultSet result = null;
        try {
            PreparedStatement st = connect.prepareStatement("select dni from usuarios");
            result = st.executeQuery();
            while (result.next()) {
                String dni = result.getString("dni");
                dnis.add(dni);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return dnis;
    }

    public static void añadirPrestamo(int codUsuario, int codEjemplar, String diaPrestamo, String diaDevolucion) {

        int codPrestamo = calcularCodigos("prestamos");

        try {
            PreparedStatement st = connect.prepareStatement("insert into prestamos (codPrestamo,codEjemplar,codUsuario, fechaInicio,fechaFin,devuelto,aumento) values (?,?,?,?,?,?,?)");
            st.setInt(1, codPrestamo);
            st.setInt(2, codEjemplar);
            st.setInt(3, codUsuario);
            st.setString(4, diaPrestamo);
            st.setString(5, diaDevolucion);
            st.setBoolean(6, false);
            st.setInt(7, 0);
            st.execute();

            PreparedStatement st2 = connect.prepareStatement("UPDATE ejemplares SET prestado=" + 1 + " where codEjemplar=" + codEjemplar);
            st2.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static int recogerCodUsuario(String dni) {
        ResultSet result = null;
        int codUsuario = 0;
        try {
            PreparedStatement st = connect.prepareStatement("select codUsuario from usuarios where dni='" + dni + "';");
            result = st.executeQuery();
            codUsuario = result.getInt("codUsuario");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return codUsuario;
    }

    public static ArrayList<String> visualizarLibros() {

        ArrayList<String> titulos = new ArrayList();
        ResultSet result = null;
        try {
            PreparedStatement st = connect.prepareStatement("select codEjemplar,titulo from libros inner join ejemplares on libros.codLibro=ejemplares.codLibro where prestado=0");
            result = st.executeQuery();
            while (result.next()) {

                String titulo = result.getString("titulo");
                int codigo = result.getInt("codEjemplar");
                titulos.add(codigo + " - " + titulo);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return titulos;

    }

    public static ArrayList<String> visualizarDnis() {
        ArrayList<String> listadni = new ArrayList();
        ResultSet result = null;
        try {
            PreparedStatement st = connect.prepareStatement("select dni from usuarios");
            result = st.executeQuery();
            while (result.next()) {

                String dni = result.getString("dni");
                listadni.add(dni);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return listadni;
    }

    public static void devolverPrestamo(int codEjemplar, String dni) {
        try {
            PreparedStatement st = connect.prepareStatement("UPDATE prestamos SET prestado=" + 0 + " where codEjemplar=" + codEjemplar);
            st.execute();
            PreparedStatement st2 = connect.prepareStatement("select codUsuario from usuarios where dni='" + dni + "'");
            st.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void añadirLibro(String titulo, String autor, String seccion, String argumento, int numEjemplares, String editorial, String isbn, String año) {

        int codLibro = calcularCodigos("libros");
        boolean existe = false;
        ResultSet result = null;
        try {
            PreparedStatement st = connect.prepareStatement("select autor from autores");
            result = st.executeQuery();

            while (result.next()) {
                if (autor.equals(result.getString(1))) {
                    existe = true;
                }
            }

            PreparedStatement st2 = connect.prepareStatement("insert into libros (codLibro,titulo,codAutor, codSeccion,argumento,numEjemplares) values (?,?,?,?,?,?)");
            st2.setInt(1, codLibro);
            st2.setString(2, titulo);

            if (existe == true) {
                PreparedStatement st3 = connect.prepareStatement("select codAutor from autores where autor='" + autor + "'");
                result = st3.executeQuery();
                st2.setInt(3, result.getInt(1));
            } else {
                int codAutor = calcularCodigos("autor");
                PreparedStatement st4 = connect.prepareStatement("insert into autores(codAutor,autor) values (?,?)");
                st4.setInt(1, codAutor);
                st4.setString(2, autor);
                st4.execute();
                st2.setInt(3, codAutor);
            }
            st2.setString(4, seccion);
            st2.setString(5, argumento);
            st2.setInt(6, numEjemplares);
            st2.execute();
            for (int i = 0; i < numEjemplares; i++) {
                int codEjemplar = calcularCodigos("ejemplares");
                 PreparedStatement st5 = connect.prepareStatement("insert into ejemplares (codEjemplar,codLibro,editorial, isbn,añoPublicacion,comentarios,prestado) values (?,?,?,?,?,?,?)");
                st5.setInt(1, codEjemplar);
                st5.setInt(2, codLibro);
                st5.setString(3, editorial);
                st5.setString(4, isbn);
                st5.setString(5, año);
                st5.setString(6, null);
                st5.setBoolean(7, false);
                st5.execute();
            }
            
             
             
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
    //   public static void prestamoQuique(String dni) {
//
//        try {
//            Statement st = connect.createStatement();
//            ResultSet rs = st.executeQuery("select codUsuario from usuarios where dni = '" + dni + "';");
//            
//            int codUsr = Integer.parseInt(rs.getString(1));
//            
//            rs.close();
//            rs = st.executeQuery("select codEjemplar from prestamos where codUsuario = "+codUsr+" and devuelto = 0;");
//            
//            ArrayList<Integer> codEjemplar = new ArrayList<Integer>(); 
//            while(rs.next()){
//            codEjemplar.add(Integer.parseInt(rs.getString(1)));
//            }
//            rs.close();
//            for (int i = 0; i < codEjemplar.size(); i++) {
//                rs = st.executeQuery("select ")
//            }
//            
//        } catch (SQLException ex) {
//            System.out.println("Que pasa hulio " + ex);
//        }
//
    //   }
}
