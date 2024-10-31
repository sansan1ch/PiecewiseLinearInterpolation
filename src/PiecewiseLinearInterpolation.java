import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PiecewiseLinearInterpolation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> xValues = new ArrayList<>();
        List<Double> yValues = new ArrayList<>();
        xValues.add(1.0);
        xValues.add(2.0);
        xValues.add(3.0);
        xValues.add(4.0);
        yValues.add(2.0);
        yValues.add(4.0);
        yValues.add(5.0);
        yValues.add(7.0);


        double x = scanner.nextDouble();

        double interpolatedValue = piecewiseLinearInterpolation(xValues, yValues, x);

        System.out.println("Интерполированное значение для x = " + x + ": " + interpolatedValue);
    }

    public static double piecewiseLinearInterpolation(List<Double> xValues, List<Double> yValues, double x) {
        // Проверка на валидность входных данных
        if (xValues.size() != yValues.size() || xValues.size() < 2) {
            throw new IllegalArgumentException("Некорректные входные данные.");
        }


        int i = 0;
        while (i < xValues.size() - 1 && xValues.get(i) < x) {
            i++;
        }


        double y1 = yValues.get(i - 1);
        double y2 = yValues.get(i);
        double x1 = xValues.get(i - 1);
        double x2 = xValues.get(i);
        double interpolatedValue = y1 + ((y2 - y1) / (x2 - x1)) * (x - x1);

        return interpolatedValue;
    }
}