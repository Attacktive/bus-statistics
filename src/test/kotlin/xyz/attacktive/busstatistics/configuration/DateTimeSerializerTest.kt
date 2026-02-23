package xyz.attacktive.busstatistics.configuration

import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.Month
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertAll

class DateTimeSerializerTest {
	@Test
	fun `formatter round-trips LocalDateTime`() {
		val value = LocalDateTime(2025, 2, 23, 14, 30, 45)
		val formatted = DateTimeSerializer.formatter.format(value)
		assertEquals("2025-02-23 14:30:45", formatted)

		val parsed = DateTimeSerializer.formatter.parse(formatted)
		assertEquals(value, parsed)
	}

	@Test
	fun `digitOnlyFormatter parses and formats yyyyMMddHHmmss`() {
		val input = "20250223143000"
		val parsed = DateTimeSerializer.digitOnlyFormatter.parse(input)

		assertAll(
			{ assertEquals(2025, parsed.year) },
			{ assertEquals(Month.FEBRUARY, parsed.month) },
			{ assertEquals(23, parsed.day) },
			{ assertEquals(14, parsed.hour) },
			{ assertEquals(30, parsed.minute) },
			{ assertEquals(0, parsed.second) }
		)

		val formatted = DateTimeSerializer.digitOnlyFormatter.format(parsed)
		assertEquals(input, formatted)
	}

	@Test
	fun `digitOnlyFormatter parses 14-digit string yyyyMMddHHmmss`() {
		val padded = "20250223000000"
		val parsed = DateTimeSerializer.digitOnlyFormatter.parse(padded)

		assertAll(
			{ assertEquals(2025, parsed.year) },
			{ assertEquals(Month.FEBRUARY, parsed.month) },
			{ assertEquals(23, parsed.day) },
			{ assertEquals(0, parsed.hour) },
			{ assertEquals(0, parsed.minute) },
			{ assertEquals(0, parsed.second) }
		)
	}

	@Test
	fun `rfc3339LikeFormatter parses datetime with fractional seconds`() {
		val input = "2025-02-23 14:30:00.1"
		val parsed = DateTimeSerializer.rfc3339LikeFormatter.parse(input)

		assertNotNull(parsed)

		assertAll(
			{ assertEquals(2025, parsed.year) },
			{ assertEquals(Month.FEBRUARY, parsed.month) },
			{ assertEquals(23, parsed.day) },
			{ assertEquals(14, parsed.hour) },
			{ assertEquals(30, parsed.minute) },
			{ assertEquals(0, parsed.second) }
		)

		val formatted = DateTimeSerializer.rfc3339LikeFormatter.format(parsed)
		assertEquals(input, formatted)
	}

	@Test
	fun `rfc3339LikeFormatter round-trips with subsecond fraction`() {
		val value = LocalDateTime(2025, 2, 23, 14, 30, 0)
		val formatted = DateTimeSerializer.rfc3339LikeFormatter.format(value)
		assertEquals("2025-02-23 14:30:00.0", formatted)

		val parsed = DateTimeSerializer.rfc3339LikeFormatter.parse(formatted)
		assertEquals(value, parsed)
	}
}
