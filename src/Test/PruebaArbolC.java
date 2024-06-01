package Test;
import java.util.Random;

import javax.swing.JOptionPane;

import Modelo.ArbolC;

public class PruebaArbolC extends Thread {
    public static void main(String args[]) {
    	
    	//instancio las variables del propio arbol y las variables para tomar los datos a ingresar
        ArbolC ArbolC = new ArbolC();
        int valor;
        String Dato;
        
        
        //variable de tipo random para invocar una funcion de nuemros aleatorios
        Random random = new Random();
        
        
        //pido la cantidad de datos a insertar en el arbol de manera manual 
        System.out.println("Insertando los siguientes valores: ");
        //Dato = JOptionPane.showInputDialog("Inserta el número de nodos que desea ingresar");
        //int n = Integer.parseInt(Dato);
        
        
        //variable que define la cantidad de datos a ingresar para el metodo automatico
        int n = 100000;
        
        for (int i = 0; i < n; i++) {
        	//insercion de los valores de manera manual
            //Dato = JOptionPane.showInputDialog("Dame el " + i + " valor para colocar en el Árbol");
           // valor = Integer.parseInt(Dato);
        	
        	//insercion de valores random
        	valor = random.nextInt(n);
        	//muestra a medida que se cargan los valores 
            System.out.print(valor + " ");
            ArbolC.insertarNodo(valor);
            //toma valor y lo inserta el primero como raiz y los demas van como
            //nodo izquierdo o derecho hasta el final de insercion de datos.
        }
        
        //valores ordenados e inicio de cronometro
        System.out.println("\n inicio de timepo y Arbol ordenado: ");
        double tiempoInicial, tiempoFinal;
        
        //un hilo que se encarga de tomar la parte izquierda a partir de la raiz 
        //y otro que toma la derecha a partir de la raiz
        tiempoInicial = System.nanoTime();
        Thread h1 = new Thread(() -> ArbolC.recorridoIzquierdo());
        Thread h2 = new Thread(() -> ArbolC.recorridoDerecho());
        
        //inician los hilos
        h1.start();
        h2.start();

        //corta el cronometro
        tiempoFinal = System.nanoTime()-tiempoInicial;
 
       System.out.println("\ntiempo finalizado de: " + tiempoFinal );
       
        
        
        
    }
}
