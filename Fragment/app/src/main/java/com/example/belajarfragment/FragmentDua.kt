package com.example.belajarfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class FragmentDua : Fragment() {

    lateinit var btnFragment2: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dua, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentSatu = FragmentSatu()

        btnFragment2 = view.findViewById(R.id.btn_fragment2)
        btnFragment2.setOnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.container, fragmentSatu, FragmentSatu::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
}