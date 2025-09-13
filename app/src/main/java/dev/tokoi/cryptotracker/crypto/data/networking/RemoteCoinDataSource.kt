package dev.tokoi.cryptotracker.crypto.data.networking

import dev.tokoi.cryptotracker.core.data.networking.constructUrl
import dev.tokoi.cryptotracker.core.data.networking.safeCall
import dev.tokoi.cryptotracker.core.domain.util.NetworkError
import dev.tokoi.cryptotracker.core.domain.util.Result
import dev.tokoi.cryptotracker.core.domain.util.map
import dev.tokoi.cryptotracker.crypto.data.mappers.toCoin
import dev.tokoi.cryptotracker.crypto.data.networking.dto.CoinsResponseDto
import dev.tokoi.cryptotracker.crypto.domain.Coin
import dev.tokoi.cryptotracker.crypto.domain.CoinDataSource
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class RemoteCoinDataSource(
    private val httpClient: HttpClient
) : CoinDataSource {
    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return safeCall<CoinsResponseDto> {
            httpClient.get(
                urlString = constructUrl("/assets")
            )
        }.map { response ->
            response.data.map { it.toCoin() }
        }
    }
}