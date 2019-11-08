/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semana5;
import java.util.Scanner;
/**
 *
 * @author Carlos
 */
public class Main {
    public static void main(String[] args) {
        Scanner lea= new Scanner(System.in);
        Empresa llamada=new Empresa();
        
        String nombre;
        int loop=0,edad,codigo,error=0,conteo=0;
        float sueldo;
        do{
        System.out.println("1.Ingresar Personas "
                   + "\n2.Ingresar Empleados "
                   + "\n3Ingresar Directivos "
                   + "\n4.Salir "
                   + "\n\nEscoga Una Opcion:");
        int opcion = lea.nextInt();
        
        if(opcion==2&&conteo==0){
            System.out.println("Ingrese un Directivo primero!!!");
            opcion=7;
        }
        
        switch(opcion){
            
            case 1:
                System.out.println("\t***INGRESO DE PERSONAS***\n");
                
                System.out.println("Ingrese nombre de la persona: ");
                nombre= lea.next();
                System.out.println("Ingrese edad de la persona: ");
                edad=lea.nextInt();
                
                Persona datosP=new Persona(nombre,edad);
                
                llamada.Persona.add(datosP);
                
                System.out.println("{"+llamada.Persona+"}");
                
            break;
            
            case 2:
                System.out.println("\t***INGRESO DE EMPLEADOS***\n");
                
                System.out.println("Ingrese nombre de la persona: ");
                nombre= lea.next();
                System.out.println("Ingrese edad de la persona: ");
                edad=lea.nextInt();
                
                error=0;
                System.out.println("Ingrese codigo del empleado: ");
                codigo=lea.nextInt();
                
                
                System.out.println("Ingrese sueldo del empleado: ");
                sueldo=lea.nextFloat();
                
                //Empleado datosE=new Empleado(nombre,edad,codigo,sueldo);
                Empleado datosE=new Empleado(nombre,edad,codigo,sueldo);
                Directivo subordinado=new Directivo(nombre,edad,codigo,sueldo);
                
                for(Persona ver:llamada.Persona){
                    if(ver.equals(codigo)){
                        System.out.println("Ese codigo ya existe!!!");
                        error=1;
                    }
                }
                
                if(error!=1){
                subordinado.subordinado.add(datosE);
                System.out.println("{"+llamada.Persona+"}");
                }
            break;
            
            case 3:
                System.out.println("\t***INGRESAR DIRECTIVOS***\n\n");
                conteo=1;
                System.out.println("Ingrese nombre de la persona: ");
                nombre= lea.next();
                System.out.println("Ingrese edad de la persona: ");
                edad=lea.nextInt();
                System.out.println("Ingrese codigo del empleado: ");
                codigo=lea.nextInt();
                System.out.println("Ingrese sueldo del empleado: ");
                sueldo=lea.nextFloat();
                
                Directivo datosD=new Directivo(nombre,edad,codigo,sueldo);
                
                llamada.Persona.add(datosD);
                System.out.println("{ "+llamada.Persona);
                
            break;
            
            default:
                System.out.println("Ingreso invalido\n");
            break;
        }
        }while(loop!=4);
        
        
    }
    
}
