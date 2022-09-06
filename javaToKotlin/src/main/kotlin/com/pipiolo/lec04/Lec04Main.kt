package com.pipiolo.lec04

// 단항 연산자 ++ --
// 산술 대입 연산자 += -= *= /= %=
// 비교 연산자 > < >= <=
    // 단 자바와 다르게 객체를 상대로 비교하면 자동으로 compareTo 메서드를 호출한다.
// 동등성 : 두 객체의 값이 같은가? / 자바 equals / kotlin == -> equals 메서드를 호출한다.
// 동일성 : 완전히 동일한 객체인가> 주소가 같은가? / 자바 == / kotlin ===

// 논리 연산자 && || ! 자바와 완전 동일 / 동일하게 LAZY 연산 -> || 했을 때 앞에서 true 가 나오면 뒤 연산을 생략하고 true 로 판단한다.
// in / !in
    // 컬렉션이나 범위에 포함되어 있다.

// a..b
// .. 연산자 a 부터 b 까지의 범위 객체를 생성한다.

// a[i]
// a 에서 특정 엔인덱스 값을 가져온다. 넣는다.

// 객체마다 연산자를 직접 정의할 수 있다.

fun main() {
    val money1 = JavaMoney(1000L)
    val money2 = JavaMoney(2000L)
    val money3 = money1

    if (money2 > money1) {
        println("Money 2가 더 크다")
    }

    println(money1 === money3) // 동일성 비교 주소 비교
    println(money1 == money2)  // 동등성 비교 equals

    val kt_money1 = Money(1_000L)
    val kt_money2 = Money(2_000L)
    println(kt_money1 + kt_money2) // 객체마다 연산자를 직접 정의할 수 있다. 자바는 + 연산자가 아닌 plus 메서드 호출로 이루어진다.
}