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
public class Persona {
    public String nombre;
    public int edad;
    
    public Persona(String nombre, int edad){
        this.nombre=nombre;
        this.edad=edad;
    }
    
    @Override
    public String toString(){
        return "Nombre: " + nombre + ", Edad: " + edad;
    }
    
    
}
