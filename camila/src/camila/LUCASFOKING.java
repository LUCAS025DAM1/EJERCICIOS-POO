//EJERCIO 1 BUTACAS DE CINE
package camila;

public class LUCASFOKING {
	private static final int FILAS = 5;
    private static final int COLUMNAS = 10;

    // Matriz para representar los asientos
    private static char[][] asientos = new char[FILAS][COLUMNAS];

    public static void main(String[] args) {
        inicializarAsientos();

        while (true) {
            mostrarSala();
            reservarAsiento();
        }
    }

    private static void inicializarAsientos() {
        // Inicializar todos los asientos como disponibles ('O' significa ocupado, 'L' significa libre)
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                asientos[i][j] = 'L';
            }
        }
    }

    private static void mostrarSala() {
        System.out.println("Estado actual de la sala:");
        System.out.print("  ");
        for (int i = 1; i <= COLUMNAS; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < FILAS; i++) {
            System.out.print((char) ('A' + i) + " ");
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(asientos[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void reservarAsiento() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la fila (A-E) y la columna (1-10) para reservar un asiento (por ejemplo, A3): ");
        String entrada = scanner.nextLine().toUpperCase();

        if (entrada.length() != 2 || entrada.charAt(0) < 'A' || entrada.charAt(0) >= 'A' + FILAS ||
            entrada.charAt(1) < '1' || entrada.charAt(1) > '0' + COLUMNAS) {
            System.out.println("Entrada inválida. Por favor, ingrese una fila válida (A-E) y una columna válida (1-10).");
            return;
        }

        int fila = entrada.charAt(0) - 'A';
        int columna = entrada.charAt(1) - '1';

        if (asientos[fila][columna] == 'L') {
            asientos[fila][columna] = 'O';
            System.out.println("¡Reserva exitosa! Asiento " + entrada + " reservado.");
        } else {
            System.out.println("Lo siento, el asiento " + entrada + " ya está ocupado. Por favor, elija otro asiento.");
        }
    }
}
}
//EJERCICIO 2 SIMULACIÓN DE CAJERO
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class CajeroAutomatico {
    private Map<String, Cuenta> cuentas;

    public CajeroAutomatico() {
        this.cuentas = new HashMap<>();
    }

    public void agregarCuenta(String id, String contrasena, double saldoInicial) {
        cuentas.put(id, new Cuenta(id, contrasena, saldoInicial));
    }

    public void iniciarSesion() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese ID de cuenta: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese contraseña: ");
        String contrasena = scanner.nextLine();

        if (cuentas.containsKey(id) && cuentas.get(id).autenticar(contrasena)) {
            menuOperaciones(id);
        } else {
            System.out.println("Autenticación fallida. Verifique ID y contraseña.");
        }
    }

    private void menuOperaciones(String id) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n1. Consultar Saldo");
            System.out.println("2. Retirar Dinero");
            System.out.println("3. Depositar Dinero");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Saldo actual: $" + cuentas.get(id).consultarSaldo());
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad a retirar: $");
                    double cantidadRetiro = scanner.nextDouble();
                    cuentas.get(id).retirarDinero(cantidadRetiro);
                    break;
                case 3:
                    System.out.print("Ingrese la cantidad a depositar: $");
                    double cantidadDeposito = scanner.nextDouble();
                    cuentas.get(id).depositarDinero(cantidadDeposito);
                    break;
                case 4:
                    System.out.println("Sesión cerrada. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);
    }

    public static void main(String[] args) {
        CajeroAutomatico cajero = new CajeroAutomatico();
        cajero.agregarCuenta("123", "password123", 1000.0);
        cajero.agregarCuenta("456", "pass456", 500.0);

        cajero.iniciarSesion();
    }
}

class Cuenta {
    private String id;
    private String contrasena;
    private double saldo;

    public Cuenta(String id, String contrasena, double saldoInicial) {
        this.id = id;
        this.contrasena = contrasena;
        this.saldo = saldoInicial;
    }

    public boolean autenticar(String contrasena) {
        return this.contrasena.equals(contrasena);
    }

    public double consultarSaldo() {
        return saldo;
    }

    public void retirarDinero(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            System.out.println("Retiro exitoso. Saldo restante: $" + saldo);
        } else {
            System.out.println("Error al retirar dinero. Verifique el monto y el saldo disponible.");
        }
    }

    public void depositarDinero(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Depósito exitoso. Saldo actual: $" + saldo);
        } else {
            System.out.println("Error al depositar dinero. Verifique el monto ingresado.");
        }
    }
}
