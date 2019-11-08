/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semana5;

import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class Directivo extends Empleado{
    
    public static ArrayList<Empleado> subordinado=new ArrayList();
    
    public Directivo(String nombre, int edad, int codigo, float sueldo) {
        super(nombre, edad, codigo, sueldo);
        
        
    }
    
    @Override
    public String toString(){
        
        return "Directivo: " +super.toString()+ "}\n{Subordinados: " + ": Empleado "+subordinado+"\n";
    }
    
    
    
}
