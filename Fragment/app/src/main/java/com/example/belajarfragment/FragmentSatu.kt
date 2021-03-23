package com.example.belajarfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class FragmentSatu : Fragment() {

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }*/

    lateinit var btnFragment1: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_satu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentDua = FragmentDua()

        btnFragment1 = view.findViewById(R.id.btn_fragment1)
        btnFragment1.setOnClickListener{

            //Menggunakan Bundel
            val bundle = Bundle()
            bundle.putString(FragmentDua.EXTRA_NAME, "Name Data dari Fragment1")

            //Menggunakan Argunemts
            val desc = "Desc Data dari Fragment 1"
            fragmentDua.arguments = bundle
            fragmentDua.desc = desc

            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.container, fragmentDua, FragmentDua::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
}