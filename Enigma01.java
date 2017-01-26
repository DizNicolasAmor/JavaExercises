/*
 * Este programa es un enigma que irá en mi CV online. 
 * Quien quiera ver mi CV deberá resolver dicho enigma. 
 */

/*
 * @author Diz, Nicolás Amor
 */
import java.util.Scanner;
import java.lang.Math;

public class Enigma01 {

    public static void main(String[] args) {
        // TODO code application logic here
        int numero; 
        int respuestaUsuario; 
        int respuestaCorrecta;
        Scanner s = new Scanner(System.in);

        System.out.println("¡Bienvenido! \nPara acceder deber resolver este enigma: "); 
        
        do{  
         numero = (int) (Math.random()*10+1);
         System.out.println("12+5 = 55 \n13+6 = 72 \n14+7 = 91 \n15+4 = 56");
         System.out.println("16+"+numero+" = ?");
         respuestaCorrecta = 16*numero-numero;
         System.out.print("Tu respuesta: ");
         respuestaUsuario = s.nextInt();
         if(respuestaUsuario != respuestaCorrecta){
            System.out.println("Respuesta incorrecta. Inténtalo otra vez. ");
         } 
        }while(respuestaUsuario != respuestaCorrecta);

        System.out.println("¡Correcto! \nAcceso permitido. ");
    }
    
}  //class
