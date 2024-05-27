package Modelo;

public class NodoArbolC {
	//atributos de cada parte del arbol, donde uno va a ser dato y valores
	//izquierdo y derecho tmb pueden ser nodos, tmb son de esta misma clase
    NodoArbolC nodoizquierdo;
    int datos;
    NodoArbolC nododerecho;

    //constructor del nodo que inicializa al nodo central y inicializa en null 
    //al nodo izquierdo y derecho 
    public NodoArbolC(int datosNodo) {
        datos = datosNodo;
        nodoizquierdo = nododerecho = null;
    }

    //
    public void insertar(int valorInsertar) {
        if (valorInsertar < datos) {
            if (nodoizquierdo == null)
                nodoizquierdo = new NodoArbolC(valorInsertar);
            else
                nodoizquierdo.insertar(valorInsertar);
        } else if (valorInsertar > datos) {
            if (nododerecho == null)
                nododerecho = new NodoArbolC(valorInsertar);
            else
                nododerecho.insertar(valorInsertar);
        }
    }
}
