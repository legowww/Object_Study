package Chapter4;

import Chapter2.DiscountCondition;
import Chapter2.Money;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

//Movie 클래스 하나에 할인정책, 할인조건이 모두 들어있다.
public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    //영화에 사용된 할인정책
    //객체의 종류를 저장하는 인스턴스 변수(movieType)와 인스턴스 종류에 따라 배타적으로 사용될 변수(discountAmount, discountPercent)를
    //하나의 클래스 안에 함께 포함시키는 방식은 데이터 중심의 설계 안에서 흔히 볼 수 있다.
    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Duration getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(Duration runningTime) {
        this.runningTime = runningTime;
    }

    public Money getFee() {
        return fee;
    }

    public void setFee(Money fee) {
        this.fee = fee;
    }

    public List<DiscountCondition> getDiscountConditions() {
        return Collections.unmodifiableList(discountConditions); //수정, 추가를 할 수 없다. final 같은 배열이다.
    }

    public void setDiscountConditions(List<DiscountCondition> discountConditions) {
        this.discountConditions = discountConditions;
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }

    public Money getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Money discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }
}
