package multipleslistas_ldnormal_materias;
import java.util.Scanner;

public class LD_NormalM extends ListaDobleM {

    public LD_NormalM() {
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
        NodoM R = this.P;
        while (R != null) {
            c++;
            R = R.getSig();
        }
        return c;
    }

    void adiPrimero(String sigla, LS_NormalE le) {
        NodoM nuevo = new NodoM();
        nuevo.setSigla(sigla);
        nuevo.setLe(le);

        if (esVacia()) {
            P = nuevo;
        } else {
            nuevo.setSig(P);
            P.setAnt(nuevo);
            P = nuevo;
        }
    }
    
    void adiFinal(String sigla, LS_NormalE le) {
        NodoM nuevo = new NodoM();
        nuevo.setSigla(sigla);
        nuevo.setLe(le);

        if (esVacia()) {
            P = nuevo;
        } else {
            NodoM R= P;
            while(R.getSig() != null){
                R = R.getSig();
            }
            R.setSig(nuevo);
            nuevo.getAnt();
        }
    }

    void mostrar() {
        NodoM R = P;
        while (R != null) {
            //R.getProy().mostrar();
            System.out.println("  SIGLA DE LA MATERIA  : " + R.getSigla());
            System.out.println("-------Lista de estudiantes de la materia: -------");
            R.getLe().mostrar();
            R = R.getSig();
        }
    }

    NodoM eliPrimero() {
        NodoM x = new NodoM();
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
    /////////////////////////////////////
    NodoM eliFinal() {
        NodoM nuevo = new NodoM();
        if (!esVacia()) {
            if (nroNodos() == 1) {
                nuevo = P;
                P = null;
            } else {
                NodoM R = P;
                while (R.getSig() != null) {
                    R = R.getSig();
                }
                nuevo = R;
                NodoM aux = R.getAnt();
                aux.setSig(null);
                nuevo.setAnt(null);
            }
        }
        return nuevo;
    }
    

    void leer1(int n) {
        Scanner lee = new Scanner(System.in);
        String sigla;
        for (int i = 1; i <= n; i++) {

            System.out.println("Intr. Sigla");
            sigla = lee.next();

            LS_NormalE le = new LS_NormalE();
            System.out.println("nro estudiantes: ");
            int ne = lee.nextInt();
            le.leer2(ne);

            adiPrimero(sigla, le);
        }
    }
    
    public void leer2(int n) {
        Scanner lee = new Scanner(System.in);
        String sigla;
        for (int i = 1; i <= n; i++) {

            System.out.println("Intr. Sigla");
            sigla = lee.next();

            LS_NormalE le = new LS_NormalE();
            System.out.println("nro estudiantes: ");
            int ne = lee.nextInt();
            le.leer2(ne);

            adiFinal(sigla, le);
        }
    }

}
