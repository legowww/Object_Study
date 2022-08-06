package Chapter11.usingInterface;

import Chapter10.ConcreteclassDp.Call;
import Chapter2.Money;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Phone {
    private List<Call> calls = new ArrayList<>();

    /**
     * 합성 사용의 예시, 런타임에 퍼블릭 인터페이스로 의존성을 주입받기 위해 인터페이스나 추상 클래스를 사용한다.
     *
     * 나는 인터페이스인 RatePolicy 에게만 의존하면 된다.
     * ratePolicy.calculateFee(this) 처럼 RatePolicy 의 퍼블릭 인터페이스만 사용하고 있으므로,
     * 구현이 변경되도 결합도가 낮기 때문에 최소한의 피해를 입는다.
     *
     * RatePolicy 가 기본 정책을 의존하고 있는지 부가 정책을 의존하고 있는지는 구분하지 않는다.
     * 모든 정책들은 RatePolicy 인터페이스를 상속받아서 제작됐다.
     *
     * Phone -----------------> RatePolicy
     *          BasicRatePolicy         AdditionalRatePolicy
     *        ...           ...          ...            ..
     *
     * Phone 은 RatePolicy 를 사용한다.
     * BasicRatePolicy 와 AdditionalRatePolicy 는 abstract class 로 new 가 불가능한 클래스이다.
     * 우리가 실제로 사용하는 클래스는 BasicRatePolicy, AdditionalRatePolicy 를
     * extends 한 NightlyDiscountPolicy, RateDiscountablePolicy ... 클래스들이다.
     *
     */
    private RatePolicy ratePolicy;

    public Phone(RatePolicy ratePolicy) {
        this.ratePolicy = ratePolicy;
    }

    public List<Call> getCalls() {
        return Collections.unmodifiableList(calls);
    }

    public Money calculateFee() {
        return ratePolicy.calculateFee(this);
    }

}

