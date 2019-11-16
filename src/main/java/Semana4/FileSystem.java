/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semana4;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Carlos
 */
public class FileSystem {
    
    public static void main(String[] args) {
        Scanner lea=new Scanner(System.in);
        ArrayList<Directory> items= new ArrayList<Directory>();
        int posicion=0,ele;
        do{
        System.out.println("1.Añadir directorio"
                + "\n2.Añadir file"
                + "\n3.Salir");
        System.out.println("Ingrese una opcion:");
        ele=lea.nextInt();
        
        switch(ele){
            
            case 1:
                System.out.println("Ingrese nombre del directorio:");
                String nombre=lea.next();
                items.add(new Directory(nombre,FileType.directory,posicion));
                posicion++;
             
            break;
            
            case 2:
                System.out.println("Ingrese nombre del archivo: ");
                String fileName=lea.next();
                System.out.println("Ingrese nombre del directorio donde desae agregar el archivo:");
                nombre=lea.next();
                int repeticion=0;
                for(Directory cosa:items){
                    
                    if(cosa.getName().equals(nombre)){
                        items.get(repeticion).addDirectory(fileName,0);
                        System.out.println("funiona");
                    }else
                        System.out.println("Directorio no encontrado");
                    
                    repeticion++;
                }
            break;
            
            
        }
        }while(ele!=3);
        /*
        items.add(new Directory("Windows",FileType.directory,0));
        items.add(new Directory("Users",FileType.directory,0));
        
        items.get(0).addDirectory("System 32",0);
        ((Directory)(items.get(0).getListFiles().get(0))).addDirectory("Config", 0);
        
        
        items.add(new Directory("hola", FileType.directory, 0));7
*/
                
    }
    
}
