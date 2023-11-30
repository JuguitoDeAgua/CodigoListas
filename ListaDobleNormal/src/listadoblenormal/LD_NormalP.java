
package listadoblenormal;

public class LD_NormalP extends ListaDobleP {

    public LD_NormalP() {
        super();
    }

    boolean esVacia() {
        if (this.P == null) {
            return true;
        }
        return false;
    }

    int nroNodos() {
        int c = 0;
        NodoP R = this.P;
        while (R != null) {
            c++;
            R = R.getSig();
        }
        return c;
    }

    void adiPrimero(Proyecto z) {
        NodoP nuevo = new NodoP();
        nuevo.setProy(z);
        if (esVacia()) {
            P = nuevo;
        } else {
            nuevo.setSig(P);
            P.setAnt(nuevo);
            P = nuevo;
        }
    }

    void mostrar() {
        NodoP R = P;
        while (R != null) {
            R.getProy().mostrar();
            R = R.getSig();
        }
    }

    NodoP eliPrimero() {
        NodoP x = new NodoP();
        if (!esVacia()) {
            if (nroNodos() == 1) {
                x = P;
                P = null;
            } else {
                x = P;
                P = P.getSig();
                P.setAnt(null);
                x.setSig(null);
            }
        }
        return x;
    }
}
