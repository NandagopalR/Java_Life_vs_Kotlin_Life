package com.sedintechnologies.workbook.model.adminconfig

import okio.buffer
import okio.sink
import okio.source
import java.io.File
import java.io.FileInputStream
import java.util.zip.ZipInputStream

/** In Java, we used to close a connection by adding <code> .close() </code> method like below
 * fileOutputStream.close(); // For FileOutputStream
 * zipInputStream.close(); // For ZipInputStream
 * realm.close(); // For Realm Database and Other Databases
 */

/** Where as In Kotlin we can simply use the <code> .use </code> operation
 * without worrying closing the connection.
 */

class DataBaseInstanceCloseExample {

  fun unzip(
    zipFile: File,
    destDir: File
  ) {
    if (!destDir.exists()) destDir.mkdirs()
    FileInputStream(zipFile).use { fis ->
      ZipInputStream(fis).use { zis ->
        var ze = zis.nextEntry
        while (ze != null) {
          val fileName = ze.name
          val newFile = File(destDir, fileName)
          newFile.parentFile?.mkdirs()
          val inputSource = zis.source()
            .buffer()
          newFile.sink()
            .buffer()
            .use { outputSink ->
              outputSink.writeAll(inputSource)
            }
          //close this ZipEntry
          zis.closeEntry()
          ze = zis.nextEntry
        }
      }
    }
  }
}