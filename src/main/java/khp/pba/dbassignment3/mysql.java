/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khp.pba.dbassignment3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Kasper
 */
public class mysql {

    public int firstDepth(int id) {
        String query = "SELECT count(DISTINCT target_node_id) "
                + "FROM t_user JOIN t_endorses ON t_user.id = source_node_id "
                + "WHERE source_node_id =" + id + ";";
        return sendQuery(query);
    }

    public int secondDepth(int id) {
        String query = "SELECT count(DISTINCT target_node_id) "
                + "FROM t_user JOIN t_endorses ON t_user.id = source_node_id "
                + "WHERE source_node_id IN "
                + "(SELECT target_node_id "
                + "FROM t_user JOIN t_endorses ON t_user.id = source_node_id "
                + "WHERE source_node_id =" + id + ");";
        return sendQuery(query);
    }

    public int thirdDepth(int id) {
        String query = "SELECT count(DISTINCT target_node_id) "
                + "FROM t_user JOIN t_endorses ON t_user.id = source_node_id "
                + "WHERE source_node_id IN "
                + "(SELECT target_node_id "
                + "FROM t_user JOIN t_endorses ON t_user.id = source_node_id "
                + "WHERE source_node_id IN "
                + "(SELECT target_node_id "
                + "FROM t_user JOIN t_endorses ON t_user.id = source_node_id "
                + "WHERE source_node_id =" + id + "));";
        return sendQuery(query);
    }

    public int fourthDepth(int id) {
        String query = "SELECT count(DISTINCT target_node_id) "
                + "FROM t_user JOIN t_endorses ON t_user.id = source_node_id "
                + "WHERE source_node_id IN "
                + "(SELECT target_node_id "
                + "FROM t_user JOIN t_endorses ON t_user.id = source_node_id "
                + "WHERE source_node_id IN "
                + "(SELECT target_node_id "
                + "FROM t_user JOIN t_endorses ON t_user.id = source_node_id "
                + "WHERE source_node_id IN "
                + "(SELECT target_node_id "
                + "FROM t_user JOIN t_endorses ON t_user.id = source_node_id "
                + "WHERE source_node_id =" + id + ")));";
        return sendQuery(query);
    }

    public int fifthDepth(int id) {
        String query = "SELECT count(DISTINCT target_node_id) "
                + "FROM t_user JOIN t_endorses ON t_user.id = source_node_id "
                + "WHERE source_node_id IN "
                + "(SELECT target_node_id "
                + "FROM t_user JOIN t_endorses ON t_user.id = source_node_id "
                + "WHERE source_node_id IN "
                + "(SELECT target_node_id "
                + "FROM t_user JOIN t_endorses ON t_user.id = source_node_id "
                + "WHERE source_node_id IN "
                + "(SELECT target_node_id "
                + "FROM t_user JOIN t_endorses ON t_user.id = source_node_id "
                + "WHERE source_node_id IN "
                + "(SELECT target_node_id "
                + "FROM t_user JOIN t_endorses ON t_user.id = source_node_id "
                + "WHERE source_node_id =" + id + "))));";
        return sendQuery(query);
    }

    public int sendQuery(String query) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://localhost:3306/sys";
        String user = "root";
        String password = "pwd";

        int amount = 0;
        try {

            con = DriverManager.getConnection(url, user, password);

            st = con.createStatement();
            rs = st.executeQuery(query);

            if (rs.next()) {
                amount = rs.getInt(1);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.err.println(ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                System.err.println(ex);
            }
            
        }
        return amount;
    }
}
