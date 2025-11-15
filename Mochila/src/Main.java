public class Main {

    public static int mochila(int i, int pesoRestante) {
        // Definimos los pesos y valores de los objetos como arrays
        int[] pesos = {2, 3, 4, 5};
        int[] valores = {3, 4, 5, 6};

        // CASO BASE: Si ya procesamos todos los objetos o no queda espacio
        if (i == pesos.length || pesoRestante == 0) {
            return 0;
        }

        // Si el objeto actual es demasiado pesado, lo saltamos
        if (pesos[i] > pesoRestante) {
            return mochila(i + 1, pesoRestante);
        }

        // OPCIÓN 1: INCLUIR el objeto actual
        // Tomamos su valor y reducimos el peso disponible
        int incluir = valores[i] + mochila(i + 1, pesoRestante - pesos[i]);

        // OPCIÓN 2: EXCLUIR el objeto actual
        // No lo tomamos y pasamos al siguiente objeto
        int excluir = mochila(i + 1, pesoRestante);

        // RETROCEDEMOS (BACKTRACK) y elegimos la opción más valiosa
        if (incluir > excluir) {
            return incluir;
        } else {
            return excluir;
        }
    }

    public static void main(String[] args) {
        int capacidad = 8; // Capacidad máxima de la mochila

        // Empezamos con el primer objeto y la capacidad completa
        int valorMaximo = mochila(0, capacidad);

        System.out.println("Valor máximo en la mochila: " + valorMaximo);
    }
}