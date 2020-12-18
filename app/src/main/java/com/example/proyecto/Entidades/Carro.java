package com.example.proyecto.Entidades;

import android.graphics.drawable.Drawable;
import android.os.Message;

import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Carro {
    private String imagenurl;
    private String Marca;
    private String Modelo;
    private String Precio;
    public static Drawable imagen;
    public Message msg;

    public static Drawable LoadImageFromWebOperations(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "src name");
            return d;
        } catch (Exception e) {
            return null;
        }
    }

    public String getCapacidad() {
        return Capacidad;
    }

    public void setCapacidad(String capacidad) {
        Capacidad = capacidad;
    }

    private String Capacidad;
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

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String precio) {
        Precio = precio;
    }

    public void Notifier(Message msg) {
        this.msg = msg;
    }




    public Drawable getImagen() {
        Drawable d;
        ExecutorService threadpool = Executors.newCachedThreadPool();
        Future<Drawable> futureTask = threadpool.submit(() -> LoadImageFromWebOperations(imagenurl));

        while (!futureTask.isDone()) {
            System.out.println("FutureTask is not finished yet...");
        }

        try {
           d = futureTask.get();
            threadpool.shutdown();
            return d;

        } catch (Exception e) {
            return null;
        }



    }


    public Carro(String marca, String modelo, String precio, String imagenurl, String capacidad) {
        this.Marca = marca;
        this.Modelo = modelo;
        this.Precio = precio;
        this.Capacidad = capacidad;
        this.imagenurl = imagenurl;
    }
}
