package code.tester;


import javafx.beans.property.SimpleStringProperty;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leerling extends Persoon{
    private Klas klas;
    private SimpleStringProperty leerlingNaam;
    private ArrayList<Aanwezigheid> aanwezigheidlist = new ArrayList<>();

    public Leerling(String leerlingNummer, Klas klas, String wachtWoord, String naam){
        super(leerlingNummer);
        this.klas = klas;
        this.leerlingNaam = new SimpleStringProperty(naam);
        klas.leerlingAppenden(this);
    }

    public void aanwezigheidToevoegen(Aanwezigheid aanwezigheid){
        aanwezigheidlist.add(aanwezigheid);
    }

    public Aanwezigheid getAanwezigheid(OnlineLes les) throws SQLException {
        return DatabaseInfo.getAbsentieLeerlingLes(les, this);
    }

    public void setAanwezigheid(OnlineLes les){
        Aanwezigheid a = new Aanwezigheid(this, "", "Aanwezig", les);
        aanwezigheidlist.add(a);
    }

    public Aanwezigheid getAanwezigheidLes(OnlineLes gevraagdeLes) {
        for (Aanwezigheid aanwezigheidLes : aanwezigheidlist) {
            if (aanwezigheidLes.getOnlineLes() == gevraagdeLes) {
                return aanwezigheidLes;
            }
        }
        return null;
    }

    public void updateAanwezigheid(Aanwezigheid updatendeAanwezigheid, String nieuweAanwezigheid) {
        this.updateAanwezigheid(updatendeAanwezigheid, nieuweAanwezigheid, "");
    }

    public void updateAanwezigheid(Aanwezigheid updatendeAanwezigheid, String nieuweAanwezigheid, String extraInformatie){
        if(aanwezigheidlist.contains(updatendeAanwezigheid)){
            int arrayListIndex = aanwezigheidlist.indexOf(updatendeAanwezigheid);
            updatendeAanwezigheid.setAanwezig(nieuweAanwezigheid);
            if(!extraInformatie.equals("")){
                updatendeAanwezigheid.setExtraInformatie(extraInformatie);
            }
            aanwezigheidlist.set(arrayListIndex, updatendeAanwezigheid);
        }
    }

    public String getLeerlingnummer() {
        return super.persoonCode;
    }

    public Klas getKlas() {
        return klas;
    }

    public String getLeerlingNaam() {
        return leerlingNaam.get();
    }

    public List<Aanwezigheid> getAanwezigheidlist() {
        return Collections.unmodifiableList(aanwezigheidlist);
    }

    public void setLeerlingnummer(String leerlingnummer) {
        super.persoonCode = leerlingnummer;
    }

    @Override
    public String toString() {
        return super.persoonCode;
    }
}
