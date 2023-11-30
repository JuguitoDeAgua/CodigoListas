
package multipleslistas_ldnormal_materias;

public class ListaSimpleE {
    protected NodoE P;  //raiz de la lista

    public ListaSimpleE() {
        P = null;		// la raiz apunta a nullo es decir
        // se define una lista simple vacia
    }

    public NodoE getP() {
        return P;
    }

    public void setP(NodoE p) {
        P = p;
    }
}
