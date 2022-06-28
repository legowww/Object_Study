package Chapter5;

import Chapter5.DiscountConditionType;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class LegacyDiscountCondition {
    private DiscountConditionType type;
    //순번 조건일 경우에만 사용되는 변수
    private int sequence;
    //기간 조건일 경우에만 사용되는 변수
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    //변경 원인1: 새로운 할인 조건이 추가되먄 if ~ else 수정해야 한다. 인스턴스 필드값도 수정해야 한다.
    public boolean isSatisfiedBy(Screening screening) {
        if (type == DiscountConditionType.PERIOD) {
            return isSatisfiedByPeriod(screening);
        }
        return isSatisfiedBySequence(screening);
    }

    //변경 원인2: 순번 조건 판단 로직이 변경되면 구현을 수정해야 한다. sequence 또한 수정해야 한다.
    private boolean isSatisfiedBySequence(Screening screening) {
        return sequence == screening.getSequence();
    }

    //변경 원인3: 위와 동일한 논리
    private boolean isSatisfiedByPeriod(Screening screening) {
        return dayOfWeek.equals(screening.getWhenScreened().getDayOfWeek()) &&
                startTime.compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
                endTime.compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
    }

    /**
     * 응집도
     *
     * DiscountCondition 는 하나 이상의 변경 이유를 가지고 있기 때문에 응집도가 낮다.
     * 응집도가 낮다는 것은 서로 연관성 없는 기능이나 데이터가 하나의 클래스에 뭉쳐져 있다는 것을 의미한다.
     * -> 변경의 이유에 따라 클래스를 분리해야 한다.
     *
     * 설계를 개선하는 작업은 변경의 이유가 하나 이상인 클래스를 찾는것으로부터 시작하는 것이 좋다.
     * -> 패턴이 존재한다.
     *
     * 패턴1: 인스턴스 변수가 초기화되는 시점
     * -> 응집도가 높으면 인스턴스 생성 시 모든 속성이 초기화된다.
     *    따라서 클래스의 응집도를 높이기 위해서는 함께 초기화되는 속성을 그룹으로 클래스를 분리해야 한다.
     *
     * 패턴2: 메서스드들이 인스턴스 변수를 사용하는 방식
     * -> isSatisfiedBySequence 메서드는 sequence 속성만을 사용하고
     *    isSatisfiedByPeriod 는 dayOfWeek, startTime, endTime 만을 사용한다.
     *    따라서 클래스의 응집도를 높이기 위해서는 속성 그룹과 해당 그룹에 접근하는 메서드 그룹을 기준으로 클래스를 분리해야 한다.
     *
     *  다음 파트: 다형성으로 해결
     */
}
