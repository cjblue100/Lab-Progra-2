
package Semana1;
import java.util.Scanner;

public class TareaConvercion {
    public static void main(String[] args) {
        Scanner lea=new Scanner(System.in);
        int num=0,menu;
        TareaConvercion respuesta= new TareaConvercion(num);
        do{ 
            respuesta.respuesta="";
            respuesta.respuestaF="";
            System.out.println("");
            System.out.println("1.Decimal a binario    "
                        + "\n2.Decimal a octal       "
                        + "\n3.Decimal a Hexadecimal "
                        + "\n4.Salir"
                        + "\nIngrese una opcion:     ");
            menu=lea.nextInt();

            switch(menu){
            
                case 1:
                    System.out.println("Ingrese un numero donvertir a binario: ");
                    num=lea.nextInt();
                    System.out.println("Numero binario es: "+respuesta.Dec2Bin(num)+"\n\n");
                break;
                
                case 2:
                    System.out.println("Ingrese nu numero para convertir a octal: ");
                    num=lea.nextInt();
                    System.out.println("Numero octal es: "+respuesta.Dec2Oct(num)+"\n\n");
                break;
                
                case 3:
                    System.out.println("Ingrese un numero para convertir a hexadecimal: ");
                    num=lea.nextInt();
                    System.out.println("Numero hexadecimal es: "+respuesta.Dec2Hex(num));
                break;
        }
       }while(menu!=4);
        
        
    }
    
    private int residuo;
    private int cociente;
    private int numero,tamaño;
    private String respuesta="";
    public String respuestaF="";
    
    
    public TareaConvercion(int numero){
        this.numero=numero;
        respuesta="";
        respuestaF="";
    }
    
    public String Dec2Bin(int numero){
        
        
       do{ 
        residuo=numero%2;
        cociente=numero/2;
        numero=cociente;
        respuesta+=residuo;
       }while(cociente>0);
       
       tamaño=respuesta.length()-1;
       
       do{
           respuestaF+=respuesta.charAt(tamaño);
           tamaño--;
       }while(tamaño>=0);
        
       return respuestaF;
    }
    
    public String Dec2Oct(int numero){
        
        
        do{ 
        residuo=numero%8;
        cociente=numero/8;
        numero=cociente;
        respuesta+=residuo;
       }while(cociente>0);
        
        tamaño=respuesta.length()-1;
       
       do{
           respuestaF+=respuesta.charAt(tamaño);
           tamaño--;
       }while(tamaño>=0);
        
       return respuestaF;
    }
    
    public String Dec2Hex(int numero){
         do{ 
        residuo=numero%16;
        cociente=numero/16;
        numero=cociente;
        
        if(residuo>=10)
            respuesta+=(char)(residuo+55);
        else
            respuesta+=residuo;
       }while(cociente>0);
        
        tamaño=respuesta.length()-1;
       
       do{
           respuestaF+=respuesta.charAt(tamaño);
           tamaño--;
       }while(tamaño>=0);
        
       return respuestaF;
    }
    
    
    
    
}
