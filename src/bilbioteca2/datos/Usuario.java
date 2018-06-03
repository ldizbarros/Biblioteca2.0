
package bilbioteca2.datos;


public class Usuario {
    
    private String dni;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String correo;
    private String login;
    private String password;
    private boolean administrador;

    public Usuario() {
    }

    public Usuario(String dni, String nombre, String apellidos, String telefono, String correo, String login, String password,boolean administrador) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
        this.login = login;
        this.password = password;
        this.administrador= administrador;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }
   public static boolean validar(String dni){

        boolean valido = true;

        if(!(dni.length()>=8 && dni.length()<=9)){
           valido= false;
        }
        
        String parteNumerica = dni.substring(0, dni.length()-1);
        int numeroDni =0;
        
        try{
           numeroDni = Integer.parseInt(parteNumerica);
        }catch(NumberFormatException e){
            valido= false;
        }
        
        char letra = dni.substring(dni.length()-1, dni.length()).toUpperCase().charAt(0);
        
        if(!(letra>='A' && letra<='Z')){
            valido= false;
        }
        
        final int divisor = 23;
        
       char letraNIF[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X',
                          'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        
       int resto = numeroDni % divisor;
       
       String nuevoDni = numeroDni +""+letraNIF[resto];
       
       if(!(nuevoDni.equals(dni))){
             valido= false;
       }
       
       return valido;
    } 
    
}
