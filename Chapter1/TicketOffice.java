package Chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketOffice {
    private Long amount;
    private final List<Ticket> tickets = new ArrayList<>();

    public TicketOffice(Long amount, Ticket... tickets) {
        this.amount = amount;
        this.tickets.addAll(Arrays.asList(tickets));
    }
    public Ticket getTicket() {
        return tickets.remove(0);
    }

    //인터페이스: 보통 메서드의 이름이 객체의 책임(enter, sellTo...)을 의미하는 경우가 많다. 그리고 인자로 객체가 메서드를 사용하지 않고 깔끔하게 사용되는 경우가 많다.
    public void sellTicketTo(Audience audience) {
        plusAmount(audience.buy(getTicket()));
    }

    //TicketOffice 객체의 책임이 plusAmount 라고 말 하기엔 부족하다. 그러므로 인터페이스라기 보다는 그냥 구현 메서드로 이해하자.
    //이러한 메서드들은 sellTicketTo 방식처럼 인터페이스에 의존할 경우 private 로 감춰지기 때문에 외부에서 접근할 수 없고, 외부에 공개되지 않는다는 것은 인터페이스가 아니라는 결론이 나온다.
    //결론: 모든 메서드들을 인터페이스라고 생각하지 말자. 인터페이스는 객체의 책임과 연결되어야 한다.
    public void plusAmount(Long amount) {
        this.amount += amount;
    }
}
