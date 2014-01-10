/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ectltool.opdracht2;

import ectltool.opdrachtinterface.Loadable;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Leon
 */
public class O2Entity implements Loadable {
    
    public static Date date;

    private int klantnummer;
    private String klantnaam;
    private String telefoon;
    private String mobiel;
    private String plaats;
    private Land land;
    private int percentage;
    private String time;

    public O2Entity(int klantnummer, String klantnaam, String telefoon, String mobiel, String plaats, Land land, int percentage) {
        this.klantnummer = klantnummer;
        this.klantnaam = klantnaam;
        this.telefoon = telefoon;
        this.mobiel = mobiel;
        this.plaats = plaats;
        this.land = land;
        this.percentage = percentage;
    }
    
    @Override
    public String getPreparedStatementString() {
        return "INSERT INTO `ectl`.`klant` ("
                + "`KlantNummer`, `KlantNaam`, `Telefoon`, `Mobiel`, `Plaats`, `Land`, `Percentage`, `SnapShotDatum`, `SnapShotTijd`) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
    }

    @Override
    public void prepareStatement(PreparedStatement prepStat) throws SQLException {
        prepStat.setInt(1, klantnummer);
        prepStat.setString(2, klantnaam);
        prepStat.setString(3, telefoon);
        prepStat.setString(4, mobiel);
        prepStat.setString(5, plaats);
        prepStat.setString(6, land.fullname);
        prepStat.setInt(7, percentage);
        prepStat.setDate(8, date);
        prepStat.setString(9, "00:00:00");
    }

    @Override
    public String getTypeName() {
        return "O2Entity";
    }
    
    public enum Land {
        BE("Belgie"),
        DE("Deutschland"),
        FR("France"),
        NL("Nederland"),
        PL("Polska"),
        UK("United Kingdom");
        
        private String fullname;
        private Land(String s) {
            fullname = s;
        }
        
        public static Land parse(String s) {
            Land l;
            try {
                l = Land.valueOf(s);
            } catch (IllegalArgumentException e) {
                l = NL;
            }
            return l;
        }
        
    }
    
}
