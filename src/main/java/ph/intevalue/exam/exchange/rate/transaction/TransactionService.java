package ph.intevalue.exam.exchange.rate.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ph.intevalue.exam.exchange.rate.controller.ExchangeRateController.RateHolderResponse;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;

    }

    public Transaction save(String ratesName, Double prize, String base, String date) {

        Transaction bundle = new Transaction();

        bundle.setRates(ratesName);
        bundle.setCurrentPrize(prize);
        bundle.setBase(base);
        bundle.setDate(date);
        return transactionRepository.save(bundle);
    }

    public List<Transaction> view() {

        return transactionRepository.findAll();
    }

}
