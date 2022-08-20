/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DAO.Conexion;
import DAO.UsuarioDAO;
import VO.*;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Aprendiz
 */
@WebService(serviceName = "ServerCrudUsuario")
public class ServerCrudUsuario extends Conexion {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "insert")
    public boolean insert(@WebParam(name = "UsuarioVO") UsuarioVO usuarioVo) {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        
        if(usuarioDao.insert(usuarioVo)){
            return true;
        }
        return false;
    }
    
    @WebMethod(operationName = "insertWithParam")
    public boolean insertWithParam(@WebParam(name = "email") String email, @WebParam(name = "pass") String pass) {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        UsuarioVO usuarioVo = new UsuarioVO(email, pass);
        return usuarioDao.insert(usuarioVo);
    }
}
