package datos;

import almacenes.AntiguedadEnum;
import almacenes.CategoriaEnum;
import almacenes.ConstantesTrabajador;

/**
 *
 * @author DaniLopez
 */
/*Directivo extiende la clase Trabajador*/
public class Directivo extends Trabajador {

    /*Constructor sin parametros*/
    public Directivo() {
    }

    /*Constructor con super() que inicializa las variables de la clase superior*/
    public Directivo(String nombre, int edad, AntiguedadEnum antiguedad, Fecha fec) {
        super(nombre, edad, antiguedad, fec);
        categoria = CategoriaEnum.CATEGORIA_DIRECTIVO;
    }

    /*Implementamos el método sueldoTrabajador para calcular el sueldo */
    @Override
    public double sueldoTrabajador() {

        double calculoSueldo;
        double importeAntiguedad;

        /*mantenemos el switch para calcular en función de la antiguedad, pero utilizamos las constantes*/
        importeAntiguedad = switch (getAntiguedad()) {
            case ANTIGUEDAD_NOVATO ->
                ConstantesTrabajador.SUELDO_PLUS_NOVATO;
            case ANTIGUEDAD_MADURO ->
                ConstantesTrabajador.SUELDO_PLUS_MADURO;
            case ANTIGUEDAD_EXPERTO ->
                ConstantesTrabajador.SUELDO_PLUS_EXPERTO;
            default ->
                0;
        };

        calculoSueldo = ConstantesTrabajador.SUELDO_BASE + (ConstantesTrabajador.SUELDO_BASE * ConstantesTrabajador.IMPCAT_DIRECTIVO) + importeAntiguedad;
        return calculoSueldo;

    }

}
