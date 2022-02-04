package eu.eleo.tipcalculatorbygoogle

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)

class CalculatorTests {
    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)
    @Test
    fun calculate_20_percent_tip() {
    }
}