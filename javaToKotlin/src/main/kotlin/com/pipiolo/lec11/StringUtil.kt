package com.pipiolo.lec11

fun isDirectoryPath(path : String): Boolean {
    return path.startsWith("hello")
}

// 해당 코드를 자바로 변화시키면
// final 클래스 안에 static 함수로 선언되어 있다.

// 이를 통해 자바에서 코틀린 파일에 접근할 떄, 정적 메서드에 접근하는 것처럼 할 수 있따.
// StringUtils.isDirectoryPath() 처럼 인스턴스화 없이 바로 사용 가능