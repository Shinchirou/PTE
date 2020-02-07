package pl.edu.pw.ii.pte.junit.money;

import java.util.HashMap;
import java.util.Map;

class Money {
    private int fAmount;
    private String fCurrency;
    public static Map<String, Integer> currencyExchangeRates = new HashMap<>();

    public Money(int amount, String currency) {
        fAmount = amount;
        fCurrency = currency;
        initCurrencyExchangeRates();
    }


    private void initCurrencyExchangeRates() {
        currencyExchangeRates.put("PLN", 1);
        currencyExchangeRates.put("EUR", 4);
        currencyExchangeRates.put("DKK", 3);
        currencyExchangeRates.put("GBP", 6);
    }

    public int getAmount() {
        return fAmount;
    }

    public String getCurrency() {
        return fCurrency;
    }

    public Money add(Money m) {
        return new Money(getAmount() + m.getAmount(), getCurrency());
    }

    public Money addCurrencyToCurrency(Money money) {
        if (getCurrency().equals(money.getCurrency())) {
            return new Money(getAmount() + money.getAmount(), getCurrency());
        } else {
            return new Money((getAmount() * currencyExchangeRates.get(getCurrency()) + money.getAmount() * currencyExchangeRates.get(money.getCurrency())), "PLN")
        }
    }

    public Money multiply(int i) {
        return new Money((getAmount() * i), getCurrency());
    }

    public boolean equals(Object anObject) {
        if (anObject instanceof Money) {
            Money a = (Money) anObject;

            return a.getCurrency().equals(getCurrency()) && getAmount() == a.getAmount();
        }
        return false;

    }

}