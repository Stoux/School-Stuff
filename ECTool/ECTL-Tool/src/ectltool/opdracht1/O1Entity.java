/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ectltool.opdracht1;

import ectltool.opdrachtinterface.Loadable;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Leon
 */
public class O1Entity implements Loadable {

    private int id;
    private String naam;
    private String telNr;
    private String mobNr;
    private String stad;
    private String land;
    private int percentage;

    public O1Entity(int id, String naam, String telNr, String mobNr, String stad, String land, int percentage) {
        this.id = id;
        this.naam = naam;
        this.telNr = telNr;
        this.mobNr = mobNr;
        this.stad = stad;
        this.land = land;
        this.percentage = percentage;
    }
    
    @Override
    public String getPreparedStatementString() {
        return "INSERT INTO `ectl`.`klant` (`KlantNummer`, `KlantNaam`, `Telefoon`, `Mobiel`, `Plaats`, `Land`, `Percentage`) VALUES (?, ?, ?, ?, ?, ?, ?);";
    }

    @Override
    public void prepareStatement(PreparedStatement prepStat) throws SQLException {
        prepStat.setInt(1, id);
        prepStat.setString(2, naam);
        prepStat.setString(3, telNr);
        prepStat.setString(4, mobNr);
        prepStat.setString(5, stad);
        prepStat.setString(6, land);
        prepStat.setInt(7, percentage);
    }

    @Override
    public String getTypeName() {
        return "O1Entity";
    }
    
}
