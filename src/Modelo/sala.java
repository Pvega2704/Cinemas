
package Modelo;


public class sala {
    private int NumeroSala;
    private int EspaciosDisponibles;
    private int EspaciosOcupados;
    private String Pelicula;

    public int getNumeroSala() {
        return NumeroSala;
    }

    public void setNumeroSala(int NumeroSala) {
        this.NumeroSala = NumeroSala;
    }

    public int getEspaciosDisponibles() {
        return EspaciosDisponibles;
    }

    public void setEspaciosDisponibles(int EspaciosDisponibles) {
        this.EspaciosDisponibles = EspaciosDisponibles;
    }

    public int getEspaciosOcupados() {
        return EspaciosOcupados;
    }

    public void setEspaciosOcupados(int EspaciosOcupados) {
        this.EspaciosOcupados = EspaciosOcupados;
    }

    public String getPelicula() {
        return Pelicula;
    }

    public void setPelicula(String Pelicula) {
        this.Pelicula = Pelicula;
    }

    public sala(int NumeroSala, int EspaciosDisponibles, int EspaciosOcupados, String Pelicula) {
        this.NumeroSala = NumeroSala;
        this.EspaciosDisponibles = EspaciosDisponibles;
        this.EspaciosOcupados = EspaciosOcupados;
        this.Pelicula = Pelicula;
    }
    
    
}
