package ejercicio3segpracticalistas;

import java.util.Scanner;

public class LS_CircularMas extends ListaSimpleMas{

    public LS_CircularMas() {
        super();
    }
    
    public boolean esVacia(){
        if(P==null){
            return true;
        }
        return false;
    }
    
    public void mostrar() {
        if (P != null) {
            NodoMas R = P;
            while (R.getSig() != P) {
                System.out.println("\n\nNombre  :\t" + R.getNombre());
                System.out.println("Edad    :\t" + R.getEdad());
                System.out.println("Tipo    :\t" + R.getTipo());
                R = R.getSig();
            }
            System.out.println("\nNombre  :\t" + R.getNombre());
            System.out.println("Edad    :\t" + R.getEdad());
            System.out.println("Tipo    :\t" + R.getTipo());
        }

    }
    
    public int nroNodos() {

        int c = 0;
        if (P != null) {
            NodoMas R = P;
            while (R.getSig() != P) {
                c++;
                R = R.getSig();
            }
            c++;
        }
        return c;
    }
    
    public void adiFinal(String nom, int eda, String tip) {
        NodoMas nuevo = new NodoMas(nom,eda,tip);
        if (P == null) {
            P = nuevo;
            P.setSig(P);
        } else {
            NodoMas R = P;
            while (R.getSig() != P) {
                R = R.getSig();

            }
            R.setSig(nuevo);
            nuevo.setSig(P);
        }
    }
    public void adiPrincipio(String nom, int eda, String tip) {
        NodoMas nuevo = new NodoMas(nom,eda,tip);
        if (P == null) {
            P = nuevo;
            P.setSig(P);
        } else {
            NodoMas R = P;
            while (R.getSig() != P) {
                R = R.getSig();
            }
            R.setSig(nuevo);
            nuevo.setSig(P);
            P = nuevo;
        }
    }

    public NodoMas eliPrincipio() {
        NodoMas x = new NodoMas();
        if (!esVacia()) {
            if (P.getSig() == P) {
                x = P;
                x.setSig(null);
                P = null;
            } else {
                x = P;
                NodoMas R = P;
                while (R.getSig() != P) {
                    R = R.getSig();
                }
                R.setSig(P.getSig());
                P = P.getSig();
                x.setSig(null);
            }
        }
        return x;
    }

    public NodoMas eliFinal() {
        NodoMas x = new NodoMas();
        if (P != null) {
            if (P.getSig() == P) {
                x = P;
                x.setSig(null);
                P = null;
            } else {
                NodoMas S = new NodoMas();
                NodoMas R = P;
                while (R.getSig() != P) {
                    S = R;
                    R = R.getSig();
                }
                x = R;
                x.setSig(null);
                S.setSig(P);
            }
        }
        return x;
    }

    public void llenar1(int n) {
        String nom;
        int edad;
        String tipo;
        for (int i = 1; i <= n; i++) {

            Scanner lee = new Scanner(System.in);
            System.out.print("Ingrese el nombre: ");
            nom = lee.nextLine();
            System.out.print("Ingrese la edad: ");
            edad = lee.nextInt();
            System.out.print("Ingrese Tipo: ");
            tipo = lee.next();

            adiPrincipio(nom, edad, tipo);
        }
    }

    public void llenar2(int n) {
        String nom;
        int edad;
        String tipo;
        for (int i = 1; i <= n; i++) {

            Scanner lee = new Scanner(System.in);
            System.out.print("Ingrese el nombre: ");
            nom = lee.nextLine();
            System.out.print("Ingrese la edad: ");
            edad = lee.nextInt();
            System.out.print("Ingrese Tipo: ");
            tipo = lee.next();

            adiFinal(nom, edad, tipo);
        }
    }
    
}
