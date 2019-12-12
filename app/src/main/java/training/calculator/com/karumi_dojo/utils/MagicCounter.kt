package training.calculator.com.karumi_dojo.utils

class MagicCounter(private val storage: Storage, private val random: RandomNumber) {
    fun increment(): Int {
         val value = random.generate()
         val result = storage.get() + (if(value > 100) value else 1)
         storage.save(result)
         return result
    }

    fun decrement(): Int {
        val currentValue = storage.get()
        val result = currentValue - 1
        storage.save(result)
        return result
    }
}
