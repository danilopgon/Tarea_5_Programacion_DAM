package datos;

import almacenes.AntiguedadEnum;
import almacenes.CategoriaEnum;
import java.util.Scanner;

/**
 *
 * @author DaniLopez
 */
public class FreeLance extends Trabajador {

    //Añadimos los nuevos atributos
    private double numHoras;
    private double sueldoHoras;

    //Constructores para FreeLance
    public FreeLance() {
    }

    public FreeLance(String nombre, int edad, AntiguedadEnum antiguedad, Fecha fec, double numHoras, double sueldoHoras) {
        super(nombre, edad, antiguedad, fec);
        this.numHoras = numHoras;
        this.sueldoHoras = sueldoHoras;
        categoria = CategoriaEnum.CATEGORIA_FREE_LANCE;
    }

    //Método para calcular el sueldo en base a numHoras y sueldoHoras
    @Override
    public double sueldoTrabajador() {
        double calculoSueldo;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce número de horas: ");
        numHoras = sc.nextDouble();
        System.out.println("Introduce sueldo por hora: ");
        sueldoHoras = sc.nextDouble();
        calculoSueldo = numHoras * sueldoHoras;
        return calculoSueldo;
    }

}
