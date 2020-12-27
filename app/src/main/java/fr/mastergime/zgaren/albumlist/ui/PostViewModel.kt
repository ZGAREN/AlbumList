package fr.mastergime.zgaren.albumlist.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fr.mastergime.zgaren.albumlist.data.PostAlbum
import fr.mastergime.zgaren.albumlist.model.AlbumModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PostViewModel : ViewModel() {
    var postsMutableLiveData: MutableLiveData<List<AlbumModel>> = MutableLiveData()

    // callback
    fun getPosts() {
        PostAlbum.getInstance()?.getPosts()
            ?.enqueue(object : Callback<List<AlbumModel>> {
                override fun onResponse(
                    call: Call<List<AlbumModel>>,
                    response: Response<List<AlbumModel>>
                ) {
                    postsMutableLiveData.value = response.body()
                }

                override fun onFailure(
                    call: Call<List<AlbumModel>>,
                    t: Throwable?
                ) {
                }
            })
    }
}