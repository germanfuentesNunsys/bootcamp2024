package main.java.com.kreitek.pets;

public class Logger {
    private static Logger instancia;
    private int contador = 0;


    private Logger() {
    }


    public static Logger getInstancia() {
        if (instancia == null) {
            instancia = new Logger();
        }
        return instancia;
    }

    public void debug(String mensaje) {
        contador++;
        String formatoDebug = String.format("[debug][%d] - %s", contador, mensaje);
        System.out.println(formatoDebug);
    }
}
