package training.calculator.com.karumi_dojo.utils

import java.util.*

class MockClock: Clock() {
    var nowOverride: Date = Date()
    override fun now(): Date = nowOverride
}