
package org.example.tareaalgoritmos;

public class Main {

    public static void main(String[] args) {

        long Max = 100000000;

        System.out.println("Prueba n, Gauss, recursivo");

        for (long i = 100; i <= Max; i *= 10) {

            long startTime = System.nanoTime();
            Sumatoria.sumatoria0aN(i);
            long endTime = System.nanoTime();
            long tiempon = endTime - startTime;

            startTime = System.nanoTime();
            Sumatoria.sumatoriaGauss(i);
            endTime = System.nanoTime();
            long tiempoGauss = endTime - startTime;

            long tiempoRecursivo = -1;

            try {
                startTime = System.nanoTime();
                Sumatoria.sumatoriaRecursiva(i, 0);
                endTime = System.nanoTime();
                tiempoRecursivo = endTime - startTime;

            } catch (StackOverflowError e) {
                System.out.println(
                        "La recursividad fallo para n = " + i
                );
            }

            System.out.println("n = " + i);
            System.out.println("Tiempo n: " + tiempon + " ns");
            System.out.println("Tiempo Gauss: " + tiempoGauss + " ns");

            if (tiempoRecursivo != -1) {
                System.out.println(
                        "Tiempo Recursivo: " + tiempoRecursivo + " ns"
                );
            } else {
                System.out.println("Tiempo Recursivo: No termino");
            }

            System.out.println("-------------------------");
        }
    }
}
