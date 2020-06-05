package com.thealphamerc.kotlin_calsee

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.thealphamerc.kotlin_calsee.databinding.MainScreenFragmentBinding


class MainScreen : Fragment() {

    companion object {
        fun newInstance() = MainScreen()
    }

    private lateinit var viewModel: MainScreenViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return inflater.inflate(R.layout.main_screen_fragment, container, false)

        val binding: MainScreenFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.main_screen_fragment, container, false
        )


        val viewModelFactory = CalcViewModelFactory()

        binding.lifecycleOwner = this

        val viewModel =
            ViewModelProviders.of(
                this, viewModelFactory
            ).get(MainScreenViewModel::class.java)

        binding.mainScreenViewModel = viewModel

        // Inflate the layout for this fragment
        return binding.root/* inflater.inflate(R.layout.fragment_main, container, false) */


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainScreenViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
