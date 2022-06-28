package Chapter5;

import Chapter2.Money;
import Chapter4.MovieType;

import java.time.Duration;
import java.util.List;

public class Movie {

    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    //영화에 사용된 할인정책
    //객체의 종류를 저장하는 인스턴스 변수(movieT ype)와 인스턴스 종류에 따라 배타적으로 사용될 변수(discountAmount, discountPercent)를
    //하나의 클래스 안에 함께 포함시키는 방식은 데이터 중심의 설계 안에서 흔히 볼 수 있다.
    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;

    /**
     * calculateMovieFee(Screening screening): 이 메세지는 수신자인 Movie 가 아니라 송신자인 Screening 의 의도를 표현한다.
     * 또한 Screening 이 Movie 의 내부 구현에 대한 아무 지식도 없이 메세지를 결정하고 있다. -> 캡슐화
     */
    public Money calculateMovieFee(Screening screening) {
        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount());
        }
        return fee;
    }

    private Money calculateDiscountAmount() {
        switch (movieType) {
            case AMOUNT_DISCOUNT:
                return calculateAmountDiscountAmount();
            case PERCENT_DISCOUNT:
                return calculatePercentDiscountAmount();
            case NONE_DISCOUNT:
                return calculateNoneDiscountAmount();
        }
        throw new IllegalStateException();
    }

    private Money calculateNoneDiscountAmount() {
        return Money.ZERO;
    }

    private Money calculatePercentDiscountAmount() {
        return fee.times(discountPercent);
    }

    private Money calculateAmountDiscountAmount() {
        return discountAmount;
    }

    //할인조건에 충족하는지 확인하는 메서드
    private boolean isDiscountable(Screening screening) {
        return discountConditions.stream()
                .anyMatch(condition -> condition.isSatisfiedBy(screening));
    }
}
