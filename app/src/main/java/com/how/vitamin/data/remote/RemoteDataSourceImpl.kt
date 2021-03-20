package com.how.vitamin.data.remote

import com.how.vitamin.data.service.HarryPotterService

class RemoteDataSourceImpl(private val service: HarryPotterService) : RemoteDataSource {

    override suspend fun getCharacters(type: String) = service.getCharacters(type)

}