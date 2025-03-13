package com.erfeck.base;

import java.time.LocalDate;

public class Falta {
    
    private int idFalta;
    private int horasFaltadas;
    private String motivo;
    private boolean cuentaComoFalta;
    private LocalDate fechaFalta;

    public Falta(int idFalta, int horasFaltadas, String motivo, boolean cuentaComoFalta, LocalDate fechaFalta) {
        this.idFalta = idFalta;
        this.horasFaltadas = horasFaltadas;
        this.motivo = motivo;
        this.cuentaComoFalta = cuentaComoFalta;
        this.fechaFalta = fechaFalta;
    }

    public int getIdFalta() {
        return idFalta;
    }
    public void setIdFalta(int idFalta) {
        this.idFalta = idFalta;
    }
    public int getHorasFaltadas() {
        return horasFaltadas;
    }
    public void setHorasFaltadas(int horasFaltadas) {
        this.horasFaltadas = horasFaltadas;
    }
    public String getMotivo() {
        return motivo;
    }
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    public boolean isCuentaComoFalta() {
        return cuentaComoFalta;
    }
    public void setCuentaComoFalta(boolean cuentaComoFalta) {
        this.cuentaComoFalta = cuentaComoFalta;
    }
    public LocalDate getFechaFalta() {
        return fechaFalta;
    }
    public void setFechaFalta(LocalDate fechaFalta) {
        this.fechaFalta = fechaFalta;
    }

    @Override
    public String toString() {
        return "Falta{" + "idFalta=" + idFalta + ", horasFaltadas=" + horasFaltadas + ", motivo=" + motivo + ", cuentaComoFalta=" + cuentaComoFalta + ", fechaFalta=" + fechaFalta + '}';
    }
}