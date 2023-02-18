package pl.edu.currenciesexchanger.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.currenciesexchanger.Model.ChangingInfoObject;
import pl.edu.currenciesexchanger.Client.WebClient;

import java.math.BigDecimal;


@Service
public class CalculatorService {

    private final WebClient webClient;

    @Autowired
    public CalculatorService(WebClient webClient) {
        this.webClient = webClient;
    }

    public BigDecimal countRate(ChangingInfoObject changingInfoObject){
        return changingInfoObject.getAmountToExchange().multiply(webClient.getRate(changingInfoObject.getBaseCurrency(), changingInfoObject.getConvertedCurrency()));
    }
}
