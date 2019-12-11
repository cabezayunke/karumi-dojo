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
    private val scenarios = listOf(
            Pair("", 0),
            Pair("1", 1),
            Pair("1,2", 3)
    )
    private fun add(numbers: String): Int {
        if(numbers.isEmpty()) {
            return 0
        }
        val parts = numbers.split(",", "\n")
        val ints = parts.map { n -> if (n.isEmpty()) 0 else n.toInt() }
        return when(ints.size) {
            1 -> 1
            else -> ints.reduce { acc, n -> if(n < 0) throw Exception("negative numbers not allow") else acc + n }
        }
    }

    @Test
    fun testWithScenarios() {
        scenarios.forEach {scenario ->
            val result = add(scenario.first)
            assertEquals(scenario.second, result)
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
    fun testAddStringWithThreeNumbers() {
        val result = add("1,2,3")
        assertEquals(6, result)
    }
    @Test
    fun testAddStringWithThreeLargerNumbers() {
        val result = add("11,22,33")
        assertEquals(66, result)
    }
    @Test
    fun testAddStringWithNewLine() {
        val result = add("11\n22\n33")
        assertEquals(66, result)
    }
    @Test
    fun testAddStringWithNewLineAtTheEnd() {
        val result = add("11\n22\n33\n")
        assertEquals(66, result)
    }
    @Test(expected = NumberFormatException::class)
    fun testAddStringWithInvalidNumberShouldThrowError() {
        add("1,a")
    }
    @Test(expected = Exception::class)
    fun testAddStringWithNegativeNumberShouldThrowError() {
        add("1,-1")
    }
}
