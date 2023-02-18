package pl.edu.currenciesexchanger.Gui;

import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;

import java.util.ArrayList;
import java.util.Arrays;


public class MoneyField extends CustomField<Money> {

    private TextField amount;
    private Select<String> currency;

    public MoneyField(String label) {
        this();
        setLabel(label);
    }

    public MoneyField() {
        amount = new TextField();
        currency = new Select<>();

        ArrayList<String> symbols = new ArrayList<>(Arrays.asList("AUD", "CAD", "CHF", "EUR", "GBP", "JPY", "USD","PLN","BTC"));

        currency.setItems(symbols);
        currency.setWidth("6em");

        HorizontalLayout layout = new HorizontalLayout(amount, currency);
        // Removes default spacing
        layout.setSpacing(false);
        // Adds small amount of space between the components
        layout.getThemeList().add("spacing-s");

        add(layout);
    }

    public TextField getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount.setValue(amount);
    }

    public Select<String> getCurrency() {
        return currency;
    }

    @Override
    protected Money generateModelValue() {
        return new Money(amount.getValue(), currency.getValue());
    }

    @Override
    protected void setPresentationValue(Money money) {
        amount.setValue(money.getAmount());
        currency.setValue(money.getCurrency());
    }
}