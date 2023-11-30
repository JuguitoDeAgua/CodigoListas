
package ejemplo2multipleslistas;

public class NodoCbPed {
    private int nroCombo;
    private int cantidad;
    private NodoCbPed sig;

    
    public NodoCbPed() {
        this.sig = null;
    }

    
    
    public int getNroCombo() {
        return nroCombo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public NodoCbPed getSig() {
        return sig;
    }

    public void setNroCombo(int nroCombo) {
        this.nroCombo = nroCombo;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setSig(NodoCbPed sig) {
        this.sig = sig;
    }
    
    
}
