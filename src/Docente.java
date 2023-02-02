import java.util.ArrayList;

public class Docente
{
    private String nombre;
    private String codDocente;
    private ArrayList<Ambiente> ambientes;

    public Docente(String nombre, String codDocente) {
        this.nombre = nombre;
        this.codDocente = codDocente;
        this.ambientes = new ArrayList<>();
    }

    public String getCodDocente() {
        return codDocente;
    }

    public ArrayList<Ambiente> getAmbientes() {
        return ambientes;
    }

    public void setAmbientes(ArrayList<Ambiente> ambientes) {
        this.ambientes = ambientes;
    }

    @Override
    public String toString() {
        return "Docente{" +
                "nombre='" + nombre + '\'' +
                ", codDocente='" + codDocente + '\'' +
                ", ambientes=" + ambientes +
                '}';
    }
}
