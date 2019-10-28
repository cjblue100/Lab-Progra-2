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
public class InvertirNum {
   // Atributos
    public String num;
    public int contador;

    //Constructor
    public InvertirNum(String num, int contador){
        this.num=num;
    }
    //Funcion
    public String invertir(String num,String og,int contador){
        if(contador>=0){
            return invertir(num,og+num.charAt(contador),--contador);
        }
        return og;
    }
    //Main
    public static void main(String[] args) {
        Scanner lea= new Scanner(System.in);
        System.out.println("Ingrse un numero a invertir:");
        String num=lea.next();
        InvertirNum llamado=new InvertirNum(num,num.length()-1);
        System.out.println("El numero invertido es: "+llamado.invertir(num,"",num.length()-1));
        
    }
    
    
}
