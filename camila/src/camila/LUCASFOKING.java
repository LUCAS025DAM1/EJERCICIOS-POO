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
