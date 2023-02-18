package pl.edu.currenciesexchanger.Gui;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.currenciesexchanger.Model.ChangingInfoObject;
import pl.edu.currenciesexchanger.Service.CalculatorService;

import java.math.BigDecimal;

@Route("exchange")
public class CalculatorGui extends VerticalLayout {
    @Autowired
    public CalculatorGui(CalculatorService calculatorService) {
        MoneyField startMoneyField = new MoneyField("Exchange Rate Calculator");
        MoneyField resultMoneyField = new MoneyField();
        Button button = new Button("Count Rate");
        setAlignItems(Alignment.CENTER);

        Notification notification = new Notification();
        notification.setPosition(Notification.Position.BOTTOM_CENTER);
        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        Div text = new Div(new Text("Failed to count rate. Check if you filled fields correctly!"));
        Button closeButton = new Button(new Icon("lumo", "cross"));
        closeButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
        closeButton.getElement().setAttribute("aria-label", "Close");
        closeButton.addClickListener(event -> notification.close());
        HorizontalLayout layout = new HorizontalLayout(text, closeButton);
        layout.setAlignItems(Alignment.CENTER);
        notification.add(layout);

        button.addClickListener(buttonClickEvent ->
                {
                    resultMoneyField.setAmount("");
                    if(StringUtils.isNumeric(startMoneyField.getAmount().getValue().replaceAll("\\.", ""))
                            && StringUtils.isNotEmpty(startMoneyField.getCurrency().getValue())
                            && StringUtils.isNotEmpty(resultMoneyField.getCurrency().getValue())) {

                        notification.close();
                        BigDecimal resultValue = calculatorService.countRate(new ChangingInfoObject(
                                startMoneyField.getCurrency().getValue(),
                                resultMoneyField.getCurrency().getValue(),
                                BigDecimal.valueOf(Double.parseDouble(startMoneyField.getAmount().getValue()))));

                        resultMoneyField.setAmount(String.valueOf(resultValue));
                    }
                    else notification.open();
                }
        );

        add(startMoneyField,resultMoneyField,button);
    }
}
