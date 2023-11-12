package christmas.util

object Validation {

    fun validateWrongDate(input: String): Int {
        val num = input.trim().toIntOrNull() ?: throw NumberFormatException(Texts.EXCEPTION_WRONG_DATE.text)
        require(num in Values.DATE_START.value..Values.DATE_END.value) {
            Texts.EXCEPTION_WRONG_DATE.text
        }
        return num
    }

    fun validateWrongMenuFormat(input: String) {
        require(input.matches(Regex("[a-zA-Z]+-[0-9]+(,[a-zA-Z]+-[0-9]+)*"))) {
            Texts.EXCEPTION_WRONG_MENU.text
        }
    }

    fun validateWrongMenuInfo(menu: String): Pair<String, Int> {
        val menuInfo = menu.split("-")
        val menuName = validateMenuName(menuInfo[0])
        val menuCount = validateMenuCount(menuInfo[1])
        return Pair(menuName, menuCount)
    }

    private fun validateMenuName(menuName: String): String {
        return menuName
    }

    private fun validateMenuCount(menuCount: String): Int {
        return menuCount.toInt()
    }
}