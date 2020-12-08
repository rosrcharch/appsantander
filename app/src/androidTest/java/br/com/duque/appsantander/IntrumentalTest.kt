package br.com.duque.appsantander

import android.content.Context
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import br.com.duque.appsantander.ui.ui.details.DetailsActivity
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class InstrumentalTest {

    @get:Rule
    val activityScenarioRule = ActivityTestRule(DetailsActivity::class.java)


    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = ApplicationProvider.getApplicationContext<Context>()
        Assert.assertEquals("br.com.duque.appsantander", appContext.packageName)
    }

    @Test
    fun appLaunchesSuccessfully() {
        ActivityScenario.launch(DetailsActivity::class.java)
    }
}