package com.mlbd.ktwc

import java.io.File

class FileManager(file: File): FileInputInterface, FileOutputInterface
{
    var fileDetail = FileDetail()
    var lines: List<String> = listOf()
    var file: File = file!!
    var totalWordCount: Int = 0

    override fun fileProcess(): Unit{

         lines = file.readLines()

        lines.forEach {
                line -> line
            if(!line.isBlank())
            {
                getTotalWordsCount(line, myOutput = { myOutput ->
                    totalWordCount +=  myOutput
                })
            }
        }
    }

    override fun getDetails(): FileDetail
    {
        fileDetail.totalLineCount =lines.count()
        fileDetail.totalBytes = getTotalBytes()
        fileDetail.totalCharCount = getTotalCharCount()
        fileDetail.totalWordCount = totalWordCount

        return fileDetail
    }

    private fun getTotalBytes(): Int {

           return  file.readBytes().count()
    }

    private fun getTotalWordsCount(text: String, myOutput: (Int) -> Unit){
        myOutput(text.split(" ").count())
    }
    private fun getTotalCharCount(): Int
    {
        var result: Int = 0;
        for (s in lines) {
            result += s.toCharArray().count()
        }
        return result
    }
}