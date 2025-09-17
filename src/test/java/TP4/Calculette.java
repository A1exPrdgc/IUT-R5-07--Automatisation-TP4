package TP4;

import java.util.Stack;

public class Calculette {
    private Stack<Double> pile;

    public Calculette() {
        pile = new Stack<>();
    }

    public void push(double valeur) {
        pile.push(valeur);
    }

    public void addition() {
        if (pile.size() < 2) throw new IllegalStateException("Pas assez d'opérandes");
        double b = pile.pop();
        double a = pile.pop();
        pile.push(a + b);
    }

    public void soustraction() {
        if (pile.size() < 2) throw new IllegalStateException("Pas assez d'opérandes");
        double b = pile.pop();
        double a = pile.pop();
        pile.push(a - b);
    }

    public void multiplication() {
        if (pile.size() < 2) throw new IllegalStateException("Pas assez d'opérandes");
        double b = pile.pop();
        double a = pile.pop();
        pile.push(a * b);
    }

    public void division() {
        if (pile.size() < 2) throw new IllegalStateException("Pas assez d'opérandes");
        double b = pile.pop();
        double a = pile.pop();
        if (b == 0) throw new ArithmeticException("Division par zéro");
        pile.push(a / b);
    }

    public double resultat() {
        if (pile.isEmpty()) throw new IllegalStateException("Pile vide");
        return pile.peek();
    }

    public void clear() {
        pile.clear();
    }

    public static double evaluerExpression(String expression) {
        Calculette calc = new Calculette();
        String[] tokens = expression.split("\\s+");
        for (String token : tokens) {
            switch (token) {
                case "+" -> calc.addition();
                case "-" -> calc.soustraction();
                case "*" -> calc.multiplication();
                case "/" -> calc.division();
                default -> {
                    try {
                        double val = Double.parseDouble(token);
                        calc.push(val);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Token invalide : " + token);
                    }
                }
            }
        }
        return calc.resultat();
    }

    public static void main(String[] args) {
        String expr = "1.0 3 + 2 3.2 / +"; // (1.0+3)+(2/3.2)
        try {
            double res = Calculette.evaluerExpression(expr);
            System.out.println("Résultat : " + res);
        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }
}

