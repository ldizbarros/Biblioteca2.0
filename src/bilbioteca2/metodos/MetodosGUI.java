package bilbioteca2.metodos;

import bilbioteca2.aplicacion.*;
import bilbioteca2.datos.*;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import libreria.Biblioteca;

public class MetodosGUI {

    public static void login(String login, String contraseña) {
        if (login.equalsIgnoreCase("") || contraseña.equalsIgnoreCase("")) {
            Biblioteca.mostrarMensaje("No han completado todos los campos.\nInténtelo de nuevo");
            PaginaPrincipal main = new PaginaPrincipal();
            main.setVisible(true);
        } else {
            String[] result = ConexionBD.login(login, contraseña);
            if (result[0] == null) {
                Biblioteca.mostrarMensaje("El usuario o la contraseña introducidos no son correctos.");
                PaginaPrincipal main = new PaginaPrincipal();
                main.setVisible(true);
            } else {
                if (result[1].equalsIgnoreCase("true")) {
                    VentanaAdmin admin = new VentanaAdmin();
                    admin.setVisible(true);
                    VentanaAdmin.jLabel_Usuario.setText("Hola " + result[0]);
                } else {
                    VentanaUsuario usuario = new VentanaUsuario();
                    usuario.setVisible(true);
                    usuario.setName(result[0]);
                    VentanaUsuario.jLabel_Usuario.setText("Hola "+result[0]);
                    VentanaUsuario.jLabel_codUsuario.setText(result[2]);
                }
            }
        }
    }

    public static void cerrarSesion() {
        PaginaPrincipal main = new PaginaPrincipal();
        main.setVisible(true);
    }

    public static DefaultTableModel mostrarLibros(ArrayList<Libro> libros) {
        if (libros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se han encontrado coincidencias");
            return null;
        } else {
            DefaultTableModel tabla = new DefaultTableModel();
            tabla.addColumn("CODIGO");
            tabla.addColumn("TITULO");
            tabla.addColumn("AUTOR");
            tabla.addColumn("EDITORIAL");
            tabla.addColumn("ISBN");
            tabla.addColumn("AÑO PUBLICACION");
            tabla.addColumn("SECCION");
            tabla.addColumn("EJEMPLARES DISPONIBLES");
            Iterator it = libros.iterator();
            while (it.hasNext()) {
                Libro libro = (Libro) it.next();
                String[] fila = new String[8];
                fila[0] = String.valueOf(libro.getCodigo());
                fila[1] = libro.getTitulo();
                fila[2] = libro.getAutor();
                fila[3] = libro.getEditorial();
                fila[4] = libro.getIsbn();
                fila[5] = libro.getAñoPublicacion();
                fila[6] = libro.getSeccion();
                fila[7] = String.valueOf(libro.getEjemplaresDisponibles());
                tabla.addRow(fila);
            }
            return tabla;
        }
    }

    public static ArrayList<Libro> busqueda(String busqueda, String filtro) {
        return ConexionBD.busqueda(busqueda, filtro);
    }
    
    public static ArrayList <Prestamos> verPrestamos(int codUsuario){
        return ConexionBD.prestamosUsuarios(codUsuario);
    } 
    
    public static DefaultTableModel mostrarPrestamos(ArrayList <Prestamos> prestamos){
         if (prestamos.isEmpty()){
            JOptionPane.showMessageDialog(null, "No tienes ningun prestamo sin devolver");
            return null;
        }else{
            DefaultTableModel tabla = new DefaultTableModel();
            tabla.addColumn("CODIGO");
            tabla.addColumn("TITULO");
            tabla.addColumn("FECHA DEVOLUCION");
            tabla.addColumn("AUMENTO");
            Iterator it = prestamos.iterator();
            while(it.hasNext()){
                Prestamos prestamo = (Prestamos) it.next();
                String[] fila = new String[4];
                fila[0] = String.valueOf(prestamo.getCodPrestamo());
                fila[1] = prestamo.getLibro();
                fila[2] = prestamo.getFechaDevolucion();
                if (prestamo.getAumento()==2){
                    fila[3] = String.valueOf("Ya no tiene disponibles mas aumentos");
                }else{
                    fila[3] = String.valueOf("Ha hecho "+prestamo.getAumento()+" aumento/s");
                }
                tabla.addRow(fila);
            }
            return tabla;
        }
    }
    
    public static void mostrarLibro(String codLibro){
        FichaLibro mostrarFicha = new FichaLibro(codLibro);
        mostrarFicha.setVisible(true);    
    }
    
    public static String [] infoLibro(int codLibro){
        String [] libro = ConexionBD.infoLibro(codLibro);
        return libro;
    }
    
    public static void aumetarPrestamo(String codPrestamo){
        int codigo= Integer.parseInt(codPrestamo);
        ConexionBD.aumentarPrestamo(codigo);
    }

    public static void añadirS(String dni, String nombre, String apellidos, String telefono, String correo, String login, String password, boolean administrador) {

        if (dni.equalsIgnoreCase("") || nombre.equalsIgnoreCase("") || apellidos.equalsIgnoreCase("") || telefono.equalsIgnoreCase("")
                || correo.equalsIgnoreCase("") || login.equalsIgnoreCase("") || password.equalsIgnoreCase("")) {
            Biblioteca.mostrarMensaje("No han completado todos los campos.\nInténtelo de nuevo");
        } else if (Usuario.validar(dni) == false) {
            Biblioteca.mostrarMensaje("DNI no válido");
        } else if (telefono.length() != 9) {
            Biblioteca.mostrarMensaje("Número de teléfono no válido");
        } else {
            Usuario us = new Usuario(dni, nombre, apellidos, telefono, correo, login, password, administrador);
            ConexionBD.añadirSocio(us);
        }
    }

    public static void eliminarS(String dni) {
        if (dni.equalsIgnoreCase("")) {
            Biblioteca.mostrarMensaje("Debe intoducir un DNI\nInténtelo de nuevo");
        } else {
            ConexionBD.eliminarSocio(dni);
        }
    }
}
