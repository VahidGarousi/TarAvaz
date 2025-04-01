package ir.taravaz.home.domain

import ir.taravaz.core.common.util.DataError
import ir.taravaz.core.common.util.Result
import ir.taravaz.core.domain.model.PlaylistSection
import ir.taravaz.home.domain.repository.PlaylistRepository

class GetPlaylistSectionUseCase(
    private val repository: PlaylistRepository,
) {
    suspend operator fun invoke(): Result<PlaylistSection, DataError.Network> {
        return repository.getPlaylist()
    }
}
