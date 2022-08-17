> 서론

『객체지향의 사실과 오해』에서는 협력, 책임, 역할의 관점으로 객체지향을 볼 수 있는 개념을 학습했다. 이 책을 통해 직접 여러 객체지향 구조들을 코드로 구현해보면서 객체지향에 관한 공부를 이어 나가 보자.

책에 있는 코드를 직접 따라 치는 것에서 끝나는 것이 아니라 객체지향의 구조에 대해 스스로 생각할 수 있는 시간을 가지면서 진행하자.

---
## CHAPTER1
- 객체 사이의 의존성이 높을 경우 결합도가 높다고 말한다. **객체는 스스로 자신의 데이터를 처리할 수 있는(=책임 질 수 있는) 자율적인 객체로 만들어야 한다.**

- 자신의 데이터를 스스로 처리하는 자율적인 객체를 만들면 응집도가 높고 결합도가 낮은 객체를 만들 수 있다.

- 캡슐화의 목적은 변경하기 쉬운 객체를 만드는 것이다. 캡슐화를 통해 데이터와 기능을 객체 내부로 함께 묶고, 접근제어를 통해 객체 내부로의 접근을 제한하면 변경에 대한 파급효과를 제어할 수 있고 객체 간 결합도가 느슨해지기 때문에 자율적인 객체를 만들 수 있다.

- 소프트웨어 객체를 생물로 생각하자. 현실 세계에서는 수동적인 존재라도 객체지향의 세계에서는 능동적이고 자율적인 존재로 바뀐다. 이러한 방식으로 객체를 설계하는 원칙을 가리켜 의인화라고 부른다.

- 객체는 인터페이스와 구현으로 나누고, 인터페이스만을 공개하여 객체 사이의 결합도를 낮추고 변경하기 쉬운 코드를 작성해야 한다.

---
## CHAPTER2

- 객체 내부로의 접근을 제어하는 이유는 객체를 자율적인 존재로 만들기 위해서다. 객체지향의 핵심은 스스로 상태를 관리하고, 판단하고, 행동하는 자율적인 객체들의 공동체를 구성하는 것이다. 자율적인 객체는 외부의 간섭으로부터 최소화되야한다.

- 책임은 객체의 공용 인터페이스를 구성한다.

- 객체는 다른 객체의 인터페이스에 공개된 행동을 수행하도록 요청하고, 요청받은 객체는 자율적인 방법에 따라 요청을 처리한 후 응답한다. 객체는 다른 객체와 메세지를 통해서만 상호작용할 수 있다. 메세지를 수신한 객체는 자율적으로 메세지를 처리할 방법을 결정한다. 이처럼 수신된 메세지를 처리하기 위한 자신만의 방법을 메서드라고 부른다.

- 자식 클래스는 상속을 통해 부모 클래스의 인터페이스를 물려 받는다.

```
인터페이스는 객체가 이해할 수 있는 메세지의 목록을 의미한다. 
결과적으로 자식 클래스는 부모가 수신할 수 있는 메세지를 모든 메세지를 수신할 수 있기 때문에 
외부 객체는 부모 클래스와 자식 클래스를 동일한 타입으로 간주할 수 있다.
```
- 자식 클래스가 부모 클래스를 대신하는 것을 업캐스팅이라고 부른다.

- 동일한 메세지를 전송하지만 실제로 어떤 메서드가 실행될 것인지는 메세지를 수신하는 객체의 클래스가 무엇이냐에 따라 달라진다. 즉, 동일한 메세지를 수신받고 다르게 반응하는 것을 다형성이라고 부른다.

- Movie와 DiscountPolicy는 합성관계로 이어져 있고, DiscountPolicy와 AmountDiscountPolicy, PercentDiscountPolicy는 상속관계로 연결돼 있다.
코드를 재사용하는 경우에는 상속보다 합성, 다형성을 위해 인터페이스를 재사용하는 경우에는 상속과 합성의 조합을 이용하는 것이 좋다.

- 객체는 퍼블릭 인터페이스와 구현으로 나뉘어진다. 
```
전자는 외부에서 접근 가능한 영역으로 객체 간 연결은 오직 퍼블릭 인터페이스를 통해서만 이루어진다.
인터페이스를 통해 내부 구현을 몰라도 클래스를 사용할 수 있다.

후자는 외부에서 접근 불가능한 영역으로 내부 구조에 해당한다. 속성(인스턴스 필드), (private | protected)메서드는 구현에 포함된다. 
구현은 자주 변경되므로 불안정한 속성을 가진다. 
```

---
## CHAPTER3

- 객체지향의 핵심은 역할, 책임, 협력이다. 협력은 애플리케이션의 기능을 구현하기 위해 메시지를 주고받는 객체들 사이의 상호작용이다. 책임은 객체가 다른 객체와 협력하기 위해 수행하는 행동이고, 역할은 대체 가능한 책임의 집합이다.

- 협력이란 객체들이 애플리케이션의 기능을 구현하기 위해 수행하는 상호작용을 말한다. 협력은 설계를 위한 문맥을 결정한다. 

- 두 객체 사이의 협력은 메세지 전송을 통해 이루어진다. 메세지를 수신받은 객체는 스스로 메세지를 처리할 수 있는 메서드를 선택하고 실행하여 요청에 응답한다. 

- 객체가 책임을 수행하게 하는 유일한 방법은 메세지를 전송하는 것이다.

- 협력이라는 문맥을 갖춘 후 협력에 필요한 행동을 수행할 수 있는 객체를 찾는다. 이때 협력에 참여하기 위해 객체가 수행하는 행동을 책임이라고 부른다.

- 책임을 수행할 적절한 객체를 찾아 책임을 할당하는 방법을 책임 주도 설계라고 부른다. 

- 객체에게 책임을 할당하는 데 필요한 메세지를 먼저 결정하고 메세지를 처리할 객체를 나중에 선택해야 한다. 

