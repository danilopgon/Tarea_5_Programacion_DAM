package almacenes;

/**
 *
 * @author DaniLopez
 */
//Enum para almacenar las constantes de Antiguedad
public enum AntiguedadEnum  {
    
    ANTIGUEDAD_NOVATO ("NOVATO", 0), 
    ANTIGUEDAD_MADURO ("MADURO", 1), 
    ANTIGUEDAD_EXPERTO ("EXPERTO", 2), 
    ANTIGUEDAD_ERRONEA ("ANTIGÜEDAD ERRÓNEA", 3);
    
    private final String nombre;
        private final int numero;

    //Constructor de AntiguedadEnum
    private AntiguedadEnum(String nombre, int numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    //Métodos Get
    public String getNombre() {
        return nombre;
    }

    public int getNumero() {
        return numero;
    }

   //Método para obtener un valor del enum a partir de la antiguedad
    public static AntiguedadEnum getAntiguedad(int numero) {
        switch (numero) {
            case 0 -> {
                return AntiguedadEnum.ANTIGUEDAD_NOVATO;
            }
            case 1 -> {
                return AntiguedadEnum.ANTIGUEDAD_MADURO;
            }
            case 2 -> {
                return AntiguedadEnum.ANTIGUEDAD_EXPERTO;
            }
            default -> {
                return AntiguedadEnum.ANTIGUEDAD_ERRONEA;
            }
            
            
        }
    }
    
}

    
    
    
    
    
    
      

