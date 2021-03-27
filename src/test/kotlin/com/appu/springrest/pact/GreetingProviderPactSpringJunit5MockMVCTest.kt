package com.appu.springrest.pact



import au.com.dius.pact.provider.junit5.PactVerificationContext
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider
import au.com.dius.pact.provider.junitsupport.Provider
import au.com.dius.pact.provider.junitsupport.State
import au.com.dius.pact.provider.junitsupport.loader.PactFolder
import au.com.dius.pact.provider.spring.junit5.MockMvcTestTarget
import au.com.dius.pact.provider.spring.junit5.PactVerificationSpringProvider
import com.appu.springrest.controller.GreetingController
import com.appu.springrest.service.GreetingService
import org.apache.http.HttpRequest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.TestTemplate
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.time.OffsetDateTime
import org.springframework.test.web.servlet.MockMvc

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.mock.mockito.MockBean


//@ExtendWith(SpringExtension::class)
@WebMvcTest(GreetingController::class)
@Provider("greeting")
@PactFolder("pacts")
internal class GreetingProviderPactSpringJunit5MockMVCTest {
    companion object {
        private val endTime: OffsetDateTime = OffsetDateTime.parse("2020-07-08T10:52:20.840Z")
        private val startTime: OffsetDateTime = endTime.minusDays(7)
    }


    @MockBean
    private lateinit var service:GreetingService

    @TestTemplate
    @ExtendWith(PactVerificationSpringProvider::class)
    fun pactVerificationTestTemplate(context: PactVerificationContext) {
        context.verifyInteraction()
    }

    /*
    //Uncomment to debug Error: "ParameterResolver registered for parameter [org.apache.http.HttpRequest request] in method"
    @TestTemplate
    @ExtendWith(PactVerificationInvocationContextProvider::class)
    fun pactVerificationTestTemplate(context: PactVerificationContext, request: HttpRequest) {
        request.addHeader("Cookie", "token=token")
        context.verifyInteraction()
    }*/

    @Autowired
    private val mockMvc: MockMvc? = null

    @State("test GET")
    fun getTrips() {
    }
    @BeforeEach
    fun before(context: PactVerificationContext) {
        val testTarget = MockMvcTestTarget(mockMvc)
        testTarget.printRequestResponse=true
        context.target = testTarget
    }


}
