package eu.eleo.tipcalculatorbygoogle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.core.StringContains.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)

class CalculatorTests {
    @get:Rule
    val activity = ActivityScenarioRule(MainActivity::class.java)
    @Test
    fun calculate_default_tip() {
        onView(withId(R.id.cost_of_service_edit_text))
            .perform(typeText("49.00"))
        onView(withId(R.id.option_fifteen))
            .perform(click())
        onView(withId(R.id.round_up_switch))
            .perform(click())
        onView(withId(R.id.calculate_button))
            .perform(click())
        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("$7.35"))))
    }
}