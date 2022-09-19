package com.pipiolo.lec07

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class FilePrinter {

    fun readFile() {
        val currentFile = File(".")
        val file = File(currentFile.absolutePath + "/a.txt")
        val reader = BufferedReader(FileReader(file))
        println(reader.readLine())
        reader.close()
    }

    fun readFile(path: String) {
        BufferedReader(FileReader(path)).use {
                reader -> println(reader.readLine());
        }
    }
}

// 자바는 체크드, 언체크드 익셉션으로 나누어져 있지만,
// 코틀린은 모두 언체크드 익셉션이다!!

// 따라서 밖으로 던지거나 try catch 로 잡아줄 필요가 없다.
// 물론 잡고 싶으면 해도 된다.

// 코트린은  try with resources 구ㅜㅁㄴ이 없다.
// 대신에 use 를 사용해 대체하 ㄹ수 있다.
// 원리는 나중에 설명
// use inline 확장함수