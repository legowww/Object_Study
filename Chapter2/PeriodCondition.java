package Chapter2;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class PeriodCondition implements DiscountCondition{
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    //할인 기간: startTime <= able <= endTime
    //compareTo(인자) > 0 : 인자보다 미래
    //compareTo() < 0 : 인자보다 과거
    //compareTo() == 0 : 인자와 같은 시간
    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.getStartTime().getDayOfWeek().equals(dayOfWeek) &&
                //할인 가능 시간의 시작시간인 startTime 이 screening 의 상영시간보다 과거임과 동시에
                startTime.compareTo(screening.getStartTime().toLocalTime()) <= 0 &&
                //할인 가능 시간의 종료시간인 endTime 이 screening 보다 미래여야 한다.
                endTime.compareTo(screening.getStartTime().toLocalTime()) >= 0;
    }
}
