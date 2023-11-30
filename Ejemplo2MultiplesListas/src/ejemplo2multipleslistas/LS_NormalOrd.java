
package ejemplo2multipleslistas;
import java.util.Scanner;
public class LS_NormalOrd extends ListaSimpleOrd{

    public LS_NormalOrd(){
        super();
    }
    
    public boolean esVacia(){
        if( P == null){
            return true;
        }
        return false;
    }
    
    public void mostrar(){
        NodoOrd R = P;
        while(R != null){
            System.out.println("NOMBRE DEL COMENSAL:  "+ R.getNomComensal()+"\n LISTA DE PEDIDOS: ");
            R.getPed().mostrar();
            R = R.getSig();
        }
    }
    public int nroNodos(){
        NodoOrd R = P;
        int cont = 0;
        while(R !=null){
            cont++;
            R = R.getSig();
        }
        return cont;
    }
    
    public void adiPrincipio(String nomCom, LS_NormalCbPed pedi){
        NodoOrd nuevo = new NodoOrd(nomCom,pedi);
        nuevo.setSig(P);
        P = nuevo;
    }
    
    public void adiFinal(String nomCom, LS_NormalCbPed pedi){
        NodoOrd nuevo = new NodoOrd(nomCom,pedi);
        if(esVacia()){
            P = nuevo;
        }
        else{
            NodoOrd R = P;
            while(R.getSig() != null){
                R = R.getSig();
            }
            R.setSig(nuevo);
        }
    }
    
    public NodoOrd eliPrincipio(){
        NodoOrd x = new NodoOrd();
        if(!esVacia()){
            x = P;
            P = P.getSig();
            x.setSig(null);
        }
        return x;
    }
    
    public NodoOrd eliFinal(){
        NodoOrd x = new NodoOrd();
        if(!esVacia()){
            if(nroNodos() ==1){
                x = P;
                P = null;
            }
            else{
                NodoOrd R = P;
                NodoOrd S = P;
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
            System.out.println("INGRESE NOMBRE COMENSAL:");
            String nomCome = lee.next();
            LS_NormalCbPed lis = new LS_NormalCbPed();
            System.out.println("INGRESE NRO DE PEDIDOS:");
            int nrop = lee.nextInt();
            lis.leer2(nrop);
            
            adiPrincipio(nomCome,lis);
        }
    }
    
    public void leer2(int n){
        for(int i = 1 ; i<=n ; i++){
            Scanner lee = new Scanner(System.in);
            System.out.println("INGRESE NOMBRE COMENSAL:");
            String nomCome = lee.next();
            LS_NormalCbPed lis = new LS_NormalCbPed();
            System.out.println("INGRESE NRO DE PEDIDOS:");
            int nrop = lee.nextInt();
            lis.leer2(nrop);
            
            adiFinal(nomCome,lis);
        }
    }
    
    
}
