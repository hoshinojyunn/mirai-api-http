/*
 * Copyright 2020 Mamoe Technologies and contributors.
 *
 * 此源代码的使用受 GNU AFFERO GENERAL PUBLIC LICENSE version 3 许可证的约束, 可以在以下链接找到该许可证.
 * Use of this source code is governed by the GNU AGPLv3 license that can be found through the following link.
 *
 * https://github.com/mamoe/mirai/blob/master/LICENSE
 */

package net.mamoe.mirai.api.http.util

import java.io.File

fun File.visit(visitor: (File) -> Boolean) = visit(this, visitor)

@JvmName("visitFile")
fun visit(file: File, visitor: (File) -> Boolean) {
    visit(arrayOf(file), visitor)
}

fun visit(file: Array<File>?, visitor: (File) -> Boolean) {
    file?.map {
        val b = visitor(it)
        if (b || it.isFile) visit(it.listFiles(), visitor)
    }
}
