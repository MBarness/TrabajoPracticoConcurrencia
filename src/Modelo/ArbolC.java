package Modelo;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReadWriteLock;

public class ArbolC {
	//atributo que hace unico de raiz
    private NodoArbolC raiz;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    
    //constructor de raiz vacio
    public ArbolC() {
        raiz = null;
    }

    //inserta nodo en el arbol
    public void insertarNodo(int valorInsertar) {
    	//bloquea la escritura pero no la lectura
        lock.writeLock().lock();
        try {
        	//si raiz es igual a null instancia la raiz
            if (raiz == null)
                raiz = new NodoArbolC(valorInsertar);
            else
            	//si no es null instancia o define nodo izquiero o derecho
                raiz.insertar(valorInsertar);
        } finally {
        	//desbloquea la escritura
            lock.writeLock().unlock();
        }
    }

    public void recorridoIzquierdo() {
        lock.readLock().lock(); 
      //bloquea la escritura pero no la lectura
        try {
            ayudanteIzquierdo(raiz); 
            // Llama a la función auxiliar que ordena
        } finally {
            lock.readLock().unlock(); 
          //desbloquea la escritura
        }
    }

    private void ayudanteIzquierdo(NodoArbolC nodo) {
        if (nodo != null) { 
        	// Verifica que el nodo no sea null antes de proceder.
            ayudanteIzquierdo(nodo.nodoizquierdo); 
            // Recurre hacia el nodo izquierdo.
            System.out.print(nodo.datos + " ");
            // Imprime los datos del nodo actual.
            if (nodo != raiz) {
            	// Si el nodo no es la raíz, recurre hacia el nodo derecho.
                ayudanteIzquierdo(nodo.nododerecho);
            }
        }
    }

    public void recorridoDerecho() {
        lock.readLock().lock();
      //bloquea la escritura pero no la lectura
        try {
            ayudanteDerecho(raiz); 
         // Llama a la función auxiliar que ordena.
        } finally {
            lock.readLock().unlock(); 
          //desbloquea la escritura
        }
    }

    private void ayudanteDerecho(NodoArbolC nodo) {
        if (nodo == null) 
        	// Retorna inmediatamente si el nodo es null.
            return;
        if (nodo != raiz) { 
        	// Si el nodo no es la raíz, recurre hacia el nodo izquierdo.
            ayudanteDerecho(nodo.nodoizquierdo);
        }
        System.out.print(nodo.datos + " "); 
        // Imprime los datos del nodo actual.
        ayudanteDerecho(nodo.nododerecho); // Recurre hacia el nodo derecho.
    }
    
    
    
    
}
