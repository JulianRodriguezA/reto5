package model.dao;

//Estructura de datos
import java.util.ArrayList;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

//Clase para conexión
import util.JDBCUtilities;

//Encapsulamiento de los datos
import model.vo.*;

public class Consulta2_19Dao {  
    public static ArrayList<Consulta2VO_19> consulta2DAO() throws SQLException {
        Connection conn = null;
        Statement command = null;
        ResultSet result = null;
        ArrayList<Consulta2VO_19> data = new ArrayList<>();
        try {
            conn = JDBCUtilities.getConnection();
           // System.out.println("La coneccion ha sido exitosa.");
            command = conn.createStatement();
            result = command.executeQuery("SELECT Proyecto.ID_Proyecto, Tipo.Area_Max FROM Proyecto  NATURAL JOIN Tipo  WHERE Proyecto.Numero_Habitaciones = 2");
            //System.out.println("#  - ID_Proyecto   -   Fecha_Inicio    -   Constructora     -   Serial");
            int i = 1;
            while(result.next()){
                Consulta2VO_19 c = new Consulta2VO_19(result.getInt("ID_Proyecto"),result.getInt("Area_Max"));
                data.add(c);
                i++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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
