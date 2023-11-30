package ejercicio4multipleslistas;

public class NodoProy {
    private String Titulo;
    private String Parti1;
    private String Parti2;
    private int calificaion;
    
    private NodoProy sig;
    private NodoProy ant;
    
    
    public NodoProy() {
        this.sig = null;
        this.ant = null;
    }

    public NodoProy(String Titulo, String Parti1, String Parti2, int calificaion) {
        this.Titulo = Titulo;
        this.Parti1 = Parti1;
        this.Parti2 = Parti2;
        this.calificaion = calificaion;
        this.sig = null;
        this.ant = null;
    }

    public NodoProy getAnt() {
        return ant;
    }

    public void setAnt(NodoProy ant) {
        this.ant = ant;
    }

    public String getTitulo() {
        return Titulo;
    }

    public String getParti1() {
        return Parti1;
    }

    public String getParti2() {
        return Parti2;
    }

    public int getCalificaion() {
        return calificaion;
    }

    public NodoProy getSig() {
        return sig;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public void setParti1(String Parti1) {
        this.Parti1 = Parti1;
    }

    public void setParti2(String Parti2) {
        this.Parti2 = Parti2;
    }

    public void setCalificaion(int calificaion) {
        this.calificaion = calificaion;
    }

    public void setSig(NodoProy sig) {
        this.sig = sig;
    }
    
    
    
    
}
