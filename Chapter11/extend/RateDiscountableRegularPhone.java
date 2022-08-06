package Chapter11.extend;

import Chapter2.Money;

import java.time.Duration;

//고정 요금 차감 정책
public class RateDiscountableRegularPhone extends RegularPhone{
    private Money discountAmount;

    public RateDiscountableRegularPhone(Money amount, Duration seconds, Money discountAmount) {
        super(amount, seconds);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return fee.minus(discountAmount);
    }
}
