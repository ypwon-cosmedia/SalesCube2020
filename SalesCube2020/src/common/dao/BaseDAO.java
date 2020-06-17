package common.dao;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.MissingResourceException;



abstract public class BaseDAO {

    protected Connection getConnection() throws SQLException, ClassNotFoundException, MissingResourceException {

        Connection con = null;
        String url;
        String host;
        String db;
        String encoding;
        String user;
        String pass;

        host     = "localhost";
        db       =	"salescube";
        encoding =  "UTF-8";
        user     =  "root";
        pass     =  "root";

        url = "jdbc:mysql://" + host + "/" + db + "?useUnicode=true&characterEncoding=" + encoding;

        // データベースに接続しコネクションを取得する
        Class.forName("com.mysql.jdbc.Driver");					// JDBCドライバの登録
        con = DriverManager.getConnection(url, user, pass);		// データベースへの接続
        con.setAutoCommit(false);								// 自動コミットの解除（トランザクション管理する）

        return con;
    }

    protected void startTransaction(Connection con)  throws SQLException {
        // Statementオブジェクトの取得
        Statement stmt = con.createStatement();
        // トランザクションの開始
        stmt.execute("START TRANSACTION");
    }

    protected void releaseDB(Connection con) {
        try {
            // 接続の開放
            if  (con != null)  {
                con.close();
            }
        } catch (SQLException e) {
        }
    }

    protected void releaseDB(Connection con, Statement stmt) {
        try {
            // リソースの開放
            if  (stmt != null)  {
                stmt.close();
            }
            // 接続の開放
            if  (con != null)  {
                con.close();
            }
        } catch (SQLException e) {
        }
    }

    protected void releaseDB(Connection con, PreparedStatement stmt) {
        try {
            // リソースの開放
            if  (stmt != null)  {
                stmt.close();
            }
            // 接続の開放
            if  (con != null)  {
                con.close();
            }
        } catch (SQLException e) {
        }
    }

    protected void releaseDB(Connection con, Statement stmt, ResultSet result) {
        try {
            // リソースの開放
            if  (result != null)  {
                result.close();
            }
            if  (stmt != null)  {
                stmt.close();
            }
            // 接続の開放
            if  (con != null)  {
                con.close();
            }
        } catch (SQLException e) {
        }
    }

    protected void releaseDB(Connection con, PreparedStatement stmt, ResultSet result) {
        try {
            // リソースの開放
            if  (result != null)  {
                result.close();
            }
            if  (stmt != null)  {
                stmt.close();
            }
            // 接続の開放
            if  (con != null)  {
                con.close();
            }
        } catch (SQLException e) {
        }
    }
}

