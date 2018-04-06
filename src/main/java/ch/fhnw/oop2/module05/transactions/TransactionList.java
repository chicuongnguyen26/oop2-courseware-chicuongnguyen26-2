package ch.fhnw.oop2.module05.transactions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Dieter Holz
 */
public class TransactionList {
    private final List<Transaction> allTransactions = new ArrayList<>();

    public void addTransaction(Transaction transaction) {
        allTransactions.add(transaction);
    }

    public int size() {
        return allTransactions.size();
    }

    public List<Transaction> transactionsInYear(int year) {
        return allTransactions.stream()
                .filter(transaction -> transaction.getYear() == year)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .collect(Collectors.toList());
    }

    public List<String> cities() {
        return allTransactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList());

    }

    /**
     * @param city the trader's city
     * @return all traders from given city sorted by name.
     */
    public List<Trader> traders(String city) {

        return allTransactions.stream()
                .map(Transaction::getTrader)
                .sorted(Comparator.comparing(Trader :: getName))
                .filter(trader -> trader.getCity().equals(city))
                .distinct()
                .collect(Collectors.toList());


    }

    /**
     * @param city the city
     * @return true if there are any trader based in given city
     */
    public boolean traderInCity(String city) {

        return allTransactions.stream()
                .map(Transaction::getTrader)
                .anyMatch(trader -> trader.getCity().equals(city));
    }

    /**
     * @param from the trader's current location
     * @param to   the trader's new location
     */
    public void relocateTraders(String from, String to) {
        allTransactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals(from))
                .forEach(trader -> trader.setCity(to));

    }

    /**
     * @return the highest value in all the transactions
     */
    public int highestValue() {
        return 0;

    }
    /**
     * @return a string of all traders’ names sorted alphabetically
     */
    /*
    public String traderNames() {
       return allTransactions.stream()
               .map(Transaction::getTrader)
               .sorted(Comparator.comparing(Trader::getName))
               .collect(Collectors.toCollection());




    }*/
}
