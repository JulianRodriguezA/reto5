package model.vo;

public class Consulta1VO_19 {
    private int id;  
    private String fecha;  
    private String constructora;
    private String serial; 

    public Consulta1VO_19(int id,String fecha, String constructora,String serial){
        this.id=id;
        this.fecha=fecha;
        this.constructora=constructora;
        this.serial=serial;
    }
    public String getConstructora() {
        return constructora;
    }
    public String getFecha() {
        return fecha;
    }
    public int getId() {
        return id;
    }
    public String getSerial() {
        return serial;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public void setConstructora(String constructora) {
        this.constructora = constructora;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setSerial(String serial) {
        this.serial = serial;
    }
}
