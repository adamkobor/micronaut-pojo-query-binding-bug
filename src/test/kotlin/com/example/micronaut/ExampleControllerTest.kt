package com.example.micronaut

import io.kotlintest.shouldBe
import io.kotlintest.specs.BehaviorSpec
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest

@MicronautTest
class ExampleControllerTest(@Client("/") private val client: RxHttpClient) : BehaviorSpec() {

    init {
        given("an endpoint with introspected POJO query binding to Int param") {
            `when`("called") {
                val resp = client.toBlocking().exchange<Any>("/introspected-int?param=1")
                then("the response should be OK") {
                    resp.status.shouldBe(HttpStatus.OK)
                }
            }
        }

        given("an endpoint with introspected POJO query binding to String param") {
            `when`("called") {
                val resp = client.toBlocking().exchange<Any>("/introspected-string?param=irrelevant")
                then("the response should be OK") {
                    resp.status.shouldBe(HttpStatus.OK)
                }
            }
        }

        given("an endpoint with POJO query binding to Int param") {
            `when`("called") {
                val resp = client.toBlocking().exchange<Any>("/?param=1")
                then("the response should be OK") {
                    resp.status.shouldBe(HttpStatus.OK)
                }
            }
        }
    }
}
