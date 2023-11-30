
package ejemplo2multipleslistas;

public class NodoOrd {
    private String nomComensal;
    private LS_NormalCbPed ped;
    private NodoOrd sig;

    public NodoOrd() {
        this.sig = null;
    }

    public NodoOrd(String nomComensal, LS_NormalCbPed ped) {
        this.nomComensal = nomComensal;
        this.ped = ped;
        this.sig = null;
    }
    

    public String getNomComensal() {
        return nomComensal;
    }

    public LS_NormalCbPed getPed() {
        return ped;
    }

    public NodoOrd getSig() {
        return sig;
    }

    public void setNomComensal(String nomComensal) {
        this.nomComensal = nomComensal;
    }

    public void setPed(LS_NormalCbPed ped) {
        this.ped = ped;
    }

    public void setSig(NodoOrd sig) {
        this.sig = sig;
    }
    
    
}
