package midas.technologies.myexamen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import midas.technologies.myexamen.modelo.ApiClient
import midas.technologies.myexamen.modelo.Todo
import midas.technologies.myexamen.modelo.TodoAdapter
import midas.technologies.myexamen.modelo.TodoApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var datos: List<Todo>? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var adaptador: TodoAdapter

    private lateinit var btnBuscar: Button
    private lateinit var etBuscador: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnBuscar = findViewById(R.id.btnBusacar)
        etBuscador = findViewById(R.id.editTextNumber)
        recyclerView = findViewById(R.id.rvLista)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)

        btnBuscar.setOnClickListener {
            mostrarDatos()
        }
    }

    private fun mostrarDatos() {
        val call: Call<List<Todo>> = ApiClient.getClient().create(TodoApi::class.java).getTodo()
        call.enqueue(object : Callback<List<Todo>> {
            override fun onResponse(call: Call<List<Todo>>, response: Response<List<Todo>>) {
                if (response.isSuccessful) {
                    datos = response.body()
                    adaptador = TodoAdapter(datos!!, applicationContext)
                    recyclerView.adapter = adaptador
                }
            }

            override fun onFailure(call: Call<List<Todo>>, t: Throwable) {

            }
        })
    }
}
