package pl.edu.currenciesexchanger.Model;

import java.math.BigDecimal;

public class ChangingInfoObject {
    private String baseCurrency;
    private String convertedCurrency;
    private BigDecimal amountToExchange;

    public ChangingInfoObject(String baseCurrency, String convertedCurrency, BigDecimal amountToExchange) {
        this.baseCurrency = baseCurrency;
        this.convertedCurrency = convertedCurrency;
        this.amountToExchange = amountToExchange;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getConvertedCurrency() {
        return convertedCurrency;
    }

    public void setConvertedCurrency(String convertedCurrency) {
        this.convertedCurrency = convertedCurrency;
    }

    public BigDecimal getAmountToExchange() {
        return amountToExchange;
    }

    public void setAmountToExchange(BigDecimal amountToExchange) {
        this.amountToExchange = amountToExchange;
    }
}
