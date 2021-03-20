package com.how.vitamin.data.remote

import com.how.vitamin.model.Character

interface RemoteDataSource {

    suspend fun getCharacters(type: String) : List<Character>

}