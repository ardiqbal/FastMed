package id.sardjito.fastmed.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import id.sardjito.fastmed.R
import id.sardjito.fastmed.databinding.ActivityPatientDetailBinding
import id.sardjito.fastmed.scope.ScopeActivity
import id.sardjito.fastmed.viewmodels.PatientViewModel
import kotlinx.coroutines.launch
import timber.log.Timber

class PatientDetailActivity : ScopeActivity() {

    private val viewModel by viewModel<PatientViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivityPatientDetailBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_patient_detail
        )

        val id = intent.getIntExtra("id", 0)

        subscribeUi(id, binding)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    private fun subscribeUi(id: Int, binding: ActivityPatientDetailBinding) = launch {
        viewModel.getPatientDetail(id.toString()).observe(this@PatientDetailActivity, Observer {
            Timber.d(it.data.toString())
            binding.patient = it.data
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
