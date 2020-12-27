package fr.mastergime.zgaren.albumlist.data

import fr.mastergime.zgaren.albumlist.model.AlbumModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private lateinit var albumInterface: AlbumInterface

class PostAlbum {

    companion object {
        const val BASE_URL = "https://static.leboncoin.fr/"
        private var INSTANCE: PostAlbum? = null
        fun getInstance(): PostAlbum? {
            if (INSTANCE == null)
                INSTANCE = PostAlbum()
            return INSTANCE
        }
    }

    init {
        val retrofit: Retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
        albumInterface = retrofit.create(AlbumInterface::class.java)
    }

    fun getPosts(): Call<List<AlbumModel>> {
        return albumInterface.getPost()
    }

}
