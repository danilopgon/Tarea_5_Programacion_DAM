package datos;

public class Fecha {

    /* declaramos los atributos privados para dia, mes y año*/
    private int dia;
    private int mes;
    private int anio;

    /*constructor sin parametros que asigna los valores 1/1/2020*/
    public Fecha() {
        this.dia = 1;
        this.mes = 1;
        this.anio = 2020;

    }

    /*constructor con parametros para dar valor a los atributos*/
    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    /*metodos get y set para cada uno de los atributos*/
 /* get y set de dia*/
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        if (dia > 0 && dia <= 31) {
            this.dia = dia;

        } else {
            System.out.println("Introduce un día válido");

        }

    }

    /* get y set de mes*/
    public int getMes() {
        return mes;
    }

    /* para la comprobacion de este set vamos a utilizar el boolean mesCorrecto que se pide en la tarea*/
    public void setMes(int mes) {
        this.mes = mes;

    }

    /* get y set de anio*/
    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        if (anio > 0) {
            this.anio = anio;

        } else {
            System.out.println("Introduce un año válido");

        }
    }

    /* metodo boolean para comprobar si el mes esta comprendido entre 1 y 12 */
    public boolean mesCorrecto() {
        return (this.mes >= 1 && this.mes <= 12) ? true : false;
        /* utilizamos el operador condicional ? para hacer las comprobaciones como se pide en la tarea */
    }

    public String nombreMes() {
        String mesString;
        mesString = switch (mes) {
            case 1 ->
                "Enero";
            case 2 ->
                "Febrero";
            case 3 ->
                "Marzo";
            case 4 ->
                "Abril";
            case 5 ->
                "Mayo";
            case 6 ->
                "Junio";
            case 7 ->
                "Julio";
            case 8 ->
                "Agosto";
            case 9 ->
                "Septiembre";
            case 10 ->
                "Octubre";
            case 11 ->
                "Noviembre";
            case 12 ->
                "Diciembre";
            default ->
                "Error";
        };

        return mesString;
    }

    public String laFechaEs() {
        return dia + " del mes de " + nombreMes() + " de " + anio;
    }

}
