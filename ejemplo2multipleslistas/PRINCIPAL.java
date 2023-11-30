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
        //pedi1.adiFinal(231, 43);
        //pedi1.adiFinal(123, 55);
        //pedi1.adiFinal(165, 2);
        
        LS_NormalCbPed pedi2 = new LS_NormalCbPed();
        pedi2.adiFinal(345, 115);
        //pedi2.adiFinal(165, 78);
        
        LS_NormalCbPed pedi3 = new LS_NormalCbPed();
        //pedi3.adiFinal(231, 24);
        pedi3.adiFinal(165, 56);
        //pedi3.adiFinal(567, 67);

        
        LS_NormalOrd lor = new LS_NormalOrd();
        lor.adiFinal("Anthony Diaz", pedi1);
        //lor.adiFinal("Artux Creed", pedi2);
        //lor.adiFinal("Juanaa Simulator", pedi3);
        
        LS_NormalOrd lor1 = new LS_NormalOrd();
        lor1.adiFinal("Anthony Diaz", pedi1);
        //lor1.adiFinal("Lusiana Creed", pedi2);
        
        LS_NormalOrd lor2 = new LS_NormalOrd();
        lor2.adiFinal("Anthonio Banderas", pedi1);
        //lor2.adiFinal("Pablo Creed", pedi2);
        //lor2.adiFinal("Elva Simulator", pedi3);
        //lor2.adiFinal("Robert Creed", pedi2);
        
        ven.adiFinal("23/nov/23", lor2);
        ven.adiFinal("25/dic/23", lor1);
        ven.adiFinal("3/ene/24", lor);
        ven.adiFinal("45/45/50", lor);
        
        
        comb.mostrar();
        System.out.println("***************************************************");
        //ven.mostrar();
        
        
        System.out.println("TOTAL GANANCIAS EN LA FECHA 25/dic/23:");
        System.out.println(TotalgananciasFecha(ven,comb,"25/dic/23"));
        
        System.out.println("**************//////////////////////////////************************************************");
        
        
        mostrarTotalPedCombo(ven,comb);
        
        System.out.println("////////**************/////////////////");
        CalculaPedidos(comb,ven);
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
    // c. Por cada combo, calcular la cantidad total de pedidos de todas las fechas. 

    public static boolean BuscaNroCombo(LS_NormalCb cb ,int nroCB){
        NodoCb R = cb.getP();
        boolean sw =false;
        while(R!=null){
            if(R.getNroCombo()==nroCB){
                //return R.getNroCombo();
                sw=true;
                return sw;
            }
            R = R.getSig();
        }
        return sw;
        //return 0;
    }
    
    public static void CalculaPedidos(LS_NormalCb cbb, LS_NormalVenta ven){
        NodoVenta R = ven.getP();
        int canti = 0;
        while(R != null){
            NodoOrd Q = R.getLord().getP();
            while(Q !=null){
                NodoCbPed S = Q.getPed().getP();
                while(S!=null){
                    int kk = S.getNroCombo();
                    if(BuscaNroCombo(cbb,kk)){
                        canti = S.getCantidad()+canti;
                        System.out.println("total pedidos del combo:"+canti);
                    }
                    S = S.getSig();
                }
                Q = Q.getSig();
            }
            R = R.getSig();
        }
        
        System.out.println("cantidad: "+canti);
    }
  
    
    public static int contarPedCombo(LS_NormalVenta lsv, int nroCombox) {
        int cant = 0;
        NodoVenta R = lsv.getP();

        while (R != null) {
            NodoOrd Q = R.getLord().getP();

            while (Q != null) {
                NodoCbPed S = Q.getPed().getP();

                while (S != null) {
                    if (S.getNroCombo() == nroCombox) {
                        cant += S.getCantidad();
                    }
                    S = S.getSig();
                }

                Q = Q.getSig();
            }

            R = R.getSig();
        }

        return cant;
    }

    public static void mostrarTotalPedCombo(LS_NormalVenta lsv, LS_NormalCb lsc) {
        NodoCb R = lsc.getP();

        while (R != null) {
            int nroCombo = R.getNroCombo();
            System.out.println(R.getNombre() + " " + contarPedCombo(lsv, nroCombo));
            R = R.getSig();
        }
    }
}
