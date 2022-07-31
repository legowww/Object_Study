package Chapter10.AbstractclassDp;

import Chapter10.ConcreteclassDp.Call;
import Chapter2.Money;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPhone {

    private List<Call> calls = new ArrayList<>();

    //공통 메서드 추출
    public Money calculateFee() {
        Money result = Money.ZERO;

        for(Call call : calls) {
            result = result.plus(calculateCallFee(call));
        }

        return result;
    }

    //자식 클래스에서 calculateCallFee 구현이 서로 다르기 때문에
    //시그니처만 부모 클래스로 이동한다.
    protected abstract Money calculateCallFee(Call call);
}
