package training.calculator.com.karumi_dojo

import org.junit.After

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

import org.junit.Assert.*
import org.junit.Before
import training.calculator.com.karumi_dojo.utils.*
import training.calculator.com.karumi_dojo.utils.FakeRandomNumber
import training.calculator.com.karumi_dojo.utils.FakeStorage
import training.calculator.com.karumi_dojo.utils.MagicCounter
import training.calculator.com.karumi_dojo.utils.Storage


@RunWith(Parameterized::class)
class MagicCounterIncrementTest(private val testNumber: Pair<Int, Int>) {

    lateinit var storage: Storage
    lateinit var magicCounter: MagicCounter

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Array<Pair<Int, Int>> = arrayOf(
                Pair(-6847356, 1),
                Pair(0, 1),
                Pair(1, 1),
                Pair(99, 1),
                Pair(101, 101)
        )
    }

    @Before
    fun before() {
        storage = FakeStorage()
        storage.clear()
    }
    @After
    fun after() {
        storage.clear()
    }

    @Test
    fun `should increase number with input`() {
        magicCounter = MagicCounter(storage, FakeRandomNumber(testNumber.first))
        val result = magicCounter.increment()
        assertEquals(testNumber.second, result)
    }

}
