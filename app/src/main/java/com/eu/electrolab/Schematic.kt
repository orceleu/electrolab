package com.eu.electrolab

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Schematic : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_schematic, container, false)

        val recyclerView1: RecyclerView = view.findViewById(R.id.rv_schematic)

        recyclerView1.layoutManager = GridLayoutManager(context,2)
        recyclerView1.adapter = Schematic.MyAdapter1()



        return view

    }
    class MyAdapter1 : RecyclerView.Adapter<MyAdapter1.ViewHolder>(), View.OnClickListener {

        private val items = listOf(
            "Paire de darlington",
            "amplificateur differentiel",
            "amplificateur a MOSFET",
            "Multivibrateur astable",
            "Oscillateur Colpitts",
            "Amplificateur classe A",
            "Amplificateur classe B",
            "Amplificateur classe C",
            "Amplificateur classe D",
            "filtre passe bas",
            "filtre passe haut",
            "regulateur de tension a zener",
            "multiplicateur de tension",
            "regulateur 78xx"
        )
        private val image = listOf(
            R.drawable.darlington,
            R.drawable.differencial,
            R.drawable.mosfet,
            R.drawable.multivibrateur,
            R.drawable.colpitts,
            R.drawable.amp_a,
            R.drawable.amp_b,
            R.drawable.amp_c,
            R.drawable.amp_d,
            R.drawable.filtre_b,
            R.drawable.filtre_h,
            R.drawable.reg_zener,
            R.drawable.pont_diode,
            R.drawable.regulateur_78xx
        )

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_schematic, parent, false)
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
           //Toast.makeText(view.context, "Clicked on item $position: $item", Toast.LENGTH_SHORT)
             //   .show()
            val context = view.context
            when (position) {
                0 -> { val intent = Intent(context, ActivityDarlington::class.java)
                    context.startActivity(intent) }
                1 -> { val intent = Intent(context, DifferentialAmp::class.java)
                    context.startActivity(intent)}
                2 -> { val intent = Intent(context, MosfetAmp::class.java)
                    context.startActivity(intent)}
                3 -> { val intent = Intent(context, Multivibrator::class.java)
                    context.startActivity(intent)}
                4 -> { val intent = Intent(context, ColpittsOsc::class.java)
                    context.startActivity(intent)}
                5-> { val intent = Intent(context, AmpA::class.java)
                    context.startActivity(intent)}
                6-> { val intent = Intent(context, AmpB::class.java)
                    context.startActivity(intent)}
                7-> { val intent = Intent(context, AmpC::class.java)
                    context.startActivity(intent)}
                8-> { val intent = Intent(context, AmpD::class.java)
                    context.startActivity(intent)}
                9-> { val intent = Intent(context, FiltreB::class.java)
                    context.startActivity(intent)}
                10-> { val intent = Intent(context, FiltreH::class.java)
                    context.startActivity(intent)}
                11-> { val intent = Intent(context, RegulatorZener::class.java)
                    context.startActivity(intent)}
                12-> { val intent = Intent(context, MultiplicateurDeTension::class.java)
                    context.startActivity(intent)}
                13-> { val intent = Intent(context, RegulateurDeTension::class.java)
                    context.startActivity(intent)}

            }

        }




        class ViewHolder(view: View) :
            RecyclerView.ViewHolder(view) {
            val textView: TextView = view.findViewById(R.id.tv_schematic)
            val imageView: ImageView = view.findViewById(R.id.iv_schematic)



        }
    }

}