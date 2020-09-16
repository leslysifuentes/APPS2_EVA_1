package com.example.eva1_11_clima;

public class Weather {
    /*Nombre de la ciudad - string
    * Temperatura - int
    * Descripción del clima - string
    * imagen - int
     */
    private String ciudad;
    private int temperatura;
    private String descripcion;
    private int imagen;

    public Weather(){
        this.ciudad = "";
        this.temperatura = 0;
        this.descripcion ="";
        this.imagen = -1;
    }
    //en el emulador (debe tener acceso a internet)
//https://samples.openweathermap.org/data/2.5/box/city?bbox=12,32,15,37,10&appid=439d4b804bc8187953eb36d2a8c26a02
    public Weather(String ciudad, int temperatura, String descripcion, int imagen) {
        this.ciudad = ciudad;
        this.temperatura = temperatura;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
