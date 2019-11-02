/* EstA Tarea es de Carlos Jose Contreras Rivera 
   y Selvin Raul Rodriguez Giron 
*/
package RetoEnClase1;
import java.util.Scanner;
/**
 *
 * @author Carlos
 */
public class Main {
    
    public static void main(String[] args) {
    
        Scanner lea=new Scanner(System.in);
        System.out.println("Ingrese numero binarion 1: ");
        int numero1=lea.nextInt();
        System.out.println("Ingrese numero binario 2: ");
        int numero2=lea.nextInt();
        
        Binario num1=new Binario(Integer.toString(numero1));
        Binario num2=new Binario(Integer.toString(numero2));
       int opcion = 0;
        do{
        System.out.println("1. Suma de numeros Ingresados ");
        System.out.println("2. Resta de numeros Ingresados ");
        System.out.println("3. Multiplicacion de numeros Ingresados ");
        System.out.println("4. Division de numeros Ingresados ");
        System.out.println("5. Finalizar");
        System.out.print("Ingrese su opcion: ");
        opcion = lea.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Suma: "+num1.Suma(num2));
                    break;
                case 2:
                    System.out.println("Resta: "+num1.Resta(num2));
                    break;
                case 3:
                    System.out.println("Multiplicacion: "+num1.Multiplicacion(num2));
                    break;
                case 4:
                    System.out.println("Division: "+num1.Division(numero1,numero2));
                    break;
                case 5:
                    System.out.println("Finalizo");
                    break;
                default:
                    System.out.println("No ingreso la correcta");
                    break;
            }
        }while(opcion !=5);
        
        //Esto era prueba jeje
        /*do{
            System.out.println(Arrays.toString(num1.arreglo));    
            System.out.println(Arrays.toString(num2.arreglo));
            System.out.println("Numero binario 1 en Decimal: "+ num1.binDec1(numero1));
            System.out.println("Numero binario 2 en Decimal: "+ num1.binDec1(numero2));
            System.out.println("Suma: "+num1.Suma(num2));
            System.out.println("Multiplicacion: "+num1.Multiplicacion(num2));
            System.out.println("Division: "+num1.Division(numero1,numero2));
            System.out.println("Resta: "+num1.Resta(num2));
            System.out.println("Desea ingresar otro numero?");
            opcion=lea.nextInt();
        }while(opcion!=2);*/
    }
    
    
    
    
}
