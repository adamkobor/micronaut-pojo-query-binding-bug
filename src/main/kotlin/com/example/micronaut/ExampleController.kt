package com.example.micronaut

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.HttpStatus

@Controller("/")
class ExampleController {

    @Get("/introspected-int{?introspectedQueryParams*}")
    fun failingQueryBinding(introspectedQueryParams: IntrospectedQueryPojoWithIntParam): HttpStatus {
        return HttpStatus.OK
    }

    @Get("/introspected-string{?introspectedQueryParams*}")
    fun successfulStringQueryBinding(introspectedQueryParams: IntrospectedQueryPojoWithStringParam): HttpStatus {
        return HttpStatus.OK
    }

    @Get("/{?queryParams*}")
    fun successfulQueryBinding(queryParams: QueryPojo): HttpStatus {
        return HttpStatus.OK
    }
}
