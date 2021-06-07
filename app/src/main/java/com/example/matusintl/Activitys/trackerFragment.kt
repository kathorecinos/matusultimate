package com.example.matusintl.Activitys

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.matusintl.databinding.FragmentTrackerBinding
import com.google.gson.Gson
import com.parse.ParseUser


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [trackerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class trackerFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private var _binding: FragmentTrackerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTrackerBinding.inflate(inflater, container, false)
        val view = binding.root
        Log.wtf("test", Gson().toJson(ParseUser.getCurrentUser()))


        return view

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.buttonTrack.setOnClickListener {


            if (binding.vin.text?.trim().toString().isNotEmpty()
                    .toString().isNotEmpty()
            ) {
                val search = binding.vin.text.toString()
                val dato = ParseUser.getCurrentUser().get("Cars").hashCode()
                dato.toString().equals("search")

            } else {
                Log.d
            }

            activity?.let {
                val intent = Intent(it, carUp::class.java)
                it.startActivity(intent)
            }
        }
        return

        // if the dialog is cancelable

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment trackerFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            trackerFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}




