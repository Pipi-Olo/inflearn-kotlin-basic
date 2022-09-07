package com.pipiolo.lec06


fun main() {

    // 컬렉션을 만드는 방법이 다르다.
    // : 대신에 in 을 사용한다.
    // 자바와 동일하게 iterator 가 구현된 것이라면 numbers 자리에 올 수 있다.
    val numbers = listOf(1L, 2L, 3L)
    for (number in numbers) {
        println(number)
    }

    /////////// for-each 문은  코틀린에서 in 문을 사용한다.

    // i 를 1부터 3까지 출력한다.
    for (i in 1..3) {
        println(i)
    }

    // 숫자가 내려갈 때는 downTo 를 사용해야 한다.
    for (i in 3 downTo 1) {
        println(i)
    }

    // 숫자를 2씩 올라가는 경우
    for (i in 1..5 step 2) {
        println(i)
    }

    ///////////////////////////////////////////////// 전통적인 for 문 사용법
    // .. 연산자 -> 범위를 만들어 내는 연산자
    // IntRange 라는 실제 범위 클래스가 있다.
    // IntRange 는 사실 IntProgression (등차수열) 을 상속하고 있다.
    // 즉 1..3 이라는 의미는 1부터 시작해서 3으로 끝나는 등차 수열을 만들어 달라는 의미이다.
    // 3 downTo 1 : 시작값 3 끝값 1 공차가 -1 등차수열
    // 1..5 step 2 : 시작값 1 끝값 5 공차 2인 등차수열
    // downTo, step 도 함수이다.!!
        // 중위 호출 함수 [변수.함수이름 (argument)] 대신에 [변수 함수이름 argument]
    // 코틀린에서 전통적인 for 문은 등차수열을 사용한다.

    // while 은 자바와 완전히 동일하다. do-while 도 동일하다.
    var i = 1
    while (i <= 3) {
        println(i)
        i++
    }
}