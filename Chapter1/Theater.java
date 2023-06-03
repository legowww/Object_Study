package Chapter1;

public class Theater {
    private final TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    //Theater는 오직 TicketSeller의 인터페이스(sellTo)에만 의존한다.
    //TicketSeller가 내부에 TicketOffice 인스턴스를 포함하고 있다는 사실은 구현의 영역이다.
    //이처럼 인터페이스에 정의된 메세지를 통해서만 코드를 재사용하는 방법을 합성이라고 부른다.
    public void enter(Audience audience) {

        //디미터 법칙과, 묻지 말고 시켜라 법칙 적용: 내부 구현 참조 xx
        //송신자(=클라이언트)인 Theater 의 의도를 나타내는 오퍼레이션명(메세지를 수신하는 객체의 인터페이스)인
        //sellTo 라는 이름의 메세지를 먼저 고려하고, 수신자인 ticketSeller 를 결정했기 때문에 캡슐화가 증대된다.

        //의도를 드러내는 인터페이스 원칙: sellTo 라는 이름은 협력이라는 문맥을 반영해서 지어졌다.
        //오퍼레이션은 클라이언트(theater)가 객체(ticketSeller)에게 어떻게가 아닌 무엇을 원하는지를 표현해야 한다.
        //다시 말해 객체 자신이 아닌 클라이언트의 의도를 표현하는 이름을 가져야 한다.

        //위임메서드(sellTo) -> 응집도를 낮출 수 있다.
        ticketSeller.sellTo(audience);
    }
}

