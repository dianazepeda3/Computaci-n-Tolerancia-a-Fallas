
/**
 * @author diana
 */
public class ManejoDeErrores {

    // Captura de excepciones
    public static void main(String[] args) throws Exception {
        System.out.println("EXCEPCIONES EN JAVA");
        
        Aritmetico();
        Limite();
        Clase();
        Comun();
        Formato("hola");
        //fijarEdad(5);
        
    }
    
    private static void Comun() {
        try {
            System.out.println("***TRATAMIENTO COMUN***");
            String[] names = { "jules", "louis", "harry" };
            for (int i = 0; i <= names.length; i++) {
                System.out.println(names[i]);
            }           
        } catch (Exception e) {
        System.out.println("Excepcion:  " + e);
        }
    }
    
    private static void Aritmetico() {
        try {
            System.out.println("***ERROR ARITMETICO***");
            System.out.println("Antes de dividir entre 0");
            int div=2/0;
            System.out.println("resultado:" + div);            
        } catch (ArithmeticException e) {
        System.out.println("Excepcion:  " + e);
        }
    }
    
    private static void Limite() {
        try {
        System.out.println("***INDICE DE ARRAY FUERA DE LIMITE***");
        String[] names = { "jules", "louis", "harry" };
        for (int i = 0; i <= names.length; i++) {
            System.out.println(names[i]);
        }
        } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Excepcion:  " + e);
        }
    }
    
    private static void Clase() {
        try {
        System.out.println("***CONVERTIR CLASE INCORRECTA***");
        Object i = Integer.valueOf(42); String s = (String)i;
        } catch (ClassCastException e) {
            System.out.println("Excepcion:  " + e);
        }
    }
    
    private static void Formato(String cadena){
	try {
            System.out.println("***FORMATO DE NUMERO INCORRECTO***");
            Integer.parseInt(cadena);            
	} catch (NumberFormatException nfe){
            System.out.println("Error: "+nfe);            
	}finally {
            System.out.println("termina");
            // Código de finalización (opcional)
        }
    }
    
    public static void fijarEdad(int edad) throws Exception {
        if (edad < 18)
            throw new Exception("No es adulta la persona, porque tiene " + edad + " años.");        
    }

    
}
