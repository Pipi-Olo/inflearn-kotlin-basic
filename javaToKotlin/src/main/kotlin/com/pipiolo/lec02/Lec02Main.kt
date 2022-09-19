package com.pipiolo.lec02

fun main() {

    val str: String? = "ABC"
    println(str?.length)      // safe call : str 이 null 이면 전체가 null / null 이 아닌 경우에만 호출한다.
    println(str?.length ?: 0) // null 이면 0 Elvis 연산자
    println(str!!.length)     // 절대 null 이 아님을 선언! ex) 엔티티 id 는 맨처음에 null 이자만 디비에 갔다오면은 무조건 값이 들어있다. -> 매번 safe call 할 수 없으므로
    println(str.length)       // !!를 한번 쓰면 그 다음에는 safe call 없이 쓸 수 있다.


    val person = Person("공부하는 개발자")
    startWithA(person.name) // 자바 코드를 코틀린으로 가져온 경우. Nullable 에 대한 정보가 필요하다.
                            // org.jetbrains.annotations.Nullable 가 붙어있다면 null 이 가능한 것이기 때문에 세이프 콜이 필요하다.
                            // org.jetbrains.annotations.NotNull 이 붙어있으면 세이프콜 필요없다
                            // 플랫폼 타입 : 코틀린이 null 관련 정보를 알 수 없을 때! Runtime 시 Exception 이 발생할 수도 있다. NPE 컴파일러는 못 잡아줌
}

fun startWithA(str: String): Boolean {
    return str.startsWith("A")
}

fun startWithA1(str: String?): Boolean {
    return str?.startsWith("A")
        ?: throw IllegalArgumentException("NULL")
    /*
    if (str == null) {
        throw IllegalArgumentException("NULL")
    }
    return str.startsWith("A")
     */
}

fun startWithA2(str: String?): Boolean? {
    return str?.startsWith("A")

    /*
    if (str == null) {
        return null
    }
    return str.startsWith("A")
     */
}

fun startWithA3(str: String?): Boolean {
    return str?.startsWith("A") ?: false

    /*
    if (str == null) {
        return false
    }
    return str.startsWith("A")
     */
}