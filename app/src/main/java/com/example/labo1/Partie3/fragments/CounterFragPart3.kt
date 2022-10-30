package com.example.labo1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * @author Perrenoud Pascal
 * @author Seem Thibault
 */

class CounterFragPart3 : Fragment() {

    private var nbFrags: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            nbFrags = it.getInt(NB_FRAGS)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // création de la vue à partir du xml
        return inflater.inflate(R.layout.fragment_counter_part3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(savedInstanceState != null)
            nbFrags = savedInstanceState.getInt(NB_FRAGS, 0)

        // récupération du TextView
        val counterTv = view.findViewById<TextView>(R.id.counter_text)

        // initialisation du compteur de fragments
        counterTv.text = "$nbFrags"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(NB_FRAGS, nbFrags)
    }

    companion object {
        @JvmStatic
        fun newInstance(counter: Int = 0) =
            CounterFragPart3().apply {
                arguments = Bundle().apply {
                    putInt(NB_FRAGS, counter)
                }
            }

        const val NB_FRAGS = "nb_frags"
    }
}