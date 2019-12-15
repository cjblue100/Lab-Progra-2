/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semana9;

/**
 *
 * @author Carlos
 */
public class Nodo {
    private int valor;
    private Nodo siguiente;
    private Nodo anterior;

    public Nodo() {
        siguiente=null;
        anterior=null;
    }
    
    public Nodo(int valor, Nodo siguiente, Nodo anterior) {
        this.valor = valor;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public int getValor() {
        return valor;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    
}
