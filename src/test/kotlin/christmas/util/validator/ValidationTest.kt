package christmas.util.validator

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ValidationTest {

    @Test
    fun `정상적으로 방문 날짜를 입력하면 예외가 발생하지 않습니다`() {
        assertDoesNotThrow {
            Validation.validateWrongDate("20")
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "0", "32"])
    fun `정상 범위 밖의 방문 날짜를 입력하면 예외가 발생합니다`(input: String) {
        assertThrows<IllegalArgumentException> {
            Validation.validateWrongDate(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "ab"])
    fun `방문 날짜에 숫자가 아닌 값을 입력하면 예외가 발생합니다`(input: String) {
        assertThrows<NumberFormatException> {
            Validation.validateWrongDate(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["타파스-1", "바비큐립-1,아이스크림-2", "해산물파스타-2,레드와인-3,초코케이크-1"])
    fun `정상적으로 형식에 맞춰 메뉴 주문을 입력하면 예외가 발생하지 않습니다`(input: String) {
        assertDoesNotThrow {
            Validation.validateWrongMenuFormat(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["타파스", "바비큐립-", "아이스크림1", "제로콜라-2,", "해산물파스타-2,레드와인-3,초코케이크"])
    fun `올바르지 않은 형식으로 입력하면 예외가 발생합니다`(input: String) {
        assertThrows<IllegalArgumentException> {
            Validation.validateWrongMenuFormat(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["타파스-1", "아이스크림-20"])
    fun `정상적으로 메뉴 이름과 개수를 입력하면 예외가 발생하지 않습니다`(menu: String) {
        assertDoesNotThrow {
            Validation.validateWrongMenuInfo(menu)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["크림파스타-1", "티본스테이크-0", "양송이수프-21"])
    fun `메뉴에 없는 이름을 입력하거나 정상 범위 밖의 개수를 입력하면 예외가 발생합니다`(menu: String) {
        assertThrows<IllegalArgumentException> {
            Validation.validateWrongMenuInfo(menu)
        }
    }

    @Test
    fun `주문한 메뉴에 중복된 메뉴가 존재하면 예외가 발생합니다`() {
        val order = listOf("타파스-2", "아이스크림-1", "타파스-1")
            .map { Validation.validateWrongMenuInfo(it) }
        assertThrows<IllegalArgumentException> {
            Validation.validateTotalMenus(order)
        }
    }

    @Test
    fun `주문한 메뉴에 음료만 존재하면 예외가 발생합니다`() {
        val order = listOf("제로콜라-2", "샴페인-1")
            .map { Validation.validateWrongMenuInfo(it) }
        assertThrows<IllegalArgumentException> {
            Validation.validateTotalMenus(order)
        }
    }

    @Test
    fun `주문한 메뉴의 총 개수가 20개를 넘으면 예외가 발생합니다`() {
        val order = listOf("시저샐러드-8", "해산물파스타-6", "초코케이크-4", "레드와인-3")
            .map { Validation.validateWrongMenuInfo(it) }
        assertThrows<IllegalArgumentException> {
            Validation.validateTotalMenus(order)
        }
    }
}