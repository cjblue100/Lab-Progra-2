/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen2;

import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class Residencia {
    public int resi;
    public String nombreFamilia;
    public ArrayList <String> inquilinos;
    public Residencia siguiente;
    public Residencia izquierda;

    public Residencia(int resi, String nombreFam) {
        this.resi = resi;
        this.nombreFamilia = nombreFam;
        this.inquilinos = new ArrayList();
        this.siguiente = null;
    }
    
    public void addInquilino(String nombre){
        inquilinos.add(nombre);
    }

    public Residencia getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Residencia siguiente) {
        this.siguiente = siguiente;
    }

    public Residencia getIzquierda() {
        return izquierda;
    }

    public int getResi() {
        return resi;
    }

    public String getNombreFamilia() {
        return nombreFamilia;
    }

    public ArrayList<String> getInquilinos() {
        return inquilinos;
    }
    
    
    
    
    public void imprimir(){
        
        
        for(String integrantes: inquilinos){
            System.out.println(integrantes);
        }
    }
    
    
}
