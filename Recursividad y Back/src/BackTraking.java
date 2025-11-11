public class BackTraking {


    public static boolean resolverLaberinto(int[][] lab, int x, int y, int salidaX, int salidaY) {
        // 1 = camino libre
        // 0 = pared
        // 2 = visitado
        // Si llegamos a la salida → caso base
        if (x == salidaX && y == salidaY) {
            return true;
        }

        // Verificar si la posición es válida
        if (!esValido(lab, x, y)) {
            return false;
        }

        // Marcar como visitado
        lab[x][y] = 2;

        // Intentar moverse ↑
        if (resolverLaberinto(lab, x - 1, y, salidaX, salidaY)) return true;

        // Intentar moverse ↓
        if (resolverLaberinto(lab, x + 1, y, salidaX, salidaY)) return true;

        // Intentar moverse ←
        if (resolverLaberinto(lab, x, y - 1, salidaX, salidaY)) return true;

        // Intentar moverse →
        if (resolverLaberinto(lab, x, y + 1, salidaX, salidaY)) return true;

        // Si ninguna dirección funcionó → backtracking
        lab[x][y] = 1;

        return false;
    }

    // Validar si la celda es accesible
    private static boolean esValido(int[][] lab, int x, int y) {
        // Dentro de límites y sin ser pared o visitado
        return x >= 0 && x < lab.length &&
                y >= 0 && y < lab[0].length &&
                lab[x][y] == 1;
    }

    public static void main(String[] args) {

        int[][] laberinto = {
                {1, 0, 1, 1},
                {1, 1, 1, 0},
                {0, 1, 0, 1},
                {1, 1, 1, 1}
        };

        boolean camino = resolverLaberinto(laberinto, 0, 0, 3, 3);

        System.out.println("¿Se encontró camino? " + camino);
    }
}
