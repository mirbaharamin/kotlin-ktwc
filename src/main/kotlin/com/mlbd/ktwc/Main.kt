package com.mlbd.ktwc
import java.io.File
import java.util.Scanner

// ktwc file path
// ktwc file path -c --Bytes -m --chars

fun main(args: Array<String>) {

  run exitProgram@ {

      var CommandSplit: String = readLine()!!
      var commandArray = CommandSplit.split(" ")

      var mapCommandList = commandArray.map { it.trim() to it.trim() }.toMap()

      mapCommandList.keys.forEach { value ->
          mapCommandList[value]

      }

      //println(mapCommandList)
      if(mapCommandList["ktwc"] != "ktwc") {
            println("invalid command")
            return@exitProgram
      }

      // Input File
      var fileName = File("${commandArray[1]}")

      var fileManager = FileManager(fileName).apply {
          fileProcess()
          getDetails()
      }
      var res: String = ""
      if(commandArray.size > 2) {
          if(mapCommandList["-c"] == "-c") {
              res += "totalBytes = ${fileManager.getDetails().totalBytes}"
          }
          if(mapCommandList["-m"] == "-m") {
              res += ", totalChatacter = ${fileManager.getDetails().totalCharCount}"
          }
          if(mapCommandList["-l"] == "-l") {
              res += ", totalChatacter = ${fileManager.getDetails().totalLineCount}"
          }
          if(mapCommandList["-w"] == "-w") {
              res += ", totalChatacter = ${fileManager.getDetails().totalWordCount}"
          }
          println(res)
      } else {
          println("totalBytes = ${fileManager.getDetails().totalBytes}" +
                  " totalChars = ${fileManager.getDetails().totalCharCount}" +
                  " totalLines = ${fileManager.getDetails().totalLineCount}" +
                  " totalWords = ${fileManager.getDetails().totalWordCount}")
      }

  }
}