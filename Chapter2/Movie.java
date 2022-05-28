package Chapter2;

import java.time.Duration;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy; // 합성: 다른 객체의 인스턴스를 자신의 인스턴스 변수로 포함하여 재사용


    public void changeDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    //Movie 는 하나의 할인 정책(금액/비율)만을 가질 수 있다.
    //실행 시점에서 Movie 인스턴스 객체가 어떤 할인 정책에 의존하고 있는지(의존성의 대상인지)는 생성자를 통해 확인할 수 있다.
    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        //예외 케이스 처리 -> 기존의 협력 방식의 일관성 붕괴
        //그동안은 할인 금액 로직의 처리가 DiscountPolicy 객체에서 발생했지만, 이 경우 Movie 객체에서 로직이 발생한다.
//        if (discountPolicy == null) {
//            return fee;
//        }

        //합성의 예시:
        //Movie 가 DiscountPolicy 가 calculateDiscountAmount 메서드를 제공한다는 사실만 알고 내부 구현에 대해서는 전혀 알지 못한다.
        //이처럼 인터페이스에 정의된 메세지를 통해서만 코드를 재사용하는 방법을 합성이라고 한다.
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }

}
