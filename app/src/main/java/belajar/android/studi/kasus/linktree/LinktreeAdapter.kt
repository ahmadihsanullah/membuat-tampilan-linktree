package belajar.android.studi.kasus.linktree

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LinktreeAdapter(
    val linktrees : List<LinktreeModel>,
    val listener: OnAdapterListener
): RecyclerView.Adapter<LinktreeAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.image)
        val title = view.findViewById<TextView>(R.id.title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LinktreeAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.linktree_adapter,parent,false)
        )
    }

    override fun onBindViewHolder(holder: LinktreeAdapter.ViewHolder, position: Int) {
        val linktree = linktrees[position]
        holder.image.setImageResource(linktree.image)
        holder.title.text = linktree.title
        holder.itemView.setOnClickListener{
            listener.onClick(linktree)
        }
    }

    override fun getItemCount() = linktrees.size

    interface OnAdapterListener{
        fun onClick(linktree: LinktreeModel)
    }
}