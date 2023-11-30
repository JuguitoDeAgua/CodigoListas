
package multipleslistas_ldnormal_materias;
import java.util.Scanner;
public class Principal {
    public static void main(String[] args) {
        System.out.println("ANDREA CAMILA TARQUI QUISPE");
        System.out.println("CI:   6957522");
        
        LD_NormalM ldm = new LD_NormalM();

        //System.out.println(ldm.esVacia());
        //ldm.leer1(4);
        
        LS_NormalE q = new LS_NormalE();
        q.adiFinal("Juan");
        q.adiFinal("Marco");
        q.adiFinal("Ana");
        q.adiFinal("Freddy");
        
        LS_NormalE q2 = new LS_NormalE();
        q2.adiFinal("Marco");
        q2.adiFinal("Luis");
        q2.adiFinal("Ana");
        q2.adiFinal("Juan");
        
        LS_NormalE q3 = new LS_NormalE();
        q3.adiFinal("Marco");
        q3.adiFinal("Jeny");
        q3.adiFinal("Freddy");
        
        LS_NormalE q4 = new LS_NormalE();
        q4.adiFinal("Ana");
        q4.adiFinal("Elba");
        
        ldm.adiFinal("INF-121", q);
        ldm.adiFinal("INF-131", q2);
        ldm.adiFinal("INF-112", q3);
        ldm.adiFinal("INF-111", q4);
        
        System.out.println("///////////////////////////////////////// LISTA ////////////////////////////////////");
        ldm.mostrar();  
        System.out.println("////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("******************METODO LEER 2******************");
        ldm.leer2(1);
        System.out.println("***************** METODO ELIPRIMERO **********************");
        ldm.eliPrimero();
        ldm.mostrar();
        System.out.println("********************** METODO ELIFINAL ***********************");
        ldm.eliFinal();
        ldm.mostrar();
        
        /*
        //a) Mostrar las siglas de las materias donde se encuentre el estudiante de nombre x
        System.out.println("************************* INCISO A ******************************************");
        System.out.println("\n Mostrar las siglas de las materias donde se encuentre el estudiante de nombre x");
        mostrarSiglaEst(ldm, "Freddy");
        
        System.out.println("************************ INCISO B ******************************************");
        //b) Mostrar las materias que tengan el mayor numero de estudiantes
        System.out.println("\nMostrar las materias que tengan el mayor numero de estudiantes");
        mostrarMatMayorNroEst(ldm);
        
        /*c) Sea la 1era materia de la lista doble de materias, 
        de cada estudiante de esta 1era materia, mostrar el nro de materias en la que se encuentra 
        
        
        System.out.println("ANDREA CAMILA TARQUI QUISPE");
        System.out.println("CI:   6957522");
        System.out.println("**********************INCISO C*************************");
        MuestraNromaterias(ldm);
        
        
        
        //d) Agregar la materia de sigla X con k estudiantes antes de la materia de sigla Z
        
        System.out.println("********************** INCISO D ************************");
        
        AgregaMateriaAntesDeMateriaZ(ldm);
        ldm.mostrar();
        */
        
        
        
    }
    
    
    //  A
    
    static boolean buscarEst(LS_NormalE aux, String nomx) {
        NodoE R = aux.getP();
        boolean sw = false;
        while (R != null) {
            if (R.getNom().equals(nomx)) {
                sw = true;
            }
            R = R.getSig();
        }
        return sw;
    }
    
    static void mostrarSiglaEst(LD_NormalM ldm, String nomx) {
        NodoM R = ldm.getP();
        while (R != null) {
            LS_NormalE aux = R.getLe();
            if (buscarEst(aux, nomx)) {
                System.out.println("sigla: " + R.getSigla());
            }
            R = R.getSig();
        }

    }

    
    
    //  B
    static void mostrarMatMayorNroEst(LD_NormalM ldm) {
        int may = mayorNroEst(ldm);
        NodoM R = ldm.getP();
        int nroMat = ldm.nroNodos();
        for (int i = 1; i <= nroMat; i++) {
            if (R.getLe().nroNodos() == may) {
                System.out.println("sigla: " + R.getSigla());
            }
            R = R.getSig();
        }
    }

    static int mayorNroEst(LD_NormalM ldm) {
        int may = 0;
        NodoM R = ldm.getP();
        int nroMat = ldm.nroNodos();
        for (int i = 1; i <= nroMat; i++) {
            if (R.getLe().nroNodos() > may) {
                may = R.getLe().nroNodos();
            }
            R = R.getSig();
        }
        return may;
    }
    
    
    //  C
    private static void MuestraNromaterias(LD_NormalM A) {

        LS_NormalE le = A.getP().getLe();
        NodoE R = le.getP();
        while (R != null) {
            contar1(A, R.getNom());
            R = R.getSig();
        }
    }

    private static void contar1(LD_NormalM A, String x) {
        int cont = 0;
        NodoM R = A.getP();
        while (R != null) {
            cont += contar2(R.getLe(), x);
            R = R.getSig();
        }
        System.out.println(x + " materias:  " + cont);

    }

    private static int contar2(LS_NormalE le, String x) {
        int cont = 0;
        NodoE R = le.getP();
        while (R != null) {
            if (R.getNom().equals(x)) {
                cont++;
            }
            R = R.getSig();
        }
        return cont;
    }
    
    //  D
    static void AgregaMateriaAntesDeMateriaZ(LD_NormalM materias) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la sigla::");
        String siglaX = scanner.next();
        System.out.println("Ingrese nro Estudiantes::");
        int nroEst = scanner.nextInt();
        System.out.println("Ingrese nueva sigla::");
        String nuevoSigla = scanner.next();
        NodoM R = materias.getP();
        NodoM prev = null;
        LS_NormalE nuevosEstudiantes = new LS_NormalE();
        nuevosEstudiantes.leer2(nroEst);
        NodoM nuevaMateria = new NodoM();
        nuevaMateria.setLe(nuevosEstudiantes);
        nuevaMateria.setSigla(nuevoSigla);

        int counter = 1;
        while (R != null) {
            if (R.getSigla().equals(siglaX)) {
                if (counter >= 2) {
                    R.setAnt(nuevaMateria);
                    nuevaMateria.setSig(R);
                    if (prev != null) {
                        prev.setSig(nuevaMateria);
                    } else {
                        materias.setP(nuevaMateria);
                    }
                    nuevaMateria.setAnt(prev);
                    return;
                } else {
                    R.setAnt(nuevaMateria);
                    nuevaMateria.setSig(R);
                    if (prev != null) {
                        prev.setSig(nuevaMateria);
                    } else {
                        materias.setP(nuevaMateria);
                    }
                    return;
                }
            }
            counter++;
            prev = R;
            R = R.getSig();
        }
    }
    
    
}




/*

public static boolean BuscaSigla(LD_NormalM liD , String SN){
        NodoM R = liD.getP();
        boolean sw = false;
        while(R.getSig() != null){
            String sig = R.getSigla();
            if(sig == SN){
                sw = true;
            }
            R = R.getSig();
        }
        return sw;
    }
    
    public static void AgregaMateriaAntesDeMateriaZ(LD_NormalM liD , String SN){
        if(BuscaSigla(liD,SN)){
            
        }
        else{
            System.out.println("no encontrado");
        }
    }
*/