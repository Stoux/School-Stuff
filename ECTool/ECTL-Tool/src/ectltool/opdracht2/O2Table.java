/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ectltool.opdracht2;

import ectltool.opdrachtinterface.Table;

/**
 *
 * @author Leon
 */
public class O2Table implements Table {

    @Override
    public String getTableCreateString() {
        return "CREATE TABLE IF NOT EXISTS `klant` (\n" +
            "  `KlantNummer` int(8) NOT NULL COMMENT 'Klantnummer is een maximaal 8 cijfers lang nummer.',\n" +
            "  `KlantNaam` varchar(32) NOT NULL,\n" +
            "  `Telefoon` varchar(16) NOT NULL,\n" +
            "  `Mobiel` varchar(16) DEFAULT NULL,\n" +
            "  `Plaats` varchar(16) NOT NULL,\n" +
            "  `Land` enum('België','Deutschland','France','Nederland','Polska','United Kingdom') NOT NULL DEFAULT 'Nederland',\n" +
            "  `Percentage` int(2) NOT NULL DEFAULT '5' COMMENT 'Percentage is een korting tussen 0 en 99.',\n" +
            "  `SnapShotDatum` date NOT NULL COMMENT 'Datum van extractie',\n" +
            "  `SnapShotTijd` time NOT NULL DEFAULT '23:00:00' COMMENT 'Tijd van extractie',\n" +
            "  PRIMARY KEY (`KlantNummer`,`SnapShotDatum`,`SnapShotTijd`)\n" +
            ") ENGINE=MyISAM DEFAULT CHARSET=latin1;";
    }    
}
