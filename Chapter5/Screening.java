package Chapter5;

import Chapter2.Money;

import java.time.LocalDateTime;

//익명의 객체가 보낸 "예메하라" 메세지에 응답할 수 있어야 한다.
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

    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    //할인된 최종 금액을 계산하는 메서드
    public Money calculateFee(int audienceCount) {
        /**
         * calculateMovieFee(Screening screening): 이 메세지는 수신자인 Movie 가 아니라 송신자인 Screening 의 의도를 표현한다.
         * 또한 Screening 이 Movie 의 내부 구현에 대한 아무 지식도 없이 메세지를 결정하고 있다. -> 캡슐화
         */
        return movie.calculateMovieFee(this).times(audienceCount);
    }

}
