package ph.intevalue.exam.exchange.rate.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ph.intevalue.exam.exchange.rate.transaction.TransactionService;

@RestController
@RequestMapping("/exchangeRate")
public class ExchangeRateController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/exchange")
    public ResponseEntity<?> getRate() {

        String url = "https://api.exchangeratesapi.io/latest";
        RateResponse rate = restTemplate.getForObject(url, RateResponse.class);
        transactionService.save("CAD", rate.rates.CAD, rate.base + " ", rate.date + " ");
        transactionService.save("HKD", rate.rates.HKD, rate.base + " ", rate.date + " ");
        transactionService.save("USD", rate.rates.USD, rate.base + " ", rate.date + " ");
        transactionService.save("IDR", rate.rates.IDR, rate.base + " ", rate.date + " ");
        transactionService.save("JPY", rate.rates.JPY, rate.base + " ", rate.date + " ");

        return ResponseEntity.ok(rate);

    }

    @GetMapping("/view")
    public ResponseEntity<?> viewData() {

        return ResponseEntity.ok(transactionService.view());

    }

    public static class RateResponse {
        public String base;
        public String date;
        public RateHolderResponse rates;

    }

    public static class RateHolderResponse {
        public Double CAD;
        public Double HKD;
        public Double USD;
        public Double IDR;
        public Double JPY;
    }

}
