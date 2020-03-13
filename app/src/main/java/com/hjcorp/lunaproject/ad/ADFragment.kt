package com.hjcorp.lunaproject.ad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.hjcorp.lunaproject.R
import com.hjcorp.lunaproject.shared.BaseFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.ad_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.lang.Exception

class ADFragment : BaseFragment() {

    private val viewModel by viewModel<ADViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.ad_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        image_button_youtube.setOnClickListener {
            redirectToYoutube()
        }
    }

    override fun bindProperties(disposable: CompositeDisposable) {
        disposable.add(
            viewModel.everySeconds()
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext {
                    viewModel.count++
                    try {
                        progress_bar_youtube.progress = viewModel.count * 50
                    } catch ( ex: Exception ) { }
                }
                .doOnComplete {
                    nav_host.findNavController().navigate(R.id.lobbyFragment)
                }
                .subscribe()
        )
    }
}
