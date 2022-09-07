package com.pipiolo.lec09

class Person constructor(name: String, age: Int) {

    val name = name // 타입 추론이 가능하기 때문에 생략가능하다.
    var age = age
}

// 자바에서는 프로퍼티 == 필드 + getter + setter
// 코틀린에서는 필드만 만들면 getter + setter 를 자동으로 생성해준다.

class Person2(name: String, age: Int) { // constructor 지시어 생략 가능하다.

    val name = name // 타입 추론이 가능하기 때문에 생략가능하다.
    var age = age
}

class Person3(
    val name: String,  // 코틀린은 생성자에서 프로퍼티를 선언할 수 있다.
    var age: Int) {

}

fun main() {
    val person = Person("강호동", 100)
    println(person.name) // 코틀린은 필드명을 통해 프로퍼티를 호출할 수 있다. getName() 으로 동작한다.
    person.age = 10

    val javaPerson = JavaPerson("유재석", 33)
    println(javaPerson.age) // 또한 코틀린에서 자바를 가져다 쓸 때에도 . 을 통해 getter seter 가져다 쓸 수 잇다.

    main2()
}

// 자바는 생성자에서 로직을 추가해서 검증이 가능하다.
// 코틀린은 생성자에서 어떻게 로직을 추가하지??

class Person4(
    val name: String,
    var age: Int
) {
    init { // 클래스가 초기화 되는 시점에 1번 호출되는 블록 + 생성자를 호출할 떄 시작되는 로직
        if (age <= 0) {
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다.")
        }
    }
}

// 자바에서는 생성자를 여러개 만들 수 있다. 코틀린은??

class Person5(
    val name: String, // 주 생성자 -> 반드시 존재햐아 한다. 단, 파라미터가 하나도 없는 NoArgs 라면 생략 가능하다.
    var age: Int
) {
    init {
        if (age <= 0) {
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다.")
        }
    }

    constructor(name: String): this(name, 1) // constructor 를 통해 생성자를 여러개 호출할 수 있다. 자바와 동일하게 this() 를 호출하면 생성자가 호출된다.
    // 부생성자 -> 있을 수도 있고 없을수도 있다. 최종적으로 반드시 this() 를 호출해서 생성자를 마무리 해야 한다.
    constructor(): this("홍길동") {
        println("WOW") // 부 생성자는 바디를 가질 수 있다.
    }
}

class Person6(
    val name: String,
    var age: Int
) {
    init {
        println("init")
    }

    constructor() : this("홍길동") {
        println("매개변수가 없는 부 생성자")
    }

    constructor(name: String) : this(name, 1) {
        println("매개변수가 하나만 있는 부 생성자")
    }
}

fun main2() {
    val person = Person6()
}

// 초기화 블록 -> 매개변수가 하나만 있는 부 생성자 -> 매개변수가 없는 부 생성자 순으로 호출된다.
// 즉 주 생성자에서 가까운 순으로 호출된다고 생각하면 된다.

// 하지만 코틀린은 부생성자 보다는 default paramenter 를 통해 기본 값을 설정하는 것울 권장한다.
class Person7(
    val name: String = "홍길동",
    var age: Int = 3
)

// Converting 과 같이 어쩔 수 없이 부생성자 로직이 필요한 경우에는 정적 팩토리 메서드를 사용하는 것이 좋다.
// 사실상 부 생성자 를 사용하는 일이 거의 없다. 정적 팩토리 메서드를 사용하면 된다.


// 클래스 내 메서드 선언
// 자바처럼 동일하게 선언 가능하다.
// 하지만 다른 방법도 존재한다.
// custom getter 마치 프로퍼티가 있는 것처럼 동작 가능하다.
class Person8(
    val name: String = "홍길동",
    var age: Int = 3
) {
    fun isAdult(): Boolean { // 자바처럼 클래스 내 메서드 선언
        return this.age >= 20
    }

    val isAdult2: Boolean   // custom getter 마치 프로퍼티처럼 보이게 한다. 그래ㅔ서 get이 동작하면 해당 로직이 동작한다.
        get() {
            return this.age >= 20 // 이것처럼 하나의 Expression 이면 된다.
        }

    val isAdult3: Boolean
        get() = this.age >= 20 // 처럼 블록과 리턴 생략가능하다.
}
// 해당 코드를 자바로 변환시키면
// 함수로 선언하나 변수처럼 동작시키나 모드 같은 로직으로 동작한다.

// 사실상 동일한 기능이다. 표현 방법 (가독성) 만 다를 뿐이다. 어차피 둘다 함수이다.
// 객체의 속성을 나타내는 거라면 custom getter 를 사용하고 isAdult -> 그 사람이 어른이니>? 속성처러 ㅁ확인 -> custom getter
// 그렇지 않은 경우에는 메서드를 선언한다.

// 커스텀 게터는 자기 자신도 변형 간으
// name 을 조회할 때 무조건 대문자로 표기한다.

class Person9(
    name: String = "홍길동", // 주 생성자에서 변수를 선언하면 자동으로 해당 필드에 대한 프로퍼티를 만들어 준다. 따라서 변수 선언을 안 하면 안 만들어 준다.
    var age: Int = 1
) {
    val name = name // this.name = name
        get() = field.uppercase() // 그냥 name 을 사용하면 this.name 으로 동작한다.
                                  // 여기서 문제가 생긴다.
                                  // name 을 부르면 get() 가 동작하고
                                  // get() 이 동작하면 name 을 찾게 된다. -> 무한루프 발생
                                  // 이런 무한루를 방지하기 위한 예약어가 field 이며 자기 자신을 가리킨다. 즉 가리키는 것은 this.name 이 동일하지만 무한 루프를 막아준다.
                                  // 이러한 것을 backing filed 라 한다. 자기 자신을 가리키는 보이지 않는 필드
                                  // 하지만 이런 커스텀 게터에 backing filed  를 사용하느 ㄴ경우느 드물다. 왜> 다음에서 설명한다.
                                  // 왜냐하면 커스텀 게터에서 백킹 필드를 쓴다는 것은 마치 프로퍼티가 존재하기 위해 쓰느 ㄴ것이 아니라 진짜 존재하는 프러퍼티에 대해서 쓰는 것이다.
                                  // 왜냐하면 백킹 필드가 자기 자신을 가리키는 것이기 때문에 실제 필드가 존재해야 하기 때문이다.
                                  // 즉 메서드를 마치 실제 필드가 존재하는 것처럼 보여주는 커스텀 게터를
                                  // 실제 필드에 적용하는 꼴이니 잘 사용하지 않는다. 차라리 다음과 같이 커스텀 게터와 + this 의 조합으로 해결할 수 있다.
}

class Person10(
    val name: String = "홍길동",
    var age: Int = 1
) {
    val uppercaseName: String
        get() = this.name.uppercase() // 이런 식으로 사용한다.
}

// 이번에는 setter 를 직접 만들어 보겠다.
class Person11(
    name: String = "홍길동",
    var age: Int = 1
) {
    var name = name
        set(value) { // value : 밖에서 들어오는 파라미터
            field = value.uppercase()  // 여기서도 커스텀 세터엣도 필드 사용한다.
        }
}

// 하지만 일반적으로 세터 자체를 지양하고 있다.
// 커스텀 세터 도 잘 안 쓴다.