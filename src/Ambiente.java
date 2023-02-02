public class Ambiente
{
    private String nombreAmbiente;
    private int capacidadEstudiantes;

    public Ambiente(String nombreAmbiente, int capacidadEstudiantes)
    {
        this.nombreAmbiente = nombreAmbiente;
        this.capacidadEstudiantes = capacidadEstudiantes;
    }

    public int getCapacidadEstudiantes() {
        return capacidadEstudiantes;
    }


    @Override
    public String toString() {
        return "\nAmbiente{" +
                "Nombre del ambiente: '" + nombreAmbiente + '\'' +
                ", capacidad de estudiantes: " + capacidadEstudiantes +
                '}';
    }
}
