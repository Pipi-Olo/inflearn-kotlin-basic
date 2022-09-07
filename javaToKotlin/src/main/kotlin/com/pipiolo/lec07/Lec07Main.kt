package com.pipiolo.lec07

// try catch finally  문법자체는 자바와 동일하다.
fun parseIntOrThrow(str: String): Int {
    return try {
        str.toInt() // toXX 타입변환 사용
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("주어진 ${str} 은 숫자가 아닙니다.") // new 를 사용하지 않는다.
    }
}

// 마찬가지로 try 또한 Expression 이기 때문에 반환 가능하다.
// null 을 반환할 수 있는 Int? 를 사용한다.
fun parseIntOrThrowV2(str: String): Int? {
    return try {
        str.toInt() // toXX 타입변환 사용
    } catch (e: NumberFormatException) {
        null
    }
}


