public class Recursividad {

    // Metodo recursivo para calcular el factorial
    public static int factorial(int n) {

        // Caso base: cuando n es 0 o 1, se detiene la recursión
        if (n == 0 || n == 1) {
            return 1;
        }

        // Llamada recursiva: reduce el problema (n-1)
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("Factorial de 5 = " + factorial(5));
    }
}
