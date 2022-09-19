package com.pipiolo.lec11

val num = 3

fun add(a: Int, b: Int): Int {
    return a + b;
}

class cat private constructor(){

}

// Kotlin
// public :
// protected : 선언된 클래스 또는 하위 클래스에서만 접근 가능 -> 자바의 같은 패키지가 삭제됨.
// 코틀린은 패키지를 namespace 를 관리하기 위한 용도로만 사용함. 가시성 제어에는 사용되지 않는다.
// default -> internal : 같은 모듈에서만 접근 가능하다.
// 마찬가지로 default 는 같은 패키지메서만 접근 가능한데 코틀린에서 패키지는 단순 namespace 를 관리하기 위한 용도
// 모듈 : 한 번에 컴파일 되는 코틀린 코드  ex) IDEA, Maven, Gradle Module 을 말함
// private :
// 나머지 퍼블릭, 프리베이트느 ㄴ동일하다.

// 자바의 기본 접근 지시언는 default
// 코틀린은 public

// 코틀린은 .kt 파일에 변수, 함수, 클래스 여러개 선언 가능하다.
// 여기서 말한 변수, 함수는 특정 클래스에 종속되어 있지 않는 것을 말한다.

// protected : 파일에서는 사용 불가능 -> .kt 파일 안에 있는 클래스 안에서만 사용 가능하다.
// 나머지는 어디서든 사용 가능

// 클래스 접근 지시어는 자바랑 동일하다.
// 생성자 접근 지시어는 자바랑 동일하다.
// 단, 생성자 접근 지시어를 사용하기 위해서는 constructor 지시어를 생략할 수 없다.
// 기존에는 public 과 함께 construcot 지시어를 생략했었는데 생성자 접근 지시어를 사용하기 위해서는 생략이 불가능하다.

// 생성자에서 접근 지시어를 붙이는 이유 중 하나인
// 자바에서 유틸성 코드를 만들 떄, 추상 클래스와 private 생성잘르 통해 외부에서 인스턴스화 하는 것믈 막았다.
// 코틀린도 비슷하게 가능하지만,
// 코틀린은 그럴 이유가 없다. 왜? 클래스 없이 함수가 작성이 가능하므로 -> StringUtil.kt 파일 ㄱ



// 프로퍼티도 접근 지시어는 자바와 동일하다.
// 코틀린이 프로퍼티 접근 제어는 2가지 방법이 있다.
// 기본의 자바 처럼 필드에 public, private 등 접근 지시어를 붙여서 생성되는 프로퍼티 getter, setter 도 한번에 접근 지시어를 정하거나
// custom getter, custom setter 를 활용해 특정 메서드만 접근 지시얼르 바꿀수 있다.

class Car (
    internal val name: String,
    private val owner: String,
    _price: Int
) {

    var price = _price // public 생략되어 있기 때문에 -> getter 는 퍼블릭이다.
    private set

}

// 자바와 코틀틴을 함께 사용할 뙤 주의할점
// 코틀린의 internal 은 바이트 코드 상 퍼블릭이 된다.
// 떄문에 자바에서 코틀린 모듈의 internal 코드를 가져올 수 있다.

// 자바의 protected 와 코틀린의 의미가 다르다.
// 자바는 같은 패키지의 코틀린 protected 멤버에 접근할 수 있따.
