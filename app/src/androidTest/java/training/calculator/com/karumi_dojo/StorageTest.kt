package training.calculator.com.karumi_dojo

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import org.junit.After

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import training.calculator.com.karumi_dojo.utils.PreferencesStorage
import training.calculator.com.karumi_dojo.utils.Storage

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class StorageTest {

    lateinit  var storage: Storage
    @Before
    fun before() {
        val appContext = InstrumentationRegistry.getTargetContext()
        storage = PreferencesStorage(appContext)
        storage.clear()
    }
    @After
    fun after() {
        val appContext = InstrumentationRegistry.getTargetContext()
        storage = PreferencesStorage(appContext)
        storage.clear()
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("training.calculator.com.karumi_dojo", appContext.packageName)
    }

    @Test
    fun shouldGetDefaultValue0() {
        val result = storage.get()
        assertEquals(result, 0)
    }

    @Test
    fun shouldGetPreviouslkySavedValue() {
        storage.save(1)
        val result = storage.get()
        assertEquals(result, 1)
    }
}
