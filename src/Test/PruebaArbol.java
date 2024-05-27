package Test;
import java.util.Random;

import javax.swing.JOptionPane;

import Modelo.Arbol;

public class PruebaArbol
{
    public static void main(String args [])
    {
        Arbol arbol = new Arbol();
        int valor;
        String Dato;
        Random random = new Random();
        System.out.println("Insertando los siguientes valores: ");
       
        //Dato = JOptionPane.showInputDialog("Inserta el numero de nodos que desea ingresar");
       // int n = Integer.parseInt(Dato);
        
        int n = 100000;
        
        for(int i = 0; i < n; i++ )
        {
           // Dato = JOptionPane.showInputDialog("Dame el " + i + " valor para colocar en el Arbol");
           // valor = Integer.parseInt(Dato);
        	valor = random.nextInt(n);
            System.out.print(valor + " ");
            arbol.insertarNodo(valor);
        }
        
        
        System.out.println("inicio de timepo y Arbol ordenado: ");
        double tiempoInicial, tiempoFinal;
        
        tiempoInicial = System.nanoTime();
        arbol.recorridoInorden();
        
        tiempoFinal = System.nanoTime()-tiempoInicial;
        
        System.out.println("\ntiempo finalizado de: " + tiempoFinal );
        
    }
}