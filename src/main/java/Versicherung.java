public class Versicherung {
    int fixkosten;
    double prozentsatz;
    int ambilligsten;
    String name;
    String vollername;

    Versicherung(int fix, double prozent, String n, String vn){
        fixkosten = fix;
        prozentsatz = prozent;
        ambilligsten = 0;
        name = n;
        vollername = vn;
    }

    public int preisBerechnung(int preis){
        return (int) (((preis/100)*this.prozentsatz)+this.fixkosten);
    }
    public void waramBilligsten(){
        ambilligsten++;
    }

}
