package com.example.submissionpemula

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import org.w3c.dom.Text

class DetailPlanetActivity : AppCompatActivity() {

    companion object {
        const val PLANET_IMAGE = "extra_image_resource"
        const val PLANET_NAME = "extra_name"
        const val PLANET_DETAIL = "extra_detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_planet)
        supportActionBar?.title = "Planet"

        supportActionBar?.apply {
            elevation = 0f
            setDisplayHomeAsUpEnabled(true)
        }

        val tvPlanetName: TextView = findViewById(R.id.planet_name)
        val tvPlanetDetail: TextView = findViewById(R.id.planet_detail)
        val imgShare: ImageView = findViewById(R.id.share_image)

        Glide.with(this)
            .load(intent.getIntExtra(PLANET_IMAGE, 0))
            .apply(RequestOptions().override(250, 250))
            .into(findViewById(R.id.planet_image))

        tvPlanetName.text = intent.getStringExtra(PLANET_NAME)
        tvPlanetDetail.text = intent.getStringExtra(PLANET_DETAIL)

        val planetName = intent.getStringExtra(PLANET_NAME)

        imgShare.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.apply {
                setType("text/html")
                putExtra(Intent.EXTRA_EMAIL, "v.rizya22@placeholder.com")
                putExtra(Intent.EXTRA_SUBJECT, "Planet")
                putExtra(Intent.EXTRA_TEXT, "Hi My favorite planet is $planetName, What's yours?\n\n\n#FavoritePlanet")
            }
            startActivity(Intent.createChooser(intent, "Share Planet"))
        }

        intent.getStringExtra(PLANET_NAME)?.let { Log.d("planet name: ", it) }
        intent.getStringExtra(PLANET_DETAIL)?.let { Log.d("detail: ", it) }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}