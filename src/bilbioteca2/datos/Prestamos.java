package bilbioteca2.datos;

public class Prestamos {
    private int codUsuario;
    private String libro;
    private String fechaPrestamo;
    private String fechaDevolucion;
    private int aumento;

    public Prestamos() {
    }

    public Prestamos(int codUsuario, String libro, String fechaPrestamo, String fechaDevolucion, int aumento) {
        this.codUsuario =  codUsuario;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.aumento = aumento;
    }

    public int getcodUsuario() {
        return codUsuario;
    }

    public String getLibro() {
        return libro;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public int getAumento() {
        return aumento;
    }

    public void setcodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public void setAumento(int aumento) {
        this.aumento = aumento;
    }
    
    
}
