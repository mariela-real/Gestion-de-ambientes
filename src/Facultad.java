import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Facultad
{
    private String nombre;
    private ArrayList<Edificio> listaEdificios;
    private Scanner lector;

    public Facultad(String nombre) {
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
        System.out.println("[7] Reporte de los primeros N ambientes con capacidad minima X");
        System.out.println("[8] Reporte del total de capacidades por ubicacion");

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
                case 4 -> mostrarCantidadAmbientesCapacidadMaximaPorUbicacion();
                case 5 -> totalAmbientesEdificio();
                case 6 -> MostrarDatos();
                case 7 -> mostrarAmbientesCapacidadMinima();
                case 8 -> mostrartotalCapacidadesUbicacion();

                case 0 -> System.out.println("El sistema se esta cerrando");
                default -> {
                }
            }
        } while(opcion!=0);

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
        listaEdificios.get(posicionEdificio).getPisos().get(nroPiso).getCantidadMaxAmbientesPiso() )
        {
            listaEdificios.get(posicionEdificio).getPisos().get(nroPiso).getAmbientes().add(new Ambiente(nombreAmbiente,capacidad ));
        }
        else
        {
            System.out.println("No se puedo agregar el ambiente");
        }

    }
    private void MostrarDatos()
    {
        System.out.println("----ListaEdificios----");
        for (int i = 0; i < listaEdificios.size(); i++) {
            System.out.println(listaEdificios.get(i));
        }
        System.out.println();
    }
    private void crearPiso()
    {
        String  nombreEdificio;
        int numeroPiso, capacidadMaximaAbientes, posicionEdificio;


        System.out.print("Ingrese el nombre del edificio: ");
        nombreEdificio = lector.next();
        System.out.print("Ingrese el numero piso: ");
        numeroPiso = lector.nextInt();
        System.out.print("Ingrese la capacidad maxima de ambientes: ");
        capacidadMaximaAbientes = lector.nextInt();

        posicionEdificio = validarEdificio(nombreEdificio);

        if (posicionEdificio != -1 && numeroPiso < listaEdificios.get(posicionEdificio).getCantidadMaxPisos())
        {
            Piso piso = new Piso(capacidadMaximaAbientes);
            listaEdificios.get(posicionEdificio).getPisos().set(numeroPiso, piso);
        }
    }
    private void crearEstructuraEdificio()
    {
        String nombreEdificio;
        int cantidadMaxPisos;

        System.out.print("Ingrese el nombre del edificio: ");
        nombreEdificio = lector.next();
        System.out.print("Ingrese la cantidad maxima de pisos: ");
        cantidadMaxPisos = lector.nextInt();
        Edificio edificio = new Edificio(nombreEdificio,cantidadMaxPisos);
        listaEdificios.add(edificio);
    }


    private boolean validarPiso(int nroPiso, int posicionEdificio)
    {
        if (nroPiso <= listaEdificios.get(posicionEdificio).getCantidadMaxPisos()
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


        System.out.print("Ingrese la ubicacion(nombre del edificio): ");
        nombreEdificio = lector.next();
        posicionEdificio = validarEdificio(nombreEdificio);
        nombreEdificio =listaEdificios.get(posicionEdificio).getNombreEdificio();

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

    private void  mostrarCantidadAmbientesCapacidadMaximaPorUbicacion()
    {
        String nombreEdificio;
        int posicionEdificio;

        int valorCapacidadMaxima, cantidadAmbientes = 0;
        System.out.print("Indique la ubicacion (nombre del edificio): ");
        nombreEdificio = lector.next();
        System.out.print("Indique una capacidad de ambiente: ");
        valorCapacidadMaxima = lector.nextInt();

        posicionEdificio = validarEdificio(nombreEdificio);


        if(buscarEdificio(nombreEdificio) && posicionEdificio != -1)
        {
            for (int j = 0; j < listaEdificios.get(posicionEdificio).getPisos().size(); j++)
            {
                if (listaEdificios.get(posicionEdificio).getPisos().get(j).getAmbientes() !=null)
                {
                    for (int k = 0; k < listaEdificios.get(posicionEdificio).getPisos().get(j).getAmbientes().size(); k++)
                    {
                        if(listaEdificios.get(posicionEdificio).getPisos().get(j) != null
                                && listaEdificios.get(posicionEdificio).getPisos().get(j).getAmbientes().get(k).getCapacidadEstudiantes() > valorCapacidadMaxima)
                        {
                            cantidadAmbientes++;
                        }
                    }
                }
            }
        }
        System.out.println("La cantidad de ambientes mayores a " + valorCapacidadMaxima + " en el edificio "
                + nombreEdificio + " es de: " + cantidadAmbientes) ;
    }

    private void  mostrarAmbientesCapacidadMinima()
    {
        int nPrimeros;

        int valorCapacidadMaximaEstudiantes, cantidadAmbientes = 0;
        System.out.print("Indique el numero de ambientes: ");
        nPrimeros = lector.nextInt();
        System.out.print("Indique la capacidad minima de estudiantes a buscar: ");
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
    private boolean buscarEdificio(String nombre)
    {
        for (int i = 0; i < listaEdificios.size(); i++)
        {
            if(listaEdificios.get(i).getNombreEdificio().equals(nombre))
            {
                return true;
            }
        }
        return false;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setListaEdificios(ArrayList<Edificio> listaEdificios) {
        this.listaEdificios = listaEdificios;
    }
}
