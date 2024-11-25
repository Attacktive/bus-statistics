package xyz.attacktive.busstatistics.statistics.domain

data class ApiResponse<T>(private val comMsgHeader: CommonMessageHeader, private val msgHeader: MessageHeader, private val msgBody: MessageBody<T>) {
	data class CommonMessageHeader(private val responseTime: String?, private val responseMsgID: String?, private val requestMsgID: String?, private val returnCode: String?, private val successYN: String?, private val errMsg: String?)
	data class MessageHeader(private val headerMsg: String, val headerCd: String, private val itemCount: Int)
	data class MessageBody<T>(val itemList: List<T>?)

	val isSuccessful = (msgHeader.headerCd == "0")
	val items = msgBody.itemList
	val safeItems = items ?: emptyList()
	val safeFirstItem = if (safeItems.isEmpty()) {
		null
	} else {
		safeItems.first()
	}
}
