package model.dao;

//Estructura de datos
import java.util.ArrayList;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;



//Clase para conexión
import util.JDBCUtilities;

//Encapsulamiento de los datos
import model.vo.*;

public class Consulta1_19Dao {
    public static ArrayList<Consulta1VO_19> consulta1DAO() throws SQLException {
        Connection conn = null;
        Statement command = null;
        ResultSet result = null;
        ArrayList<Consulta1VO_19> data = new ArrayList<>();
        try {
            conn = JDBCUtilities.getConnection();
           // System.out.println("La coneccion ha sido exitosa.");
            command = conn.createStatement();
            result = command.executeQuery("SELECT ID_Proyecto , Fecha_Inicio , Constructora , Serial FROM Proyecto where ID_Proyecto < 15");
            //System.out.println("#  - ID_Proyecto   -   Fecha_Inicio    -   Constructora     -   Serial");
            int i = 1;
            while(result.next()){
                Consulta1VO_19 c = new Consulta1VO_19(result.getInt("ID_Proyecto"), result.getString("Fecha_Inicio"),  result.getString("Constructora"), result.getString("Serial"));
                data.add(c);
                i++;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }finally{
            try {
                if (result != null){
                    result.close();
                }
                if (command != null) {
                    command.close();
                }
                if (conn != null){
                    conn.close();
                }
            } catch (SQLException e) {
            }
            
        }
        return data;
    }
}
