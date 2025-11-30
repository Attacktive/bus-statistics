package xyz.attacktive.busstatistics.statistics.domain

import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import org.junit.jupiter.api.Test

class ApiResponseTest {
	@Test
	fun `should be successful when header code is 0`() {
		val response = ApiResponse(
			comMsgHeader = ApiResponse.CommonMessageHeader(
				responseTime = null,
				responseMsgID = null,
				requestMsgID = null,
				returnCode = "0",
				successYN = "Y",
				errMsg = null
			),
			msgHeader = ApiResponse.MessageHeader(
				headerMsg = "success",
				headerCd = "0",
				itemCount = 2
			),
			msgBody = ApiResponse.MessageBody(listOf("item1", "item2"))
		)

		assertTrue(response.isSuccessful)
		assertEquals(2, response.safeItems.size)
		assertEquals("item1", response.safeFirstItem)
	}

	@Test
	fun `should handle empty response gracefully`() {
		val response = ApiResponse(
			comMsgHeader = ApiResponse.CommonMessageHeader(
				responseTime = null,
				responseMsgID = null,
				requestMsgID = null,
				returnCode = "1",
				successYN = "N",
				errMsg = "Error"
			),
			msgHeader = ApiResponse.MessageHeader(
				headerMsg = "error",
				headerCd = "1",
				itemCount = 0
			),
			msgBody = ApiResponse.MessageBody<String>(null)
		)

		assertFalse(response.isSuccessful)
		assertEquals(emptyList(), response.safeItems)
	}
}
