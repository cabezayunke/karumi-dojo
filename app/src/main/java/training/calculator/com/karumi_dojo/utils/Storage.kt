package training.calculator.com.karumi_dojo.utils

import android.content.Context

interface Storage {
    fun save(value: Int)
    fun get():Int
    fun clear()
}

class PreferencesStorage(private val context: Context): Storage {

    companion object {
        const val MAGIC_PREFS = "magic_prefs"
        const val MAGIC_NUMBER = "magic_number"
    }

    override fun save(value: Int) {
        val editor = context.getSharedPreferences(MAGIC_PREFS, Context.MODE_PRIVATE).edit()
        editor.putInt(MAGIC_NUMBER, value)
        editor.apply()
    }

    override fun get():Int = context.getSharedPreferences(MAGIC_PREFS, Context.MODE_PRIVATE).getInt(MAGIC_NUMBER, 0)

    override fun clear() {
        context.getSharedPreferences(MAGIC_PREFS, Context.MODE_PRIVATE).edit().remove(MAGIC_NUMBER).apply()
    }
}

class FakeStorage: Storage {
    var storedValue = 0
    override fun save(value: Int) {
        storedValue = value
    }

    override fun get():Int = storedValue

    override fun clear() {
        storedValue = 0
    }
}