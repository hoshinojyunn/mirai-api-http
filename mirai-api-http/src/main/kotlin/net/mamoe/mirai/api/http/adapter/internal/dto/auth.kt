/*
 * Copyright 2020 Mamoe Technologies and contributors.
 *
 * 此源代码的使用受 GNU AFFERO GENERAL PUBLIC LICENSE version 3 许可证的约束, 可以在以下链接找到该许可证.
 * Use of this source code is governed by the GNU AGPLv3 license that can be found through the following link.
 *
 * https://github.com/mamoe/mirai/blob/master/LICENSE
 */

package net.mamoe.mirai.api.http.adapter.internal.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import net.mamoe.mirai.api.http.context.MahContext
import net.mamoe.mirai.api.http.context.session.AuthedSession

@Serializable
internal data class VerifyDTO(val verifyKey: String) : DTO

@Serializable
internal data class VerifyRetDTO(val code: Int, val session: String) : DTO

@Serializable
internal abstract class AuthedDTO : DTO {
    val sessionKey: String = MahContext.SINGLE_SESSION_KEY

    @Transient
    open lateinit var session: AuthedSession // 反序列化验证成功后传入
}

@Serializable
internal class EmptyAuthedDTO : AuthedDTO()

@Serializable
internal data class BindDTO(val qq: Long) : AuthedDTO()
