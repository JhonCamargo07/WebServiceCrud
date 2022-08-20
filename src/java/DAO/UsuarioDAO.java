package DAO;

import VO.UsuarioVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aprendiz
 */
public class UsuarioDAO extends Conexion {

    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private String sql = "";
    private boolean operacionExitosa;

    public boolean insert(UsuarioVO usuarioVo) {

        try {
            sql = "INSERT INTO usuario (email, password) VALUES (?,?)";

            conn = this.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuarioVo.getEmail());
            stmt.setString(2, usuarioVo.getPassword());
            stmt.executeUpdate();
            
            operacionExitosa = true;

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return operacionExitosa;
    }

}
