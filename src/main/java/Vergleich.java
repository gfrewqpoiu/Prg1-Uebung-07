public class Vergleich {
    public static final int versicherung1_fixkosten = 50;
    public static final int versicherung2_fixkosten = 0;
    public static final int versicherung3_fixkosten = 100;
    public static final double versicherung1_prozentsatz = 4;
    public static final double versicherung2_prozentsatz = 5;
    public static final double versicherung3_prozentsatz = 3.5;

    public static int preisBerechnung(int preis, int fixkosten, double prozentsatz){
        return (int) (((preis/100)*prozentsatz)+fixkosten);
    }
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
        System.out.println("Preis" +"\t"+  "Vers1" +"\t"+ "Vers2" +"\t"+  "Vers3" +"\t"+ "Minimum" +"\t\t\t"+ "Delta Min.");
        int vers1Billigsten=0, vers2Billigsten=0, vers3Billigsten = 0;
        for (int preis =1000; preis<=16000; preis+=200){
            int vers1 = preisBerechnung(preis, versicherung1_fixkosten, versicherung1_prozentsatz);
            int vers2 = preisBerechnung(preis, versicherung2_fixkosten, versicherung2_prozentsatz);
            int vers3 = preisBerechnung(preis, versicherung3_fixkosten, versicherung3_prozentsatz);
            System.out.print(preis+ "\t");
            System.out.print(vers1+ "\t\t");
            System.out.print(vers2+ "\t\t");
            System.out.print(vers3+ "\t\t");
            int billigste =berechneBilligstes(vers1, vers2, vers3);
            if (billigste == 1) {
                System.out.print("Versich. 1" + "\t\t");
                vers1Billigsten++;
            }
            else if (billigste == 2) {
                System.out.print("Versich. 2" + "\t\t");
                vers2Billigsten++;
            }
                else {
                System.out.print("Versich. 3" + "\t\t");
                vers3Billigsten++;
            }
            System.out.print(berechneDelta(billigste, vers1 ,vers2, vers3));
            System.out.println("");
        }
        System.out.println("Am günstigsten:");
        System.out.println("Versicherung 1:\t"+vers1Billigsten+"\tMal");
        System.out.println("Versicherung 2:\t"+vers2Billigsten+"\tMal");
        System.out.println("Versicherung 3:\t"+vers3Billigsten+"\tMal");
    }
}
