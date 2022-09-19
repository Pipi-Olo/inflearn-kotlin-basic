package com.pipiolo.lec15

// 코틀린이 배열과 컬렉션을 바루는 방법

class Lec15Main {
}

// 1. 배열
// 배열은 잘 사용하지 않는다. 리스트를 추천.  in 이펙티브 자바

fun main() {
    val array = arrayOf(100, 200)

    for (i in array.indices) {
        println("${array[i]}")
    }

    for ((idx, value) in array.withIndex()) {
        println("${idx} ${value}")
    }

    array.plus(300) // 배열에 새로운 엘리먼트 추가
}

// 2. 컬렉션
// 반드시 시작할 떄 불변인지, 가변인지 설정해야 한다. 따라서 총 6개 (List, Set, Map) X 2
// 가변 컬렉션 : 컬렉션에 에리먼트 추가 삭제할 수 있따.
// - MutableXXX
// 불변 컬렉션 컬렉션에 할수 없다.
// - 컬렉션을 만들자 마자, Collections.unmodifiableList()  를 붙여줬다고 생각하자.
// 불변 컬렉션이랗 ㅏ더라더 Reference Type Element 는 바꿀 수 있다.
// 즉 새로운 엘리먼트를 추가하거나 삭제할 수는 없지만, 변경할 수 는 있따.

fun main2() {
    val numbers = listOf(100, 200) // 이럴 떄는 값을 보고 타입 추론이 가능하다.
    val emptyList = emptyList<Int>() // 빈 리스트를 만들때는 명시적으로 타입을 적어줘야 한다.

    printNumbers(emptyList()) // printNumbers 메서드에 의해 List<Int> 임을 추론이 가능하므로 타입이 생략이 가능하다.

    // 컬렉션에서 값 가져오기

    numbers[0] // 배열처럼 대괄호로 가져올 수 있따.

    for (number in numbers) {
        println(number)
    }

    for ((idx, value) in numbers.withIndex()) {

    }

    // 가변 리스트!!
    // 기본 구현체는 arrayList
    // TIP 우선 불변 리스트로 만들고 필요한 경우 가변으로 바꾸자
    val mutableNumbers = mutableListOf(100, 200)
    mutableNumbers.add(300)
}

private fun printNumbers(numbers: List<Int>) {

}

// 2-2. Collection - set
// 기본 구현체는 LinkedHashSet

// 2-3. Collections - Map

// 기존 자바의 get, put 등 다 쓸 수 잇다.
fun main2_3() {
    val oldMap = mutableMapOf<Int, String>()
    oldMap[1] = "MONDEY"
    oldMap[2] = "MONDDDY"

    val map = mapOf(1 to "MONDAY", 2 to "TUESEDAY") // 중위 호출 Pair 클래스를 만들어서 해준다.

    for (key in oldMap.keys) {
        println(key)
        println(oldMap[key])
    }

    for ((key, value) in oldMap.entries) {
    }
}

// 컬렉션과 NULL
// List<Int?>   : 리스트에 null 이 들어갈 수 있지만, 리스트는 절대 널이 아님
// List<Int>?   : 리스트에 널이 들어갈 수 없지만, 리스트는 널 일 수 있음
// List<Int?>?  : 리스트네 널이 들어 갈 수도 있고 리스트가 널 일 수 도 있음

// 자바는 읽기 전용과 변경 가능 컬렉션을 구분하지 않는다.
// 코틀린가 자바를 같이 쓸떄,
// 코틀린에서 자바로 넘어간 불변 컬렉션이 자바에 의해 컬렉션이 추가될 수 있따.
// 그리고 이 불변 컬렉션이 코틀린으로 넘어오면 코틀린 입장에서는 불변 컬렉션에 엘리먼트가 추가되어 오동작을 일으킬 수 있다.

// 마찬가지로 자바는 nullable non-nullable 타입을 구분하지 안흔다.
// 따라서 List<Int> 코틀린 컬렉션임에도 불구하고 자바를 거치면 null 이 추가될 수 있다.

// 즉! 코틀린 컬렉션이 자바에서 호출되면 컬렉션 내용이 변할 수 있음을 인지해야 한다.
// 다시 돌아왔을 때 방ㅇ어로직!!
// 혹은 Collections.unmodifableXXX() 를 활용하면 자바에서도 변경 불가능하게 막을수 있다.

// 반대로 자바의 List<Integer> 가 코틀린으로 넘어가면  List<Int?>? ???? 정확히 어떤것인지 알 수가 없다.
// 자바 코드를 보면서 어떠 ㄴ값들이 허용되는지 맥락을 확인하고
// 자바 코드 가져오는 지점에 wrapping 을 통해서 해결해야 한다.