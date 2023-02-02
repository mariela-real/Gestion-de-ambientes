import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Facultad
{
    private String nombre;
    private ArrayList<Edificio> listaEdificios;
    private ArrayList<Docente> listaDocentes;
    private Scanner lector;

    public Facultad(String nombre)
    {
        listaDocentes = new ArrayList<>();
        listaEdificios = new ArrayList<>();
        this.nombre = nombre;
        lector = new Scanner(System.in);
    }

    private void menuPrincial()
    {
        System.out.println("----Bienvenidos a la facultad de "+ nombre + "----");
        System.out.println("[1] Crear la estructura del edificio");
        System.out.println("[2] Crear la estructura del piso");
        System.out.println("[3] Crear nuevo ambiente");
        System.out.println("[4] Cantidad de ambientes mayores a un valor y que pertenecen a un edificio");
        System.out.println("[5] Cantidad total de ambientes en una ubicacion");
        System.out.println("[6] Reporte de todos los ambientes de la facultad ");
        System.out.println("[7] Reporte de los primeros N ambientes con capacidad minima a X");
        System.out.println("[8] Reporte del total de capacidades por ubicacion");
        System.out.println("[9] Registrar Docente");
        System.out.println("[10] Asignar Ambiente a un docente ");
        System.out.println("[11] Mostrar docentes");

        System.out.println("[0] Salir");
    }
    public void Iniciar()
    {
        int opcion;

        do{
            menuPrincial();

            opcion=lector.nextInt();

            switch (opcion)
            {
                case 1 -> crearEstructuraEdificio();
                case 2 -> crearPiso();
                case 3 -> resgistrarAmbiente();
                case 4 -> mostrarCantidadAmbientesMayoresPorUbicacion();
                case 5 -> totalAmbientesEdificio();
                case 6 -> mostrarDatos();
                case 7 -> mostrarPrimerosAmbientesCapacidadMinima();
                case 8 -> mostrartotalCapacidadesUbicacion();
                case 9 -> registrarDocente();
                case 10 -> asignarClase();
                case 11 -> mostrarDocentes();

                case 0 -> System.out.println("El sistema se esta cerrando");
                default -> {
                }
            }
        } while(opcion!=0);

    }
    private void asignarClase()
    {
        String codDocente, nombreAmbiente;
        int posiciondocente;
        Ambiente ambiente;
        System.out.println("Ingrese el codigo de docente");
        codDocente = lector.next();
        System.out.println("Ingrese el nombre del ambiente(Aula)");
        nombreAmbiente = lector.next();
        posiciondocente = validadDocente(codDocente);
        ambiente = validadAmbiente(nombreAmbiente);
        if(ambiente!=null && posiciondocente !=-1)
        {
            listaDocentes.get(posiciondocente).getAmbientes().add(ambiente);
            System.out.println("Ambiente asignado exitosamente !!");
        }



    }
    private void mostrarDocentes()
    {
        for (int i = 0; i < listaDocentes.size(); i++)
        {
            System.out.println(listaDocentes.get(i));
        }

}
    private void registrarDocente()
    {
        String nombre, codDocente, asignatura;
        System.out.print("Ingrese el nombre del docente: ");
        nombre = lector.next();
        System.out.print("Ingrese el codigo de docente");
        codDocente = lector.next();
        Docente docente = new Docente(nombre, codDocente);
        listaDocentes.add(docente);
    }

    private int validadDocente(String codDocente)
    {
        int posicion = -1;
        for (int i = 0; i < listaDocentes.size(); i++)
        {
            if(listaDocentes.get(i).getCodDocente().equals(codDocente))
            {
                return i;
            }

        }
        return posicion;
    }
    private Ambiente validadAmbiente(String nombreAmbiente)
    {
        int posicion = -1;
        for (int i = 0; i < listaEdificios.size(); i++)
        {
            for (int j = 0; j < listaEdificios.get(i).getPisos().size(); j++)
            {
                for (int k = 0; k < listaEdificios.get(i).getPisos().get(j).getAmbientes().size(); k++)
                {
                    if(listaEdificios.get(i).getPisos().get(j).getAmbientes().get(k).getNombreAmbiente().equals(nombreAmbiente))
                    {
                        return  listaEdificios.get(i).getPisos().get(j).getAmbientes().get(k);
                    }

                }
            }
        }
        return null;
    }
    private void crearEstructuraEdificio()
    {
        String nombreEdificio;
        int cantidadPisos;

        System.out.print("Ingrese el nombre del edificio: ");
        nombreEdificio = lector.next();
        System.out.print("Ingrese la cantidad de pisos: ");
        cantidadPisos = lector.nextInt();

         Edificio edificio = new Edificio(nombreEdificio,cantidadPisos);
         listaEdificios.add(edificio);

    }
    private void crearPiso()
    {
        String  nombreEdificio;
        int numeroPiso, posicionEdificio, cantidadAmbientes;

        System.out.print("Ingrese el nombre del edificio: ");
        nombreEdificio = lector.next();
        System.out.print("Ingrese el numero de pisos: ");
        numeroPiso = lector.nextInt();
        System.out.print("Ingrese la cantidad de ambientes por piso: ");
        cantidadAmbientes = lector.nextInt();

        posicionEdificio = validarEdificio(nombreEdificio);

        if (posicionEdificio != -1 && numeroPiso <= listaEdificios.get(posicionEdificio).getCantidadPisos())
        {
            Piso piso = new Piso(cantidadAmbientes);
            listaEdificios.get(posicionEdificio).getPisos().set(numeroPiso, piso);
        }


    }

    private void resgistrarAmbiente()
    {
        String nombreAmbiente, nombreEdificio;
        int capacidad, nroPiso, posicionEdificio;

        System.out.print("Ingrese el nombre del edificio: ");
        nombreEdificio = lector.next();
        System.out.print("Ingrese el numero de piso: ");
        nroPiso = lector.nextInt();
        System.out.print("Ingrese el nombre del ambiente: ");
        nombreAmbiente = lector.next();
        System.out.print("Ingrese la capacidad de estudiantes: ");
        capacidad = lector.nextInt();

        posicionEdificio = validarEdificio(nombreEdificio);

        if (posicionEdificio != -1 && validarPiso(nroPiso, posicionEdificio ) &&
        listaEdificios.get(posicionEdificio).getPisos().get(nroPiso).getAmbientes().size() <=
        listaEdificios.get(posicionEdificio).getPisos().get(nroPiso).getCantidadAmbientesPiso())
        {
            listaEdificios.get(posicionEdificio).getPisos().get(nroPiso).getAmbientes().add(new Ambiente(nombreAmbiente,capacidad));
        }
        else
        {
            System.out.println("No se puedo agregar el ambiente");
        }

    }
    private void mostrarDatos()
    {
        System.out.println("----ListaEdificios----");
        for (int i = 0; i < listaEdificios.size(); i++) {
            System.out.println(listaEdificios.get(i));
        }
        System.out.println();
    }



    private boolean validarPiso(int nroPiso, int posicionEdificio)
    {
        if (nroPiso <= listaEdificios.get(posicionEdificio).getCantidadPisos()
        && listaEdificios.get(posicionEdificio).getPisos().get(nroPiso) != null)
        {
           return true;
        }

        return false;
    }

    private int validarEdificio(String nombreEdificio)
    {
        int response = -1;

        for (int i = 0; i < listaEdificios.size() ; i++)
        {
            if (Objects.equals(listaEdificios.get(i).getNombreEdificio(), nombreEdificio))
            {
               return i;
            }
        }

        return response;
    }

    private void totalAmbientesEdificio()
    {
        String nombreEdificio;
        int posicionEdificio, totalAmbientes = 0;


        System.out.print("Ingrese la ubicacion (nombre del edificio): ");
        nombreEdificio = lector.next();
        posicionEdificio = validarEdificio(nombreEdificio);
        nombreEdificio = listaEdificios.get(posicionEdificio).getNombreEdificio();

        if(posicionEdificio != -1)
        {
            for (int i = 0; i < listaEdificios.get(posicionEdificio).getPisos().size(); i++)
            {
                if (listaEdificios.get(posicionEdificio).getPisos().get(i) !=null)
                {
                    totalAmbientes = totalAmbientes +  listaEdificios.get(posicionEdificio).getPisos().get(i).getAmbientes().size();
                }
            }
        }

        System.out.println("El total de ambientes en el edificio " + nombreEdificio + " es igual a: " + totalAmbientes);
    }

    private void mostrartotalCapacidadesUbicacion()
    {
        String nombreEdificio;
        int posicionEdificio, totalCapcidades = 0;


        System.out.print("Ingrese la ubicacion(nombre del edificio): ");
        nombreEdificio = lector.next();

        posicionEdificio = validarEdificio(nombreEdificio);
        nombreEdificio =listaEdificios.get(posicionEdificio).getNombreEdificio();

        if(posicionEdificio != -1)
        {
            for (int i = 0; i < listaEdificios.get(posicionEdificio).getPisos().size(); i++)
            {
                for (int j = 0; j < listaEdificios.get(posicionEdificio).getPisos().get(i).getAmbientes().size(); j++)
                {
                    totalCapcidades = totalCapcidades + listaEdificios.get(posicionEdificio).getPisos().get(i).getAmbientes().get(j).getCapacidadEstudiantes();
                }
            }
        }
        System.out.println("El total de la capacidad de ambientes del edificio " + nombreEdificio + " es de: "+ totalCapcidades);
    }

    private void  mostrarCantidadAmbientesMayoresPorUbicacion()
    {
        String nombreEdificio;
        int posicionEdificio;

        int valorCapacidad, cantidadAmbientes = 0;
        System.out.print("Indique la ubicacion (nombre del edificio): ");
        nombreEdificio = lector.next();
        System.out.print("Indique una capacidad de ambiente: ");
        valorCapacidad = lector.nextInt();

        posicionEdificio = validarEdificio(nombreEdificio);

        if(posicionEdificio != -1)
        {
            for (int j = 0; j < listaEdificios.get(posicionEdificio).getPisos().size(); j++)
            {
                if (listaEdificios.get(posicionEdificio).getPisos().get(j) != null
                        && listaEdificios.get(posicionEdificio).getPisos().get(j).getAmbientes() != null)
                {
                    for (int k = 0; k < listaEdificios.get(posicionEdificio).getPisos().get(j).getAmbientes().size(); k++)
                    {
                        if( listaEdificios.get(posicionEdificio).getPisos().get(j).getAmbientes().get(k).getCapacidadEstudiantes() > valorCapacidad)
                        {
                            cantidadAmbientes++;
                        }
                    }
                }
            }
        }
        System.out.println("La cantidad de ambientes mayores a " + valorCapacidad + " en el edificio "
                + nombreEdificio + " es de: " + cantidadAmbientes) ;
    }

    private void  mostrarPrimerosAmbientesCapacidadMinima()
    {
        int nPrimeros;

        int valorCapacidadMaximaEstudiantes, cantidadAmbientes = 0;
        System.out.print("Indique el numero de ambientes: ");
        nPrimeros = lector.nextInt();
        System.out.print("Indique la capacidad minima de estudiantes: ");
        valorCapacidadMaximaEstudiantes = lector.nextInt();

        for (int i = 0; i < listaEdificios.size(); i++)
        {
            for (int j = 0; j < listaEdificios.get(i).getPisos().size(); j++)
            {
                for (int k = 0; k < listaEdificios.get(i).getPisos().get(j).getAmbientes().size(); k++)
                {
                    if(listaEdificios.get(i).getPisos().get(j).getAmbientes().get(k).getCapacidadEstudiantes() >= valorCapacidadMaximaEstudiantes)
                    {
                        cantidadAmbientes++;

                        if(cantidadAmbientes <= nPrimeros)
                        {
                            System.out.println(listaEdificios.get(i).getPisos().get(j).getAmbientes().get(k));
                        }
                    }
                }
            }
        }
    }

    public void setListaEdificios(ArrayList<Edificio> listaEdificios) {
        this.listaEdificios = listaEdificios;
    }
}
