package dev.tokoi.cryptotracker.core.data.networking

import dev.tokoi.cryptotracker.BuildConfig

fun constructUrl(url: String): String {
    return when {
        url.contains(BuildConfig.COIN_BASE_URL) -> url
        url.startsWith("/") -> BuildConfig.COIN_BASE_URL + url.drop(1)
        else -> BuildConfig.COIN_BASE_URL + url
    }
}