package com.example.testdiegoandroid

import android.arch.lifecycle.ViewModelProviders
import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import com.example.testdiegoandroid.Repositories.DeviceDataRepository
import com.example.testdiegoandroid.simpleViewModelFiles.MyViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel: MyViewModel by lazy {
        ViewModelProviders.of(this).get(MyViewModel::class.java)
    }

    private val changeObserver =
        Observer<Int> {
                value -> value?.let { incrementCount(value) }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.restoreState(savedInstanceState)
        viewModel.changeNotifier.observe(this, changeObserver)
        lifecycle.addObserver(viewModel)
        getBtn.setOnClickListener { viewModel.increment() }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        viewModel.saveState(outState)
    }

    private fun incrementCount(value: Int) {
        textView.text = (value).toString()
    }
/*CODE OF THE EXCERCICE
    lateinit var deviceDataRepository : DeviceDataRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        deviceDataRepository = DeviceDataRepository(this)

        textView.text = deviceDataRepository.getOrderStatus().toString()

        getBtn.setOnClickListener {
            deviceDataRepository.setOrderStatus((editText.text).toString().toInt())
            textView.text = deviceDataRepository.getOrderStatus().toString()
        }
        restartBtn.setOnClickListener {
            deviceDataRepository.setOrderStatus(0)
            textView.text = deviceDataRepository.getOrderStatus().toString()
        }
    }
*/
}
