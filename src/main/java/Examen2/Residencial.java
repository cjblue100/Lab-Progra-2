/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 *
 * @author Carlos
 */
public class Residencial {
    public String nameResi;
    public Residencia primerCasa;

    public Residencial(String nameResi) {
        this.nameResi = nameResi;
        this.primerCasa = null;
    }
    
    public boolean esVacia(){
        return primerCasa == null;
    }
    
    public boolean numeroDisponible(int num){
        Residencia actual=primerCasa;
        
        while(actual!=null){
            
            if(actual.getResi()==num)
                return false;
            
            actual=actual.getSiguiente();
        }
        
        return true;
    }
    
    public void contruirResidencia(int num, String nombreFamilia){
        if(numeroDisponible(num)==true){
            
            Residencia nuevo=new Residencia(num,nombreFamilia);
            
            if(esVacia()){
                primerCasa=nuevo;
            }else{
                Residencia actual = primerCasa;
                
                while(actual.getSiguiente()!=null){
                    actual=actual.getSiguiente();
                }
                
                actual.setSiguiente(nuevo);
            }
            
        }else
            System.out.println("Ese numero ya existe");
    }
    
    public void agregarInquilinoEn(int num, String inquilino){
        if(numeroDisponible(num)==false){
            primerCasa.addInquilino(inquilino);
        }else
            System.out.println("No existe esa residencia");
    }
    
    public void informacionCasa(int num){
        Residencia actual = primerCasa;
        int para=0;
        if(numeroDisponible(num)==false){
            
            
            while(actual!=null&&para==0){
                System.out.println("Numero de la residencial: "+num);
                System.out.println("Nombre de ka familia: "+ actual.getNombreFamilia());
                actual.imprimir();
                para=1;
                actual.getSiguiente();
            }
            
        }else
            System.out.println("No se encontro casa");
    }
    
    public void backup(String filePath) throws FileNotFoundException, IOException{
        RandomAccessFile backUP=new RandomAccessFile(filePath,"rw");
        Residencia info=primerCasa;
        int cant=0;
        
        backUP.writeInt(info.resi);
        backUP.writeUTF(info.getNombreFamilia());
        
        
        backUP.writeInt(info.getInquilinos().size());
        
        
            backUP.writeUTF(info.getInquilinos().toString());
            
        
        
        
        
        
    }
    
    
    public void reloadFromBackup(String filePath) throws FileNotFoundException, IOException{
        RandomAccessFile backUP=new RandomAccessFile(filePath,"r");
        Residencia info=primerCasa;
        while(info!=null){
            info=null;
            info.setSiguiente(null);
        }
        
        backUP.seek(0);
        while(backUP.getFilePointer()<backUP.length()){
        int numRes=backUP.readInt();
        String name=backUP.readUTF();
        int cant=backUP.readInt();
        String inquilino=backUP.readUTF();
        
        contruirResidencia (numRes,name);
        agregarInquilinoEn(numRes, inquilino);
        
        }
        
    }
    
    public static void main(String[] args) {
        Scanner lea= new Scanner(System.in);
        int op;
        Residencial ver= new Residencial("Residencial los pinos");
        do{
        System.out.println("1.Construir residencia "
                + "\n2.Agregar inquilinos"
                + "\n3.Informacion casa"
                + "\n4.Hacer backUP"
                + "\n5.Reload from backUP"
                + "\n6.Salir");
            System.out.println("Ingrese opcion:");
            op=lea.nextInt();
        
            try{
                
                switch(op){
                    case 1:
                        System.out.println("Ingrese numero de residencia:");
                        int num=lea.nextInt();
                        System.out.println("Ingrese nombre de la familia");
                        String name=lea.next();
                        
                        ver.contruirResidencia(num, name);
                    break;
                    
                    case 2:
                        System.out.println("Ingrese numero de la residencial:");
                        num=lea.nextInt();
                        System.out.println("Ingrese nombre del inquilino:");
                        name=lea.next();
                        
                        ver.agregarInquilinoEn(num, name);
                        
                    break;
                    
                    case 3:
                        System.out.println("Ingrese numero de la casa:");
                        num=lea.nextInt();
                        ver.informacionCasa(num);
                    break;
                    
                    case 4:
                        System.out.println("Ingrese path del archivo:");
                        name=lea.next();
                        ver.backup(name);
                    break;
                    
                    case 5:
                        System.out.println("Ingrese nombre del archivo:");
                        name=lea.next();
                        
                        ver.reloadFromBackup(name);
                        System.out.println("Se realizo la accion con exito.");
                    break;
                    
                    default:
                        System.out.println("Ingrese un numero correcto");
                    break;
                }
                
                
                
                
            }catch(IOException e){
                System.out.println("Error");
            }
            
        }while(op<6);
        
        
    }
    
    
    
    
}
