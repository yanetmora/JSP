/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author yanet
 */
public class Actividad {
    private int cveUniversidad;
    private String descripcion;
    private String lugar;
    private String fechaInicio;
    private String fechaFin;
    private int totalHoras;

    public Actividad(){
         this(0,"","","","",0);
   
    }

    public Actividad(int cveUniversidad, String descripcion, String lugar, String fechaInicio, String fechaFin, int totalHoras) {
        this.cveUniversidad = cveUniversidad;
        this.descripcion = descripcion;
        this.lugar = lugar;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.totalHoras = totalHoras;
    }

    public int getCveUniversidad() {
        return cveUniversidad;
    }

    public void setCveUniversidad(int cveUniversidad) {
        this.cveUniversidad = cveUniversidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getTotalHoras() {
        return totalHoras;
    }

    public void setTotalHoras(int totalHoras) {
        this.totalHoras = totalHoras;
    }

    @Override
    public String toString() {
        return "Actividad{" + "cveUniversidad=" + cveUniversidad + ", descripcion=" + descripcion + ", lugar=" + lugar + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", totalHoras=" + totalHoras + '}';
    }

    


    
}