- 행동이 상태를 결정한다. 상태가 행동을 결정할 경우, 내부 구현이 공용 인터페이스에 노출되기 쉽기 때문에 캡슐화를 저해한다.

- 역할은 동일한 책임을 할 수 있는 다양한 종류의 객체를 끼워 넣을 수 있는 일종의 슬롯이다.

- 역할의 가장 큰 장점은 설계의 구성 요소를 추상화 할 수 있다는 것이고 상위 수준의 정책을 쉽고 간단하게 표현할 수 있다.

- 역할과 객체의 구분: 나중에 동일한 책임을 서로 다른 방식으로 수행할 수 있는 객체들이 필요해질 때가 왔을 때 역할의 도입을 고려해도 늦지 않다.


## CHAPTER5
- 메세지는 메세지를 수신할 객체가 아니라 메세지를 전송할 객체의 의도를 반영해서 결정해야 한다(= 메세지를 수행하는 메서드의 이름을 송신자 객체의 입장에서 작성). 

- 메세지를 전송할 객체는 무엇을 원하는가?(예매하라) -> 메세지를 수신할 적합한 객체는 누구인가?(Screening)

- 정보 전문가 패턴에서 책임을 수행할 객체가 꼭 데이터를 가질 필요는 없다. 정보를 제공할 수 있다는 것은 정보 제공 객체를 알고 있는 것도 포함하기 때문이다. 

- 역할은 추상 클래스 또는 인터페이스를 사용한다.
- 추상 클래스: 역할을 대체하는 클래스들 사이에서 구현을 공유해야 할 필요가 있을 때 사용한다.
- 인터페이스: 역할을 대체하는 클래스의 책임만 정의하고 싶을 때 사용한다.

- 객체의 타입에 따라 변하는 로직을 if ~ else 또는 switch를 통해 처리할 경우 프로그램이 수정될 경우 조건 논리를 수행해야 한다. 

- 타입을 나타내는 코드를 다형성으로 바꾸는 리팩터링을 "Replace Tpye Code with Class"라고 부른다.

- 객체의 타입에 따라 변하는 행동이 있다면 타입을 분리하여 명시적인 클래스로 정의하고(sequence -> SequenceCondition) 각 타입에 다형적으로 행동하는 책임(@Override)을 할당하라. 이를 다형성 패턴이라고 부른다. 

- 객체로 책임을 분배할 때 가장 먼저 할 일은 메서드를 응집도 있는 수준으로 분해하는 것이다. 긴 메서드는 읽기 어렵고 재사용하는 것이 불가능하고 코드 중복을 초래하기 쉽다.

- 그 다음으로 해야할 일은 객체를 자율적으로 만드는 것이다. 메서드가 사용하는 데이터를 저장하고 있는 클래스로 메서드를 이동시키면 된다.

- 책임 주도 설계, 즉 객체에게 책임을 할당하는 작업이 어렵게 느껴진다면 일단 데이터 중심으로 구현한 후 리팩터링을 통해 결과물을 얻을 수 있다. 

- 생성자, 다형성, 정보 보호 패턴을 CHATRER5 코드와 주석을 통해 읽어보자

## CHAPTER6

- 메세지를 통해 객체간의 협력이 이루어진다.

- 객체의 책임은 수신받을 수 있는 메세지의 기반이된다. 객체가 수신하는 메세지들이 모여 퍼블릭 인터페이스를 구성한다.

- 퍼블릭 인터페이스란 객체가 협력에 참여하기 위해 외부에서 수신할 수 있는 메세지의 묶음이다. 퍼블릭 인터페이스의 품질이 객체의 품질을 결정한다.

- 객체지향 어플리케이션에서 가장 중요한 재료는 클래스가 아니라 객체가 주고받는 메세지이다. 

- 메세지는 전송자와 수신자 사이의 협력 관계를 강조하는 데 비해 오퍼레이션은 메세지를 수신받는 객체의 인터페이스를 강조한다. 

- 메서드는 메세지에 응답하기 위해 실행되는 코드 블럭이다. 메서드는 오퍼레이션의 구현이며 동일한 오퍼레이션이라고 해도 다형에 의해 다른 메서드를 호출 할 수 있다.

- 흐름: 메세지전송 -> 오퍼레이션 호출 -> 메서드 실행

- 객체가 메세지를 수신받을 때, 객체의 타입에 따라 실행되는 메서드가 달라질 수 있다. 메세지와 메서드가 실행시점에 연결되며 이를 통해 두 객체간 결합도가 낮아진다.

- condition.isSatisfiedBy(screening) = 수신자.오퍼레이션명(인자)

퍼블릭 인터페이스의 품질에 영향을 미치는 요소


