package com.pipiolo.lec16

class Lec16Main {
}

// 1. 확장 함수
// 코틀린은 자바와 100% 호환을 목표!!
// 기존 자바 코드위에 자연스럽게 코틀린을 추가할 수 없을 까??
// 자바로 만들어진 라이브러리에 코틀린 코드르 덧붙이고 싶다.
// 어떤 클래스 안에 있는 메서드처럼 호출할 수 있지만, 함수는 밖에 만들 수 있게 하자.

// 함수의 코드 자체는 클래스 밖에 있지만, 마치 클래스 안 메서드를 호출하는 것처럼 사용할 수 있
// 이것이 바로 확장 함수

// 마치 스트링 클래스 안에 있는 메서드 것처럼 동작하기!!
fun String.lastChar(): Char { // String.XXXX()
    return this[this.lastIndex]
}

// fun 확장하려는 클래스.함수이름(파라미터): 리턴타입 { 수신객체 타입 : 확장하려는 클래스
// this 를 이용해 실제 클래스 안의 값에 접근한다.
// 이런 this 를 수신 객체라 한다.
//}

// 마치 기존 스트링 함수 메서드 처럼 사용 가능하다.
fun main() {
    val str = "ABC"
    print(str.lastChar())
}

// 았! 만약에 확장함수가 public 이고 수신 객체 클래스의 private 를 가져오면 캡슐화가 깨지는 것이 아닐까?
// 맞다! private 이 외부에 노출되므로 캡슐화가 깨진다!
// 따라서 확장함수는 클래스에 있는 private, protected 를 애초에 가져올 수 없다.
// 만약 확장함수의 이름과 수신 객체의 원래 메서드 이름이 겹치면 어떻게 될 까??

// 이 때는 멤버함수가 우선적으로 호출된다.
class Person (
    var age: Int
    ) {

    fun nextYearAge(): Int {
        println("멤버 함수!~!")
        return this.age + 1;
    }
}

fun Person.nextYearAge(): Int {
    println("확장 함수!~!")
    return this.age + 1;
}

fun main2() {
    var person = Person(10)
    person.nextYearAge() // 멤버 함수의 메서드가 호출된다.
}

// 만약 내가 확장함수를 먼저 만들었는데
// 뒤 늦게 똑같은 시그니쳐의 멤버 함수가 생기면 오류가 발생할 수 있다.

// 확장함수 오버라이드??
// 인스턴스가 중요하지 않고 해당 변수의 현재 타입에 의해 어떤 확장 함수가 호출될지 결정된다.

// 자바에서 코틀린 확장 함수를 어떻게 쓸가??
// 마치 정적 메서드를 호출하는 것처럼 호출 가능하다.

// 확장 함수는 확장 프러퍼티와 연결된다.
// 확장함수 + custom getter == 확장 프로퍼티

// 2. 중위 함수! infix
// 함수를 호출하는 새로운 방법 // 새로운 종류의 함수가 아니다.
// downTo, step 도 함수이다. 종위 호출 함수
// 변수.함수이름(매개변수) 대신에
// 변수 함수이름 매개변수 로 사용한다.

fun Int.add(other: Int) : Int {
    return this + other
}

infix fun Int.add2(other: Int): Int {
    return this + other
}

fun main3() {
    3.add(4)

    3 add2 4 // 중위 함수
}

// 인픽스는 멤버 함수에서도 가능하다.

// 3. inline  함수
// 함수가 호출되는 대신에, 함수를 호출한 지점에 한수 본문을 그대로 복붙하고 싶은 경우에 사용하낟.

inline fun Int.add3(other: Int): Int {
    return this + other;
}

fun main4() {
    3.add3(4)
}

// 이렇게 하면 컴팡리 했을 때,
// 함수를 호출하는 형태가 아니라, 변수에 함수 로직을 넣는 형태가 된다.
// int a = a + b 이런 식으로 컴파일된다.
// 왜 사용하느냐??
// 함수는 파라미터로 전달될때 오버헤드가 발생하는데 이를 줄일 수 있다.
// 콜 체인에 의해 오버헤드 발생

// 이 오버헤드를 감소시키기 위해 해둔다
// 이거는 성능 측정과 함게 주의해서 사용해얗 ㅏㄴ다.
// 코틀린에서는 몇몇 함수들이 인라인으로 선언되어 있따.

// 4. 지역함수
// 함수 안에 함수를 선언할 수 있다.

fun createPerson(firstName: String, lastName: String): Person {
    fun validateName(name: String) {
        if (name.isEmpty()) {

        }
    }

    validateName(firstName)
    validateName(lastName)

    return Person(1)
}

// 함수를 호출하고 싶은 데 해당 함수에서만 사용할 때! 사용한다.
// 뎁스가 깊어지고 코드가 깔끔하지 않다. -> 잘 사용하지 않는다.