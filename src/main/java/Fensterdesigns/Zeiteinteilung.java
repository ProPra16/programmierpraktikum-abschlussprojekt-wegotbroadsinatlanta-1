package Fensterdesigns;

/**
 * Created by Ando Mando on 07.07.2016.
 */
public class Zeiteinteilung {
    private String bereich;
    private long startZeit;
    private long endZeit;
    private long differenz;

    public void Zeiteinteilung(String bereich, long startZeit, long endZeit){
        this.bereich = bereich;
        this.startZeit = startZeit;
    }

    public void zeitunterschied(){
        this.differenz = this.endZeit - this. startZeit;
    }

    public void getzeit(){

    }

}