```java
1. 디미터 법칙: 객체의 내부 구조에 강하게 결합되지 않도록 협력 경로를 제한하라, 하나의 도트(.)만 사용하라
디미터 법칙을 따르는 코드는 메세지 수신자의 내부 구조가 전송자에게 노출되지 않으며(캡슐화 증대), 메세지 전송자는 
수신자의 내부 구현에 결합되지 않는다. 따라서 클라이언트와 서버 사이에 낮은 결합도를 유지 할 수 있다.


클래스 내부의 메서드가 아래 조건을 만족하는 인스턴스에만 메세지를 전송하도록 프로그래밍해야 한다.
<this 객체, this의 속성, this의 속성인 컬렉션의 요소, 메서드의 매개변수, 메서드 내에서 생성된 지역객체>

- 디미터 법칙 적용
public class ReservationAgency {
    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        Money fee = screening.calculateFee(audienceCount);
        return new Reservation(customer, screening, fee, audienceCount);
    }
}
-> 메서드의 인자인 Screening 인스턴스에만 메세지를 전송하고 있다. 인스턴스의 내부 구조에 대해서는 전혀 알고있지 않다.
calculateFee()는 Screening 의 퍼블릭 인터페이스이지 내부 구조라고 할 수 없다.


- 디미터 법칙 위반
screening.getMovie().getDiscountConditions();

-> 기차 충돌이라고 부르는 코드이다. 보통은 getter()를 통해 내부의 객체를 참조하는 형태의 코드를 가진다. 
수신자인 screening에게 내부 구조에 대해 물어보고 있으며 메세지 전송자가 메세지 수신자의 내부 구현에 강하게 결합된다.

디미터 법칙을 위반할 경우 인터페이스와 구현의 분리 원칙을 위반하게 된다.
객체의 내부 구조는 구현에 해당한다. Screening이 Movie를 포함한다는 사실은 Screening의 내부 구현에 속하며 Screening은 자신의 내부 구현을
자유롭게 변경할 수 있어아 햔다. 그러나 getMovie가 퍼블릭 인터페이스로 노출될 경우 외부에서 내부 구현을 변경할 수 있기 때문에 불안정한 코드를 가지게 된다.

여기서 주의할점은 물어보는 대상이 객체(Movie)가 아닌 데이터(getFee())라면 디미터 법칙을 적용할 필요가 없다는 것이다.
```
```java
2. 묻지 말고 시켜라: 디미터 법칙의 코딩 스타일
screening.getMovie().getDiscountConditions(); 처럼 객체의 상태에 대해 묻지 말고 
screening.calculateFee(audienceCount); 처럼 원하는 것을 시켜라

- 객체의 정보를 이용하는 행동을 객체의 외부가 아닌 내부에 위치시키기 때문에 높은 응집도를 가진 클래스를 얻을 수 있다.
- 묻지 말고 시켜라 스타일인 아래 코드에서는 두 객체가 어떤 상호작용을 하는지 위임 메서드의 이름을 통해 명시적으로 확인 할 수 있다.
```
```java
3. 의도를 드러내는 인터페이스: 인터페이스는 객체가 "어떻게" 하는지가 아니라 "무엇을" 하는지를 서술해야 한다. 
무엇을에 초점을 맞출 경우 동일한 작업을 수행하는 메서드들을 하나의 타입 계층으로 묶을 수 있는 가능성이 커진다.

isSatifiedByPeriod, isSatifiedBySequence -> isSatifiedBy 

이유
- 두 메서드의 내부 구조를 이해하지 못하면 두 메서드가 동일한 작업을 수행한다는 사실을 알아채기 어렵다.
- 할인 방법이 달라질 경우 메서드의 이름을 변경해야 한다. 그 말은 메서드를 사용하는 클라이언트(전송자)의 코드도 변경해야 한다.
- 동일한 인터페이스를 가지고 있지 않으므로 다형적으로 행동하는 책임(@Override)을 사용할 수 없다. 
 
```

```java
4. 명령-쿼리 분리 법칙: CHAPTRE6 코드 참조하자. 명령-쿼리 인터페이스를 한 메서드에서 같이 사용할 경우 에러를 발생할 수 있다.
```
이 법칙들을 효과적으로 적용하기 위해서 해야할 가장 첫 번째 일은 **메세지를 먼저 결정**하는 것이다.

---
# CHAPTER7 객체 분해

- 프로그래밍 언어에서의 타입
> 변수에 저장할 수 있는 내용물의 종류와 변수에 적용될 수 있는 연산의 가짓수를 의미한다. 연산의 집합이 정해지기 때문에 변수의 값이 어떻게 행동할 것인지 예측할 수 있다.

- 추상 데이터 타입과 클래스 모두 퍼블릭 인터페이스를 통해서만 객체 간 의사소통을 할 수 있다는 공통점을 가진다. 하지만 가장 핵심적인 차이로는 클래스는 상속과 다형성을 지원한다는 것이다.
```java
추상 데이터 타입: 
- 추상 데이터 타입의 기본 의도는 프로그램이 언어가 제공하는 기본 타입처럼 동작하는 사용자 정의 타입을 추가할 수 있게 하는 것이다.
- 오퍼레이션을 기준으로 타입이 묶인다. 즉, 오퍼레이션이 호출될 경우 객체의 타입에 따라 변하는 로직을 조건문으로 처리하면서 암묵적으로 타입이 나눠진다.
- 데이터 중심 설계를 따른다. -> 하나의 추상 데이터 타입 안에는 여러 개의 타입이 공존할 수 있으며 객체의 타입을 결정하는 인스턴스 변수가 존재한다.
- 데이터와 기능이 분리되어 있다. 데이터를 이용하는 핵심 로직들은 추상 데이터 타입 외부에 존재한다.

클래스:
- OOP, 즉 책임 주도 설계를 따른다. 
- 타입을 기준으로 오퍼레이션을 묶는다. 이 말은 상속을 통한 다형성을 이용한다고 해석할 수 있다.
- 부모 타입을 따르는 자식 타입들이 존재하며, 자식 타입들은 다형적으로 행동할 수 있는 책임을 할당받는다.
```

---
# CHAPTER8 의존성 관리하기
> 의존성
```
-실행 시점: 의존하는 객체가 정상적으로 동작하기 위해서는 실행 시에 의존 대상 객체가 반드시 존재해야 한다.
-구현 시점: 의존 대상 객체가 변경될 경우 의존하는 객체도 함께 변경된다.
```
> 의존성의 예시
```java
public class PeriodCondition implements DiscountCondition{
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.getStartTime().getDayOfWeek().equals(dayOfWeek) &&
                startTime.compareTo(screening.getStartTime().toLocalTime()) <= 0 &&
                endTime.compareTo(screening.getStartTime().toLocalTime()) >= 0;
    }
}
PeriodCondition는 DiscountCondition, Screening, DayOfWeek, LocalTime 클래스에 의존하고 있다.
의존성이 존재한다는 말은 의존되는 요소가 변경될 때 의존하는 요소도 함께 변경될 수 있다는 것을 의미한다.
의존성은 단방향으로만 존재할 수 있다. Screening이 변경될 경우 PeriodCondition는 영향을 받지만 역은 성립하지 않는다.
```
> 의존성 전이
```java
Screening은 Movie클래스에 의존하고 있다. 의존성 전이에 의해 PeriodCondition는 잠재적으로 Movie에 의존한다.
```

