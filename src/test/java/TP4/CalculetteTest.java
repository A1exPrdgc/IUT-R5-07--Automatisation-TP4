package TP4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculetteTest {

    @Test
    public void testAddition() {
        Calculette calc = new Calculette();
        calc.push(1.5);
        calc.push(2.5);
        calc.addition();
        assertEquals(4.0, calc.resultat());
    }

    @Test
    public void testSoustraction() {
        Calculette calc = new Calculette();
        calc.push(5.0);
        calc.push(2.0);
        calc.soustraction();
        assertEquals(3.0, calc.resultat());
    }

    @Test
    public void testMultiplication() {
        Calculette calc = new Calculette();
        calc.push(2.0);
        calc.push(3.0);
        calc.multiplication();
        assertEquals(6.0, calc.resultat());
    }

    @Test
    public void testDivision() {
        Calculette calc = new Calculette();
        calc.push(6.0);
        calc.push(3.0);
        calc.division();
        assertEquals(2.0, calc.resultat());
    }

    @Test
    public void testExpressionRPN() {
        String expr = "1.0 3 + 2 3.2 / +";
        double res = Calculette.evaluerExpression(expr);
        assertEquals(4 + (2/3.2), res, 1e-9);
    }
}
