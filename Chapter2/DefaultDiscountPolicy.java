package Chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DefaultDiscountPolicy implements DiscountPolicy{
    //순번 조건과 기간 조건을 저장하는 List
    private List<DiscountCondition> conditions = new ArrayList<>();

    public DefaultDiscountPolicy(DiscountCondition ... conditions) {
        //고정된 객체들로 구성된 List 사용 시에는 Arrays.asList() 사용
        this.conditions = Arrays.asList(conditions);
    }

    //DiscountPolicy 인터페이스를 오버라이드
    @Override
    public Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition each : conditions) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }
        return Money.ZERO;
    }

    //추상메서드만 정의한다. 실제로 요금하는 부분은 자식 클래스에서 오버라이딩 된 메서드가 실행된다.
    //이처럼 부모 클래스에 기본적인 알고리즘의 흐름을 구현하고 중간에 필요한 처리를 자식 클래스에게 위임하는 디자인 패턴을
    //TEMPLATE METHOD 라고 부른다.
    protected abstract Money getDiscountAmount(Screening screening);
}
