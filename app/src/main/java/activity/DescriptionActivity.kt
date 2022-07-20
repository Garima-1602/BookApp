package activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.bookapp.R

class DescriptionActivity : AppCompatActivity() {
    lateinit var imagebook:ImageView
    lateinit var txtBookName:TextView
    lateinit var txtBookAuthor:TextView
    lateinit var txtBookPrice:TextView
    lateinit var txtBookRating:TextView
    lateinit var txtDescription:TextView
    lateinit var progresslayout:RelativeLayout
    lateinit var progressBar: ProgressBar
    lateinit var btnfav: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)
        imagebook=findViewById(R.id.imagebook)
        txtBookName=findViewById(R.id.txtBookName)
        txtBookAuthor=findViewById(R.id.txtBookAuthor)
        txtBookPrice=findViewById(R.id.txtBookPrice)
        txtBookRating=findViewById(R.id.txtBookRating)
        txtDescription=findViewById(R.id.txtDescription)
        progresslayout=findViewById(R.id.progressLayout)
        progresslayout.visibility= View.VISIBLE
        progressBar=findViewById(R.id.progressBar)
        progressBar.visibility=View.VISIBLE

    }
}