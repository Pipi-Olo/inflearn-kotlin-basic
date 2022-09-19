package com.pipiolo.lec10

abstract class Animal (
    protected val species: String,
    protected open val legCount: Int // 코틀린은 오버라이드하기 위해서는 open 예약어를 무조건 붙여줘야 한다. 즉, species 는 하위 클래스에서 오버라이드 할 수 없다.
                                     // open 을 안 붙이면 아예 못 사용한다는 의미가 아니다. 하위 클래스에서 오버라이드 할 수 없다는 것이다.
) {
    abstract fun move()
}

class Cat (
    species: String
) : Animal(species, 4) {   // 코틀린은 : 을 통해서 상속한다. 코틀린은 무조건 바로 상위 클래스의 생성자를 바로 호출해야 한다.

    override fun move() {           // 코틀린은 override 가 애노테이션이 아닌 예약어로 존재하낟. 필수적으로 붙여야 한다.
        println("고양이가 움직인다.")
    }
}

class Penguin (
    species: String
) : Animal(species, 2) {

    private val wingCount: Int = 2

    override fun move() {
        println("펭귄이 움직인다.")
    }

    override val legCount: Int                  // legCount 프로퍼티를 오버라이드 한다. -> getLegCount() 메서드
        get() = super.legCount + this.wingCount // 상위 클래스에 super 키워드로 접근한다.
}

// 자바와 동일하게 추상 클래스는 인스턴스화 할 수 없다.

class Penguin2 (
    species: String
) : Animal(species, 2), Flyable, Swimable { // 클래스 상속, 인터페이스 구현 모두 : 를 사용한다. 그래서 , 로 추가ㅏㄴ다.

    private val wingCount: Int = 2

    override fun move() {
        println("펭귄이 움직인다.")
    }

    override val legCount: Int
        get() = super.legCount + this.wingCount

    override fun act() {
        super<Swimable>.act() // 상위 인터페이스의 함수를 부를때 자바는 Swimable.super.act() 인터페이스타입.super.메서드() 이지만, 코틀린은 다음과 같이 사용한다.
        super<Flyable>.act()  // super<타입>.메서드
    }

    override fun fly() {    // 상위 인터페이스에서 기본 구현이 없다. 즉 추상 메서드임
       println("날아 간다")
    }

    override val swimAbility: Int   //
        get() = TODO("Not yet implemented")
}

// 자바와 동일하게 인터페이스는 인스턴스화 할 수 없다.

// 코틀린은 backing field 가 없는 프로퍼티를 인터페이스에 만들 수 있다.
// 인터페이스에서 변수를 선언하고 그에 대한 구현을 구체 클래스에서 진행한다. 이 떄,
//

// 클래스 상속할 떄 주의점
open class Base (
    open val number:Int = 100
) {
    init {
        println("Base Init")
        println(number)
    }
}

class Derived (
    override val number: Int
) : Base(number) {

    init {
        println("Derived Init")
        println(number)
    }
}

fun main() {
    val derived = Derived(300)
    println("post constructor")
    println(derived.number)
}

// 하위 클래스를 생성하면
// 상위 클래스 생성자 -> 하위 클래스 생성자 순으로 동작한다.
// 이 때 상위 클래스에서 number 변수를 사용했는데 이 값이 오버라이드 했기 때문에 하위 클래스 number 에서 읽어오려고 한다.
// 하지만, 상위 클래스 생성자 단계에서는 아직 하위 클래스 생성자를 도달한 단계가 아니기 떄문에 300으로 초기화 되어있지 않은 상태이다.
// 따라서 Int 의 기본 값인 0이 나오게 된다.
// 결론 상위 클래스 init 에서 하위 클래스에서 오버라이드하고 있는 final 이 아닌 프러퍼티에 접근하면 안 된다.
// 상위 클래스를 설게할 떄 생성자 또는 초기화 블록에서 사용되는 프로퍼티는  open 을 피해야 한다.

// final : override 할 수 없게 한다. default 값이다. 생략되서 존재한다.  따라서 오버라이드 하고 싶으면 open 을 쓴다.
// open : 오버라이드 할 수 있게 한다.
// abstact : 반드시 오버라이드 해야한다.
// override : 상위 타입을 오버라이드 하고 있다. 필수!