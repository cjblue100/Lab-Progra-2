/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semana7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Carlos
 */
public class Course {
    
    private File fileCourse;
    private RandomAccessFile binaryCourse;
    
    /*
    Inicializa el atributo File
    */
    public Course() throws FileNotFoundException 
    {
        fileCourse=new File("Course");
        binaryCourse=new RandomAccessFile(fileCourse,"rw");
    }
    
    /*
    Almacena un curso con sus datos
    Codigo (int), nombre (String) y sus Unidades Valorativas (float)
    */
    public void addCourse(int code, String name, int rating) throws IOException 
    {
        binaryCourse.writeInt(code);
        binaryCourse.writeUTF(name);
        binaryCourse.writeInt(rating);
    }
    
    /*
    Retorna el nombre de la clase segun su codigo
    */
    public String getNameCourse(int code) throws IOException
    {
        binaryCourse.seek(0);
        while(binaryCourse.getFilePointer()<binaryCourse.length()){
        int codigo=binaryCourse.readInt();
        String nombre=binaryCourse.readUTF();
        binaryCourse.readInt();
        
        if(codigo==code)
            return nombre;
        }
        
        return null;
    }
    
    /*
    Retorna el numero de unidades valorativas segun 
    codigo de clase
    */
    public float getRatingCourse(int code) throws IOException
    {
        binaryCourse.seek(0);
        while(binaryCourse.getFilePointer()<binaryCourse.length()){
        int codigo=binaryCourse.readInt();
        binaryCourse.readUTF();
        float unidad=binaryCourse.readInt();
        
        if(codigo==code)
            return unidad;
        }
        return 0;
    }
    
    /*
    Imprime todos los cursos con su codigo, 
    nombre y UVs
    */
    public void printAllCourses() throws IOException
    {
        binaryCourse.seek(0);
        while(binaryCourse.getFilePointer()<binaryCourse.length()){
            int codigo=binaryCourse.readInt();
            String nombre=binaryCourse.readUTF();
            float unidad=binaryCourse.readInt();
            
            System.out.println("Codigo: "+codigo+"\nNombre: "+nombre+"Unidades valorativas: "+unidad+"\n");
        }
    }
    
}
