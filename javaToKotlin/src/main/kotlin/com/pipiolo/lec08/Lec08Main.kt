package com.pipiolo.lec08

fun maxV1(a: Int, b:Int): Int {
    return if (a > b) {
        a
    }
    else {
        b
    }
}

// 함수가 하나의 결과 값이라면 block 대신에 = 을 사용할 수 있다.
fun maxV2(a: Int, b:Int): Int =
    if (a > b) {
        a
    }
    else {
        b
    }

// 반환 값이 모두 Int 이기 떄문에 추론이 가능하다. -> 생략 가능하다. 단, 블록을 사용하는 경우는 아니다.
// 블록을 사용하는 경우에는 Unit 이 아니라면 명시적으로 표기해야 한다
// 하지만 블로대신 = 을 사용했다면 생랴 까능하다.
// 밑에 있던 if 구문을 위로 올려서 한 줄로 만들었다.
// 한줄이기 때문에 중괄호를 생략할 수 있다.
fun maxV3(a: Int, b:Int) = if (a > b) a else b

// 코틀린에서 함수는 클래스 안에 있을 수도 있고
// 파일 최상단에 있을 수도 있고
// 한 파일안에 여러 함수들이 있을 수도 있다.



// 자바는 오버로딩을 통해 메서드의 파라미터 기본 값들을 설정하 ㄹ수 있따.
// 하지만 문제점은 메서드 가 여러개 존재해야 한다.
// 코틀린은 이 문제를 1개의 메서드와 디폴트 값으로 해결한다.
// = 3 , = ture 기본 값을 설정해두면 매개변수 str 만 입력하면 나머지 파라미터 값은 기본 값으로 동작한다.
// 물론 코틀린에서도 자바와 동일하게 오버로딩 기능이 있다.
fun repeat(
    str: String,
    num: Int = 3,
    useNewLine: Boolean = true
) {
    for (i in 1..num) {
        if (useNewLine) {
            println(str)
        } else {
            print(str)
        }
    }
}

// Named Argument
// 매개변수 이름을 통해 직접 지정이 가능하다.
// 빌더를 직접 만들지 않고 빌더의 장점을 가질 수 있게 된다.
fun main() {
    repeat("Hello", 3, false) // num = 3이 기본값이기 때문에 중복해서 입력하고 싶지 않다.
                                                   // 하지만, repeat("Hello", false) 는 불가능하다. num = false 로 동작한다,.
    repeat("Hello", useNewLine = false)        // Naemd Argument  를 사용한다.


    printNameAndGender("남자", "강호동") // 둘다 타입이 동일하기 때문에 순서가 바뀌어도 컴파이러가 잡아줄 수 없다.
    printNameAndGender(name = "남자", gender = "강호동") // 마치 빌더를 사용하는 것처럼 가능하ㅏㄷ.

    printAll("A", "B", "C")

    val array = arrayOf("A", "B", "C")
    printAll(*array)  // 자바에서는 배열을 그대로 넣을 수 있었지만, 코틀린에서 배열을 가변인자로 사용하기 위해서는 * 인자가 필요하다.
}

// 하지만!!! 코틀린에서 자바 함수를 가져다 쓸 때는 Named Arguemtn 를 쓸스 웂더ㅣ
// 왜?? 코틀린에서 자바 코드를 쓸 떄
// JVM 에서 자바가 바이트 코드로 변환 되엉 ㅣㅆ는
// 이 떄 파라미터 이름을 보존하고 있지 않기 때문이다.
// 파라미터 이름을 바탕으로 도앚ㄱ하는 네임드 아규먼트가 동작하지 않느다.

fun printNameAndGender(name: String, gender: String) {
    println(name)
    println(gender)
}


// 같은 타입의 여러 파라미터 받기 가변인자
// 자바 에서 (String... strings) -> for 문 사용

fun printAll(vararg strings: String) {
    for (str in strings) {
        println(str)
    }
}