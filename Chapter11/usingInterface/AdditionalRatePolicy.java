package Chapter11.usingInterface;

import Chapter2.Money;

//부가 정책
public abstract class AdditionalRatePolicy implements RatePolicy{

    //부가 정책은 기본 정책이나 다른 부가 정책의 인스턴스를 참조할 수 있어야 한다.
    private RatePolicy next;

    public AdditionalRatePolicy(RatePolicy next) {
        this.next = next;
    }

    //중복 구현을 제거하기 위해 훅 메서드 사용
    @Override
    public Money calculateFee(Phone phone) {
        Money fee = next.calculateFee(phone);
        return afterCalculated(fee);
    }

    abstract protected Money afterCalculated(Money fee);

}
