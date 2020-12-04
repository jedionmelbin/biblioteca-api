package com.ixcorp.app.api.dto;

public class PrestamoStatus {

    private PrestamoDTO prestamos;

    private String status; // progress, completed

    private String message;

    public PrestamoStatus() {
    }

    public PrestamoStatus(PrestamoDTO prestamos, String status, String message) {
        this.prestamos = prestamos;
        this.status = status;
        this.message = message;
    }

    public PrestamoDTO getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(PrestamoDTO prestamos) {
        this.prestamos = prestamos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "PrestamoStatus{" +
                "prestamos=" + prestamos +
                ", status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
