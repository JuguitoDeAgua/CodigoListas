
package ejemplo2multipleslistas;
import java.util.Scanner;
public class LS_NormalCb extends ListaSimpleCb{

    public LS_NormalCb() {
        super();
    }
    
    
    public boolean esVacia(){
        if(P ==null){
            return true;
        }
        return false;
    }
    
    public int nroNodos(){
        NodoCb R = P;
        int cont = 0;
        while(R!=null){
            cont++;
            R =  R.getSig();
        }
        return cont;
    }
    
    public void mostrar(){
        NodoCb R = P;
        while(R != null){
            System.out.println("NROCOMBO:  "+R.getNroCombo()+"\n NOMBRE:  "+R.getNombre()+"\n PRECIO:  "+R.getPrecio()+ " Bs.");
            R = R.getSig();
        }
    }
    
    public void adiPrincipio(int nroCombo, String nom, double precio){
        NodoCb nuevo = new NodoCb();
        nuevo.setNombre(nom);
        nuevo.setNroCombo(nroCombo);
        nuevo.setPrecio(precio);
        
        nuevo.setSig(P);
        P = nuevo;
    }
    
    public void adiFinal(int nroCombo, String nom, double precio){
        NodoCb nuevo = new NodoCb();
        nuevo.setNombre(nom);
        nuevo.setNroCombo(nroCombo);
        nuevo.setPrecio(precio);
        
        if(esVacia()){
            P = nuevo;
        }
        else{
            NodoCb R = P;
            while(R.getSig() != null ){
                R = R.getSig();
            }
            R.setSig(nuevo);
        }
    }
    
    public NodoCb eliPrincipio(){
        NodoCb x = new NodoCb();
        if(!esVacia()){
            x = P;
            P = P.getSig();
            x.setSig(null);
        }
        return x;
    }
    
    public NodoCb eliFinal(){
        NodoCb x = new NodoCb();
        if(!esVacia()){
            if(nroNodos() ==1){
                x = P;
                P = null;
            }
            else{
                NodoCb R = P;
                NodoCb S = P;
                while(R.getSig() != null){
                    S = R;
                    R = R.getSig();
                }
                x=R;
                S.setSig(null);
            }
        }
        return x;
    }
    
    public void leer1(int n){
        for(int i = 1 ; i <=n ; i++){ 
            Scanner lee = new Scanner(System.in);
            System.out.println("ingrese nroCombos: ");
            int nroc = lee.nextInt();
            System.out.println("Ingrese el nombre: ");
            String nom = lee.next();
            System.out.println("Ingrese el precio");
            double precio = lee.nextDouble();            
            adiPrincipio(nroc,nom,precio);
        }
    }
    
    public void leer2(int n){
        for(int i = 0 ; i <=n ; i++){
            Scanner lee = new Scanner(System.in);
            System.out.println("ingrese nroCombos: ");
            int nroc = lee.nextInt();
            System.out.println("Ingrese el nombre: ");
            String nom = lee.next();
            System.out.println("Ingrese el precio");
            double precio = lee.nextDouble();            
            adiFinal(nroc,nom,precio);
        }
    }
    
    
}
