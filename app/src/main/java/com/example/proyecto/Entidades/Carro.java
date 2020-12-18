package com.example.proyecto.Entidades;

public class Carro {
    private String Marca;
    private String Modelo;
    private String Agencia;
    private String Precio;
    private int imagenid;

    public Carro() {
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public String getAgencia() {
        return Agencia;
    }

    public void setAgencia(String agencia) {
        Agencia = agencia;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String precio) {
        Precio = precio;
    }

    public int getImagenid() {
        return imagenid;
    }

    public void setImagenid(int imagenid) {
        this.imagenid = imagenid;
    }

    public Carro(String marca, String modelo, String agencia, String precio, int imagenid) {
        this.Marca = marca;
        this.Modelo = modelo;
        this.Agencia = agencia;
        this.Precio = precio;
        this.imagenid = imagenid;
    }
}
