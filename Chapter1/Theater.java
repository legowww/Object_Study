package Chapter1;

public class Theater {
    private final TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    //구현이 아닌 sellTo 라는 인터페이스에만 의존해야 한다.
    //이처럼 인터페이스에 정의된 메세지를 통해서만 코드를 재사용하는 방법을 합성이라고 부른다.
    public void enter(Audience audience) {
        ticketSeller.sellTo(audience);
    }
}

