package Chapter2;

import java.time.LocalDateTime;

public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public LocalDateTime getStartTime() {
        return whenScreened;
    }

    // 상영시간의 순번과 같다면
    public boolean isSequence(int sequence) {
        return this.sequence == sequence;
    }

    //원래의 영화 요금
    public Money getMovieFee() {
        return movie.getFee();
    }

    //예약 메서드
    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    //할인 여부 체크하여 할인이 적용된 예약 금액 반환
    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }
}
