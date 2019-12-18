package com.hjcorp.lunaproject.game1

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hjcorp.lunaproject.R

class Game1Fragment : Fragment() {

    companion object {
        fun newInstance() = Game1Fragment()
    }

    private lateinit var viewModel: Game1ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.game1_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(Game1ViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
