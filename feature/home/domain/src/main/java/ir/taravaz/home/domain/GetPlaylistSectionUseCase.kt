package ir.taravaz.home.domain

import ir.taravaz.core.domain.model.PlaylistSection
import ir.taravaz.home.domain.repository.PlaylistRepository

class GetPlaylistSectionUseCase(
    private val repository: PlaylistRepository,
) {
    suspend operator fun invoke(): PlaylistSection {
        return repository.getPlaylist()
    }
}
