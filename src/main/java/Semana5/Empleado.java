/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semana5;

/**
 *
 * @author Carlos
 */
public class Empleado extends Persona{
    public int codigo;
    public float sueldo;
    
    public Empleado(String nombre, int edad, int codigo, float sueldo){
        super(nombre,edad);
        this.codigo=codigo;
        this.sueldo=sueldo;
    }
    
    @Override
    public String toString(){
        return "Codigo: "+ codigo + " " + super.toString() + " Salario: " + sueldo+"\n";
    }
    
}
