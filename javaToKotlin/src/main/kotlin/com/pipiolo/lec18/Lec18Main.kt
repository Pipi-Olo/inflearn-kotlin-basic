package com.pipiolo.lec18

import com.pipiolo.lec17.Fruit

// filter
// filterIndexed
// map
// mapIndexed
// mapNotnull

private fun filterFruits(
    fruits: List<Fruit>,
    filter: (Fruit) -> Boolean
): List<Fruit> {
    return fruits.filter(filter)
}

// 2. 다양한 컬렉션 처리 기능

// all : 조건으 ㄹ모두 만족하면 트루 아니면 폴스
// none : 주어진 조건을 모두 불만족하면 트로 라이면 펄스
// any : 주어진 조건 중 하나만 만족해도 true 아니면 펄스

// count : 개수 == size()
// sortedBy : 오름차순 정렬을 한다. srtedByDesencding 내림차순 정렬
// distinctBy : 변형된 값을 기준으로 중복을 제거한다.

// fisrt : 첫번 째 값 무조건 널이 아니어야한다.
// firstOrNull : 첫번재 값 또는 널을 가져온다.
// last :  마지막 값을 가져온다
// lastOrNull : 마지막 혹은 널을 가져온다.

// 3. 리스트를 맵으로
// groupby
// associateBy


// 4. 중첩된 컬렉션 처리
// flatMap
// flatte