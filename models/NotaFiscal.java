package com.mycompany.exemplocrudjdbc.models;

/**
 *
 * @author juan.adsantos
 */
public class NotaFiscal {

    private int idNota;
    private int numeroNota;
    private double valorNota;

    public NotaFiscal(int numeroNota, double valorNota) {
        this.numeroNota = numeroNota;
        this.valorNota = valorNota;
    }
    
    public NotaFiscal(int idNota, int numeroNota, double valorNota) {
        this.idNota = idNota;
        this.numeroNota = numeroNota;
        this.valorNota = valorNota;
    }
    
    /**
     * @return the idNota
     */
    public int getIdNota() {
        return idNota;
    }

    /**
     * @param idNota the idNota to set
     */
    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    /**
     * @return the numeroNota
     */
    public int getNumeroNota() {
        return numeroNota;
    }

    /**
     * @param numeroNota the numeroNota to set
     */
    public void setNumeroNota(int numeroNota) {
        this.numeroNota = numeroNota;
    }

    /**
     * @return the valorNota
     */
    public double getValorNota() {
        return valorNota;
    }

    /**
     * @param valorNota the valorNota to set
     */
    public void setValorNota(double valorNota) {
        this.valorNota = valorNota;
    }
    
    
}
