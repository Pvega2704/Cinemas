package Modelo;

public class ticket {

    private int NumeroTicket;
    private int Cedula;
    private String Nombre;
    private String Correo;
    private int Precio;
    private Double IVA;
    private int PrecioTotal;
    private int CantidadEntradas;

    private String Pelicula;

    public ticket() {
    }

    public ticket(int NumeroTicket, int Cedula, String Nombre, String Correo, int Precio, Double IVA, int PrecioTotal, int CantidadEntradas, String Pelicula) {
        this.NumeroTicket = NumeroTicket;
        this.Cedula = Cedula;
        this.Nombre = Nombre;
        this.Correo = Correo;
        this.Precio = Precio;
        this.IVA = IVA;
        this.PrecioTotal = PrecioTotal;
        this.CantidadEntradas = CantidadEntradas;
        this.Pelicula = Pelicula;
    }

    public int getNumeroTicket() {
        return NumeroTicket;
    }

    public void setNumeroTicket(int NumeroTicket) {
        this.NumeroTicket = NumeroTicket;
    }

    public int getCedula() {
        return Cedula;
    }

    public void setCedula(int Cedula) {
        this.Cedula = Cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    public Double getIVA() {
        return IVA;
    }

    public void setIVA(Double IVA) {
        this.IVA = IVA;
    }

    public int getPrecioTotal() {
        return PrecioTotal;
    }

    public void setPrecioTotal(int PrecioTotal) {
        this.PrecioTotal = PrecioTotal;
    }

    public int getCantidadEntradas() {
        return CantidadEntradas;
    }

    public void setCantidadEntradas(int CantidadEntradas) {
        this.CantidadEntradas = CantidadEntradas;
    }

    public String getPelicula() {
        return Pelicula;
    }

    public void setPelicula(String Pelicula) {
        this.Pelicula = Pelicula;
    }


 
   

}
