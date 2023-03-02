package com.example.submissionpemula

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvPlanets: RecyclerView
    private var list: ArrayList<Planet> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Planets List"

        rvPlanets = findViewById(R.id.rv_planets)
        rvPlanets.setHasFixedSize(true)
        //rvPlanets.addItemDecoration(DividerItemDecoration(rvPlanets.context, DividerItemDecoration.VERTICAL))

        list.addAll(PlanetsData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvPlanets.layoutManager = LinearLayoutManager(this)
        val listPlanetAdapter = ListPlanetAdapter(list, this)
        rvPlanets.adapter = listPlanetAdapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_profile -> {
                startActivity(Intent(this@MainActivity, AboutMeActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}