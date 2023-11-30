
package ejemplo2multipleslistas;
import java.util.Scanner;
public class LS_NormalCbPed extends ListaSimpleCbPed{

    public LS_NormalCbPed() {
        super();
    }
    
    public boolean esVacia(){
        if(P == null){
            return true;
        }
        return false;
    }
    
    public int nroNodos(){
        NodoCbPed R = P;
        int cont =0;
        while(R != null){
            cont++;
            R = R.getSig();
        }
        return cont;
    }
    public void mostrar(){
        NodoCbPed R = P;
        while(R != null){
            System.out.println("NRO DE COMBO:  "+R.getNroCombo()+"\nCANTIDAD:  "+R.getCantidad());
            R = R.getSig();
        }
    }
    public void adiPrincipio(int nroCom , int canti){
        NodoCbPed nuevo = new NodoCbPed();
        nuevo.setNroCombo(nroCom);
        nuevo.setCantidad(canti);
        
        nuevo.setSig(P);
        P = nuevo;
    }
    public void adiFinal(int nroCom , int canti){
        NodoCbPed nuevo = new NodoCbPed();
        nuevo.setNroCombo(nroCom);
        nuevo.setCantidad(canti);
        
        if(esVacia()){
            P = nuevo;
        }
        else{
            NodoCbPed R = P;
            while(R.getSig() != null){
                R = R.getSig();
            }
            R.setSig(nuevo);
        }
    }
    
    public NodoCbPed eliPrincipio() {
        NodoCbPed x = new NodoCbPed();
        if (!esVacia()) {
            x = P;
            P = P.getSig();
            x.setSig(null);
        }
        return x;
    }

    public NodoCbPed eliFinal() {
        NodoCbPed x = new NodoCbPed();
        if (!esVacia()) {
            if (nroNodos() == 1) {
                x = P;
                P = null;
            } else {
                NodoCbPed R = P;
                NodoCbPed S = P;
                while (R.getSig() != null) {
                    S = R;
                    R = R.getSig();
                }
                x = R;
                S.setSig(null);
            }
        }
        return x;
    }
    
    public void leer1(int n){
        for(int i = 1 ; i<=n ; i++){
            Scanner lee = new Scanner(System.in);
            System.out.println("INGRESE NRO cOMBO:");
            int nrocombo = lee.nextInt();
            System.out.println("INGRESE CANTIDAD: ");
            int cantidad = lee.nextInt();
            adiPrincipio(nrocombo,cantidad);
        }
    }
    
    
    public void leer2(int n){
        for(int i = 1 ; i<= n ; i++){
            Scanner lee = new Scanner(System.in);
            System.out.println("INGRESE NRO COMBOS:");
            int nroc = lee.nextInt();
            System.out.println("INGRESE CANTIDAD");
            int cantid = lee.nextInt();
            
            adiFinal(nroc,cantid);
        }
    }
    
    
}