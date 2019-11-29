/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semana7;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author Carlos
 */
public class University {
    public static Student student;
    public static Course course;
    public static Grade grade;
    /*
    Preparar un menu principal en donde se permita:
        1. Alumnos
            1.1 Agregar Alumno
            1.2 Consultar Alumno
            1.3 Imprimir Alumnos
        2. Materias
            2.1 Agregar Materia
            2.2 Consultar Materia
            2.3 Imprimir Materias
        3. Notas
            3.1 Ingresar Nota
            3.2 Consultar Notas
            3.3 Consultar Notas por Alumno
            3.4 Consultar Notas por Materia
        4. Salir del Sistema
    */
    public static void main() throws FileNotFoundException
    {
        Scanner lea=new Scanner(System.in);
        course=new Course();
        student =new Student();
        grade=new Grade();
        int opcion1,opcion2;
        
        do{
        System.out.println("\n1.Alumnos "
                    + "\n2.Materias  "
                    + "\n3.Notas  "
                    + "\n4.Salir del sistema");
        opcion1=lea.nextInt();
        try{
        switch(opcion1){
            case 1:
                System.out.println("\n1 Agregar Alumno  "
                    + "\n2 Consultar Alumno "
                    + "\n3 Imprimir Alumnos  ");
               opcion2=lea.nextInt();
               
               switch(opcion2){
                   case 1:
                       System.out.println("Ingrese codigo de cuenta: ");
                       int codigo=lea.nextInt();
                       System.out.println("Ingrese nombre: ");
                       String name=lea.next();
                       
                       student.addStudent(codigo, name);
                       
                   break;
                   
                   case 2:
                       System.out.println("Ingrese codigo de alumno: ");
                       codigo=lea.nextInt();
                       grade.printGradesByStudent(codigo);
                    
                   break;
                   
                   case 3:
                       
                       student.printAllStudents();
                       
                   break;
                   
                   
               }
                
                
            break;
            
            case 2:
                System.out.println("\n1. Agregar Materia  "
                    + "\n2. Consultar Materia "
                    + "\n3. Imprimir Materias  ");
                opcion2=lea.nextInt();
               
                switch(opcion2){
                    case 1:
                        System.out.println("Ingrese codigo de materia: (solo numeros)");
                        int codigo=lea.nextInt();
                        System.out.println("Ingrese nombre de la materia: ");
                        String name=lea.next();
                        System.out.println("Ingrese unidades valorativas: ");
                        int uv=lea.nextInt();
                        
                        course.addCourse(codigo, name, uv);
                    break;
                    
                    case 2:
                        System.out.println("Ingrese codigo de materia: ");
                        codigo=lea.nextInt();
                        grade.printGradesByCourse(codigo);
                    break;
                    
                    case 3:
                        grade.printAllGrades();
                    break;
                }
                
            break;
            
            case 3:
                System.out.println("\n1 Ingresar Nota"
                    + "\n2 Consultar Notas "
                    + "\n3 Consultar Notas por Alumno  "
                    + "\n4 Consultar Notas por Materia  ");
                opcion2=lea.nextInt();
                
                switch(opcion2){
                    case 1:
                        System.out.println("Ingrese codigo de estudiante: ");
                        int codigoA=lea.nextInt();
                        System.out.println("Ingrese codigo de materia: ");
                        int codigoM=lea.nextInt();
                        System.out.println("Ingrese nota: ");
                        float nota=lea.nextFloat();
                        
                        grade.addGrade(codigoA, codigoM, nota);
                    break;
                    
                    case 2:
                        grade.printAllGrades();
                    break;
                    
                    case 3:
                        System.out.println("Ingrese codigo de alumno: ");
                        codigoA=lea.nextInt();
                        grade.printGradesByStudent(codigoA);
                    break;
                    
                    case 4:
                        System.out.println("Ingrese codigo de materia: ");
                        codigoM=lea.nextInt();
                        grade.printGradesByCourse(codigoM);
                    break;
                }
                
                
            break;
            
            
        }
        }catch(IOException e){
            System.out.println("Algo ha salido mal.");
        }
        }while(opcion1!=4);
    }
}
