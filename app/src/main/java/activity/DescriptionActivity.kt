package activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.bookapp.R
import com.squareup.picasso.Picasso
import org.json.JSONObject
import java.util.HashMap

class DescriptionActivity : AppCompatActivity() {
    lateinit var imagebook:ImageView
    lateinit var txtBookName:TextView
    lateinit var txtBookAuthor:TextView
    lateinit var txtBookPrice:TextView
    lateinit var txtBookRating:TextView
    lateinit var txtDescription:TextView
    lateinit var progresslayout:RelativeLayout
    lateinit var progbar: ProgressBar
    lateinit var btnfav: Button
    var bookId:String?="100"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)
        imagebook=findViewById(R.id.imagebook)
        txtBookName=findViewById(R.id.txtBookName)
        txtBookAuthor=findViewById(R.id.txtBookAuthor)
        txtBookPrice=findViewById(R.id.txtBookPrice)
        txtBookRating=findViewById(R.id.txtBookRating)
        txtDescription=findViewById(R.id.txtDescription)
        progresslayout=findViewById(R.id.progresslayout)
        progresslayout.visibility= View.VISIBLE
        progbar=findViewById(R.id.progbar)
        progbar.visibility=View.VISIBLE

        if(intent!=null)
        {
           bookId= intent.getStringExtra("book_id")
        }
        else
        {
            finish()
            Toast.makeText(this@DescriptionActivity,"Some unexpected error has occured",Toast.LENGTH_SHORT).show()
        }
        if(bookId=="100")
        {
            finish()
            Toast.makeText(this@DescriptionActivity,"Some unexpected error has occured",Toast.LENGTH_SHORT).show()
        }
        val queue= Volley.newRequestQueue(this@DescriptionActivity)
        val url="http://13.235.250.119/v1/book/get_book/"
        val jsonParams=JSONObject()
        jsonParams.put("book_id",bookId)
        val jsonRequest=object:JsonObjectRequest(Request.Method.POST,url,jsonParams,Response.Listener {
                 try{
                     val success=it.getBoolean("success")
                     if(success)
                     {
                              val bookJsonObject=it.getJSONObject("book_data")
                         progresslayout.visibility=View.GONE
                         Picasso.get().load(bookJsonObject.getString("image"))
                         txtBookName.text=bookJsonObject.getString("name")
                         txtBookAuthor.text=bookJsonObject.getString("author")
                         txtBookPrice.text=bookJsonObject.getString("price")
                         txtBookRating.text=bookJsonObject.getString("rating")
                         txtDescription.text=bookJsonObject.getString("description")
                     }
                     else
                     {
                         Toast.makeText(this@DescriptionActivity,"Some unexpected error has occured",Toast.LENGTH_SHORT).show()
                     }

                 }catch(e:Exception){
                     Toast.makeText(this@DescriptionActivity,"Some unexpected error has occured",Toast.LENGTH_SHORT).show()
                 }
        },Response.ErrorListener {
            Toast.makeText(this@DescriptionActivity,"Volley error occured $it",Toast.LENGTH_SHORT).show()
        })
        {
            override fun getHeaders(): MutableMap<String, String> {
                val headers=HashMap<String,String>()
                headers["Content-type"]="application/json"
                headers["token"]="2334db3a8fd667"
                return headers
            }
        }
    }
}