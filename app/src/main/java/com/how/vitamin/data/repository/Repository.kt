package com.how.vitamin.data.repository

import com.how.vitamin.model.Character

interface Repository {

    suspend fun getCharacters(type: String) : List<Character>

}