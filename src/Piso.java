import java.util.ArrayList;

public class Piso
{
    private int cantidadMaxAmbientesPiso;
    private int cantidadAmbientesPiso;
    private ArrayList<Ambiente> ambientes;

    public Piso(int cantidadAmbientesPiso)
    {
        this.cantidadAmbientesPiso = cantidadAmbientesPiso;
        this.cantidadMaxAmbientesPiso = 50;
        this.ambientes = new ArrayList<>();
    }

    public void setCantidadMaxAmbientesPiso(int cantidadMaxAmbientesPiso) {
        this.cantidadMaxAmbientesPiso = cantidadMaxAmbientesPiso;
    }

    public int getCantidadAmbientesPiso() {
        return cantidadAmbientesPiso;
    }

    public void setCantidadAmbientesPiso(int cantidadAmbientesPiso) {
        this.cantidadAmbientesPiso = cantidadAmbientesPiso;
    }

    public int getCantidadMaxAmbientesPiso() {
        return cantidadMaxAmbientesPiso;
    }

    public ArrayList<Ambiente> getAmbientes() {
        return ambientes;
    }

    public void setAmbientes(ArrayList<Ambiente> ambientes) {
        this.ambientes = ambientes;
    }

    @Override
    public String toString() {
        return "\nPiso{" +
                "Cantidad de ambientes por piso: " + cantidadAmbientesPiso +
                ", Ambientes: " + ambientes +
                "}\n";
    }
}
