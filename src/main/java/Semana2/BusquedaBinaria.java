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
            System.out.printf("[%d] \n",valor);
        }
        System.out.println("");
        
    }
    //Funcion recursiva
    static int busquedaBinaria(int buscar,int arreglo[],int inicio,int fin)throws InterruptedException{
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
    
    //Funcion lineal
    static int busquedaBinaria2(int busqueda,int arreglo[],int respuesta){
       int posicion=0;
       
       for(int busco:arreglo){
           if(busco==busqueda){
                respuesta=posicion;
                return respuesta;
       }
           posicion++;
    }
        return respuesta;
    }
    
    public static void main(String[] args) throws InterruptedException {
        
       
        Scanner lea=new Scanner(System.in);
        System.out.println("***B U S Q U E D A  B I N A R I A***");
        BusquedaBinaria llamada=new BusquedaBinaria();
        int auxiliar,opcion=0;
        int arreglo[]=new int[1000];
        int[] arregloOrdenado=new int[1000];
        arreglo[0]=(int)(Math.random()*1000);
        
        //INICIO Ingreso de valores RANDOM
        for(int x=1;x<arreglo.length;x++){
            arreglo[x]=(int)(Math.random()*10);
            for(int y=0;y<x;y++){
                if(arreglo[x]==arreglo[y]){
                    x--;
                }
            }
        }
        //FIN Ingreso de valores RANDOM
        
        //INICIO Algoritmo Burbuja
        for(int i = 0; i < arreglo.length-1; i++){
        for(int j = 0;j < arreglo.length-1;j++){
          if(arreglo[j] > arreglo[j+1]){
            auxiliar = arreglo[j];
            arreglo[j] = arreglo[j+1];
            arreglo[j+1] = auxiliar;
          }   
         }
        }
         arregloOrdenado = arreglo;
        //FIN algoritmo burbuja
        
        imprimirArreglo(arregloOrdenado);
        
       do{ 
        
        
        System.out.println("Ingrese valor a buscar: ");
        int buscar=lea.nextInt();
        
        int busqueda= busquedaBinaria(buscar,arreglo,0,arreglo.length);
        int busqueda2=busquedaBinaria2(buscar,arregloOrdenado,9);
        
        long inicio= System.nanoTime();
        if(busqueda==-1)
            System.out.println("Valor no encontrado en arreglo");
        else{
            System.out.printf("Busqueda Binaria: Valor encontrad0 en arreglo[%d] %n",busqueda);
            long fin= System.nanoTime();
            double tiempo=(double)((fin-inicio));
            System.out.println(tiempo+ " nano segundos");
            System.out.printf("Busqueda lineal: Valor encontrad0 en arreglo[%d] %n",busqueda2);
            fin= System.nanoTime();
            double tiempo2=(double)((fin-inicio));
            System.out.println(tiempo2+ " nano segundos");
            System.out.println("La busqueda lineal se tarda " +(tiempo2-tiempo)+ " nano segundos mas que la busqueda binaria.");
            tiempo=0;
            tiempo2=0;
            
            System.out.println("\nDesea buscar otro valor? (1.SI  2.NO)");
            opcion=lea.nextInt();
        }
       }while(opcion!=2);
        
    }
    
    
}
