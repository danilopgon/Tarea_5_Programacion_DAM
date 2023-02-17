package datos;

import almacenes.AntiguedadEnum;
import almacenes.CategoriaEnum;

/**
 *
 * @author DaniLopez
 */
public class TrabajadorBuilder {

    private String nombre;
    private int edad;
    private AntiguedadEnum antiguedad;
    private CategoriaEnum categoria;
    private Fecha fec;

    public TrabajadorBuilder() {
    }

    public TrabajadorBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public TrabajadorBuilder edad(int edad) {
        this.edad = edad;
        return this;
    }

    public TrabajadorBuilder antiguedad(AntiguedadEnum antiguedad) {
        this.antiguedad = antiguedad;
        return this;

    }

    public TrabajadorBuilder categoria(CategoriaEnum categoria) {
        this.categoria = categoria;
        return this;
    }

    public TrabajadorBuilder fec(Fecha fec) {
        this.fec = fec;
        return this;
    }

    //getters para el builder
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public AntiguedadEnum getAntiguedad() {
        return antiguedad;
    }

    public CategoriaEnum getCategoria() {
        return categoria;
    }

    public Fecha getFec() {
        return fec;
    }

    //setters para el builder
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setAntiguedad(AntiguedadEnum antiguedad) {
        this.antiguedad = antiguedad;
    }

    public void setCategoria(CategoriaEnum categoria) {
        this.categoria = categoria;
    }

    public void setFec(Fecha fec) {
        this.fec = fec;
    }

}
