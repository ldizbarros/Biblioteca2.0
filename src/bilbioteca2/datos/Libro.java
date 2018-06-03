package bilbioteca2.datos;

public class Libro {
    private int codigo;
    private String titulo;
    private String autor;
    private String editorial;
    private String isbn;
    private String añoPublicacion;
    private String seccion;
    private int ejemplaresDisponibles;

    public Libro() {
    }

    public Libro(int codigo, String titulo, String autor, String editorial, String isbn, String añoPublicacion, String seccion, int ejemplaresDisponibles) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.isbn = isbn;
        this.añoPublicacion = añoPublicacion;
        this.seccion = seccion;
        this.ejemplaresDisponibles = ejemplaresDisponibles;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAñoPublicacion() {
        return añoPublicacion;
    }

    public String getSeccion() {
        return seccion;
    }

    public int getEjemplaresDisponibles() {
        return ejemplaresDisponibles;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setAñoPublicacion(String añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public void setEjemplaresDisponibles(int ejemplaresDisponibles) {
        this.ejemplaresDisponibles = ejemplaresDisponibles;
    }

    @Override
    public String toString() {
        return "Libro{" + "codigo=" + codigo + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial + ", isbn=" + isbn + ", a\u00f1oPublicacion=" + añoPublicacion + ", seccion=" + seccion + ", ejemplaresDisponibles=" + ejemplaresDisponibles + '}';
    } 
}
