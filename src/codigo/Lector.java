package codigo;

/**
 * @author Santiago
 * @version 1.2
 *
 */
//version 1.2
public class Lector {

    private int idSocio;
    private String dni;
    private String nombre;

    private String email;

    private String codPostal;

    private boolean sancionado;

    private boolean datosValidos;

    public Lector(int idSocio, String dni, String nombre, String email, String codPostal) {
        this.idSocio = idSocio;
        this.dni = dni;
        this.nombre = nombre;

        if(!validarCodigoPostal(codPostal)){
            throw new IllegalArgumentException("Codigo postal inválido");
        }
        this.codPostal = codPostal;

        if(!validarEmail(email)){
            throw new IllegalArgumentException("Email inválido");

        }
        this.email = email;
    }

    /**
     *
     * el metodo es publico,es buleano y trata sobre validar un codigopostal donde si el cogido postal es nuelo duvelve un false
     * y si el codigo postal es menor de 5 y mayor de 0 numeros devolvera un true
     * @param postalCode el parametro introducido es de tipo string y es un codigo postal que introduciremos para validarlo
     * @return true nos devuelve un valor true si el codigo postal tiene mas de 0 digitos y menos de 5 digitos
     * @since 1.1
     *
     */
    //descripcion de metodo
    //parametros
    //retorno
    //está desde la 1.1
    public boolean validarCodigoPostal(String postalCode) {
        if (postalCode == null || postalCode.length() != 5) {
            return false;
        }

        for (int i = 0; i < 5; i++) {
            if (!Character.isDigit(postalCode.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * el metodo es publico y es buelano de validar un email  nos vevolera un valor false cuando el email introducido
     * tengas los casos descritos en los if y si no ,nos devolvera un true
     * @param email el parametro introducido es de tipo string y es un email que introduciremos para validarlo
     * @return true nos vuelve un valor true si evita los casos descritos en los if como valor nulo,que la longitud
     * sea menor que 3 ....
     * @since  1.1
     *
     */
    //descripcion de metodo
    //parametros
    //retorno
    //está desde la 1.1
    public boolean validarEmail(String email) {
        if (email == null || email.length() < 3 || !email.contains("@")) {
            return false;
        }

        int atIndex = email.indexOf("@");
        String localPart = email.substring(0, atIndex);
        String domainPart = email.substring(atIndex + 1);

        if (localPart.isEmpty() || domainPart.length() < 3 || !domainPart.contains(".")) {
            return false;
        }

        return true;
    }


    /* MÉTODOS GET Y SET. NO COMENTAR CON JAVADOC */

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public boolean isSancionado() {
        return sancionado;
    }

    public void setSancionado(boolean sancionado) {
        this.sancionado = sancionado;
    }

    public boolean isDatosValidos() {
        return datosValidos;
    }

    public void setDatosValidos(boolean datosValidos) {
        this.datosValidos = datosValidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
