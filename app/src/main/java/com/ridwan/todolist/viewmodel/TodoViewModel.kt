package com.ridwan.todolist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.ridwan.todolist.database.TodoRepository
import com.ridwan.todolist.model.Todo

class TodoViewModel(application: Application): AndroidViewModel(application) {
    private var todoRepository = TodoRepository(application)
    private var todos: LiveData<List<Todo>>? = todoRepository.getTodos()


    fun getTodos(): LiveData<List<Todo>>? {
        return todos
    }

    fun insertTodo(todo: Todo) {
        todoRepository.insert(todo)
    }

    fun deleteTodo(todo: Todo) {
        todoRepository.delete(todo)
    }

    fun updateTodo(todo: Todo) {
        todoRepository.update(todo)
    }
}