package view;

import controller.ControladorRequerimientosReto4;
import model.vo.*;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class VistaRequerimientosReto4 {
  
    public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();
    
    public static void generar(){
        JframePrincipal jf = new JframePrincipal(VistaRequerimientosReto4.consulta1(),VistaRequerimientosReto4.consulta2(),VistaRequerimientosReto4.consulta3());
        jf.setVisible(true);
    }
    public static ArrayList<Consulta1VO_19> consulta1(){
        System.out.println("-----Consulta 1-------"); 
         ArrayList<Consulta1VO_19> lista = null;
        try{

            lista = controlador.realizarConsulta1();

            //Encabezado del resultado
            System.out.println("id_proyecto, Fecha_Inicio , Constructora , serial");//int-s-s-d
           
            
            //Cada VO cargado, mostrarlo en la vista
            for(int i = 0;i<lista.size();i++){
                //System.out.printf("%d %s %s %s \n",lista.get(i).getId(),lista.get(i).getFecha(),lista.get(i).getConstructora(),lista.get(i).getSerial());
            }
            return lista;
        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }  
        return lista;
    }

    public static ArrayList<Consulta2VO_19> consulta2(){
        System.out.println("-----Consulta 2-------"); 
        ArrayList<Consulta2VO_19> lista = null;
        try{

            lista = controlador.realizarConsulta2();

            //Encabezado del resultado
            System.out.println("id_proyecto, area_max");
            
            //Cada VO cargado, mostrarlo en la vista
            for(int i = 0;i<lista.size();i++){
                //System.out.printf("%d %d \n",lista.get(i).getId(),lista.get(i).getArea_max());
            }
            
        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }   
        return lista;
    }


    public static ArrayList<Consulta3VO_19> consulta3(){
        System.out.println("-----Consulta 3-------"); 
         ArrayList<Consulta3VO_19> lista = null;
        try{

            lista = controlador.realizarConsulta3();

            //Encabezado del resultado
            System.out.println("id_proyecto, nombreapellido");
            //Cada VO cargado, mostrarlo en la vista
            for(int i = 0;i<lista.size();i++){
                System.out.printf("%d %s \n",lista.get(i).getId(),lista.get(i).getNombre());
            }
        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }  
        return lista;
    }
}
