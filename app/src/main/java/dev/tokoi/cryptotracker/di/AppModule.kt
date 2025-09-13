package dev.tokoi.cryptotracker.di

import dev.tokoi.cryptotracker.core.data.networking.HttpClientFactory
import dev.tokoi.cryptotracker.crypto.data.networking.RemoteCoinDataSource
import dev.tokoi.cryptotracker.crypto.domain.CoinDataSource
import dev.tokoi.cryptotracker.crypto.presentation.coin_list.CoinListViewModel
import io.ktor.client.engine.cio.CIO
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single { HttpClientFactory.create(CIO.create()) }
//    single { RemoteCoinDataSource(get()) }
    singleOf(::RemoteCoinDataSource).bind<CoinDataSource>()

    viewModelOf(::CoinListViewModel)
}