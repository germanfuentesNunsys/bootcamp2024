package main.java.com.kreitek.pets;

public class Logger {
    private static int contador = 0;

    public void debug(String mensaje) {
        contador++;
        String formatoDebug = String.format("[debug][%d] - %s", contador, mensaje);
        System.out.println(formatoDebug);
    }
}
