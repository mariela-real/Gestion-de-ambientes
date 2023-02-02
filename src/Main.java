import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
    {
        ArrayList<Ambiente> listaambiente1 = new ArrayList<>();
        ArrayList<Ambiente> listaambiente2 = new ArrayList<>();
        ArrayList<Piso> listapisos = new ArrayList<>();
        ArrayList<Edificio> listaEdificios = new ArrayList<>();


        Ambiente ambiente1 = new Ambiente("Art-4b", 50);
        Ambiente ambiente2 = new Ambiente("500A", 150);
        Ambiente ambiente3 = new Ambiente("121B", 35);
        Ambiente ambiente4 = new Ambiente("50C", 200);
        Ambiente ambiente5 = new Ambiente("34A", 100);

        listaambiente1.add(ambiente1);
        listaambiente1.add(ambiente2);
        listaambiente2.add(ambiente3);
        listaambiente2.add(ambiente4);
        listaambiente2.add(ambiente5);


        Piso piso0 = new Piso(2);
        Piso piso1 = new Piso(3);

        piso0.setAmbientes(listaambiente1);
        piso1.setAmbientes(listaambiente2);

        listapisos.add(piso0);
        listapisos.add(piso1);

        Edificio antiguo = new Edificio("antiguo",2);
        antiguo.setPisos(listapisos);

        listaEdificios.add(antiguo);

        Facultad fcyt = new Facultad("Ciencias y tecnologia");
        fcyt.setListaEdificios(listaEdificios);
        fcyt.Iniciar();


    }
}