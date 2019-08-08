package com.example.micronaut

import io.micronaut.core.annotation.Introspected

@Introspected
data class IntrospectedQueryPojoWithIntParam(
    val param: Int
)

@Introspected
data class IntrospectedQueryPojoWithStringParam(
    val param: String
)

data class QueryPojo(
    var param: Int? = null
)
