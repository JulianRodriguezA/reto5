package controller;

//Estructuras de datos (colecciones)
import java.util.ArrayList;

//Modelos (acceso y objetos contenedores)
import model.dao.*;
import model.vo.*;
import util.JDBCUtilities;

//Librerías para bases de datos
import java.sql.SQLException;

public class ControladorRequerimientosReto4 {       
/*1) Seleccione el id del proyecto, la fecha, la constructora y el serial de los proyectos que tengan
como id de proyecto los números menores a 15
SELECT ID_Proyecto , Fecha_Inicio , Constructora , Serial FROM Proyecto where ID_Proyecto < 15 

2) Seleccione el id del proyecto y el área máxima del Tipo de los proyectos con construcciones con
un numero de cuartos/habitaciones igual a 2.
SELECT p.ID_Proyecto, t.Area_Max 
FROM Proyecto p
NATURAL JOIN Tipo t
WHERE p.Numero_Habitaciones = 2
3) Seleccione el id del proyecto y como segunda y última columna el nombre del Lider concatenado
con su primer apellido separados por un espacio con el nombre de la columna como
nombreapellido, y la condición deberá ser que todos los proyectos seleccionados pertenezcan al
banco “Bancolombia”. 
SELECT p.ID_Proyecto, l.Nombre || " " || l.Primer_Apellido as nombreapellido
from Proyecto p 
join Lider l 
where p.Banco_Vinculado ='Bancolombia' and p.ID_Lider = l.ID_Lider 
*/
    public ArrayList<Consulta1VO_19> realizarConsulta1() throws SQLException{
        ArrayList<Consulta1VO_19> data = null;
        data = Consulta1_19Dao.consulta1DAO();
        return data;
    }
    public ArrayList<Consulta2VO_19> realizarConsulta2() throws SQLException{
        ArrayList<Consulta2VO_19> data = null;
        data = Consulta2_19Dao.consulta2DAO();
        return data;
    }
    public ArrayList<Consulta3VO_19> realizarConsulta3() throws SQLException{
        ArrayList<Consulta3VO_19> data = null;
        data = Consulta3_19Dao.consulta3DAO();
        return data;
    }
}
