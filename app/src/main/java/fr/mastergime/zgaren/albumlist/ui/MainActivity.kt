package fr.mastergime.zgaren.albumlist.ui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import fr.mastergime.zgaren.albumlist.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: PostViewModel
    private lateinit var postsAdapter: PostsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(PostViewModel::class.java)

        viewModel.getPosts()
        // recycler
        recycler.layoutManager = LinearLayoutManager(this)
        postsAdapter = PostsAdapter()
        recycler.adapter = postsAdapter

        viewModel.postsMutableLiveData.observe(this, Observer { postsAdapter.setList(it) })
    }
}
