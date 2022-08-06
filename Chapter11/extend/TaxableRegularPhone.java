package Chapter11.extend;

import Chapter2.Money;

import java.time.Duration;

public class TaxableRegularPhone extends RegularPhone{

    private double taxRate;

    public TaxableRegularPhone(Money amount, Duration seconds, Double taxRate) {
        super(amount, seconds);
        this.taxRate = taxRate;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return fee.plus(fee.times(taxRate));
    }
}
