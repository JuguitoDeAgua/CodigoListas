
package ejemplo2multipleslistas;

public class PRINCIPAL {
    
    public static void main(String[] args) {
        // LISTA DE COMBOS:
        LS_NormalCb comb = new LS_NormalCb();
        
        comb.adiFinal(165, "Fiesta", 35);
        comb.adiFinal(231, "Jumbo", 165);
        comb.adiFinal(567, "Kapuja", 78);
        comb.adiFinal(123, "Copa", 180);
        comb.adiFinal(345, "Junior", 15);
        // LISTA DE VENTAS
        LS_NormalVenta ven = new LS_NormalVenta();
        
        LS_NormalCbPed pedi1 = new LS_NormalCbPed();
        pedi1.adiFinal(165, 23);
        pedi1.adiFinal(231, 43);
        pedi1.adiFinal(123, 55);
        pedi1.adiFinal(165, 2);
        
        LS_NormalCbPed pedi2 = new LS_NormalCbPed();
        pedi2.adiFinal(345, 115);
        pedi2.adiFinal(165, 78);
        
        LS_NormalCbPed pedi3 = new LS_NormalCbPed();
        pedi3.adiFinal(231, 24);
        pedi3.adiFinal(165, 56);
        pedi3.adiFinal(567, 67);

        
        LS_NormalOrd lor = new LS_NormalOrd();
        lor.adiFinal("Anthony Diaz", pedi1);
        lor.adiFinal("Artux Creed", pedi2);
        lor.adiFinal("Juanaa Simulator", pedi3);
        
        LS_NormalOrd lor1 = new LS_NormalOrd();
        lor1.adiFinal("Anthony Diaz", pedi1);
        lor1.adiFinal("Lusiana Creed", pedi2);
        
        LS_NormalOrd lor2 = new LS_NormalOrd();
        lor2.adiFinal("Anthonio Banderas", pedi1);
        lor2.adiFinal("Pablo Creed", pedi2);
        lor2.adiFinal("Elva Simulator", pedi3);
        lor2.adiFinal("Robert Creed", pedi2);
        
        ven.adiFinal("23/nov/23", lor2);
        ven.adiFinal("25/dic/23", lor1);
        ven.adiFinal("3/ene/24", lor);
        ven.adiFinal("45/45/50", lor);
        
        
        comb.mostrar();
        System.out.println("***************************************************");
        //ven.mostrar();
        
        
        System.out.println("TOTAL GANANCIAS EN LA FECHA 25/dic/23:");
        System.out.println(TotalgananciasFecha(ven,comb,"25/dic/23"));
    }
    
    public static double PrecioCombo(LS_NormalCb cb, int nrocb){
        NodoCb r = cb.getP();
        
        while(r !=null){
            if(r.getNroCombo()==nrocb){
                return r.getPrecio();
            }
            r = r.getSig();
        }
        return 0;
    }
    
    public static double TotalgananciasFecha(LS_NormalVenta ven,LS_NormalCb cb, String fecha){
        NodoVenta R = ven.getP();
        double total =0;
        while(R !=null){
            if(R.getFecha()== fecha){
                NodoOrd Q = R.getLord().getP();
                while(Q!=null){
                    NodoCbPed S = Q.getPed().getP();
                    while(S!=null){
                        int nroCombo = S.getNroCombo();
                        total = total + (PrecioCombo(cb, nroCombo) * S.getCantidad());
                        S = S.getSig();
                    }
                    Q = Q.getSig();
                }
            }
            R = R.getSig();
        }
        return total;
    }
    
}