> 런타임 의존성과 컴파일 타임 의존성
```java
-런타임 의존성: 애플리케이션이 실행되는 시점을 가르킨다.
-컴파일 의존성: 보통 코드가 작성된 시점을 가르킨다.
-> 유연하고 재사용 가능한 코드를 설계하기 위해서 두 종류의 의존성을 서로 다르게 만들어야 한다.
```

> 추상화에 의존하라 
```java
        Movie -----------------> DiscountPolicy
                                       |
                               -------------------
                               |                 |
                            Amount            Percent
                        DiscountPolicy     DiscountPolicy
                        
컴파일 의존성 시점에서 Movie클래스는 오직 추상 클래스인 DiscountPolicy클래스에만 의존해야 한다. 
Amount, Percent에 대해서는 전혀 알지 못한다.
하지만 런타임 의존성 시점에서는 Amount, Percent 인스턴스와 협력할 수 있어야 한다.

어떤 클래스의 인스턴스가 다양한 클래스의 인스턴스와 협력하기 위해서는 협력할 인스턴스의 구체적인 클래스를 알아서는 안 된다.
실제로 협력할 객체는 런타임에 해결해야 한다.
클래스가 협력할 객체의 클래스를 명시적으로 드러내고 있다면 다른 클래스의 인스턴스와 협력할 가능성 자체가 없어진다. 

높은 결합도 ------------> 낮은 결합도
 구체 클래스, 추상 클래스, 인터페이스
```

> 컨텍스트 독립성
```java
클래스가 사용될 특정한 문맥에 대해 최소한의 가정만으로 이뤄져 있다면 다른 문맥에서 재사용하기가 더 수월해진다. 
이를 컨텍스트 독립성이라고 부른다. 컨텍스트 독립성은 더 유연한 설계와 변경에 탄력적으로 대응할 수 있게 도와준다.
```

> 의존성 주입
```java
1. 객체를 생성하는 시점에 생성자를 통해 의존성 해결
- 명시적인 의존성: 모든 경우에 의존성은 명시적으로 퍼블릭 인터페이스에 노출된다. 이를 명시적 의존성이라 부른다.

/**
    의존성의 대상인 DiscountPolicy가 Movie 생성자 메서드 인자로 사용되고 있다.
    Movie가 DiscountPolicy에 의존한다는 사실이 퍼블릭 인터페이스에 명시적으로 드러나게 된다.  
    -> 명시적인 의존성을 사용하기 때문에 컴파일 타임 의존성을 적절한 런타임 의존성으로 교체할 수 있다.
**/
public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
    this.title = title;
    this.runningTime = runningTime;
    this.fee = fee;
    this.discountPolicy = discountPolicy;
}     
    new Movie("아바타",
            Duration.ofMinutes(120),
            Money.wons(10000),
            new AmountDiscountPolicy(Money.wons(800),
                new SequenceCondition(1),
                new SequenceCondition(10),
                new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59))));                
      
      
2. 객체 생성 후 setter 메서드를 통해 의존성 해결
Movue avatar = new Movie(..);
//setter 메서드를 이용하면 할인 정책을 교체할 수 있다.
//setter 주입의 단점은 객체가 올바르게 생성되기 위해 어떤 의존성이 필수적인지 명시적이지 않다는 사실이다.
avatar.setDiscountPolicy(new AmountDiscountPolicy(...));


3. 메서드 실행 시 인자를 이용해 의존성 해결
//의존성이 한 두개의 메서드에서만 사용된다면 고려해볼만 하다.
- public Money calculateMovieFee(Screening screening, DiscountPolicy discountPolicy) {}
- avatar.calculateDiscountAmount(screening, new AmountDiscountPolicy(...));

결론: 생성자와 setter 메서드 둘 다 이용하는 방법이 가장 좋다.
```

> 결합도
```java
바람직한 의존성은 재사용성과 관련이 있다. 어떤 의존성이 다양한 환경에서 재사용할 수 있다면 바람직한 의존성이다.

private DiscountPolicy discountPolicy; -> 바람직한 의존성 -> 느슨한, 약한 결합도
private AmountDiscountPolicy discountPolicy -> 다른 인스턴스와 협력 불가능. 바람직하지 않은 의존성 -> , 강한 결합도
```

> new는 해롭다
```java
1. new 연산자를 사용하기 위해서는 구체 클래스의 이름을 직접 기술해야 한다 -> 구체 클래스 의존은 높은 결합도를 의미.
2. new 연산자에 사용되는 인자들의 값을 알아야 한다 -> 클라이언트가 알아야 하는 지식의 양이 늘어나기 때문에 높은 결합도를 가진다.
```

