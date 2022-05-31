package BBDD;

public class Principal {
    public static void main(String[] args) {
        Interfaz vent = new Interfaz();
        vent.run();
        Metodos.conectar();
    }
}
