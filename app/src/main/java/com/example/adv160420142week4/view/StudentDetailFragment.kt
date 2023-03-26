package com.example.adv160420142week4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.adv160420142week4.R
import com.example.adv160420142week4.viewmodel.DetailViewModel
import com.google.android.material.textfield.TextInputEditText

class StudentDetailFragment : Fragment() {

    private lateinit var detailViewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailViewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        detailViewModel.fetch()
        val txtID = view.findViewById<TextInputEditText>(R.id.txtID)
        val txtName = view.findViewById<TextInputEditText>(R.id.txtName)
        val txtBod = view.findViewById<TextInputEditText>(R.id.txtBod)
        val txtPhone = view.findViewById<TextInputEditText>(R.id.txtPhone)
        detailViewModel.studentLD.observe(viewLifecycleOwner){studentDetail ->
            txtID.setText(studentDetail.id.toString())
            txtName.setText(studentDetail.name.toString())
            txtBod.setText(studentDetail.dob.toString())
            txtPhone.setText(studentDetail.phone.toString())
        }
    }
}