package dev.tokoi.cryptotracker.crypto.presentation.coin_list

import dev.tokoi.cryptotracker.core.domain.util.NetworkError

sealed interface CoinListEvent {
    data class Error(val error: NetworkError) : CoinListEvent
}