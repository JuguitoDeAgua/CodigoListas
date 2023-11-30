
package listadoblenormal;

public class ListaDobleNormal {

    public static void main(String[] args) {
        LD_NormalP A = new LD_NormalP();

        System.out.println("Lista vacia: ");
        System.out.println(A.esVacia());

        System.out.println("nro de nodos: ");
        System.out.println(A.nroNodos());

        System.out.println("\nadicionando como primero: ");
        Proyecto z1 = new Proyecto("tienda", "willy", "monica");
        Proyecto z2 = new Proyecto("juego", "ana", "bryan");
        Proyecto z3 = new Proyecto("uml", "jose", "adrian");
        Proyecto z4 = new Proyecto("oop", "alan", "jorge");

        A.adiPrimero(z1);
        A.adiPrimero(z2);
        A.adiPrimero(z3);
        A.adiPrimero(z4);

        A.mostrar();

        System.out.println("\nEliminando el nodo primero");
        NodoP w = A.eliPrimero();
        System.out.println("proyecto eliminado: ");
        w.getProy().mostrar();

        System.out.println("\nlista doble: ");
        A.mostrar();
    }
    
}
