package com.how.vitamin.di

import com.how.vitamin.data.remote.RemoteDataSource
import com.how.vitamin.data.remote.RemoteDataSourceImpl
import org.koin.dsl.module

val dataSourceModule = module {
    single<RemoteDataSource> { RemoteDataSourceImpl(service = get()) }
}