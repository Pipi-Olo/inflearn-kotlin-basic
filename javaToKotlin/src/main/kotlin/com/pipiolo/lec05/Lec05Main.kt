package com.pipiolo.lec05

// 자바 if 문과 동일하다.
fun validateScoreIsNotNegative(score: Int) {
    if (score < 0) {
        throw IllegalArgumentException("${score}는 0보다 작을 수 없다.")
    }
}

// 자바는 Statement  : 프로그램의 문장, 하나의 값으로 도출되지 않는다.
// 코틀린은 Expression : 하나의 값으로 도출되는 문장

// Statement 집합이 Expression 집합을 포함한다.

// 자바에서는 if 문 결과를 그대로 변수에 대입할 수 없다.
// 왜? 자바의 if 문은 statement 이기 때문에 하나의 값으로 도출되지 않는다.
// 이를 위해 자바는 3항 연산자를 제공한다. scores >= 50 ? P : F

// 코틀린에서는 if-else 문을 그대로 반환하거나 변수에 대입이 가능하므로 3항 연산자 개념이 없다.
// 나머지 if - else if - else 문법은 동일하다.

fun getPassOrFail(score: Int): String {
    return if (score >= 50) {
        "P"
    }
    else {
        "F"
    }
}

// 어떠한 값이 특정 범위에 포함되어 있느지 있지 안흔ㄴㄴ지
// 자바에서 if (0 <= score && score <= 100)

fun range(score: Int) {
    if (score in 0..100) {
        println("${score} 는 0과 100 사이 값이다.")
    }
}

// switch when
// 자바의 switch -> when 으로 대체
// 자바의 case 대신에 화살표 -> 으로 분기 표현 가능
// Expression 이기 떄문에 하나의 값이다. 따라서 바로 반환 가능.
// default 대신에 else 사용
fun getGradeWithSwitch(score: Int): String {
    return when(score / 10) {
        9 -> "A"
        8 -> "B"
        7 -> "C"
        else -> "D"
    }

    // 범위 등 다양한 기타 조건을 통해서도 분기를 칠 수 있다.
    return when(score) {
        in 90..99 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        else -> "D"
    }
}

// 조건부에 어떤 expression 도 들어갈 수 있다.
// is 도 가능

fun startWithA(obj: Any): Boolean {
    return when (obj) {
        is String -> obj.startsWith("A")
        else -> false
    }
}

// , 을 통해 여러 조건을 동시에 검색 가능
fun judgeNumber(number: Int) {
    when (number) {
        -1, 0, 1 -> println("자주 보던 숫자이다.")
        else -> println("처음 보는 숫자이다.")
    }
}

// when (값) 에서 값이 없어도 된다.
fun judgeNumber2(number: Int) {
    when {
        number % 2 == 0 -> println("짝수")
        number % 2 == 1 -> println("홀수")
    }
}

// when Enum, Sealed class 와 함께 사용할 때 더욱더 진가를 발휘한다.