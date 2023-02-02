import java.util.ArrayList;

public class Edificio
{
    private String nombreEdificio;
    private int cantidadMaxPisos;
    private int cantidadPisos;
    private ArrayList<Piso> pisos;

    public Edificio(String nombreEdificio, int cantidadPisos) {
        this.pisos = new ArrayList<>();
        this.nombreEdificio = nombreEdificio;
        this.cantidadPisos = cantidadPisos;
        this.cantidadMaxPisos = 10;

        for (int i = 0; i <= cantidadPisos; i++) {
            pisos.add(i,null);
        }
    }

    public String getNombreEdificio() {
        return nombreEdificio;
    }

    public int getCantidadMaxPisos() {
        return cantidadMaxPisos;
    }

    public int getCantidadPisos() {
        return cantidadPisos;
    }

    public void setCantidadPisos(int cantidadPisos) {
        this.cantidadPisos = cantidadPisos;
    }

    public ArrayList<Piso> getPisos() {
        return pisos;
    }


    @Override
    public String toString() {
        return "\nEdificio\n" +
                "Nombre del dificio: " + nombreEdificio +
                ", cantidad de pisos: " + cantidadPisos +
                ", Pisos: " + pisos +
                '}';
    }

    public void setPisos(ArrayList<Piso> pisos) {
        this.pisos = pisos;
    }
}
