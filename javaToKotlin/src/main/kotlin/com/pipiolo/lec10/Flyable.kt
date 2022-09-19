package com.pipiolo.lec10

interface Flyable { // public 생략

    fun act() { // default 생략 Unit 반환 생략
        println("파닥 파닥") // default 키워드 없이 기본 구현 가능하다.
    }

    fun fly() // 추상 메서드
}