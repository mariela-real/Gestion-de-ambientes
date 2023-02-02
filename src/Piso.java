import java.util.ArrayList;

public class Piso
{
    private int cantidadMaxAmbientesPiso;
    private ArrayList<Ambiente> ambientes;

    public Piso(int cantidadMaxAmbientesPiso)
    {
        this.cantidadMaxAmbientesPiso = cantidadMaxAmbientesPiso;
        this.ambientes = new ArrayList<>();
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
                "Cantidad maxima de ambientes por piso: " + cantidadMaxAmbientesPiso +
                ", Ambientes: " + ambientes +
                "}\n";
    }
}
