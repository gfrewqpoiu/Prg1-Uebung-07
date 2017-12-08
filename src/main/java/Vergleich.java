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
    public static int berechneBilligstes(int preis1, int preis2, int preis3){
        if (preis1 <= preis2 && preis1 <= preis3)
            return 1;
        else if(preis2 < preis3)
                return 2;
            else
                return 3;

    }
    public static void main(String[] args){
        Tabelle t = new Tabelle();
        t.printKopf();
        t.println("");
        Versicherung vers1 =  new Versicherung(versicherung1_fixkosten, versicherung1_prozentsatz, "Versich. 1");
        Versicherung vers2 =  new Versicherung(versicherung2_fixkosten, versicherung2_prozentsatz, "Versich. 2");
        Versicherung vers3 =  new Versicherung(versicherung3_fixkosten, versicherung3_prozentsatz, "Versich. 3");
        for (int preis =1000; preis<=6000; preis+=200){
            int vers1preis = vers1.preisBerechnung(preis);
            int vers2preis = vers2.preisBerechnung(preis);
            int vers3preis = vers3.preisBerechnung(preis);
            t.makezeile(preis, 1);
            t.makezeile(vers1preis, 2);
            t.makezeile(vers2preis, 2);
            t.makezeile(vers3preis, 2);
            int billigste = berechneBilligstes(vers1preis, vers2preis, vers3preis);
            if (billigste == 1) {
                t.makezeile(vers1.name, 2);
                vers1.waramBilligsten();
            }
            else if (billigste == 2) {
                t.makezeile(vers2.name, 2);
                vers2.waramBilligsten();
            }
                else {
                t.makezeile(vers3.name, 2);
                vers3.waramBilligsten();
            }
            t.makezeile((berechneDelta(billigste, vers1preis ,vers2preis, vers3preis)), 0);
            t.printzeile();
        }
        t.printfooter(vers1, vers2, vers3);
    }
}
