
package multipleslistas_ldnormal_materias;
import java.util.Scanner;

public class LS_NormalE extends ListaSimpleE {

    public LS_NormalE() {
        super();
    }

    public boolean esVacia() {
        if (P == null) {
            return true;
        }
        return false;
    }

    public void adiPrincipio(String nom) {
        NodoE nuevo = new NodoE();
        nuevo.setNom(nom);
        nuevo.setSig(P); //el siguiente del nodo nuevo apunta a nodo raiz
        P = nuevo;      //P apunta a nuevo
    }

    public void adiFinal(String nom) {
        NodoE nuevo = new NodoE();
        nuevo.setNom(nom);

        if (esVacia()) {
            P = nuevo;   //p apunta a nuevo
        } else {
            NodoE R = P;
            while (R.getSig() != null) {
                R = R.getSig();
            }
            R.setSig(nuevo);
        }
    }

    public void mostrar() {
        NodoE R = P;   //R apunta  a la raiz P
        while (R != null) {
            //R.getQ().mostrar();
            System.out.println("nom Est: " + R.getNom());
            R = R.getSig();
        }
    }

    public int nroNodos() {
        NodoE R = P;
        int c = 0;
        if (this.esVacia()) {
            return 0;
        } else {
            while (R != null) {
                c++;
                R = R.getSig();
            }
        }
        return c;
    }

    public NodoE eliPrincipio() {
        NodoE x = new NodoE();
        if (!esVacia()) {
            x = P;     // x apunta a la raiz P
            P = P.getSig();
            x.setSig(null);
        }
        return x;
    }

    public NodoE eliFinal() {
        NodoE x = new NodoE();
        if (!esVacia()) {
            if (nroNodos() == 1) {
                x = P;      //x apunta a la raiz P
                P = null;
            } else {
                NodoE R = P;
                NodoE S = P;
                while (R.getSig() != null) {
                    S = R;         //S apunta a R
                    R = R.getSig(); //R apunta al siguiente de R
                }
                x = R;
                S.setSig(null);
            }
        }
        return x;
    }

    public void leer1(int n) {
        Scanner lee = new Scanner(System.in);
        String nom;
        for (int i = 1; i <= n; i++) {
            //String z = new String();
            //z.leer();
            System.out.println("Intr. nombre de estudiante: ");
            nom = lee.next();
            adiPrincipio(nom);
        }
    }

    public void leer2(int n) {
        Scanner lee = new Scanner(System.in);
        String nom;
        for (int i = 1; i <= n; i++) {
            //String z = new String();
            //z.leer();
            System.out.println("Intr. nombre de estudiante: ");
            nom = lee.next();
            adiFinal(nom);
        }
    }
}
