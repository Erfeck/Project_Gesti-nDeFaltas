package com.erfeck.base;

public class Asignatura {
    
    private int idAsignatura;
    private String nombreAsignatura;
    private int faltasTotales;

    public Asignatura(int idAsignatura, String nombreAsignatura, int faltasTotales) {
        this.idAsignatura = idAsignatura;
        this.nombreAsignatura = nombreAsignatura;
        this.faltasTotales = faltasTotales;
    }

    public int getIdAsignatura() {
        return idAsignatura;
    }
    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }
    public String getNombreAsignatura() {
        return nombreAsignatura;
    }
    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }
    public int getFaltasTotales() {
        return faltasTotales;
    }
    public void setFaltasTotales(int faltasTotales) {
        this.faltasTotales = faltasTotales;
    }

    @Override
    public String toString() {
        return nombreAsignatura;
    }
}