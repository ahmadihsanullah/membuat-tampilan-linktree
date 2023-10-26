package belajar.android.studi.kasus.linktree

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var image: ImageView
    private lateinit var logo: ImageView
    private lateinit var title: TextView
    private lateinit var subtitle: TextView
    private lateinit var list: RecyclerView
    private lateinit var footerdesc: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        image = findViewById(R.id.image)
        title = findViewById(R.id.title)
        subtitle = findViewById(R.id.subtitle)
        logo = findViewById(R.id.logo)
        list = findViewById(R.id.list)
        footerdesc = findViewById(R.id.footerdesc)

        image.setImageResource(R.drawable.pribadi1)
        title.text = "Ahmad Ihsanullah Rabbani"
        subtitle.text = "Software Engineer"
        logo.setImageResource(R.drawable.logo)
        footerdesc.text = "programming learner"

        list.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = linkAdapter
        }


    }

    private val linkAdapter by lazy {
        val items = listOf<LinktreeModel>(
            LinktreeModel(R.drawable.fb,"Facebook","fb.com"),
            LinktreeModel(R.drawable.ig,"Instagram","https://instagram.com/ahmadihsanullahrabbani"),
            LinktreeModel(R.drawable.linkedin,"Linkedin","https://www.linkedin.com/in/ahmad-ihsanullah-rabbani-392b64219/"),
            LinktreeModel(R.drawable.web,"Website","kreasi.nurulfikri.ac.id/ahma21327ti/faskes"),
            LinktreeModel(R.drawable.wa,"WhatsApp","https://wa.me/628979276362"),
        )

        LinktreeAdapter(
            items, object : LinktreeAdapter.OnAdapterListener{
                override fun onClick(linktree: LinktreeModel) {
                    Log.e("onClick", linktree.url)
                    openUrl(linktree.url)
                }
            }
        )
    }

    private fun openUrl(url:String){
        val openUrl = Intent(Intent.ACTION_VIEW)
        openUrl.data = Uri.parse(url)
        startActivity(openUrl)
    }
}