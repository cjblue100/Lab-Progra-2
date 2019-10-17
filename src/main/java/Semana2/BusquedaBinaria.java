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
public class BusquedaBinaria {
    
    
    static void imprimirArreglo(int arreglo[]){
        for(int valor:arreglo){
            System.out.printf("[%d] ",valor);
        }
        System.out.println("");
        
    }
    
    static int busquedaBinaria(int buscar,int arreglo[],int inicio,int fin){
        //Caso base
        if(fin<inicio)
            return -1;
        
        int pivote=(inicio+fin)/2;
        
        if(arreglo[pivote]==buscar)
            return pivote;
        
        else if(buscar>arreglo[pivote])
            return busquedaBinaria(buscar,arreglo,pivote+1,fin);
        else 
            return busquedaBinaria(buscar,arreglo,inicio,pivote-1);
        
        
    }
    
    public static void main(String[] args) {
        Scanner lea=new Scanner(System.in);
        System.out.println("***B U S Q U E D A  B I N A R I A***");
        int arreglo[]=new int[10];
        
        for(int x=0;x<arreglo.length;x++){
            System.out.printf("Ingrese valor en array[%d]: ",x);
            arreglo[x]=lea.nextInt();
        }
        
        imprimirArreglo(arreglo);
        
        System.out.println("Ingrese valor a buscar: ");
        int buscar=lea.nextInt();
        
        int busqueda= busquedaBinaria(buscar,arreglo,0,arreglo.length);
        
        if(busqueda==-1)
            System.out.println("Valor no encontrado en arreglo");
        else
            System.out.printf("Valor encontradp en arreglo[%d] %n",busqueda);
    }
    
    
}