> 결론
```java
new Movie("아바타",
        Duration.ofMinutes(120),
        Money.wons(10000),
        new AmountDiscountPolicy(Money.wons(800),
            new SequenceCondition(1),
            new SequenceCondition(10),
            new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59))));   
            
           
1. Movie가 DiscountPolicy라는 추상화에 의존하고, DiscountPolicy의 자식 클래스를 추가함으로써
간단하게 Movie가 사용될 컨텍스트를 확장할 수 있다.

2. 생성자를 통해 DiscountPolicy에 대한 의존성을 명시적으로 드러냈다.

3. new와 같은 구체 클래스를 다뤄야 하는 책임을 Movie 외부인 클라이언트에게 위임했다.

주석 없이도 코드를 읽는 것 만으로도 객체가 어떤 일을 하는지 쉽게 이해할 수 있다.
위의 코드처럼 의존성을 잘 관리하여 재사용성이 좋고 유연한 코드를 만들어야 한다.
```
---
# CHAPTER9 유연한 설계
> 개방-폐쇄 원칙(Open-Closed Principle, OCP)
```java
소프트웨어 개체(클래스, 모듈, 함수 등등)는 확장에 대해 열려 있어야 하고, 수정에 대해서는 닫혀 있어야 한다.
-확장: 확장에 대해 열려 있다. 애플리케이션의 요구사항이 변경될 때 이 변경에 맞게 새로운 '동작'을 추가해서 애플리케이션의 기능을 확장할 수 있다.
-수정: 수정에 대해 닫혀 있다. 기존의 '코드'를 수정하지 않고도 애플리케이션의 동작을 추가하거나 변경할 수 있다.

즉 OCP란, 기존 코드에 아무런 영향도 미치지 않고 새로운 객체 유형과 행위를 추가할 수 있는 객체지향의 특성을 말한다.
```
> 어떻게 OCP를 지킬 수 있을까?
```java
컴파일타임 의존성을 고정시키고 런타임 의존성을 변경하라
-> '추상화'에 '의존'하라, 추상화는 확장을 가능하게 하고 추상화에 대한 의존은 폐쇄를 가능하게 한다.
```
>객체의 생성과 사용 분리
- BEFORE: 객체의 생성과 사용을 함께 맡고 있는 Movie
```java
public class Movie {
    ...
    
    //객체의 생성: AmountDiscountPolicy 생성함.
    public Movie(String title, Duration runningTime, Money fee) {
        ...
        this.discountPolicy = new AmountDiscountPolicy(...);
    }
    
    //객체의 사용: AmountDiscountPolicy 메세지를 전송하고 있다.
    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
}
```
- AFTER: 객체의 생성을 전담하는 FACTORY 추가

1. Movie와 AmountDiscountPolicy를 생성하는 책임이 모두 FACTORY로 이동했다.
2. Client는 사용과 관련된 책임만을 가진다. FACTORY를 통해 생성된 Movie객체를 얻기 위한 것이고 다른 하나는 Movie를 통해 가격을 계산하기 위한 것이다. 
3. 도메인과 무관한 인공적인 객체를 PURE FABRICATION(순수한 가공물)이라고 부른다.

