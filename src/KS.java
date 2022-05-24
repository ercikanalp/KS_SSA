import java.lang.reflect.Array;
import java.util.ArrayList;

public class KS {
    public static double kolmogorovSmirnov(ArrayList<Double> values) {
        double dPlus = 0;
        double dMinus = 0;
        ArrayList<Double> plus = new ArrayList<>();
        ArrayList<Double> minus = new ArrayList<>();
        for (int i = 0; i < values.size(); i++) {
            dPlus = plusFormula(values.size(), i, values.get(i));
            plus.add(dPlus);
            dMinus = minusFormula(values.size(), i, values.get(i));
            minus.add(dMinus);
        }
        for (int i = 0; i < values.size(); i++) {
            if (plus.get(i) > dPlus) {
                dPlus = plus.get(i);
            }
            if (minus.get(i) > dMinus) {
                dMinus = minus.get(i);
            }
        }

        return Math.max(dMinus, dPlus);
    }

    private static double plusFormula(double n, double i, double value) {
        if (value < 0) {
            value = 0;
        } else if (value >= 1) {
            value = 1;
        }
        double div = i/n;
        System.out.println("Minus value: " + (div - value));
        return div - value;
    }

    private static double minusFormula(double n, double i, double value) {
        if (value < 0) {
            value = 0;
        } else if (value >= 1) {
            value = 1;
        }
        double div = (i-1.0)/n;
        System.out.println("Minus value: " + (value - div ));
        return value - div;
    }

    public static void main(String[] args) {
        ArrayList<Double> values = new ArrayList<>();
        values.add(-0.8049);
        values.add(-0.7460);
        values.add(-0.4430);
        values.add(0.0938);
        values.add(0.2647);
        values.add(0.6294);
        values.add(0.8116);
        values.add(0.8268);
        values.add(0.9150);
        values.add(0.9298);
        double outcome = kolmogorovSmirnov(values);
        System.out.println("Outcome is: " + outcome);
    }
}
