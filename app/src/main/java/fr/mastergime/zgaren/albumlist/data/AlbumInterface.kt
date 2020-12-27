package fr.mastergime.zgaren.albumlist.data

import fr.mastergime.zgaren.albumlist.model.AlbumModel
import retrofit2.Call
import retrofit2.http.GET

interface AlbumInterface {
    @GET("img/shared/technical-test.json")
    fun getPost(): Call<List<AlbumModel>>
}