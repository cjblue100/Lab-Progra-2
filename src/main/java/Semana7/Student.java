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
public class Student {
    
    private File fileStudent;
    private RandomAccessFile binaryStudent;
    public float indice=0;
    /*
    Inicializa el atributo File
    */
    Student() throws FileNotFoundException
    {
        fileStudent=new File("Students");
        binaryStudent=new RandomAccessFile(fileStudent,"rw");
    }
    
    /*
    Almacena el alumno con sus datos:
    NumeroCuenta (int), Nombre (String) y su indice académico (float)
    */
    public void addStudent(int account, String name) throws IOException
    {
        binaryStudent.writeInt(account);
        binaryStudent.writeUTF(name);
        binaryStudent.writeFloat(getGradePoint(account));
        
    }
    
    /* 
    Retorna el nombre del alumno basado en su numero de cuenta
    */
    public String getNameStudent(int account) throws IOException
    {
        binaryStudent.seek(0);
        while(binaryStudent.getFilePointer()<binaryStudent.length()){
        int cuenta=binaryStudent.readInt();
        String nombre=binaryStudent.readUTF();
        binaryStudent.readFloat();
        if(cuenta==account)
            return nombre;
       }
        return null;
    }
    
    /*
    Retorna el indice académico de un alumno 
    a partir de su numero de cuenta
    */
    public float getGradePoint(int account) throws IOException
    {
        float guardo=0;
        float guardoUvs=0;
        float indice=0;
        binaryStudent.seek(0);
        while(binaryStudent.getFilePointer()<binaryStudent.length()){
        int cuenta=binaryStudent.readInt();
        binaryStudent.readUTF();
        float uv=University.course.getRatingCourse(account);
        
        float nota=University.grade.getNota(account);
        
        
        if(cuenta==account){
            guardo+=nota*uv;
            guardoUvs+=uv;
            indice=guardo/guardoUvs;
        }
        }
        
        return indice;
    }
    
    /*
    Imprime todos los alumnos con su codigo, nombre e
    Indice academico
    */
    public void printAllStudents() throws IOException
    {
       binaryStudent.seek(0);
       while(binaryStudent.getFilePointer()<binaryStudent.length()){
           int cuenta=binaryStudent.readInt();
           String nombre=binaryStudent.readUTF();
           float indice=binaryStudent.readFloat();
           
           System.out.println("Cuenta: "+cuenta+"\nNombre: "+nombre+"\nIndice: "+indice);
       }
    }
    
    /*
    Actualiza el indice academico (grade) del estudiante basado
    en su codigo
    */
    public boolean  updateGradePointStudent(int code, float grade) throws IOException
    {
        while(binaryStudent.getFilePointer()<binaryStudent.length()){
        binaryStudent.seek(0);
        int cuenta=binaryStudent.readInt();
        binaryStudent.readUTF();
        long posicion=binaryStudent.getFilePointer();
        float indice=binaryStudent.readFloat();
        
        if(cuenta==code){
            binaryStudent.seek(posicion);
            binaryStudent.writeFloat(grade);
            return true;
        }
        }
        return false;
    }
    
}
