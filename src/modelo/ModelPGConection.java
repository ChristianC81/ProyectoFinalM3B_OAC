package modelo;

import java.sql.DriverManager;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class ModelPGConection {

    String cadenaConexion = "jdbc:oracle:thin:@localhost:1521:XE [ProyectoFinalOAC on PROYECTOFINALOAC]";
    String pgUsuario = "ProyectoFinalOAC ";
    String pgPassword = "1234";
    Connection con;

    public ModelPGConection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModelPGConection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            con = DriverManager.getConnection(cadenaConexion, pgUsuario, pgPassword);
        } catch (SQLException ex) {
            Logger.getLogger(ModelPGConection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public ResultSet consulta(String sql){   //SLECTS
        try{
            Statement st = con.createStatement();
            return st.executeQuery(sql);
        }catch(SQLException ex){
            Logger.getLogger(ModelPGConection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public boolean accion(String sql){   //INSERT,UPDATE,DELETE
        
        boolean correcto;
        try{
            
            Statement st = con.createStatement();
            st.execute(sql);
            st.close();  //CIERRO CONEXION SOLO EN CASO DE ACCION
            correcto = true;
        }catch(SQLException ex){
            Logger.getLogger(ModelPGConection.class.getName()).log(Level.SEVERE, null, ex);
            correcto = false;
        }
        return correcto;
    }
}
