package controllers

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

/**
 * MainController is responsible for managing the state and calculations of three values.
 * It provides getter and setter methods for each value and automatically recalculates the result
 * whenever any of the values are set.
 */
class MainController {
    private var firstValue: MutableState<String> = mutableStateOf("")
    private var secondValue: MutableState<String> = mutableStateOf("")
    private var thridValue: MutableState<String> = mutableStateOf("")
    private var resultValue: MutableState<String> = mutableStateOf("")

    /**
     * Retrieves the current value of the first value.
     * @return The current value of the first value.
     */
    fun getFirstValue(): String {
        return firstValue.value
    }

    /**
     * Sets the value of the first value and triggers a recalculation.
     * @param value The new value for the first value.
     */
    fun setFirstValue(value: String) {
        firstValue.value = value
        calculate()
    }

    /**
     * Retrieves the current value of the second value.
     * @return The current value of the second value.
     */
    fun getSecondValue(): String {
        return secondValue.value
    }

    /**
     * Sets the value of the second value and triggers a recalculation.
     * @param value The new value for the second value.
     */
    fun setSecondValue(value: String) {
        secondValue.value = value
        calculate()
    }

    /**
     * Retrieves the current value of the third value.
     * @return The current value of the third value.
     */
    fun getThridValue(): String {
        return thridValue.value
    }

    /**
     * Sets the value of the third value and triggers a recalculation.
     * @param value The new value for the third value.
     */
    fun setThridValue(value: String) {
        thridValue.value = value
        calculate()
    }

    /**
     * Retrieves the current result value.
     * @return The current result value.
     */
    fun getResultValue(): String {
        return resultValue.value
    }

    /**
     * Calculates the result value based on the current values of the first, second, and third values.
     * The calculation is defined as (secondValue * thirdValue) / firstValue.
     * If any of the values cannot be converted to a Double, the result value is set to an empty string.
     */
    private fun calculate() {
        val firstDouble = getFirstValue().toDoubleOrNull()
        val secondDouble = getSecondValue().toDoubleOrNull()
        val thirdDouble = getThridValue().toDoubleOrNull()

        if (firstDouble != null && secondDouble != null && thirdDouble != null) {
            val result = (secondDouble * thirdDouble) / firstDouble
            resultValue.value = String.format("%.2f", result)
        } else {
            resultValue.value = ""
        }
    }
}
