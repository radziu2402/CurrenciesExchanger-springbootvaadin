package pl.edu.currenciesexchanger.Client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.edu.currenciesexchanger.Dto.RateModel;

import java.math.BigDecimal;
import java.util.Objects;

@Component
public class WebClient {

    public static final String EXCHANGE_URL = "https://api.exchangerate.host/convert?from=";
    private final RestTemplate restTemplate = new RestTemplate();

    public BigDecimal getRate(String baseCurrency, String convertedCurrency) {
        ResponseEntity<RateModel> exchange = restTemplate.exchange(
                EXCHANGE_URL + "{baseCurrency}&to={convertedCurrency}",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                RateModel.class,
                baseCurrency,
                convertedCurrency);
        return Objects.requireNonNull(exchange.getBody()).getResult();
    }
}
