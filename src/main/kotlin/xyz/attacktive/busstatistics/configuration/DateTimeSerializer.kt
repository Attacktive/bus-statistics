package xyz.attacktive.busstatistics.configuration

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.format.char

object DateTimeSerializer {
	val formatter = LocalDateTime.Format {
		year()
		char('-')
		monthNumber()
		char('-')
		day()
		char(' ')
		hour()
		char(':')
		minute()
		char(':')
		second()
	}

	val digitOnlyFormatter = LocalDateTime.Format {
		year()
		monthNumber()
		day()
		hour()
		minute()
		second()
	}

	val rfc3339LikeFormatter = LocalDateTime.Format {
		year()
		char('-')
		monthNumber()
		char('-')
		day()
		char(' ')
		hour()
		char(':')
		minute()
		char(':')
		second()
		char('.')
		secondFraction(1)
	}
}
