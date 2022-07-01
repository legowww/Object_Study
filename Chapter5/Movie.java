package Chapter5;

import Chapter2.Money;
import Chapter4.MovieType;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;


/**
 * 데이터 중심 설계(LegacyMovie): 객체의 종류를 저장하는 인스턴스 변수(movie Type)와 인스턴스 종류에 따라 배타적으로 사용될 변수(discountAmount, discountPercent)를 사용했다.
 *                              또한 객체의 타입에 따라 변하는 로직을 switch~case 로 처리했기 때문에 변경에 취약하다.
 *
 *                          데이터 중심 설계   (by 다형성,정보보호패턴)->  책임 주도 설계
 *
 * 다형성: 하나의 클래스가 여러 타입의 행동을 구현하고 있을 때 다형성을 사용하여 책임을 분산시켜라.

 *       객체의 타입에 따라 변하는 행동이 있다면 타입을 분리하여 명시적인 클래스로 정의하고(discountAmount -> AmountDiscountMovie)
 *       각 타입에 다형적으로 행동하는 책임(calculateDiscountAmount @Override)을 사용했다.
 *
 * 정보 보호 패턴: 예측 가능한 변경으로 클래스들이 불안정 할 거 샅다면 안정적인 인터페이스 뒤로 변경을 캡슐화하라.
 *
 *       Screening 은 Movie 와 메세지를 통해 다형적으로 협력하고 있기 때문에, 새로운 Movie 클래스가 Screening 은 영향받지 않는다. 이를 인터페이스 뒤로 캡슐화 됐다고 말한다.
 */


public abstract class Movie {

    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions; //챕터2는 합성으로 할인정책이 할인조건을 가지고있다, 여기서는 정책을 변경하려면 새로운 인스턴스 생성해야 한다.

    public Movie(String title, Duration runningTime, Money fee, DiscountCondition ... discountConditions) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountConditions = Arrays.asList(discountConditions);
    }

    public Money calculateMovieFee(Screening screening) {
        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount());
        }
        return fee;
    }

    private boolean isDiscountable(Screening screening) {
        return discountConditions.stream()
                .anyMatch(condition -> condition.isSatisfiedBy(screening));
    }

    protected abstract Money calculateDiscountAmount();

    protected Money getFee() {
        return fee;
    }
}
