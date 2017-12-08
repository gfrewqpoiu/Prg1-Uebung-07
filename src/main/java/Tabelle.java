public class Tabelle {
    String kopf = "Preis" +"\t"+  "Vers1" +"\t"+ "Vers2" +"\t"+  "Vers3" +"\t"+ "Minimum" +"\t\t\t"+ "Delta Min.";
    String zeile = "";
    public void print(String ausgabe){
        System.out.print(ausgabe);
    }
    public void printKopf(){
        print(kopf);
    }
    public void println(String ausgabe){
        print(ausgabe + "\n");
    }

    public void printfooter(Versicherung vers1, Versicherung vers2, Versicherung vers3){
        println("");
        println("Am günstigsten:");
        println("Versicherung 1:\t"+vers1.ambilligsten+"\tMal");
        println("Versicherung 2:\t"+vers2.ambilligsten+"\tMal");
        println("Versicherung 3:\t"+vers3.ambilligsten+"\tMal");
    }

    public void makezeile(String s, int tabs){
        if (tabs == 2){
            s = s + "\t\t";
        }
        else{
            if (tabs == 1){
                s = s + "\t";
            }
        }
        zeile = zeile + s;
    }

    public void makezeile(int s,int tabs) {
        makezeile(Integer.toString(s), tabs);
    }
    public void printzeile(){
        println(zeile);
        zeile = "";
    }
}
