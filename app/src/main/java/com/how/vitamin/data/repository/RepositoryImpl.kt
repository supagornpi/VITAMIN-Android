package com.how.vitamin.data.repository

import com.how.vitamin.data.remote.RemoteDataSource

class RepositoryImpl(private val remoteDataSource: RemoteDataSource) : Repository {

    override suspend fun getCharacters(type: String) =
        remoteDataSource.getCharacters(type)

}