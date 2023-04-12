package garousi.dev.taravaz.home.domain.use_case

import garousi.dev.taravaz.home.domain.model.Banner

sealed interface GetBannersResult {
    data class Success(val data: List<Banner>) : GetBannersResult
    sealed interface Failure {
        data class Unknown(val message : String) : GetBannersResult
    }
}
