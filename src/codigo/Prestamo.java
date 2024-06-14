package codigo;

/**
 * @author Santiago
 * @version 1.2
 *
 */
//version 1.2
public class Prestamo {

    private static final double MULTA_DIARIA_DEVOLUCION_TARDIA = 1.50;

    private int identificador;

    private Lector lectorPrestamo;
    private EjemplarLibro libroPrestado;
    private int diaVencimiento;
    private int mesVencimiento;

    private int diaDevolucion;
    private int mesDevolucion;
    private boolean devuelto = false;
    private boolean penalizado = false;

    public Prestamo() {

    }

    public Prestamo(int identificador, Lector lectorPrestamo, EjemplarLibro libroPrestado, int diaVencimiento, int mesVencimiento) {
        this.identificador = identificador;
        this.lectorPrestamo = lectorPrestamo;
        this.libroPrestado = libroPrestado;
        this.diaVencimiento = diaVencimiento;
        this.mesVencimiento = mesVencimiento;

    }


    /**
     * es un metodo que es publico y de valor double donde comprobaremos la devolucion de los prestamos con los valores diadev y mes dev
     * y se calculara los dias del prestamo
     * @param diaDev introducimos un parametro llamado diaDev que es de tipo int numero entero
     * @param mesDev introducimos un parametro llamado mesdev que es de tipo int numero entero
     * @return diasTarde devuelve un dias tarde
     * @throws  IllegalArgumentException
     * @since 1.2
     */
    //descripcion de metodo
    //parametros
    //retorno
    //está desde la 1.2
    //lanza la IllegalArgumentException
    public double devolverPrestamo(int diaDev, int mesDev) {

        if (diaDev < 1 || diaDev > 30 || mesDev < 1 || mesDev > 12) {
            throw new IllegalArgumentException("Las fechas son inválidas");
        }

        this.diaDevolucion = diaDev;
        this.mesDevolucion = mesDev;
        this.devuelto = true;

        int diasTarde = 0;

        //Si es el mismo mes, restamos el dia que lo devolvió menos el diq que vencía
        if (mesVencimiento == mesDevolucion) {
            diasTarde = diaDevolucion - diaVencimiento;
        } else if (mesVencimiento < mesDevolucion) {
            //si no es el mismo mes, completamos desde el dia de vencimiento al dia 30, y le sumamos

            //Completamos días hasta el fin de mes
            int diasHastaFinMes = 30 - diaVencimiento;
            int diasDiferenciaMeses = (mesDevolucion - (mesVencimiento + 1)) * 30;
            diasTarde += diasHastaFinMes + diasDiferenciaMeses + diaDevolucion;

        }

        if (diasTarde <= 0) {
            this.penalizado = false;
            return 0.0; // No hay penalización si no hay días de retraso

        } else {
            this.penalizado = true;
            return diasTarde * MULTA_DIARIA_DEVOLUCION_TARDIA;
        }
    }

    /**
     * el metodo es publico y de tipo double donde calcularemosmultarprestamo es par acalcular los dias que se han entregado
     * tarde y se le multara si se paso de los dias de devolucion
     * @deprecated esta deprecado de las version 1.0
     * @param . aqui el valor param seria nulo pues no hemos introducido ningun parametro
     * @return diasTarde devolverermos diasTarde cuando el usuario se haya pasado de la fecha de la devolucion y multa
     */
    //deprecado desde la version 1.0
    //descripcion de metodo
    //parametros
    //retorno
    @Deprecated(since = "1.0")
    public double calcularMultaPrestamo() {

        if (diaDevolucion < 1 || diaDevolucion > 31 || mesDevolucion < 0 || mesDevolucion > 12) {
            return -1;
        }
        int diasTarde = 0;

        //Si es el mismo mes, restamos el dia que lo devolvió menos el diq que vencía
        if (mesVencimiento == mesDevolucion) {
            diasTarde = diaDevolucion - diaVencimiento;
        } else if (mesVencimiento < mesDevolucion) {
            diasTarde = (30 - diaVencimiento) + diaDevolucion;
        }

        if (diasTarde <= 0) {
            return 0.0; // No hay penalización si no hay días de retraso
        } else {
            this.penalizado = true;
            return diasTarde * MULTA_DIARIA_DEVOLUCION_TARDIA;
        }


    }


    /* MÉTODOS GET Y SET. NO COMENTAR CON JAVADOC */

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public Lector getLectorPrestamo() {
        return lectorPrestamo;
    }

    public void setLectorPrestamo(Lector lectorPrestamo) {
        this.lectorPrestamo = lectorPrestamo;
    }

    public EjemplarLibro getLibroPrestado() {
        return libroPrestado;
    }

    public void setLibroPrestado(EjemplarLibro libroPrestado) {
        this.libroPrestado = libroPrestado;
    }

    public int getDiaVencimiento() {
        return diaVencimiento;
    }

    public void setDiaVencimiento(int diaVencimiento) {
        this.diaVencimiento = diaVencimiento;
    }

    public int getMesVencimiento() {
        return mesVencimiento;
    }

    public void setMesVencimiento(int mesVencimiento) {
        this.mesVencimiento = mesVencimiento;
    }

    public int getDiaDevolucion() {
        return diaDevolucion;
    }

    public void setDiaDevolucion(int diaDevolucion) {
        this.diaDevolucion = diaDevolucion;
    }

    public int getMesDevolucion() {
        return mesDevolucion;
    }

    public void setMesDevolucion(int mesDevolucion) {
        this.mesDevolucion = mesDevolucion;
    }

    public boolean isPenalizado() {
        return penalizado;
    }

    public boolean isDevuelto() {
        return devuelto;
    }
}
