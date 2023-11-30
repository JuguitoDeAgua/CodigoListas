
package multipleslistas_ldnormal_materias;

public class NodoE {
    private String nom;  //define el dato objeto String
    private NodoE sig; //definiendo el campo enlace sig

    public NodoE() {  //constructor
        sig = null;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public NodoE getSig() {
        return sig;
    }

    public void setSig(NodoE sig) {
        this.sig = sig;
    }
}
