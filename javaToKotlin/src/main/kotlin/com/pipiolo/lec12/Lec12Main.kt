package com.pipiolo.lec12

class Person private constructor(
    var name: String,
    var age: Int) {

    // 동행 객체
//    companion object {
//        private const val MIN_AGE = 1
//        fun newBaby(name: String): Person {
//            return Person(name, MIN_AGE)
//        }
//    }

    companion object Factory {
        private const val MIN_AGE = 1

        @JvmStatic
        fun newBaby(name: String): Person {
            return Person(name, MIN_AGE)
        }
    }
}

// 1. static 함수와 변수
// static 키워드 대신에 코틀린은 companion object 블록안에 넣어둔 변수와 함수가 자바의 static 것처럼 사용된다.
// static 이란 클래스가 인스턴스화 될 때마다 새로운 값이 복제되는 것이 아니라, 정적으로 인스턴스끼리 값을 공유한다.,
// companion object 란 클래스와 동행하는 유일한 오브젝트
// const 를 붙이면 컴파일시 변수가 할당된다. 없으면 런타임시 붙인다. 즉 const 진짜 상수에 붙인다.
// 동반 객체는 하나의 객채로 간주된다. 때문에 이름을 붙일 수도 인터페이스를 구현할 수도 있따.
// 유틸성 함수들을 넣어도 되지만, 최상단 파일에 넣는 것이 좋다.
// 자바에서 사용할 때는 Person.Companion.newbaby() 같은 Companion 이름으로 쓸 수 있다.
// 만약 Companion 없이 쓰고 싶으면 @JvmStatic 애노테이션을 메서드에 붙이면 Person.newbaby() 로 접근할 수 있따.
// 만약 동반 객체에 별도로 이름을 설정했다면, 해당 이름으로 접근하면 된다. Person.Factory.newBaby()

// 2. 싱글톤
// 코트린에서 싱글톤 만들기 : object 를 붙이면 된다. 끝.
// 인스턴스화가 필요없다.

object Singleton {
    var a: Int = 10
}

// 3. 익명 클래스
// 특정 인터페이스나 클래스를 상속받은 구현체를 일회성으로 사용할 떄 스는 클래스
// 자바에서 일회성으로 만들 때, 익명 클래스로 만들어서 사용함 new Movable() 

fun main() {
    println(Singleton.a)

    moveSomething(object : Movable{
        override fun move() {
            TODO("Not yet implemented")
        }

        override fun fly() {
            TODO("Not yet implemented")
        }
    })
}

private fun moveSomething(movable: Movable) {
    movable.move()
    movable.fly()
}