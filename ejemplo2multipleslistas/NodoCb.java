
package ejemplo2multipleslistas;

public class NodoCb {
    private int nroCombo;
    private String nombre;
    private double Precio;
    private NodoCb sig;

    
    
    public NodoCb() {
        this.sig = null;
    }

    
    
    public int getNroCombo() {
        return nroCombo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return Precio;
    }

    public NodoCb getSig() {
        return sig;
    }

    public void setNroCombo(int nroCombo) {
        this.nroCombo = nroCombo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public void setSig(NodoCb sig) {
        this.sig = sig;
    }
    
    
}
