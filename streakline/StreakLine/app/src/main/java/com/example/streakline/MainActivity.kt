package com.example.streakline

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var btnAddTask:Button
    lateinit var etTask:EditText
    lateinit var rvTask:RecyclerView

    lateinit var adapter:TaskAdapter

    var tasks = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUi()
    }

    private fun initUi() {
        initView()
        initListeners()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        rvTask.layoutManager = LinearLayoutManager(this)
        adapter = TaskAdapter(tasks)
        rvTask.adapter = adapter

    }

    private fun initListeners() {
        btnAddTask.setOnClickListener {addTask()}
    }

    private fun addTask() {
        val taskToAdd:String = etTask.text.toString()
        tasks.add(taskToAdd)
        adapter.notifyDataSetChanged()
        etTask.setText("")
    }

    private fun initView() {
        btnAddTask = findViewById(R.id.btnAddTask)
        etTask = findViewById(R.id.etTask)
        rvTask = findViewById(R.id.rvTasks)
    }
}