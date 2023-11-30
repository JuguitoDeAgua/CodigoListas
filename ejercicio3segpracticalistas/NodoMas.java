
package ejercicio3segpracticalistas;

public class NodoMas {
    private String nombre;
    private int edad;
    private String tipo;
    
    private NodoMas sig;

    public NodoMas(String nombre, int edad, String tipo) {
        this.nombre = nombre;
        this.edad = edad;
        this.tipo = tipo;
        this.sig = null;
    }

    
    public NodoMas() {
        this.sig = null;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getTipo() {
        return tipo;
    }

    public NodoMas getSig() {
        return sig;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setSig(NodoMas sig) {
        this.sig = sig;
    }
    
    
}
