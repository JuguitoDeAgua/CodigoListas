
package ejercicio4multipleslistas;
import java.util.Scanner;
public class LD_NormalProy extends ListaDobleProy{

    public LD_NormalProy() {
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
        NodoProy R = this.P;
        while (R != null) {
            c++;
            R = R.getSig();
        }
        return c;
    }

    void adiPrimero(String titul, String part1, String part2, int calif) {
        NodoProy nuevo = new NodoProy(titul,part1,part2,calif);
        if (esVacia()) {
            P = nuevo;
        } else {
            nuevo.setSig(P);
            P.setAnt(nuevo);
            P = nuevo;
        }
    }
    
    void adiFinal(String titul, String part1, String part2, int calif) {
        NodoProy nuevo = new NodoProy(titul,part1,part2,calif);

        if (esVacia()) {
            P = nuevo;
        } else {
            NodoProy R= P;
            while(R.getSig() != null){
                R = R.getSig();
            }
            R.setSig(nuevo);
            nuevo.getAnt();
        }
    }

    void mostrar() {
        NodoProy R = P;
        while (R != null) {
            System.out.println("        TITULO PROYECTO:  "+R.getTitulo());
            System.out.println("PARTICIPANTE 1:   "+R.getParti1());
            System.out.println("PARTICIPANTE 2:   "+R.getParti2());
            System.out.println("CALIFICACION:    "+R.getCalificaion()+"\n");
            R = R.getSig();
        }
    }

    NodoProy eliPrimero() {
        NodoProy x = new NodoProy();
        if (!esVacia()) {
            if (nroNodos() == 1) {
                x = P;
                P = null;
            }
            else {
                x = P;
                P = P.getSig();
                P.setAnt(null);
                x.setSig(null);
            }
        }
        return x;
    }
    
    NodoProy eliFinal() {
        NodoProy nuevo = new NodoProy();
        if (!esVacia()) {
            if (nroNodos() == 1) {
                nuevo = P;
                P = null;
            } else {
                NodoProy R = P;
                while (R.getSig() != null) {
                    R = R.getSig();
                }
                nuevo = R;
                NodoProy aux = R.getAnt();
                aux.setSig(null);
                nuevo.setAnt(null);
            }
        }
        return nuevo;
    }
    

    public void leer1(int n) {
        Scanner lee = new Scanner(System.in);
        String titulo;
        String participante1;
        String participante2;
        int calificaciones;
        
        for (int i = 1; i <= n; i++) {

            System.out.println("INTRODUZCA TITULO DEL PROYECTO:");
            titulo = lee.next();
            
            System.out.println("INTRODUZCA NOMBRE DEL PARTICIPANTE 1:");
            participante1 = lee.next();
            
            System.out.println("INTRODUZCA NOMBRE DEL PARTICIPANTE 2:");
            participante2 = lee.next();
            
            System.out.println("INTRODUZCA LA CALIFICACION:");
            calificaciones = lee.nextInt();

            
            adiPrimero(titulo,participante1,participante2,calificaciones);
        }
    }
    
    public void leer2(int n) {
        Scanner lee = new Scanner(System.in);
        String titulo;
        String participante1;
        String participante2;
        int calificaciones;
        
        for (int i = 1; i <= n; i++) {

            System.out.println("INTRODUZCA TITULO DEL PROYECTO:");
            titulo = lee.next();
            
            System.out.println("INTRODUZCA NOMBRE DEL PARTICIPANTE 1:");
            participante1 = lee.next();
            
            System.out.println("INTRODUZCA NOMBRE DEL PARTICIPANTE 2:");
            participante2 = lee.next();
            
            System.out.println("INTRODUZCA LA CALIFICACION:");
            calificaciones = lee.nextInt();

            
            adiFinal(titulo,participante1,participante2,calificaciones);
        }
    }
    
}
