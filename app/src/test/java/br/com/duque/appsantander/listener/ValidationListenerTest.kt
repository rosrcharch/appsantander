package br.com.duque.appsantander.listener

import com.nhaarman.mockitokotlin2.isA
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ValidationListenerTest {

    lateinit var SUP: ValidationListener

    @Before
    fun setUp() {
        SUP = ValidationListener()
    }

    @Test
    fun validation_result_message_failure() {
       SUP = ValidationListener("test")
       assertEquals(false, SUP.success())
       assertEquals("test", SUP.failure())
    }

    @Test
    fun validation_result_boolean_success() {
        SUP = ValidationListener("")
        assertEquals(true, SUP.success())
        assertEquals("", SUP.failure())
    }

}