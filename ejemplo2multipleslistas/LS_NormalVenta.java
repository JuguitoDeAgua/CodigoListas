
package ejemplo2multipleslistas;
import java.util.Scanner;
public class LS_NormalVenta extends ListaSimpleVenta{

    public LS_NormalVenta() {
        super();
    }
    
    public boolean esVacia(){
        if( P == null){
            return true;
        }
        return false;        
    }
    
    public void mostrar(){
        NodoVenta R = P;
        while(R != null){
            System.out.println("//////////////////////////////////////////////////////////////////////////");
            System.out.println("FECHA:"+R.getFecha()+"\nLISTA DE ORDENES: ");
            R.getLord().mostrar();
            R = R.getSig();
        }
    }
    
    public int nroNodos(){
        NodoVenta R = P;
        int cont =0;
        while(R != null){
            cont++;
            R = R.getSig();
        }
        return cont;
    }
    
    public void adiPrincipio(String fech, LS_NormalOrd liOrd){
        NodoVenta nuevo = new NodoVenta(fech,liOrd);
        nuevo.setSig(P);
        P = nuevo;
    }
    
    public void adiFinal(String fech, LS_NormalOrd liOrd){
        NodoVenta nuevo = new NodoVenta(fech,liOrd);
        
        if(esVacia()){
            P = nuevo;
        }
        else{
            NodoVenta R = P;
            while(R.getSig()!=null){
                R = R .getSig();
            }
            R.setSig(nuevo);
        }
    }
    
    public NodoVenta elPrincipio(){
        NodoVenta x = new NodoVenta();
        while(!esVacia()){
            x = P;
            P = P.getSig();
            x.setSig(null);
        }
        return x;
    }
    
    public NodoVenta eliFinal(){
        NodoVenta x = new NodoVenta();
        if(!esVacia()){
            if(nroNodos()==1){
                x = P;
                P = null;
            }
            else{
                NodoVenta R = P;
                NodoVenta S = P;
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
        for(int i = 1 ; i<= n; i++){
            Scanner lee = new Scanner(System.in);
            System.out.println("INGRESE LA FECHA:");
            String fecha = lee.next();
            
            LS_NormalOrd ord = new LS_NormalOrd();
            System.out.println("INGRESE Nro DE ORDENES:");
            int nroOrd = lee.nextInt();
            ord.leer2(n);
            
            adiFinal(fecha,ord);
        }
    }
    public void leer2(int n){
        for(int i = 1 ; i<= n; i++){
            Scanner lee = new Scanner(System.in);
            System.out.println("INGRESE LA FECHA:");
            String fecha = lee.next();
            
            LS_NormalOrd ord = new LS_NormalOrd();
            System.out.println("INGRESE Nro DE ORDENES:");
            int nroOrd = lee.nextInt();
            ord.leer2(n);
            
            adiPrincipio(fecha,ord);
        }
    }
}
