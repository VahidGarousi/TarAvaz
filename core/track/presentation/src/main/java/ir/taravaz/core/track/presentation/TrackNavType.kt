package ir.taravaz.core.track.presentation

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import ir.taravaz.core.track.presentation.model.TrackUi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class TrackNavType(
    private val json: Json,
) : NavType<TrackUi>(isNullableAllowed = false) {
    override fun get(
        bundle: Bundle,
        key: String,
    ): TrackUi? {
        return json.decodeFromString(bundle.getString(key) ?: return null)
    }

    override fun put(
        bundle: Bundle,
        key: String,
        value: TrackUi,
    ) {
        bundle.putString(key, json.encodeToString(value))
    }

    override fun parseValue(value: String): TrackUi = json.decodeFromString(Uri.decode(value))

    override fun serializeAsValue(value: TrackUi): String = Uri.encode(json.encodeToString(value))
}
