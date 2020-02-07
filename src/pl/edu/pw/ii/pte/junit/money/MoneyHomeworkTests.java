package pl.edu.pw.ii.pte.junit.money;


import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class MoneyHomeworkTests {

    private Money m10PLN;
    private Money m3PLN;
    private Money m0PLN;
    private Money m0EUR;
    private Money m5EUR;
    private Money m7DDK;

    @Before
    public void setUp() throws Exception {
        m10PLN = new Money(10, "PLN");
        m3PLN = new Money(3, "PLN");
        m0PLN = new Money(0, "PLN");
        m0EUR = new Money(0, "EUR");
        m5EUR = new Money(5, "DKK");
        m7DDK = new Money(7, "DKK");
    }

    @Test
    public void testSimpleAdd() {
        Money m12CHF = new Money(12, "CHF"); //
        Money m14CHF = new Money(14, "CHF");
        Money expected = new Money(26, "CHF");
        Money result = m12CHF.add(m14CHF); //
        assertTrue(expected.equals(result)); //
    }



}