package com.pipiolo.lec17

// 자바에서 함수는 2급 시민이다.
// 변수에 할당하거나 파라미터로 넘길 수 없다.

// 코틀린에서는 함수가 그 자체로 값이 될 수 있다.
// 변수에 할당하거나, 파라미터로 넘길 수 있다.

fun main() {
    val fruits = listOf(
        Fruit("사과", 1000),
        Fruit("사과", 1200),
        Fruit("사과", 1200),
        Fruit("사과", 1500),
        Fruit("바나나", 3000),
        Fruit("바나나", 3200),
        Fruit("바나나", 2500),
        Fruit("수박", 10000)
    )

    // 람다를 만다는 2가지 방법
    val isApple = fun(fruit: Fruit): Boolean { // 이러한 변수에 함수 타입이 별도로 존재한다!!
                                               // (Fruit) -> Boolean 이 함수 타입이다. 왜? 과일을 받아서 불린을 반환하는 타입
        return fruit.name == "사과"
    }
    val isApple2 = { fruit: Fruit -> fruit.name == "사과" }

    // 변수에 할당한 함수를 호출하는 방법, 람다를 직접 호출하는 방법
    isApple(fruits[0])
    isApple.invoke(fruits[0])

    filterFruits(fruits, isApple)
    filterFruits(fruits, { fruit: Fruit -> fruit.name == "사과" })

    // 메서드의 마지막이 함수형 타입일 경우, 소괄호 안에 중괄호가 들어가는 형태가 어색하므로 다음과 같이 가능하다.
    // 중괄호를 밖으로 뺄 수가 있다.
    filterFruits(fruits) { fruit: Fruit -> fruit.name == "사과" }

    // 함수의 필터가 Fruit 을 받아 Boolean 을 반환하는 타입으로 추론이 가능하다.
    // 따라서 Fruit 타입을 생략 가능하다.
    filterFruits(fruits) { fruit -> fruit.name == "사과" }

    // 익명 함수를 만들 때, 함수 파라미터가 1개인 경우에는 it 으로 대체 가능하다.
    filterFruits(fruits) { it.name == "사과" }

    // 람다를 여러줄 작성할 때는, 따로 리턴 값이 없어도 마지막 줄의 결과가 항상 람다의 반환값이다.
}

private fun filterFruits(
    fruits: List<Fruit>,
    filter: (Fruit) -> Boolean
): List<Fruit> {
    val results = mutableListOf<Fruit>()
    for (fruit in fruits) {
        if (filter(fruit)) {
            results.add(fruit)
        }
    }
    return results
}

// 3. Closure
// 자바에서는 람다를 쓸 때, 사용할 수 있는 변수에 제약이 있다.
// 자바에서는 람다 밖에 있는 변수를 쓸 때는  final 인 변수 혹은 실질적인  final 변수만 가능하다.

// 코틀린은 제약이 없다.
// 코린에서는 람다가 시작하는 지점에 참조하고 있는 변수들을 모두 포획하여 그 정보를 가지고 있다.
// 이렇게 해야만 람다가 실행되는 시점에 쓰고있는 변수들을 모두 가지고 있어야만 람다를 진정한 일급 시민으로 간주할 수 있다.
// 이러한 데이터 구조를 Closure 라 한다.


// 4. try with resources
// 코틀린의 use
// Closeable 구현체에 대한 확장함수
// inline 함수
// 받고 있는 파라미터가 (T) -> R 타입인 람다이어야 한다.
