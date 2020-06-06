package pl.edu.pw.ii.pte.junit.money;


import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoneyHomeworkTests {

    private Money m10PLN;
    private Money m3PLN;
    private Money m0PLN;
    private Money m0EUR;
    private Money m5EUR;
    private Money m10EUR;
    private Money m5DDK;
    private Money m7DDK;
    private Money m10DDK;

    @Before
    public void setUp() throws Exception {
        m10PLN = new Money(10, "PLN");
        m3PLN = new Money(3, "PLN");
        m0PLN = new Money(0, "PLN");
        m0EUR = new Money(0, "EUR");
        m5EUR = new Money(5, "EUR");
        m10EUR = new Money(9, "EUR");
        m7DDK = new Money(7, "DKK");
        m10DDK = new Money(10, "DKK");
        m5DDK = new Money(5, "DKK");
    }

    @Test
    public void testSimpleAdd() {
        Money m12CHF = new Money(12, "CHF"); //
        Money m14CHF = new Money(14, "CHF");
        Money expected = new Money(26, "CHF");
        Money result = m12CHF.add(m14CHF); //
        assertTrue(expected.equals(result)); //
    }



    @Test
    public void checkAmount() {
        assertTrue(10 == m10PLN.getAmount());
    }
    @Test
    public void checkCurrency() {
        assertEquals("PLN", m10PLN.getCurrency());
    }

    @Test
    public void multiplyingMoneyByPositiveInteger() {
        Money expected = new Money(50, "PLN");
        Money result = m10PLN.multiply(5);
        assertTrue(expected.equals(result));
    }

    @Test
    public void multiplyMoneyByZero() {
        Money expected = new Money(0, "PLN");
        Money result = m10PLN.multiply(0);
        assertTrue(expected.equals(result));
    }

    @Test
    public void addPLNMoneyToItself() {
        Money expected = new Money(20, "PLN");
        Money result = m10PLN.add(m10PLN);
        assertTrue(expected.equals(result));
    }


    @Test
    public void addEURMoneyToPLNMoney() {
        Money expected = new Money(30, "PLN");
        Money result = m10PLN.addCurrencyToCurrency(m5EUR);
        assertTrue(expected.equals(result));
    }

    @Test
    public void addEURMoneyToDKKMoney() {
        Money expected = new Money(19, "DKK");
        Money result = m7DDK.addCurrencyToCurrency(m10EUR);
        assertTrue(expected.equals(result));
    }

    @Test
    public void add0EURMoneyToPLNMoney() {
        Money expected = new Money(10, "PLN");
        Money result = m10PLN.addCurrencyToCurrency(m0EUR);
        assertTrue(expected.equals(result));
    }

    @Test
    public void addDKKMoneyToDKKMoney() {
        Money expected = new Money(17, "DKK");
        Money result = m7DDK.addCurrencyToCurrency(m10DDK);
        assertTrue(expected.equals(result));
    }

    @Test
    public void add0EURMoneyTo0PLNMoney() {
        Money expected = new Money(0, "PLN");
        Money result = m0PLN.addCurrencyToCurrency(m0EUR);
        assertTrue(expected.equals(result));
    }

    @Test
    public void createdMoneyIsTheSame() {
        assertTrue(m10PLN.equals(m10PLN));
    }

    @Test
    public void twoMoneyWithDifferentAmountANDCurrencyAreNotEqual() {
        assertFalse(m10PLN.equals(new Money(99, "CHF")));
    }

    @Test
    public void twoMoneyWithDifferentCurrencyAreNotEqual() {
        assertFalse(m5EUR.equals(new Money(5, "DKK")));
    }

    @Test
    public void checkCurrencyValueForDifferentCurrency() {
        assertTrue(m5EUR.checkValueForDifferentCurrency() == 20);
    }

    @Test
    public void checkValueForDifferentCurrencyWithZero(){
        assertTrue(m0EUR.checkValueForDifferentCurrency() == 0);
    }

    @Test
    public void checkCurrencyRateDKK(){
        assertTrue(Money.getExchangeRateForCurrency("DKK") == 3);
    }

    @Test
    public void checkCurrencyRateForExistingCurrency(){
        assertThrows(NullPointerException.class, () -> Money.getExchangeRateForCurrency("JPY"));
    }

}