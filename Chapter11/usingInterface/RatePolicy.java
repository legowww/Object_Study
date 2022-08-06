package Chapter11.usingInterface;

import Chapter2.Money;

//기본 정책과 부가 정책은 서로 구분되지 않아야 하므로 동일한 RatePolicy 인터페이스를 사용한다.
public interface RatePolicy {
    Money calculateFee(Phone phone);
}
