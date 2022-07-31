package Chapter10;

import Chapter2.Money;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TypeInstancePhone {
    private static final int LATE_NIGHT_HOUR = 22;
    enum PhoneType { REGULAR, NIGHTLY }

    private Phone.PhoneType type;
    private Money amount;
    private Money nightlyAmount;
    private Money regularAmount;
    private Duration seconds;
    private List<Call> calls = new ArrayList<>();

    public TypeInstancePhone(Money amount, Duration seconds) {
        this(Phone.PhoneType.REGULAR, amount, Money.ZERO, Money.ZERO, seconds); //this 는 생성자
    }

    public TypeInstancePhone(Money nightlyAmount, Money regularAmount, Duration seconds) {
        this(Phone.PhoneType.REGULAR, Money.ZERO, nightlyAmount, regularAmount, seconds); //this 는 생성자
    }

    public TypeInstancePhone(Phone.PhoneType type, Money amount, Money nightlyAmount, Money regularAmount, Duration seconds) {
        this.type = type;
        this.amount = amount;
        this.nightlyAmount = nightlyAmount;
        this.regularAmount = regularAmount;
        this.seconds = seconds;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            if (type == Phone.PhoneType.REGULAR) {
                result = result.plus(amount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
            }
            else {
                if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
                    result = result.plus(
                            nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
                } else {
                    result = result.plus(
                            regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
                }
            }
        }
        return result;
    }
}
