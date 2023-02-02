import java.util.ArrayList;

public class Edificio
{
    private String nombreEdificio;
    private int cantidadMaxPisos;
    private ArrayList<Piso> pisos;

    public Edificio(String nombreEdificio,int cantidadMaxPisos) {
        this.pisos = new ArrayList<>();
        this.nombreEdificio = nombreEdificio;
        this.cantidadMaxPisos = cantidadMaxPisos;

        for (int i = 0; i <= cantidadMaxPisos; i++) {
            pisos.add(i,null);
        }
    }

    public String getNombreEdificio() {
        return nombreEdificio;
    }

    public int getCantidadMaxPisos() {
        return cantidadMaxPisos;
    }

    public ArrayList<Piso> getPisos() {
        return pisos;
    }


    @Override
    public String toString() {
        return "\nEdificio\n" +
                "nombreEdificio: " + nombreEdificio + ", cantidadMaxPisos: " + cantidadMaxPisos +
                ", Pisos: " + pisos +
                '}';
    }

    public void setPisos(ArrayList<Piso> pisos) {
        this.pisos = pisos;
    }
}
