package me.seoly.spring.utils

import kotlin.reflect.KParameter

class ModelMapper: org.modelmapper.ModelMapper() {

    inline fun <reified T, reified R> reflect(source: T): R {
        R::class.constructors
            .last { constructor ->
                val mutableMap: MutableMap<KParameter, Any?> = mutableMapOf<KParameter, Any?>()
                constructor.parameters.forEach { parameter ->
                    mutableMap[parameter] = T::class.members.find { it.name == parameter.name }?.call(source)
                }
                return constructor.callBy(mutableMap)
            }
        throw RuntimeException("Not Exist Class ${R::class.simpleName} Constructor.")
    }
}