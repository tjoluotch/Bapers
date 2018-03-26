/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.*;

/**
 *
 * @author tjay
 */
public interface DBConnectivity {
     
    Connection open_Connection();
        //void close_Connection() throws SQLException;
}
