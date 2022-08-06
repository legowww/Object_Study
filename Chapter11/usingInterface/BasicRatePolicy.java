package Chapter11.usingInterface;

import Chapter10.ConcreteclassDp.Call;
import Chapter2.Money;

//기본 정책
public abstract class BasicRatePolicy implements RatePolicy{

    //중복 구현을 제거하기 위해 훅 메서드 사용
    @Override
    public Money calculateFee(Phone phone) {
        Money result = Money.ZERO;
        for(Call call : phone.getCalls()) {
            result = result.plus(calculateCallFee(call));
        }

        return result;
    }

    protected abstract Money calculateCallFee(Call call);
}
