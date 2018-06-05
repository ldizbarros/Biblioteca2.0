package bilbioteca2.datos;

public class Ejemplares {
    private int codigo;
    private String isbn;
    private String editorial;
    private String añoPublicacion;
    private String comentarios;
    private boolean prestado;

    public Ejemplares() {
    }

    public Ejemplares(int codigo, String isbn, String editorial, String añoPublicacion, String comentarios, boolean prestado) {
        this.codigo = codigo;
        this.isbn = isbn;
        this.editorial = editorial;
        this.añoPublicacion = añoPublicacion;
        this.comentarios = comentarios;
        this.prestado = prestado;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getAñoPublicacion() {
        return añoPublicacion;
    }

    public String getComentarios() {
        return comentarios;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setAñoPublicacion(String añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }
   
}
