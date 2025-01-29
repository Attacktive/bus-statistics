package xyz.attacktive.busstatistics.configuration

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.format.char
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object DateTimeSerializer: KSerializer<LocalDateTime> {
	override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor(LocalDateTime::class.qualifiedName!!, PrimitiveKind.STRING)

	val formatter = LocalDateTime.Format {
		year()
		char('-')
		monthNumber()
		char('-')
		dayOfMonth()
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
		dayOfMonth()
		hour()
		minute()
		second()
	}

	val rfc3339LikeFormatter = LocalDateTime.Format {
		year()
		char('-')
		monthNumber()
		char('-')
		dayOfMonth()
		char(' ')
		hour()
		char(':')
		minute()
		char(':')
		second()
		char('.')
		secondFraction(1)
	}

	override fun serialize(encoder: Encoder, value: LocalDateTime) = encoder.encodeString(formatter.format(value))

	override fun deserialize(decoder: Decoder) = throw NotImplementedError("It's not supposed to be invoked.")
}
