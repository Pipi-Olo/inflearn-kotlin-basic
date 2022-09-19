package com.pipiolo.lec14

import kotlin.contracts.contract

class Lec14Main {
}

// 1. Data class
// 소위 말하는 DTO 객체를 말한다.
// 필드 생성자 getter equasl, hashcode, tostring 등 의 함수를 가지고 있다.
// 주로 IDE, 롬복을 활용하지만 어찌됐든 추가적인 처리가 필요하다는 단점이 있다.

// 코틀린은 data 키워드를 붙이게 되면
// 자동으로 equasl, hashcode, tostring 메서드를 만들어 준다.

data class PersonDto(
    private var name: String,
    private var age: Int
)

// 필더 패턴까지 활용하게 되면
// builder, equasl, hashcode, tostering 을 만들어준다.
// 자바는 JDK 16 부터 recored 클래스 도입

// 2. Enum class

enum class Country(
    private var code: String
) {
    KOREA("KO"),
    AMERIACE("US")
    ;
}

// Lec05. when 은 Enum 클래스와 함께 쓰면 효과가 더 좋아진다.
// 자바에서는 if 문을 통해 비교하는 로직을 추가해야 하고 틁지 else 가 고민이 된다.
// 이넘 클래스에 의해 해당 값이 아닌 값들이 올 수가 ㅇ벗다.
// 이 떄 엘스에서 열외를 던질지 널을 던질지 아니면 엘스 자체를 없애야 할지 고민이 생긴다.

// 하지만, 코틀린에서는 애초에 이넘 클래스에 한국과 아메리카만 있기 땜누에 엘스를 작성할 필요가ㅣ 없다.
// 더 쩌는 ㄴ것은 만약 내가 이넘 클래스에 새로운 이넘 값을 추가 하게되면
// 컴파일러가 알아서 경고를 내보내준다. 너 이넘에 새로 하나 추가 됬는데 when 로직에는 2개 밖에 없어~ 라고!

fun handleCountry(country: Country) {
    when (country) {
        Country.KOREA -> TODO()
        Country.AMERIACE -> TODO()
    }
}

// 3. Sealed CLass, Sealed Interface
// 상속이 가능한 추상클래스를 만들까 하는데, 외부에서는 이 클래스를 상속받지 않게 하도록!
// 컴파일 타임 때 하위 클래스 타입을 모두 기억한다.
// 즉 런타임일 떄 클래스 타입이 추가될 수 없다.
// 하위 클래스는 같은 패키지에 있어야 하낟.
// 이넘과 다른점
// - 클래스를 상속받을 수 있다.
// - 하위 클래스는 멀티 인스턴스가 간읗다ㅏ.

sealed class HyundaiCar(
    private var name: String
)

// 마찬가지로 when 과 같이 사용될 때 혀과가 지린다.


//fun test(car: HyundaiCar) {
//    when(car) {
//        is XXX
//        is XXX
//        is XXX
//    }
//}

// 이런 식으로 지린다.
// 참고로 자바에서는 JDK 17 에서 추가되었다./