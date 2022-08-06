package Chapter11.extend;

import Chapter10.ConcreteclassDp.Call;
import Chapter2.Money;

import java.util.ArrayList;
import java.util.List;

public abstract class Phone {
    private List<Call> calls = new ArrayList<>();

    public List<Call> getCalls() {
        return calls;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;
        for(Call call : calls) {
            result = result.plus(calculateCallFee(call));
        }

        return afterCalculated(result);
    }

    //중복 코드를 막기위해 추상 메서드에서 실제로 구현했다.
    //이런 메서드를 훅 메서드라고 부른다.
    protected Money afterCalculated(Money fee) {
        return fee;
    }

    protected abstract Money calculateCallFee(Call call);
}

