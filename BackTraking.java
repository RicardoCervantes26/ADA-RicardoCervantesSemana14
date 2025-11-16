public class BackTraking {

    public static boolean resolverLaberinto(int[][] lab, int x, int y, int salidaX, int salidaY) {
        // 1 = camino libre
        // 0 = pared
        // 2 = visitado
        // 3 = camino solución
        // Si se  llega a la salida →se llega al caso base
        if (x == salidaX && y == salidaY) {
            lab[x][y] = 3; // Marcamos la salida como parte del camino solución
            return true;
        }

        // Verificar si la posición es válida
        if (!esValido(lab, x, y)) {
            return false;
        }

        // Marcar como visitado
        lab[x][y] = 2;

        // Intentar moverse ↑
        if (resolverLaberinto(lab, x - 1, y, salidaX, salidaY)) {
            lab[x][y] = 3; // Marcar como parte del camino solución
            return true;
        }

        // Intentar moverse ↓
        if (resolverLaberinto(lab, x + 1, y, salidaX, salidaY)) {
            lab[x][y] = 3; // Marcar como parte del camino solución
            return true;
        }

        // Intentar moverse ←
        if (resolverLaberinto(lab, x, y - 1, salidaX, salidaY)) {
            lab[x][y] = 3; // Marcar como parte del camino solución
            return true;
        }

        // Intentar moverse →
        if (resolverLaberinto(lab, x, y + 1, salidaX, salidaY)) {
            lab[x][y] = 3; // Marcar como parte del camino solución
            return true;
        }

        // Si ninguna dirección funcionó → backtracking
        lab[x][y] = 1; // Desmarcar (vuelve a ser camino libre)

        return false;
    }

    // Validar si la celda es accesible
    private static boolean esValido(int[][] lab, int x, int y) {
        // Dentro de límites y sin ser pared o visitado
        return x >= 0 && x < lab.length &&
                y >= 0 && y < lab[0].length &&
                lab[x][y] == 1;
    }

    // Metodo para imprimir el laberinto de forma visual
    public static void imprimirLaberinto(int[][] lab) {
        System.out.println("\n=== LABERINTO ===");
        for (int i = 0; i < lab.length; i++) {
            for (int j = 0; j < lab[i].length; j++) {
                switch (lab[i][j]) {
                    case 0: System.out.print("▓ "); break; // Pared
                    case 1: System.out.print("  "); break; // Camino libre
                    case 2: System.out.print(". "); break; // Visitado
                    case 3: System.out.print("◉ "); break; // Camino solución
                    default: System.out.print("? "); break;
                }
            }
            System.out.println();
        }
        System.out.println("================\n");
    }

    // Metodo para pausar la ejecución y ver el proceso
    public static void esperar(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Contar los pasos de la solución
    public static int contarPasosSolucion(int[][] lab) {
        int count = 0;
        for (int i = 0; i < lab.length; i++) {
            for (int j = 0; j < lab[i].length; j++) {
                if (lab[i][j] == 3) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] laberinto = {
                {1, 0, 1, 1},
                {1, 1, 1, 0},
                {0, 1, 0, 1},
                {1, 1, 1, 1}
        };

        System.out.println("INICIANDO RESOLUCIÓN DEL LABERINTO");
        System.out.println("Leyenda:");
        System.out.println("▓ = Pared");
        System.out.println("  = Camino libre");
        System.out.println(". = Visitado");
        System.out.println("◉ = Camino solución");

        imprimirLaberinto(laberinto);

        boolean caminoEncontrado = resolverLaberinto(laberinto, 0, 0, 3, 3);

        System.out.println("¿Se encontró camino? " + (caminoEncontrado ? "SÍ" : "NO"));

        if (caminoEncontrado) {
            int pasos = contarPasosSolucion(laberinto);
            System.out.println("Pasos en la solución: " + pasos);
            System.out.println("Camino solución marcado con ◉");
        }

        imprimirLaberinto(laberinto);
    }

}
