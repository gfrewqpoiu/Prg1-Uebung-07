public class Vergleich {
    public static final int versicherung1_fixkosten = 50;
    public static final int versicherung2_fixkosten = 0;
    public static final int versicherung3_fixkosten = 100;
    public static final double versicherung1_prozentsatz = 4;
    public static final double versicherung2_prozentsatz = 5;
    public static final double versicherung3_prozentsatz = 3.5;

    public static int berechneDelta(int billigstes, int preis1, int preis2, int preis3){
        if (billigstes == 1) {
            if (preis2 <= preis3) {
                return preis2 - preis1;
            }
            else{
                return preis3 - preis1;
            }
        }
        else if(billigstes == 2){
            if(preis1 < preis3){
                return preis1 - preis2;
            }
            else{
                return preis3 - preis2;
            }
        }
        else{
            if (preis1 < preis2)
                return preis1 - preis3;
            else
                return preis2 - preis3;
        }
    }
    public static int berechneBilligstes(int[] preise){
        if (preise[0] <= preise[1] && preise[0] <= preise[2])
            return 1;
        else if(preise[1] < preise[2])
                return 2;
            else
                return 3;

    }
    public static int billigstes(Tabelle t, int[] preise, Versicherung[] vers){
        int billigste = berechneBilligstes(preise);
        if (billigste == 1) {
            t.makezeile(vers[0].name, 2);
            vers[0].waramBilligsten();
            return 1;
        }
        else if (billigste == 2) {
            t.makezeile(vers[1].name, 2);
            vers[1].waramBilligsten();
            return 2;
        }
        else {
            t.makezeile(vers[2].name, 2);
            vers[2].waramBilligsten();
            return 3;
        }
    }
    public static void main(String[] args){
        Tabelle t = new Tabelle();
        t.printKopf();
        t.println("");
        Versicherung vers1 =  new Versicherung(versicherung1_fixkosten, versicherung1_prozentsatz, "Versich. 1", "Versicherung 1:");
        Versicherung vers2 =  new Versicherung(versicherung2_fixkosten, versicherung2_prozentsatz, "Versich. 2", "Versicherung 2:");
        Versicherung vers3 =  new Versicherung(versicherung3_fixkosten, versicherung3_prozentsatz, "Versich. 3", "Versicherung 3:");
        Versicherung versicherungen[] = new Versicherung[]{vers1, vers2, vers3};
        for (int preis =1000; preis<=6000; preis+=200){
            int preise[] = new int[]{vers1.preisBerechnung(preis), vers2.preisBerechnung(preis), vers3.preisBerechnung(preis)};
            t.makezeile(preis, 1);
            for (int vpreis:
                 preise) {
                t.makezeile(vpreis, 2);
            }
            t.makezeile((berechneDelta(billigstes(t, preise, versicherungen), preise[0] ,preise[1], preise[2])), 0);
            t.printzeile();
        }
        t.printfooter(versicherungen);
    }
}
