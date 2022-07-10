package Chapter6;

import java.time.Duration;
import java.time.LocalDateTime;


public class Event {
    private String subject;
    private LocalDateTime from;
    private Duration duration;

    public Event(String subject, LocalDateTime from, Duration duration) {
        this.subject = subject;
        this.from = from;
        this.duration = duration;
    }

    /**
     * 코드:
     * DayOfWeek 는 enum 으로 싱글톤 객체이므로 동일성 보장
     * LocalTime 변수와 Duration 변수는 동일성 보장 x -> 동등성 보장 equals() 사용
     *
     * 문제 원인: 쿼리처럼 보이는 isSatisfied 안에 명령인 reschedule 이 존재했다.
     * 명령과 쿼리를 뒤섞으면 실행 결과를 예측하기 어렵다. 명령과 쿼리를 분리하자.
     */
    public boolean isSatisfiedLegacy(RecurringSchedule schedule) {
        if (from.getDayOfWeek().equals(schedule.getDayOfWeek()) &&
            from.toLocalTime().equals(schedule.getFrom()) &&
            duration.equals(schedule.getDuration()))
            return true;
        reschedule(schedule);
        return false;
    }

    /**
     * 쿼리(=함수 = 참조 투명성 보장, 값 반환 o, 부수효과 x): isSatisfied()
     * 명령(=프로시저, 값 반환 x, 부수효과 o): reschedule()
     * 쿼리와 명령을 분리하여 예측 가능한 코드가 되었다.
     *
     * 참조 투명성: 어떤 표현식 e가 있을 때 e의 값으로 e가 나타나는 모든 위치를 교체하더라도 결과가 달라지지 않는다.
     * ex) e = f(1) = 3
     * f(1) + 5 = 8         3 + 5 = 8
     * f(1) + f(1) = 6      3 + 3 = 6
     * 이러한 참조 투명성은 f(1)의 불변성으로 부터 보장된다.
     *
     * 참조 투명성의 장점:
     * - 모든 함수를 이미 알고 있는 하나의 결괏값으로 대체할 수 있기 때문에 식을 쉽게 변경할 수 있다.
     * - 모든 곳에서 함수의 결괏값이 동일하기 때문에 식의 순서를 변경하더라도 각 식의 결과는 달라지지 않는다.
     *
     * 하지만 프로그래밍 언어에서 참조 투명성은 예외에 가깝다. 대부분의 언어는 부수효과를 기반으로하는 명령형 프로그래밍
     * 방식을 사용하기 때문이다. 그래서 쿼리-명령 분리 원칙을 사용하면 제한적으로 참조 투명성의 장점을 누릴 수 있다.
     * */
    public boolean isSatisfied(RecurringSchedule schedule) {
        return from.getDayOfWeek().equals(schedule.getDayOfWeek()) &&
                from.toLocalTime().equals(schedule.getFrom()) &&
                duration.equals(schedule.getDuration());
    }

    public void reschedule(RecurringSchedule schedule) {
        from = LocalDateTime.of(from.toLocalDate().plusDays(daysDistance(schedule)),
                schedule.getFrom());
        duration = schedule.getDuration();
    }

    private long daysDistance(RecurringSchedule schedule) {
        return schedule.getDayOfWeek().getValue() - from.getDayOfWeek().getValue();
    }

    @Override
    public String toString() {
        return "Event{" +
                "subject='" + subject + '\'' +
                ", from=" + from +
                ", duration=" + duration +
                '}';
    }
}
