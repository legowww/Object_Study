package Chapter5;


/**
 * 다형성을 통해 분리하기: 하나의 클래스가 여러 타입의 행동을 구현하고 있을 때 다형성을 사용하여 책임을 분산시켜라.
 *
 * GRASP: 다형성 패턴
 *
 *  Movie 의 입장에서는 할인 여부를 판단하는 책임을 수행하는 클래스를 구분하는 것은 중요하지 않다.
 * 역할의 등장: SequenceCondition 와 PeriodCondition 은 동일한 책임을 수행하므로 동일한 역할이다. 역할은 대체 가능성을 의미한다.
 * 즉, Movie 는 구체적인 클래스를 알지 못한 채 역할(DiscountCondition)에 대해서만 결합되도록 의존성을 제거할 수 있게 된다.
 *
 * 역할은 추상 클래스 또는 인터페이스를 사용한다.
 * 추상 클래스: 역할을 대체하는 클래스들 사이에서 구현을 공유해야 할 필요가 있을 때 사용한다.
 * 인터페이스: 역할을 대체하는 클래스의 책임만 정의하고 싶을 때 사용한다.
 */
public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
