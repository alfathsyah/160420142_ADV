package com.example.adv160420142week4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.adv160420142week4.R
import com.example.adv160420142week4.databinding.FragmentStudentDetailBinding
import com.example.adv160420142week4.databinding.StudentListItemBinding
import com.example.adv160420142week4.util.loadImage
import com.example.adv160420142week4.viewmodel.DetailViewModel
import com.google.android.material.textfield.TextInputEditText
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class StudentDetailFragment : Fragment() {

    private lateinit var detailViewModel: DetailViewModel
    private lateinit var dataBinding:FragmentStudentDetailBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate<FragmentStudentDetailBinding>(inflater, R.layout.fragment_student_detail, container, false)
        return dataBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailViewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        detailViewModel.refresh(StudentDetailFragmentArgs.fromBundle(requireArguments()).id)
        observeViewModel()

//        val txtID = view.findViewById<TextInputEditText>(R.id.txtID)
//        val txtName = view.findViewById<TextInputEditText>(R.id.txtName)
//        val txtBod = view.findViewById<TextInputEditText>(R.id.txtBod)
//        val txtPhone = view.findViewById<TextInputEditText>(R.id.txtPhone)
//        val imgView = view.findViewById<ImageView>(R.id.imageView2)
//        detailViewModel.studentLD.observe(viewLifecycleOwner)
//        {studentDetail ->
//            txtID.setText(studentDetail.id.toString())
//            txtName.setText(studentDetail.name.toString())
//            txtBod.setText(studentDetail.bod.toString())
//            txtPhone.setText(studentDetail.phone.toString())
//            var url = studentDetail.photoUrl
//            Picasso.get()
//                .load(url)
//                .resize(400, 400)
//                .centerCrop()
//                .error(R.drawable.baseline_error_24)
//                .into(imgView)
//        }
    }

    fun observeViewModel() {
        detailViewModel.studentLD.observe(viewLifecycleOwner, Observer {
            dataBinding.student = it
        })
    }

}