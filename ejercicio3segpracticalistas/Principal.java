package ejercicio3segpracticalistas;
import java.util.Scanner;
public class Principal {

    public static void main(String[] args) {
        // a) INSERTAR 6 MASCOTAS Y MOSTRAR
        LS_CircularMas L = new LS_CircularMas();
        L.adiFinal("happy", 3, "felino");
        L.adiFinal("Toto", 5, "canino");
        L.adiFinal("Misha", 8, "canino");
        L.adiFinal("Nene", 2, "reptil");
        L.adiFinal("Poli", 3, "felino");
        L.adiFinal("Botittas", 1, "ave");
        L.mostrar();
        
        
        System.out.println("\n*********************************************************");
        // b) ELIMINAR A LA MASCOTA DEE EDAD "X" Y TIPO "Y"
        eliminaMascota(L,5,"canino");
        L.mostrar();
        
        
        // c) CREAR UNA NUEVA LISTA DE MASCOTAS DE TIPO FELINO
        System.out.println("****************************************************************");
        LS_CircularMas LFel = new LS_CircularMas();
        CreaListaFelinos(L,LFel);
        LFel.mostrar();

    }
    
    public static void eliminaMascota(LS_CircularMas L ,int edad ,String tipo){
        NodoMas R = L.getP();
        NodoMas S = R;
        while(R.getSig()!=L.getP()){
            if(R.getEdad()== edad && R.getTipo()== tipo){
                if (R == L.getP()) {
                    
                    //los tres punteros avanzan
                    R = R.getSig();
                    S=R;
                    L.setP(R);
                    
                } else {
                    // R va a ser lo que vamos a eliminar
                    
                    S.setSig(R.getSig());
                    R = R.getSig();
                    
                }
            }
            else{
                // asi caminamos con la sombra
                
                S = R;
                R = R.getSig();
            }
        }
    }
    
    public static void CreaListaFelinos(LS_CircularMas L ,LS_CircularMas LFel){
        NodoMas R = L.getP();
        while(R.getSig()!=L.getP()){
            if(R.getTipo()=="felino"){
                LFel.adiFinal(R.getNombre(), R.getEdad(), R.getTipo());
            }
            R = R.getSig();
        }
    }
    
}