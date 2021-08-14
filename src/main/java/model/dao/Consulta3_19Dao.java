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

public class Consulta3_19Dao {
    public static ArrayList<Consulta3VO_19> consulta3DAO() throws SQLException {
        Connection conn = null;
        Statement command = null;
        ResultSet result = null;
        ArrayList<Consulta3VO_19> data = new ArrayList<>();
        try {
            conn = JDBCUtilities.getConnection();
           // System.out.println("La coneccion ha sido exitosa.");
            command = conn.createStatement();
            result = command.executeQuery("SELECT Proyecto.ID_Proyecto, Lider.Nombre || \" \" || Lider.Primer_Apellido as nombreapellido from Proyecto join Lider where Proyecto.Banco_Vinculado ='Bancolombia' and Proyecto.ID_Lider = Lider.ID_Lider ");
            //System.out.println("#  - ID_Proyecto   -   Fecha_Inicio    -   Constructora     -   Serial");
            int i = 1;
            while(result.next()){
                Consulta3VO_19 c = new Consulta3VO_19(result.getInt("ID_Proyecto"),result.getString("nombreapellido"));
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
