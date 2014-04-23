/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ectltool.opdracht1;

import ectltool.opdrachtinterface.Table;

/**
 *
 * @author Leon
 */
public class O1Table implements Table{

    @Override
    public String getTableCreateString() {
        return 
                "CREATE TABLE IF NOT EXISTS `klant` "
                + "(`KlantNummer` int(11) NOT NULL, "
                + "`KlantNaam` varchar(32) DEFAULT NULL, "
                + "`Telefoon` varchar(16) DEFAULT NULL, "
                + "`Mobiel` varchar(16) DEFAULT NULL, "
                + "`Plaats` varchar(16) DEFAULT NULL, "
                + "`Land` char(2) DEFAULT NULL, "
                + "`Percentage` int(2) DEFAULT NULL, "
                + "PRIMARY KEY (`KlantNummer`)) "
                + "ENGINE=MyISAM DEFAULT CHARSET=latin1;";
    }

}
