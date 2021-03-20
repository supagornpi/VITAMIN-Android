package com.how.vitamin.di

import com.how.vitamin.data.repository.Repository
import com.how.vitamin.data.repository.RepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<Repository> { RepositoryImpl(remoteDataSource = get()) }
}