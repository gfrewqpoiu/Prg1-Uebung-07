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
    public void printfooter(Versicherung[] v){
        println("");
        println("Am günstigsten:");
        for (Versicherung vers:
             v) {
            makezeile(vers.vollername, 1);
            makezeile(vers.ambilligsten, 1);
            makezeile("Mal", 0);
            printzeile();
        }
    }
}
