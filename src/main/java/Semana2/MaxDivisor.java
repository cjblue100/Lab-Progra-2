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
public class MaxDivisor {
    
   
    public int MCD_Euclides(int a, int b){
        while(a != b){
            if(a > b){
                a = a - b;
            }else{
                b = b - a;
           }
        }
        return a;
    }
    
    
    public static void main(String[] args) {
        Scanner lea=new Scanner(System.in);
        
        System.out.println("Ingrese numero A");
        int numA=lea.nextInt();
        System.out.println("Ingrese numero B");
        int numB=lea.nextInt();
        
        MaxDivisor llamado=new MaxDivisor();
        
        System.out.println("El maximo comun divisor es: "+llamado.MCD_Euclides(numA, numB));
    }
}
