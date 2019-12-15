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
public class ListaEnlazada {
    private Nodo primero;

    public ListaEnlazada() {
        primero=null;
    }
    
    public boolean esVacia(){
        return primero==null;
    }
    
    public void InsertarNodo(int valor){
        Nodo nuevo=new Nodo(valor,null,null);
        
        if(esVacia())
            primero=nuevo;
        else{
            Nodo tmp=primero;
            
            while(tmp.getSiguiente()!=null){
                tmp=tmp.getSiguiente();
            }
            
            tmp.setSiguiente(nuevo);
            
            tmp=primero;
            
           while(tmp.getSiguiente()!=null){
               if(tmp.getValor()>tmp.getSiguiente().getValor()){
                   tmp.setValor(tmp.getSiguiente().getValor());
                   tmp.setSiguiente(nuevo);
                   
                   
                   
               }
               tmp=tmp.getSiguiente();
           }
         
            
        }
        
        
        
        
    }
    
     
    
    
    
    public void eliminarNodo(int valor){
        Nodo anterior =null;
        Nodo actual=primero;
        
        while(actual!=null){
            if(actual.getValor()==valor){
                if(actual==primero)
                    primero=actual.getSiguiente();
                else{
                    anterior.setSiguiente(actual.getSiguiente());
                }
                return;
            }
            anterior=actual;
            actual=actual.getSiguiente();
        }
    }
    
    public void imprimir(){
        if(esVacia())
            System.out.println("La lista esta vacia.");
        else{
            Nodo tmp=primero;
            
            while(tmp!=null){
                System.out.println(tmp.getValor());
                tmp=tmp.getSiguiente();
            }
        }
    
    }
    
    public static void main(String[] args) {
        ListaEnlazada llamo=new ListaEnlazada();
        
        llamo.InsertarNodo(1);
        llamo.InsertarNodo(2);
        llamo.InsertarNodo(3);
        llamo.InsertarNodo(5);
        llamo.InsertarNodo(4);
       
        
        llamo.imprimir();
        System.out.println("\n");
        
        
    }
    
    
}
