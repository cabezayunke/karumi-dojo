package training.calculator.com.karumi_dojo.utils

interface RandomNumber {
    fun generate(): Int
}
class FakeRandomNumber(val value: Int): RandomNumber {
    override fun generate(): Int = value
}
class RealRandomNumber: RandomNumber {
    override fun generate(): Int = 100
}