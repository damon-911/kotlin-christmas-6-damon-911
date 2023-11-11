package christmas.util

object Validation {

    fun validateWrongDate(input: String): Int {
        val num = input.trim().toIntOrNull() ?: throw NumberFormatException(Messages.EXCEPTION_WRONG_DATE.message)
        require(num in Values.VALUE_START_DATE.value..Values.VALUE_END_DATE.value) {
            Messages.EXCEPTION_WRONG_DATE.message
        }
        return num
    }
}