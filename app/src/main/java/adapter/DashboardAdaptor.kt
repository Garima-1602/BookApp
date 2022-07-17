package adapter

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bookapp.R
//construction two primary constructors
//adaptor class has viewholder inside it and viewholder is also a class
class DashboardRecyclerAdapter(val context: Context,val itemList:ArrayList<String>) :RecyclerView.Adapter<DashboardRecyclerAdapter.DashboardViewHolder>(){
    class DashboardViewHolder (view: View):RecyclerView.ViewHolder(view) {

   val textView:TextView=view.findViewById(R.id.txtBookname)



    }
//these methods are responsible for connceting the adaptor to the list
    override fun onCreateViewHolder(//responsible for creating 10 viewHolders
        parent: ViewGroup,
        viewType: Int
    ): DashboardRecyclerAdapter.DashboardViewHolder {
      val view=LayoutInflater.from(parent.context).inflate(R.layout.recycler_dashboard_single,parent,false)
    return DashboardViewHolder(view)
    }

//this method is responsible for recycling and reusing of viewholder
    override fun onBindViewHolder(
        holder: DashboardRecyclerAdapter.DashboardViewHolder,
        position: Int
    ) {
    val text= itemList[position]//store item present at zero of ArrayList
    holder.textView.text=text

    }

    //store number of count of list statically we know that
    override fun getItemCount(): Int {
       return itemList.size
    }
}