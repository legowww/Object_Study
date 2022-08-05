package Chapter11.usingExtend;

import Chapter2.Money;

import java.time.Duration;

/**
 * 상속의 남용으로 하나의 기능을 추가하기 위해 필요 이상으로 많은 수의 클래스를 추가하고 있다. 이를 클래스 폭발이라고 부른다.
 * 클래스 폭발 문제는 자식 클래스가 부모 클래스의 구조현에 강하게 결합되도록 강요하는 상속의 근본적인 한계 때문에 발생하는 문제다.
 * 부모와 자식의 관계가 컴파일타임에 결정되므로 둘 사이의 관계는 변경될 수 없다.
 * 유연한 설계, 즉 재사용과 수정이 필요할 경우 해결하기 불가능한 수준이다. 상속을 포기하자
 *
 * 합성은 컴파일타임 관계를 런타임 관계로 변경함으로써 이 문제를 해결한다.
 * 합성을 사용하면 구현이 아닌 퍼블릭 인터페이스에 대해서만 의존할 수 있기 때문에 런타임에 객체의 관계를 변경할 수 있다.
 * 합성은 조합을 구성하는 요소들을 개별 클래스로 구현한 후 실행 시점에 인스턴스를 조립하는 방법을 사용하는 것이다.
 *
 *
 * p368
 * 컴파일타임 의존성과 런타임 의존성의 거리가 멀수록 설계가 유연해진다는 사실을 기억해라.
 * 상속을 사용할 경우 컴파일타임의 의존성과 런타임의 의존성을 동일하게 만든다고 선언하는 것이다.
 * 따라서 상속을 사용할경우 부모와 자식 클래스의 관계가 정적으로 고정되기 때문에 실행 시점에 동적으로 관계를 변경할 수 없다.
 *
 *
 */
public class TaxableAndRateDiscountableRegularPhone extends TaxableRegularPhone{

    private Money discountAmount;


    public TaxableAndRateDiscountableRegularPhone(Money amount, Duration seconds, Double taxRate, Money discountAmount) {
        super(amount, seconds, taxRate);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return super.afterCalculated(fee).minus(discountAmount);
    }
}
