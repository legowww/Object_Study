package Chapter1;

public class TicketSeller {
    private final TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void sellTo(Audience audience) {
        //인터페이스가 아닌 구현에 의존하고 있다. 하지만 trade-off 를 고려하여 그대로 사용한다.역: 아래 코드에서 TicketSeller 는 TicketOffice 에 있는 Ticket 을 마음대로 꺼내서 Audience 에게 팔고 받은 돈을 TicketOffice 에 넣는다.
        //구현: 객체의 내부 메서드들을 사용하여, 어떤 책임(sellTicketTo 에 해당하는)을 복잡하게 구현하고 있는 경우 ?
        ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()));

//        ticketOffice.sellTicketTo(audience);
    }
}
