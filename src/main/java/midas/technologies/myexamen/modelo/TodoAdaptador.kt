package midas.technologies.myexamen.modelo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import midas.technologies.myexamen.R


class TodoAdapter(private val temp: List<Todo>, private val datos: Context) :
    RecyclerView.Adapter<TodoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titulo.text = temp[position].titulo
        holder.descripcion.text = temp[position].descripcion
    }

    override fun getItemCount(): Int {
        return temp.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titulo: TextView = itemView.findViewById(R.id.tvTitulo)
        var descripcion: TextView = itemView.findViewById(R.id.tvDescripcion)
    }
}
