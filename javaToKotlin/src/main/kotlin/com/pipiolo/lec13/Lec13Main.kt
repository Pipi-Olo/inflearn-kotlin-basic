package com.pipiolo.lec13

class Lec13Main {
}

// 중첩 클래스 종류
// 이펙티브 자바에 따르면 내부 클래스를 만들때 static 을 쓰는 것이 좋다.
// static 이 없는 내부 클래스를 사용하면 메모리 누수, 디버깅, 직렬화 제한 등이 있다.
// 왜냐하면 static 이 없는 내부 클래스는 외부 클래스와 연결되어 있기 때문에 별도의 인스턴스화 없이 외부 클래스를 마구잡이로 쓸 수 있기 떄문이다.
// 따라서 내부 클래스는 static 으로 만들자.

// 코틀린은 이러한 사상을 따르고 있다.
// 그냥 클래스 안에 클래스를 작성하면 자동으로 스태틱으로 해준다. 다만 코틀린에서는 스태틱 명령어가 없다.
// 기본적으로 밖깥 클래스와 연결이 없는 중첩 클래스로 만들어지기 떄문이다.
// 박깥 클래스와 연결된 클래스를 만들고 싶으면 inner 지시어를 사용하면 된다.
// 값을 가져올 때도 this@박깥클래스 키워드가 필요하다.
// 코틀린은 기본적으로 박갂 ㅌ 클래스를 참조하지 않는다.

class House(
    private var address: String,
    private var livingRoom: LivingRoom
    ) {

//    class LivingRoom (
//        private var area : Double
//        )

    inner class LivingRoom (
        private var area: Double
            ) {
        val address: String
        get() = this@House.address
    }
}