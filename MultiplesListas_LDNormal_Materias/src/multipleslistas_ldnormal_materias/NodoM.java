package multipleslistas_ldnormal_materias;

public class NodoM {

    private String sigla;
    private LS_NormalE le;
    private NodoM ant;
    private NodoM sig;

    NodoM() {
        this.sig = null;
        this.ant = null;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public LS_NormalE getLe() {
        return le;
    }

    public void setLe(LS_NormalE le) {
        this.le = le;
    }

    public NodoM getAnt() {
        return ant;
    }

    public void setAnt(NodoM ant) {
        this.ant = ant;
    }

    public NodoM getSig() {
        return sig;
    }

    public void setSig(NodoM sig) {
        this.sig = sig;
    }

}
