/* EstA Tarea es de Carlos Jose Contreras Rivera 
   y Selvin Raul Rodriguez Giron 

*/
package RetoEnClase1;

import java.util.Arrays;


public class Binario {
    //Atributos
    public int arreglo[];
    
    //Constructores
    public Binario(){
        arreglo=new int[8];
        for(int x=0;x<arreglo.length-1;x++){
            arreglo[x]=0;
        }
    }
    
    public Binario(String valor){
        arreglo = new int[8];
        int j = valor.length() - 1;
        for(int i = arreglo.length - 1; i >= 0; i--){
            if(j >= 0){
                if(valor.charAt(j) == '1'){
                    arreglo[i] = 1;
                    j--;
                }else if(valor.charAt(j) == '0'){
                    arreglo[i] = 0;
                    j--;
                }
            }else{
            arreglo[i] = 0;
        }
        }
    }
    //Funciones
    //Funcion Suma
    public String Suma(Binario sumar){
        int resultado[]=new int[8];
        for(int x=this.arreglo.length-1; x>=0 ; x--){
        if(this.arreglo[x]==0 && sumar.arreglo[x]==1||this.arreglo[x] == 1 && sumar.arreglo[x]==0)
            resultado[x]=1;    
         else if(this.arreglo[x] == 0 && sumar.arreglo[x]==0) 
             resultado[x]=0;
         else if(this.arreglo[x] == 1 && sumar.arreglo[x]== 1){
             resultado[x]=0;
             if(x!=0){
             resultado[x-1]=1;
             x--;
             }
         }
             
        }
        return Arrays.toString(resultado) ;
        
    }
    
    
    //Funcion Resta
    public String Resta(Binario restar){
        int resultado[]=new int[8];
        for(int x=this.arreglo.length-1; x>=0 ; x--){
        if(this.arreglo[x]==0 && restar.arreglo[x]==1){
            resultado[x]=1;
            for(int z=x;z>0;z--){
                if(arreglo[z]==1){
                    arreglo[z]=0;
                    z=0;
                }      
            }
        }else if(this.arreglo[x]==1 && restar.arreglo[x]==0)
            resultado[x]=1;
         else if(this.arreglo[x] == 0 && restar.arreglo[x]==0) 
             resultado[x]=0;
         else if(this.arreglo[x] == 1 && restar.arreglo[x]== 1){
             resultado[x]=0;
            
         }
             
        }
        return Arrays.toString(resultado) ;
        
    }
    
    //Funcion Multiplicacion
    public String Multiplicacion(Binario producto){
        int resultado[]=new int[8];
        for(int x=this.arreglo.length-1; x>=0 ; x--){
        if(this.arreglo[x]==0 && producto.arreglo[x]==1||this.arreglo[x] == 1 && producto.arreglo[x]==0)
            resultado[x]=0;    
         else if(this.arreglo[x] == 0 && producto.arreglo[x]==0) 
             resultado[x]=0;
         else if(this.arreglo[x] == 1 && producto.arreglo[x]== 1){
             resultado[x]=1;
         }
             
        }
        return Arrays.toString(resultado) ;
    }
    
    //Funcion Division
    public String Division(int numero,int numero2){
        
        int decimal = 0;
        int decimal2=0;

        int binario1 = numero;
        int binario2= numero2;

        int ayuda = 0,residuo,cociente,num,numero3,tamaño;
        String respuesta="",respuestaF="";
      

 

        while (binario1 != 0) {

            int lastDigit = binario1 % 10;

            decimal += lastDigit * Math.pow(2, ayuda);

            ayuda++;

            binario1 = binario1 / 10;

        }
        ayuda=0;
        while(binario2!=0){
            
            int lastDigit = binario2 % 10;

            decimal2 += lastDigit * Math.pow(2, ayuda);

            ayuda++;

            binario2 = binario2 / 10;
            
        }
        
        int divi= decimal/decimal2;
        
        do{ 
        residuo=divi%2;
        cociente=divi/2;
        numero3=cociente;
        respuesta+=residuo;
       }while(cociente>=1);
       
       tamaño=respuesta.length()-1;
       
       do{
           respuestaF+=respuesta.charAt(tamaño);
           tamaño--;
       }while(tamaño>=0);

       return respuestaF;
    }
    
    public String binDec1(int numero){
        
        int decimal = 0;
        int binario1 = numero;
        int ayuda = 0;
        
        while (binario1 != 0) {

            int lastDigit = binario1 % 10;

            decimal += lastDigit * Math.pow(2, ayuda);

            ayuda++;

            binario1 = binario1 / 10;
        }
        
        return Integer.toString(decimal);
    }
    
    
}
