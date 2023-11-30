package ejemplo2multipleslistas;

public class NodoVenta {
    private String fecha;
    private LS_NormalOrd lord;
    private NodoVenta sig;

    public NodoVenta() {
        this.sig = null;
    }

    public NodoVenta(String fecha, LS_NormalOrd lord) {
        this.fecha = fecha;
        this.lord = lord;
        this.sig = null;
    }

    
    
    public String getFecha() {
        return fecha;
    }

    public LS_NormalOrd getLord() {
        return lord;
    }

    public NodoVenta getSig() {
        return sig;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setLord(LS_NormalOrd lord) {
        this.lord = lord;
    }

    public void setSig(NodoVenta sig) {
        this.sig = sig;
    }
    
    
}
