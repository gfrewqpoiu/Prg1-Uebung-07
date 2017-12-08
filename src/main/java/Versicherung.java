public class Versicherung {
    int fixkosten;
    double prozentsatz;
    int ambilligsten;
    String name;

    Versicherung(int fix, double prozent, String name){
        fixkosten = fix;
        prozentsatz = prozent;
        ambilligsten = 0;
        name = name;
    }

    public int preisBerechnung(int preis){
        return (int) (((preis/100)*this.prozentsatz)+this.fixkosten);
    }
    public void waramBilligsten(){
        ambilligsten++;
    }

}
