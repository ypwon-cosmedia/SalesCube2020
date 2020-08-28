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

        // �f�[�^�x�[�X�ɐڑ����R�l�N�V�������擾����
        Class.forName("com.mysql.jdbc.Driver");					// JDBC�h���C�o�̓o�^
        con = DriverManager.getConnection(url, user, pass);		// �f�[�^�x�[�X�ւ̐ڑ�
        con.setAutoCommit(false);								// �����R�~�b�g�̉����i�g�����U�N�V�����Ǘ�����j

        return con;
    }

    protected void startTransaction(Connection con)  throws SQLException {
        // Statement�I�u�W�F�N�g�̎擾
        Statement stmt = con.createStatement();
        // �g�����U�N�V�����̊J�n
        stmt.execute("START TRANSACTION");
    }

    protected void releaseDB(Connection con) {
        try {
            // �ڑ��̊J��
            if  (con != null)  {
                con.close();
            }
        } catch (SQLException e) {
        }
    }

    protected void releaseDB(Connection con, Statement stmt) {
        try {
            // ���\�[�X�̊J��
            if  (stmt != null)  {
                stmt.close();
            }
            // �ڑ��̊J��
            if  (con != null)  {
                con.close();
            }
        } catch (SQLException e) {
        }
    }

    protected void releaseDB(Connection con, PreparedStatement stmt) {
        try {
            // ���\�[�X�̊J��
            if  (stmt != null)  {
                stmt.close();
            }
            // �ڑ��̊J��
            if  (con != null)  {
                con.close();
            }
        } catch (SQLException e) {
        }
    }

    protected void releaseDB(Connection con, Statement stmt, ResultSet result) {
        try {
            // ���\�[�X�̊J��
            if  (result != null)  {
                result.close();
            }
            if  (stmt != null)  {
                stmt.close();
            }
            // �ڑ��̊J��
            if  (con != null)  {
                con.close();
            }
        } catch (SQLException e) {
        }
    }

    protected void releaseDB(Connection con, PreparedStatement stmt, ResultSet result) {
        try {
            // ���\�[�X�̊J��
            if  (result != null)  {
                result.close();
            }
            if  (stmt != null)  {
                stmt.close();
            }
            // �ڑ��̊J��
            if  (con != null)  {
                con.close();
            }
        } catch (SQLException e) {
        }
    }
}

