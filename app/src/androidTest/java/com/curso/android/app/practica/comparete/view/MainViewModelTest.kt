package com.curso.android.app.practica.comparete.view

import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.curso.android.app.practica.comparete.R
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {

    @get: Rule
    val rule:ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }
    @Test
    fun mainActivity_comparate(){
        Espresso.onView(
            ViewMatchers.withId(R.id.imageButton)
        ).perform(
            ViewActions.click()
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.textView)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Palabras iguales")
            )
        )
    }
}