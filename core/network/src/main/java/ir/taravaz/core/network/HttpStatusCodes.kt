package ir.taravaz.core.network

object HttpStatusCodes {
    const val UNAUTHORIZED = 401
    const val REQUEST_TIMEOUT = 408
    const val CONFLICT = 409
    const val PAYLOAD_TOO_LARGE = 413
    const val TOO_MANY_REQUESTS = 429
    const val NOT_FOUND = 404

    private const val SUCCESS_START = 200
    private const val SUCCESS_END = 299
    val SUCCESS_RANGE = SUCCESS_START..SUCCESS_END

    private const val SERVER_ERROR_START = 500
    private const val SERVER_ERROR_END = 599
    val SERVER_ERROR_RANGE = SERVER_ERROR_START..SERVER_ERROR_END
}
