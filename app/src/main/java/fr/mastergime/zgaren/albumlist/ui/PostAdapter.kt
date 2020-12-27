package fr.mastergime.zgaren.albumlist.ui


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.squareup.picasso.Picasso
import fr.mastergime.zgaren.albumlist.R
import fr.mastergime.zgaren.albumlist.model.AlbumModel


class PostsAdapter : RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {
    private var AlbumList: List<AlbumModel> = ArrayList()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostViewHolder {
        return PostViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.album_item, parent, false)
        )
    }

    override fun onBindViewHolder(
        holder: PostViewHolder,
        position: Int
    ) {
        holder.albumid.text = AlbumList[position].albumId.toString()
        holder.id.text = AlbumList[position].id.toString()
        holder.title.text = AlbumList[position].title
        holder.url.text = AlbumList[position].url

        //Picasso.get().load(AlbumList[position].url).fit().centerCrop().into(holder.url)
        Picasso.get().load(AlbumList[position].thumbnailUrl).fit().centerCrop().into(holder.thumbnailUrl)

    }

    override fun getItemCount(): Int {
        return AlbumList.size
    }

    fun setList(albumList: List<AlbumModel>) {
        this.AlbumList = albumList
        notifyDataSetChanged()
    }

    inner class PostViewHolder(itemView: View) : ViewHolder(itemView) {
        var albumid: TextView
        var id: TextView
        var title: TextView
        var url: TextView
        var thumbnailUrl: ImageView

        init {
            albumid = itemView.findViewById(R.id.id_album_textview)
            id = itemView.findViewById(R.id.Id_textView)
            title = itemView.findViewById(R.id.title_textView)
            url = itemView.findViewById(R.id.url_image_view)
            thumbnailUrl = itemView.findViewById(R.id.thumbnailUrl_image_view)
        }
    }
}