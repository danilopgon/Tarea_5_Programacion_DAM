package datos;

import almacenes.AntiguedadEnum;
import almacenes.CategoriaEnum;
import almacenes.ConstantesTrabajador;
import java.util.function.BiFunction;

public abstract class Trabajador implements Antiguedad {

    /* declaramos los atributos de trabajador */
    private String nombre;
    private int edad;
    private AntiguedadEnum antiguedad;
    private CategoriaEnum categoria;
    private Fecha fec;

    /* constructor sin parametros */
    private Trabajador() {
    }

    /*constructor para Builder*/
    public Trabajador(TrabajadorBuilder builder) {
        this.nombre = builder.getNombre();
        this.edad = builder.getEdad();
        this.antiguedad = builder.getAntiguedad();
        this.categoria = builder.getCategoria();
        this.fec = builder.getFec();
    }

    /* métodos get y set para cada uno de los atributos */
 /* get y set para nombre*/
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*get y set para edad*/
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad > 0) {
            this.edad = edad;
        } else {
            System.out.println("Introduzca una edad adecuada");
        }
    }

    /* get y set para antiguedad*/
    public AntiguedadEnum getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(AntiguedadEnum antiguedad) {
        this.antiguedad = antiguedad;
    }

    /* get y set para la fecha */
    public Fecha getFec() {
        return fec;
    }

    public void setFec(Fecha fec) {
        this.fec = fec;
    }


    /* metodo String para devolver el nombre de la categoria del empleado,  */
    public String nombreCategoria() {
        return categoria.getNombre();
    }

    /* metodo String para devolver el nombre de la antiguedad */
    public String nombreAntiguedad() {
        return antiguedad.getNombre();
    }

    /* metodo boolean para comprobar la antiguedad */
    @Override
    public boolean antiguedadCorrecta() {
        return (antiguedad.getNumero() >= 0 && antiguedad.getNumero() <= 2);
    }

    /* Método abstract para calcular el sueldo */
    abstract public double sueldoTrabajador();

    /* metodo para devolver los datos del trabajador, reemplazamos datosTrabajador por un ToString*/
    @Override
    public String toString() {

        return nombre + ", edad: " + getEdad() + "\nCategoría: " + nombreCategoria() + "\nAntigüedad: " + nombreAntiguedad() + "\nFecha de Alta: " + fec.laFechaEs() + "\nSueldo: " + sueldoTrabajador();
    }


    /*Interfaz funcional BiFunction*/
    protected BiFunction<Double, Double, Double> sueldoFunction = (porcentaje, importe) -> {
        return ConstantesTrabajador.SUELDO_BASE + (ConstantesTrabajador.SUELDO_BASE * porcentaje) + importe;
    };

}
