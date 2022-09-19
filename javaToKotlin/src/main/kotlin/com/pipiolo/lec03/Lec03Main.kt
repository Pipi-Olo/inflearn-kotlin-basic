package com.pipiolo.lec03

fun main() {
    val number1 = 3  // Int
    val number2: Long = number1.toLong() // Long

//    number2 = number1 // TypeMismatch

    val number3 = 5
    val number4 = 9
    val number5 = number3 / number4.toDouble()

    val number6: Int? = 3
    val number7: Long = number6?.toLong() ?: 0L
}

fun printAgeIfPerson(obj: Any) {
    if (obj is Person) {
        val person = obj as Person // as Person 생략할 수 있다. -> 컴파일러가 스마트 캐스트를 해준다.
                                   // 만약 obj 가 Person 이 변환이 안된다면 에라가 발생한다.
        println(person.age)
    }

    if (obj !is Person) { // Java 에서는 if(!(obj instanceof Person)) 만 가능하다.

    }
}

fun printAgeIfPerson2(obj: Any?) {
    val person = obj as? Person // as? 만약 obj 가 null 이라면 전차게 널이 된다. 즉 person 이 널이 될 수 있다.
                                // as? 연산자는 Person 으로 변환이 아닐 때 에러가 아닌 널 값을 넣어준다.
                                // 안전한 타입 변환
    println(person?.age)        // person 이 널이 될 수 있기 때문에 ?. 세이프콜을 해야한다.
}

// Any
// Java 의 Object 역할 모든 객체의 최상위 타입
// 모든 Primitive Type 의 최상위 타입도 Any 이다. 자바는 그렇지 않다.
// Any 자체는 널 포함이 안 된다. 널을 포함하고 싶다면  Any? 로 표현한다.
// equals / hashcode / toString 메서드가 존재한다.

// Unit
// Java void 와 동일한 역할
// void 와 다르게 Unit 은 그 자체로 타입 인자로 사용 가능하다.
    // void + Void -> Unit
    // 제네릭에서 void 를 쓰고 싶으면 Void 를 써야 하는데 Unit 은 이거 하나로 전부 가능
// 단 하나의 인스턴스만 갖는 타입을 의미한다.

// Nothing
// 함수가 정상적으로 끝나지 않았다는 사실을 표현한다.
// 무조건 예외를 반환하는 함수 / 무한 루프 함수 등

// String interpolation
// ${}
fun strInter() {
    val person = Person("dd", 100)
    println("이름 : ${person.name} 나이 : ${person.age}")

    val name = "AAA"
    println("이름 $name") // 중괄호 생략 가능하다. 하지만, 가독성 일괄 변호나 정규식 활용 등의 이유로 중괄호를 넣는 것이 좋다.

    val str = """
        ABC
        DASD
        kdlASDK
        ${name}
    """.trimIndent()

    println(str)
}

// String indexing()
// 자바의 배열처럼 대괄호를 통해서 str.charAt(i)
fun strIndex() {
    val str = "ABCDEF"
    println(str[0])
    println(str[1])
}

// 코틀린의 변수는 초기값을 보고 타입을 추론하며 기본 타입들 간의 변환은 명시적으로 이루어진다.
// is !is as as? 을 이요해 타입을 확인하고 캐스팅한다
// Any 는 자바의 오브젝트
// Unit 은 자바의  void
// Nothing 은 정삭적으로 끝나지 않는 함수의 반환
// 문자열 가공할대 ${변수} """""" 을 통해
// 문자열에서 문자를 가져올때 자바의 배열처럼 대괄호