package midas.technologies.myexamen.modelo

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface TodoApi {
    @GET("api/todos")
    fun getTodo(): Call<List<Todo>>

    @POST("api/todo")
    fun setTodo(): Call<String>
}