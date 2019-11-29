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
public class Grade {
    private File fileGrade;
    private RandomAccessFile binaryGrade;

    /*
    Inicializa el atributo File
    */
    public Grade() throws FileNotFoundException 
    {
        fileGrade=new File("Notas");
        binaryGrade=new RandomAccessFile(fileGrade,"rw");
    }
    
    /*
    Almacena una nota a partir del codigo de estudiante, 
    codigo de materia y nota obtenida
    */
    public void addGrade(int codeStudent, int codeCourse, float grade) throws IOException
    {
        binaryGrade.writeInt(codeStudent);
        binaryGrade.writeInt(codeCourse);
        binaryGrade.writeFloat(grade);
        
        
    }
    
    /*
    Imprime todos los alumnos con su materia y nota obtenida
    de acuerdo al formato: Nombre de Alumno, Nombre de Carrera y Nota
    */
    public void printAllGrades() throws IOException
    {
        
        
        binaryGrade.seek(0);
        while(binaryGrade.getFilePointer()<binaryGrade.length()){
        int codigo=binaryGrade.readInt();
        int materias=binaryGrade.readInt();
        float nota=binaryGrade.readFloat();
        
        String nombre=University.student.getNameStudent(codigo);
        String materia=University.course.getNameCourse(materias);
        
        System.out.println("Nombre: "+nombre+"\nMateria: "+materia+"\nNota: "+nota+"\n");
        
        }
    }
    
    public float getNota(int code) throws IOException{
        binaryGrade.seek(0);
        while(binaryGrade.getFilePointer()<binaryGrade.length()){
        int codigo=binaryGrade.readInt();
        binaryGrade.readInt();
        float nota=binaryGrade.readFloat();
        
        if(code==codigo)
            return nota;
        }
        return 0;
    }
        
    
    /*
    Imprime todas las notas registras a un alumno a partir de su codigo,
    de acuerdo al formato: Nombre de Carrera y Nota;
    finalmente mostrar su indice academico
    */
    public void printGradesByStudent(int codeStudent) throws IOException
    {
        binaryGrade.seek(0);
        float indice=0;
        while(binaryGrade.getFilePointer()<binaryGrade.length()){
        int codigo=binaryGrade.readInt();
        int materias=binaryGrade.readInt();
        float nota=binaryGrade.readFloat();
        
        String nombre=University.student.getNameStudent(codigo);
        String materia=University.course.getNameCourse(materias);
        indice= University.student.getGradePoint(codigo);
        
        if(codigo==codeStudent){
                
                System.out.println("Nombre: "+nombre+"\nMateria: "+materia+"\nNota: "+nota+"\n");
        }else
                System.out.println("Alumno no encontrado");
        
        }
        
        System.out.println("Indice: "+indice);
       
    }
    
    /*
    Imprime todas las notas registras a partir de su codigo de Materia,
    de acuerdo al formato: Nombre de Alumno y Nota;
    finalmente mostrar el promedio de notas de la materia
    */
    public void printGradesByCourse(int codeCourse) throws IOException
    {
        float indice=0;
        float guardoN=0;
        int cant=0;
        binaryGrade.seek(0);
        while(binaryGrade.getFilePointer()<binaryGrade.length()){
        int codigo=binaryGrade.readInt();
        int materias=binaryGrade.readInt();
        float nota=binaryGrade.readFloat();
        
        String nombre=University.student.getNameStudent(codigo);
        String materia=University.course.getNameCourse(materias);
        
        if(materias==codeCourse){
                guardoN+=nota;
                cant++;
                indice=(guardoN)/cant;
                
                System.out.println("Nombre: "+nombre+"\nMateria: "+materia+"\nNota: "+nota+"\n");
        }else
                System.out.println("Materia no encontrada");
        
        }
        System.out.println("Indice: "+indice);
    }
}
