
package org.example.tareaalgoritmos;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;

public class HelloController {

    public VBox crearGraficas() {

        VBox panel = new VBox(10);

        XYChart.Series<Number, Number> iterativo =
                new XYChart.Series<>();
        iterativo.setName("Iterativo");

        XYChart.Series<Number, Number> gauss =
                new XYChart.Series<>();
        gauss.setName("Gauss");

        XYChart.Series<Number, Number> recursivo =
                new XYChart.Series<>();
        recursivo.setName("Recursivo");

        long[] valores = {
                100, 1000, 10000, 100000,
                1000000, 10000000, 100000000
        };

        for (long n : valores) {

            long inicio = System.nanoTime();
            Sumatoria.sumatoria0aN(n);
            long tiempo = System.nanoTime() - inicio;

            iterativo.getData().add(
                    new XYChart.Data<>(n, tiempo));

            inicio = System.nanoTime();
            Sumatoria.sumatoriaGauss(n);
            tiempo = System.nanoTime() - inicio;

            gauss.getData().add(
                    new XYChart.Data<>(n, tiempo));

            try {
                inicio = System.nanoTime();
                Sumatoria.sumatoriaRecursiva(n, 0);
                tiempo = System.nanoTime() - inicio;

                recursivo.getData().add(
                        new XYChart.Data<>(n, tiempo));

            } catch (StackOverflowError e) {
                System.out.println("Fallo recursivo: " + n);
            }
        }

        // Grafica iterativa
        NumberAxis x1 = new NumberAxis();
        x1.setLabel("Valor de n");

        NumberAxis y1 = new NumberAxis();
        y1.setLabel("Tiempo en nanosegundos");

        LineChart<Number, Number> grafica1 =
                new LineChart<>(x1, y1);

        grafica1.setTitle("Metodo Iterativo");
        grafica1.setAnimated(false);
        grafica1.setCreateSymbols(true);
        grafica1.setPrefHeight(250);
        grafica1.getData().add(iterativo);

        // Grafica de Gauss
        NumberAxis x2 = new NumberAxis();
        x2.setLabel("Valor de n");

        NumberAxis y2 = new NumberAxis();
        y2.setLabel("Tiempo en nanosegundos");

        LineChart<Number, Number> grafica2 =
                new LineChart<>(x2, y2);

        grafica2.setTitle("Metodo Gauss");
        grafica2.setAnimated(false);
        grafica2.setCreateSymbols(true);
        grafica2.setPrefHeight(250);
        grafica2.getData().add(gauss);

        // Grafica recursiva
        NumberAxis x3 = new NumberAxis();
        x3.setLabel("Valor de n");

        NumberAxis y3 = new NumberAxis();
        y3.setLabel("Tiempo en nanosegundos");

        LineChart<Number, Number> grafica3 =
                new LineChart<>(x3, y3);

        grafica3.setTitle("Metodo Recursivo");
        grafica3.setAnimated(false);
        grafica3.setCreateSymbols(true);
        grafica3.setPrefHeight(250);
        grafica3.getData().add(recursivo);

        panel.getChildren().addAll(
                grafica1, grafica2, grafica3);

        return panel;
    }
}
