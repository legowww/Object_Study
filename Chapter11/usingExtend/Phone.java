package Chapter11.usingExtend;

import Chapter10.ConcreteclassDp.Call;
import Chapter2.Money;

import java.util.ArrayList;
import java.util.List;
/**
 * 추상화 의존:
 * 구체 클래스 의존 -> 상속을 사용하여 만든 추상 클래스 의존

 장점1:
 자식 클래스들은 이제 추상 메서드인 calculateCallFee() 에만 의존하면 되므로 결합도가 낮아진다.

 장점2(SRP):
 Phone 은 전체 통화 목록 계산, RegularPhone 은 일반 요금 한 건 계산, NightlyDiscountPhone 은 심야 요금 한 건 계산
 하는 방식이 바뀔 경우에 만 변경의 이유를 가진다. 이 클래스들은 단일 책임 원칙을 준수하므로 응집도가 높아진다.

 장점3(DIP):
 의존성의 방향이 세부적인 계산 방식인 하위정책(NightlyDiscountPhone)에서 상위정책(Phone)으로 향한다.
 의존한다는 것은 꼭 구체 클래스를 인스턴스로 클래스에서 사용하는 것 뿐만 아니라 추상 클래스 혹은 인터페이스를 상속받는 경우도 포함한다.

 장점4(OCP):
 새로운 요금제가 필요하다면 Phone 을 상속받는 자식 클래스를 추가하고 calculateCallFee()만 오버라이딩 하면 된다.
 다른 클래스는 수정할 필요가 없다.

 한계: 부모 클래스에 새로운 인스턴스 필드(taxRate)가 생길 경우 자식 클래스에서 생성자 코드를 수정해야 한다.
 */
public abstract class Phone {
    private List<Call> calls = new ArrayList<>();


    //1st. 자식 클래스들 간 공통 코드를 가지는 메서드가 존재한다면, 차이점을 메서드로 추출하고(calculateCallFee) 자식 클래스에 남긴다.
    //2nd. 중복 코드(calculateFee)는 부모 클래스(AbstractPhone)로 옮긴다.
    //3rd. 중복 코드(calculateFee)를 부모 클래스에서 추상 메서드로 사용함으로써 재사용성과 응집도를 높인다.
    //요약: 차이에 의한 프로그래밍 사용(차이점->자식 클래스, 공통점-> 부모 클래스)
    public Money calculateFee() {
        Money result = Money.ZERO;
        for(Call call : calls) {
            result = result.plus(calculateCallFee(call));
        }

        return result;
    }

    //자식 클래스들의 calculateCallFee() 시그니처는 같지만 구현이 서로 다르기 때문에 시그니처만 부모 클래스로 이동한다. -> 추상 메서드로 변경
    protected abstract Money calculateCallFee(Call call);
}

