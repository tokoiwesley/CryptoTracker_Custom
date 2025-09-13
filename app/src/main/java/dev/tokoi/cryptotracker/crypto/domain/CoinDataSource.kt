package dev.tokoi.cryptotracker.crypto.domain

import dev.tokoi.cryptotracker.core.domain.util.NetworkError
import dev.tokoi.cryptotracker.core.domain.util.Result

interface CoinDataSource {
    suspend fun getCoins(): Result<List<Coin>, NetworkError>
}