package com.eu.electrolab


import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Calculator : Fragment() {




        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_calculator, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.rv_recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = MyAdapter()



        return view


    }


        class MyAdapter : RecyclerView.Adapter<MyAdapter.ViewHolder>(), View.OnClickListener {

        private val items = listOf(
            "Item 1",
            "Item 2",
            "Item 3",
            "Item 4",
            "Item 5",
            "Item 6",
            "Item 7",
            "Item 8",
            "Item 9",
            "Item 10",
            "Item 11",
            "Item 12"
        )
        private val image = listOf(
            R.drawable.ic_launcher_background,
            android.R.drawable.arrow_up_float,
            android.R.drawable.ic_dialog_map,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            android.R.drawable.ic_menu_save,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
        )

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_calculator, parent, false)
            view.setOnClickListener(this)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.textView.text = items[position]
            holder.imageView.setImageResource(image[position])
            holder.itemView.tag = position


        }

        override fun getItemCount(): Int {
            return items.size
        }

        override fun onClick(view: View) {
            val position = view.tag as Int
            val item = items[position]
            Toast.makeText(view.context, "Clicked on item $position: $item", Toast.LENGTH_SHORT)
                .show()
            val context = view.context
            when (position) {
                0 -> {
                    val intent = Intent(context, Item1::class.java)
                    context.startActivity(intent)
                }
                1 -> {}
                2 -> {}
                3 -> {}
                4 -> {}
            }

        }




        class ViewHolder(view: View) :
            RecyclerView.ViewHolder(view) {
            val textView: TextView = view.findViewById(R.id.tv_title)
            val imageView: ImageView = view.findViewById(R.id.iv_image)



   }
    }
}

