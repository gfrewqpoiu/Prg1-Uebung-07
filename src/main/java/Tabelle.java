public class Tabelle { //table in English
    String kopf = "Preis" +"\t"+  "Vers1" +"\t"+ "Vers2" +"\t"+  "Vers3" +"\t"+ "Minimum" +"\t\t\t"+ "Delta Min."; //header
    String zeile = ""; //one line of the table
    public void print(String ausgabe){
        /*
         * shorthand for System.out.print(s)
         */
        System.out.print(ausgabe);
    }
    public void printKopf(){
        print(kopf);
    }
    public void println(String ausgabe){
        /*
         * shorthand for System.out.println
         */
        print(ausgabe + "\n");
    }
    
    public void makezeile(String s, int tabs){
        /*
         * Adds the given String to the end of the current line and then adds the given amount of tabulators at the end.
         */
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