```java
public class Factory {
    public Movie createAvatarMovie() {
        return new Movie("아바타",
                    Duration.ofMinutes(120),
                    Money.wons(10000),
                    new AmountDiscountPolicy(Money.wons(800),
                        new SequenceCondition(1),
                        new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59))));
    }
}

public class Client {
    private Factory factory;

    public Client(Factory factory) {
        this.factory = factory;
    }

    public Money getAvatarFee() {
        Movie avatar = factory.createAvatarMovie();
        return avatar.getFee();
    }
}
```
![KakaoTalk_20220728_2013231020](https://user-images.githubusercontent.com/70372188/181492245-fd872ddf-509f-4bc0-8c8d-00c664b6babe.jpg)

```java
PURE FABRICATION:
책임 주도 설계에서는 정보 전문가 패턴을 사용하여 객체에게 책임을 할당했다. 
정보 전문가 패턴은 보통 높은 응집도와 낮은 결합도, 캡슐화를 지킬 수 있게 도와준다.
PURE FABRICATION은 정보 전문가 패턴을 할당한 결과가 바람직하지 않을 경우 대안으로 사용할 수 있는 패턴이다. 
도메인 상에는 존재하지 않지만 순수하게 전체 설계의 품질을 높이기 위해 추가된 가공물이다.
```
> 의존성 주입
```java
//생성자에서 생성이 이루어지지 않고있다. 외부의 다른 객체가 Movie에게 생성된 인스턴스를 전달해야 한다는 것을 의미한다.
public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
    this.title = title;
    this.runningTime = runningTime;
    this.fee = fee;
    this.discountPolicy = discountPolicy;
}
```
> 숨겨진 의존성은 지양하라
```java
객체의 퍼블릭 인터페이스에 노출하라. 의존성을 구현 내부에 숨기면 숨길수록 코드를 이해하기도, 수정하기도 어려워진다.
내부 구현을 이해할 것을 강요하는 순간 숨겨진 의존성은 캡슐화를 위반하게 된다.
```
> 의존성 역전 원칙(Dependency inversion principle, DIP)
```java
/**
 * 상위 수준 클래스인 Movie가 하위 수준 클래스인 AmountDiscountPolicy에 의존한다.
 * Movie와 관계를 가져야 하는 본질은 영화의 가격을 계산하는 것이다. 어떻게 할인 금액을 계산할 것인지는 본질이 아니다.
 *
 * 문제점
 * 1. 재사용성 문제 발생. 하위 수준 클래스도 같이 재사용해야 한다.
 * 2. 하위 수준의 변경으로 상위 수준이 변경되서는 곤란하다.
 */
public class Moive {
    private AmountDiscountPolicy discountPolicy;
}
```
의존성은 하위 수준(AmountDiscountPolicy)에서 상위 수준(Moive)으로 향해야하며, 
상위 수준의 클래스는 하위 수준의 클래스에 의존하면 안된다.

- 해결책: `추상화`에 의존하라
유연하고 재사용 가능한 설계를 원한다면 모든 의존성의 방향이 추상 클래스나 인터페이스와 같은 추상화를 따라야 한다.
구체 클래스(Movie)는 의존성의 시작점이어야한다. 의존성의 목적지가 돼서는 안 된다.
```
    Movie(의존성 시작) ----------> DiscountPolicy(의존성 목적지)
                                       |
                               -------------------
                               |                 |
                            Amount            Percent
                        DiscountPolicy     DiscountPolicy
                        
Movie와 AmountDiscountPolicy 모두 추상 클래스인 DiscountPolicy에 의존하고 있다.
다시 말해서 상위 수준의 클래스와 하위 수준의 클래스 모두 추상화에 의존한다.

이를 의존성 역전 원칙(DIP)이라고 부른다. 역전이 붙은 이유는 그동안의 프로그래밍에서는 상위 모듈에서 하위 모듈에 의존하는 경향이 있었는데,
이 의존 관계를 하위 모듈에서 상위 모듈에 의존하도록 역전시켰기 때문이다.
```
# Chapter10 상속과 코드 재사용

> 중복 코드의 문제점
```java
코드를 읽는 사람들에게 중복 코드가 정말 동일한 코드인가? 실수인가? 의도적인가? 등 여러가지 의심을 생성시킨다. 
하지만 가장 큰 이유는 중복 코드는 변경을 방해한다는 것이다.
```

> DRY(Dont Repeat Yourself)
```java
코드 안에 중복이 존재해서는 안된다. 객체 지향 프로그래밍에서 코드의 중복을 제거하기 위해 상속을 사용한다.
```

> 구체 클래스 상속의 문제점
```java
1. 자식 클래스의 메서드 안에서 super 참조를 이용해 부모 클래스의 메서드를 직접 호출할 경우 두 클래스는 강하게 결합된다. 
   객체를 사용하는 이유는 구현과 관련된 세부사항을 퍼블릭 인터페이스 뒤로 캡슐화할 수 있기 때문이다. 하지만 상속을 사용할 경우
   자식 클래스는 부모 클래스의 구현 세부사항에 의존하게 되기 때문에 캡슐화를 약화시킨다. 

2. 상속받은 부모 클래스의 메서드가 자식 클래스의 내부 구조에 대한 규칙을 깨트릴 수 있다.

3. 클래스를 상속하면 자식 클래스와 부모 클래스는 동시에 변경될 수 밖에 없다.
```

> 추상화에 의존하라
```java
public abstract class Phone {
    private List<Call> calls = new ArrayList<>();
    private double taxRate;

    public Phone(double taxRate) {
        this.taxRate = taxRate;
    }

    //1st. 자식 클래스들 간 공통 코드를 가지는 메서드가 존재한다면, 차이점을 메서드로 추출하고(calculateCallFee) 자식 클래스에 남긴다.
    //2nd. 중복 코드(calculateFee)는 부모 클래스(AbstractPhone)로 옮긴다.
    //3rd. 중복 코드(calculateFee)를 부모 클래스에서 추상 메서드로 사용함으로써 재사용성과 응집도를 높인다.
    //요약: 차이에 의한 프로그래밍 사용(차이점->자식 클래스, 공통점-> 부모 클래스)
    public Money calculateFee() {
        Money result = Money.ZERO;

        for(Call call : calls) {
            result = result.plus(calculateCallFee(call));
        }

        return result.plus(result.times(taxRate));
    }

    //자식 클래스들의 calculateCallFee() 시그니처는 같지만 구현이 서로 다르기 때문에 시그니처만 부모 클래스로 이동한다. -> 추상 메서드로 변경
    protected abstract Money calculateCallFee(Call call);
}
```
```java
public class NightlyDiscountPhone extends Phone {
    ...
    @Override
    protected Money calculateCallFee(Call call) {
        if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
            return nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds());
        }

        return regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
}
```
```java
public class RegularPhone extends Phone {
    ...
    @Override
    protected Money calculateCallFee(Call call) {
        return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
}
```



```java
 구체 클래스 의존 -> 추상 클래스 의존

 장점1:
 자식 클래스들은 이제 추상 메서드인 calculateCallFee() 에만 의존하면 되므로 결합도가 낮아진다.

 장점2(SRP):
 Phone 은 전체 통화 목록 계산, RegularPhone 은 일반 요금 한 건 계산, NightlyDiscountPhone 은 심야 요금 한 건을 계산
 하는 방식이 바뀔 경우에만 변경의 이유를 가진다. 이 클래스들은 단일 책임 원칙을 준수하므로 응집도가 높아진다.

 장점3(DIP):
 의존성의 방향이 세부적인 계산 방식인 하위정책(NightlyDiscountPhone)에서 상위정책(Phone)으로 향한다.
 의존한다는 추상 클래스 혹은 인터페이스를 상속받는 경우도 포함한다.

 장점4(OCP):
 새로운 요금제가 필요하다면 Phone 을 상속받는 자식 클래스를 추가하고 calculateCallFee()만 오버라이딩 하면 된다.
 다른 클래스는 수정할 필요가 없다.

 하지만 부모 클래스에 새로운 인스턴스 필드(taxRate)가 생길 경우에는 자식 클래스에서도 생성자 코드를 수정해야 한다. 
```
![KakaoTalk_20220803_125202665](https://user-images.githubusercontent.com/70372188/182520505-99d275d7-7323-420b-a9cd-ba06ec43e83a.jpg)

# Chapter11 합성과 유연한 설계
> 상속의 문제점
```java
상속을 사용하여 요금 정책 로직을 작성한 경우 하나의 기능을 추가하기 위해 필요 이상으로 많은 수의 클래스가 생성됐다.
이를 클래스 폭발이라고 부른다. 

클래스 폭발 문제는 자식 클래스가 부모 클래스의 구조에 강하게 결합되도록 강요하는 상속의 근본적인 한계 때문에 발생하는 문제다.
우리는 컴파일타임 의존성과 런타임 의존성의 거리가 멀수록 설계가 유연해진다는 사실을 알고있다.
부모와 자식의 관계(TaxableRegularPhone.class)가 컴파일타임에 결정되므로 둘 사이의 관계는 변경될 수 없다.
상속을 사용한다면, 재사용과 수정은 사실상 불가능하다. 상속을 포기하고 합성을 사용하자.

보통 상속 관계를 is-a 관계라고 부르고 합성 관계는 has-a 관계라고 부른다.
```

> 합성
```java
합성을 사용하는 이유는 크게 두 가지다.

- 런타임에 객체의 관계를 변경할 수 있다. 객체를 생성하는 시점에 생성자를 통해 인스턴스에 대한 의존성을 주입받기 때문이다.
 
- 내부에 포함되는 객체의 구현이아닌 퍼블릭 인터페이스에 의존하기 때문에, 내부 구현이 변경되더라도 영향을 최소화할 수 있다.



public class Phone {
    private List<Call> calls = new ArrayList<>();

    //합성 객체인 RatePolicy는 런타임에 생성자로 의존성을 주입받아야 하기 때문에 인터페이스나 추상 클래스를 사용해야 한다.
    private RatePolicy ratePolicy;
    
    //Phone은 합성 객체인 RatePolicy의 퍼블릭 인터페이스인 calculateFee()에만 의존하면 된다.
    //상속과 다르게 합성으로 엮여있는 두 클래스는 낮은 결합도를 가질 수 있다.
    public Money calculateFee() {
        return ratePolicy.calculateFee(this);
    }
```

```java
합성은 조합을 구성하는 요소들을 개별 클래스로 구현한 후 실행 시점에 인스턴스를 조립하는 방법을 사용하는 것이다.

RegularPolicy regularPolicy = new RegularPolicy(Money.wons(30), Duration.ofSeconds(50));
RateDiscountablePolicy rateDiscountablePolicy = new RateDiscountablePolicy(regularPolicy, Money.wons(3000));
TaxablePolicy taxablePolicy = new TaxablePolicy(rateDiscountablePolicy, 0.05);
Phone phone = new Phone(taxablePolicy);
```

# Chapter12 다형성
> 상속
```
상속을 사용하는 이유는 상속이 클래스들을 계층으로 쌓아 올린 후 상황에 따라 적절한 메서드를 선택할 수 있는 
메카니즘을 제공해주기 때문이다.

데이터 관점의 상속: 
상속을 이용하면 부모 클래스에서 정의한 모든 데이터를 자식 클래스의 인스턴스에 자동으로 포함시킬 수 있다.

행동 관점의 상속:
부모 클래스에서 정의한 일부 메서드 역시 자동으로 자식 클래스에 포함시킬 수 있다.
```

> 업캐스팅과 동적 메서드
```java
동일한 메세지를 수신받아도 서로 다른 메서드가 실행 될 수 있는 이유는 업캐스팅과 동적 메서드 메커니즘이 존재하기 때문이다.

업캐스팅: 부모 클래스 타입으로 선언된 변수에 자식 클래스의 인스턴스를 할당하는 것이 가능하다.

//대입문
Lecture lecture = new GradeLecture(...);

//메서드의 파라미터
public class Professor {
    public Professor(String name, Lecture lecture) { ... }
}
Professor professor = new Professor("다익스트라", new GradeLecture(...));


동적 바인딩: 메세지를 수신하는 객체의 타입에 따라 실행되는 메서드가 결정된다. 
메세지를 처리할 적절한 메서드를 컴파일 시점이 아닌 런타임에 결정하기 때문에 가능하다.

foo.bar()라는 코드를 읽는 것만으로는 실행되는 bar가 어떤 클래스의 어떤 메서드인지를 판단하기 어렵다.
foo가 가르키는 객체가 실제로 어떤 클래스의 인스턴스인지를 알아야 하고 bar 메서드가 해당 클래스의
상속 계층의 어디에 위치하는지를 알아야 한다.
이처럼 실행될 메서드를 런타임에 결정하는 방식을 동적 바인딩이라고 부른다.
```

> 메서드 선택 과정
```
1. 메세지를 선택한 객체는 자신을 생성한 클래스에 적합한 메서드가 존재하는지 검사한다. 존재하면 실행하고 종료.
2. 메서드를 찾지 못했다면 부모 클래스에서 메서드 탐색을 계속한다. 이 과정은 상속 계층을 따라 계속 진행된다.
3. 최상위 계층에 이르러도 메서드가 없다면 예외를 발생시키고 탐색을 종료한다.

메서드 탐색은 두 가지 원리로 구성된다.

첫 번째 원리는 자동적이 메세지 위임이다. 자식 클래스는 자신이 이해할 수 없는 메세지를 전송받은 경우
상속 계층을 따라 부모 클래스에서 처리를 위임한다.

두 번째 원리는 메서드를 탐색할 때 동적인 문맥을 사용한다는 것이다.
이 문맥은 실행시점에 self 참조를 이용하여 결정된다.
```

> self와 super
```java
self:
객체가 메세지를 수신하면 컴파일러는 self 참조라는 임시 변수를 자동으로 생성한 후 
메세지를 수신한 객체를 가르키도록 설정한다. 동적 메서드 탐색은 self가 가리키는 객체의
클래스에서 시작해서 상속 계층의 역방향으로 이뤄지며 메서드 탐색이 종료되는 순간
self 참조는 자동으로 소멸된다.

Lecture lecture1 = new Lecture(...); -> self: Lecture
Lecture lecture2 = new GradeLecture(...); -> self: GradeLecture

이 self에 따라서 메서드 탐색을 위한 문맥이 동적으로 바뀐다.

lecture1의 메서드 탐색 문맥: Lecture ~ Object 클래스
lecture2의 메서드 탐색 문맥: GradeLecture ~ Object 클래스



public class Lecture {
   
   public String stats() {
       //만약 현재 객체에게 메세지를 전송하는 경우 메서드는 self 참조 객체에서부터 탐색을 재시작한다.
       retrun String.format(getEvaluationMethod());
   }

   public String getEvaluationMethod() {
        ...
    }
}

```
![KakaoTalk_20220811_134733520](https://user-images.githubusercontent.com/70372188/184066435-6b70387d-3e4f-4cbc-96bf-dd224b0b8b1c.jpg)

```
super:
self 참조는 메세지를 수신한 객체의 클래스에 따라 메서드 탐색을 위한 문맥이 실행시간에 동적으로 결정된다.
하지만 이와 반대로 컴파일 시간에 결정되는 속성이 있다. 바로 super 이다.

super 참조는 부모 클래스에 정의된 메서드를 실행하기 위한 것이 아니다.
super 참조의 정확한 의도는 부모 클래스에서부터 메서드 탐색을 시작하라는 것이다.
super 참조는 부모 클래스의 코드에 접근할 수 있게 함으로써 중복 코드를 제거할 수 있다.
```
# CHAPTER13 서브클래싱과 서브타이핑
> 
```
객체의 퍼블릭 인터페이스가 객체의 타입을 결정한다. 따라서 동일한 퍼블릭 인터페이스를 제공하는 객체들은 동일한 타입으로 분류된다.

타입 계층에서 더 일반적인 타입을 슈퍼타입이라고 부르고 더 특수한 타입을 서브타입이라고 부른다.

슈퍼타입은 서브타입이 정의한 퍼블릭 인터페이스를 일반화시켜 으로 범용적이고 넓은 의미로 정의한 것이다.
서브타입은 슈퍼타입이 정의한 퍼블릭 인터페이스를 특수화시켜 상대적으로 구체적이고 좁은 의미로 정의한 것이다.

서브타입 객체는 슈퍼타입의 객체로 간주될 수 있다. 즉, 동일한 퍼블릭 인터페이스를 가지고 있어야 한다.
```
> 상속을 통한 서브타입 구현
```java
1. is-a 관계에 너무 집착하지 마라.
- 펭귄은 새다.
- 새는 날 수 있다.

public class Bird {
    public void fly() { ... }
}

public class Penguin extends Bird {
    ...
}

이 예시를 통해 어휘적인 정의로 타입 계층을 구현할 경우 잘못된 클래스를 만들 수 있다는 사실을 알 수 있다.
단어의 어휘적인 관계가 아닌 두 클래스의 행동이 호환될 수 있느냐 아니냐를 고려하자.
```

```java
2. 클라이언트의 관점에서 행동의 호환 여부를 판단하라.

어떤 클라이언트는 객체가 fly라는 메세지를 수신받을 수 있기를 기대하고 또 다른 클라이언트는
walk라는 메세지를 수신받을 수 있기를 기대할 수 있다. 어쩌면 두 메세지 둘다 수신받을 수 있기를
기대할 수도 있다.

클라이언트가 기대하는 바에 따라 인터페이스를 분리하는 방식으로 상속 계층을 구현하자.
구체 클래스보다 인터페이스를 사용할 경우 구현이 아닌 퍼블릭 인터페이스에만 결합되기 때문에
더 낮은 결합도를 가지게 된다.

클라이언트의 요구는 언제든지 변경될 수 있다. 인터페이스를 분리할 경우 변경의 파급 효과를 
효과적으로 제어할 수 있다.

이처럼 인터페이스를 클라이언트의 기대에 따라 분리함으로써 변경에 의한 영향을 제어하는 설계 원칙을 
인터페이스 분리 원칙(ISP)이라고 부른다.

클라이언트 관점에서 두 클래스에게 전송할 수 있는 메세지와 기대하는 행동이 서로 같으면
두 클래스를 상속 관계로 연결할 수 있다.
```

> 서브클래싱과 서브타이핑
```
서브클래싱: 다른 클래스의 코드를 재사용할 목적으로 상속을 사용하는 경우를 가르킨디.
자식 클래스와 부모 클래스의 행동이 호환되지 않기 때문에 자식 클래스의 인스턴스가 부모 클래스의 인스턴스를 대체할 수 없다.

서브타이핑: 자식 클래스의 인스턴스가 부모 클래스의 인스턴스를 대체할 수 있다.
부모 클래스가 슈퍼타입이 되고 자식 클래스가 서브타입이 된다.

슈퍼타입과 서브타입 관계에서 제일 중요한 것은 퍼블릭 인터페이스이다.
서브타입이 최소한 슈퍼타입이 정의한 퍼블릭 인터페이스와 동일하거나 더 많은 오퍼레이션을 포함할 경우
슈퍼타입 인스턴스를 요구하는 모든 곳에서 서브타입의 인스턴스를 대신 사용할 수 있다.

서브타입이 되기 위해서는 행동 호환성과 대체 가능성을 충족시켜야 한다.
행동 호환성은 서브타입이 슈퍼타입이 하는 모든 행동을 동일하게 할 수 있는 것이고
대체 가능성은 부모 클래스를 새로운 자식 클래스로 대체하더라도 시스템이 문제없이 동작할 것을 보장해야 한다.

올바른 서브타이핑 상속관계에서 자식 클래스는 부모 클래스가 사용되는 모든 문맥에서 부모 클래스와 동일하게 행동할 수 있다.
이는 리스코프 치환 원칙(LSP)에 해당한다.

LSP: "S형의 각 객체 o1에 대해 T형의 객체o2가 하나 있고, T에 의해 정의된 모든 프로그램 P에서 T가 S로 치환될 때,
P의 동작이 변하지 않으면 S는 T의 서브타입이다."
```

- CHAPTER8 코드
```java
public class OverlappedDiscountPolicy extends DiscountPolicy {
    private List<DiscountPolicy> discountPolicies = new ArrayList<>();

    public OverlappedDiscountPolicy(DiscountPolicy ... discountPolicies) {
        this. discountPolicies = Arrays.asList(discountPolicies);
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        Money result = Money.ZERO;
        for(DiscountPolicy each : discountPolicies) {
            result = result.plus(each.calculateDiscountAmount(screening));
        }
        return result;
    }
}
```
![KakaoTalk_20220813_164430067](https://user-images.githubusercontent.com/70372188/184474467-29fad4ab-3b83-47f2-b398-87c29d6cad73.jpg)

# CHAPTER14 일관성 있는 협력

재사용을 위해 객체들의 협력 방식을 일관성 있게 만들어아 햔다. 객체들의 협력이 전체적으로 일관성 있는 유사한 패턴을 따른다면 시스템을 이해하기 쉬워진다.









