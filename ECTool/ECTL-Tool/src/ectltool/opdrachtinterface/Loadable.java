/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ectltool.opdrachtinterface;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Leon
 */
public interface Loadable {
    
    /**
     * Get the full {@link PreparedStatement} query string
     * @return the SQL query
     */
    public String getPreparedStatementString();
    
    /**
     * Fill the PreparedStatement with this loadable
     * @param prepStat The prepped statement
     * @throws SQLException
     */
    public void prepareStatement(PreparedStatement prepStat) throws SQLException;
    
    public String getTypeName();
    
}
