package ir.taravaz.core.playlist.domain.usecase

import ir.taravaz.core.common.util.DataError
import ir.taravaz.core.common.util.Result
import ir.taravaz.core.playlist.domain.model.PlaylistSection
import ir.taravaz.core.playlist.domain.repository.PlaylistRepository

class GetPlaylistSectionUseCase (
    private val repository: PlaylistRepository
){
    suspend operator fun invoke(): Result<PlaylistSection, DataError.Network> {
        return repository.getPopularPlaylistSection()
    }
}
