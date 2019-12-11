package training.accenture.com.karumi_dojo

import training.accenture.com.karumi_dojo.StringCalculator;
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class StringCalculatorTest {
    private fun add(numbers: String): Int {
        if(numbers.isEmpty()) {
            return 0
        }
        val parts = numbers.split(",")
        return when(parts.size) {
            1 -> 1
            else -> parts[0].toInt() + parts[1].toInt()
        }
    }

    @Test
    fun testAddStringWithEmptyString() {
        val result = add("")
        assertEquals(0, result)
    }
    @Test
    fun testAddStringWithOneNumber() {
        val result = add("1")
        assertEquals(1, result)
    }
    @Test
    fun testAddStringWithTwoNumbers() {
        val result = add("1,2")
        assertEquals(3, result)
    }
    @Test
    fun testAddStringWithMoreThanTwoNumbersShouldAddOnlyFirstTwo() {
        val result = add("1,2,3")
        assertEquals(3, result)
    }
    @Test
    fun testAddStringWithInvalidNumberAtTheEndShouldWork() {
        val result = add("1,2,a")
        assertEquals(3, result)
    }
    @Test(expected = NumberFormatException::class)
    fun testAddStringWithInvalidNumberShouldThrowError() {
        add("1,a")
    }
}
