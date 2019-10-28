/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semana2;
import java.util.Scanner;
/**
 *
 * @author Carlos
 */
public class MetodoRuso {
     public int MultiplicacionRusa(int num1, int num2){
        int resultado=0;
        while(num1!=0){
         if(num1 % 2 != 0){
            resultado = resultado + num2;
         }
        num1 = num1 / 2;
        num2 = num2 * 2;
    }
    return resultado;
}
     public static void main(String[] args) {
        Scanner lea=new Scanner(System.in);
        
        System.out.println("Ingrese numero A");
        int numA=lea.nextInt();
        System.out.println("Ingrese numero B");
        int numB=lea.nextInt();
        
        MetodoRuso llamado=new MetodoRuso();
        
         System.out.println("Resultado: "+llamado.MultiplicacionRusa(numA, numB));
    }
}
