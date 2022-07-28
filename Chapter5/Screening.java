package Chapter5;

import Chapter2.Money;

import java.time.LocalDateTime;

//익명의 객체가 보낸 "예메하라" 메세지에 응답할 수 있어야 한다. -> 정보 전문가 패턴에 따라 Screening 객체가 선택된다.
public class Screening {
    //Movie 에 가격을 계산하라 메세지를 보내야하기 때문에 참조.
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;


    public LocalDateTime getWhenScreened() {
        return whenScreened;
    }

    public int getSequence() {
        return sequence;
    }

    //GRASP CREATOR 패턴: Screening 은 Reservation 을 초기화하는데 필요한 데이터를 가지고 있다.
    //만약 결합돼 있는 객체에 CREATOR 패턴을 사용하다면 결합도가 그대로 유지된다.
    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    //할인된 최종 금액을 계산하는 메서드
    public Money calculateFee(int audienceCount) {
        /**
         * calculateMovieFee(Screening screening): 이 메세지는 수신자인 Movie 가 아니라 송신자인 Screening 의 의도를 표현한다.
         * 또한 Screening 이 Movie 의 내부 구현을 고려하지 않고 필요한 메세지를 결정했기 때문에 Movie 의 캡슐화가 가능하다.
         */
        return movie.calculateMovieFee(this).times(audienceCount);
    }
}
