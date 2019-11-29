/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semana7;
import java.io.File;
import java.io.RandomAccessFile; //Son archivos que los guardamos con una estructura definida.
/**
 *
 * @author Carlos
 */
public class EjemploArchivoBinario {
    
    private static File file=new File("empleados.bin"); //En general la extension se nombra .bin o .dat
    private static RandomAccessFile binaryFile;
    
    
    public static void main(String[] args) {
        
       /* 
        addEmployee(100, "Ramiro Eustaquio", 25000);
        addEmployee(101, "Allan Brito", 1200);
        addEmployee(102, "Albin Yakitori", 50);
        */
        readEmployee(100);
        
    }
    
    
    public static void addEmployee(int code, String name,double salario){
        
        try
        {
            binaryFile=new RandomAccessFile(file,"rw");
            binaryFile.seek(binaryFile.length()); // Se coloca al final del archivo para empezar a escribir nuevos datos
            binaryFile.writeInt(code);
            binaryFile.writeUTF(name);
            binaryFile.writeDouble(salario);
            
            binaryFile.close();//Cierra el archivo
            
            System.out.println("¡Registro Almacenado!");
            
        }catch(Exception e)
        {
            System.out.println("Error al intentar abrir o crear el archivo que tenemos!!!");
        }
        
    }
    
    public static void readEmployee(int codeI){
        
        try
        {
            binaryFile=new RandomAccessFile(file,"r");
            binaryFile.seek(0);
            
            while(binaryFile.getFilePointer()<binaryFile.length()){
                int code= binaryFile.readInt();
                String name= binaryFile.readUTF();
                double salario= binaryFile.readDouble();
                
                if(codeI==code){
                    System.out.printf("¡Registro encotrado!%nRegistro: {code: %d, name: %s, %f",code,name,salario);
                    binaryFile.close();
                    return;
                }
            }
            System.out.println("No se encontro el codigo de empleado!!!!");
            
        }catch(Exception e)
        {
            System.out.println("Error al intentar abrir o crear el archivo que tenemos!!!");
        }
    }
    
    
}
