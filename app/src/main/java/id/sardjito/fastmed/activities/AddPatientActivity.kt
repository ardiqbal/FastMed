package id.sardjito.fastmed.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import id.sardjito.fastmed.R
import id.sardjito.fastmed.databinding.ActivityAddPatientBinding
import id.sardjito.fastmed.scope.ScopeActivity
import id.sardjito.fastmed.viewmodels.PatientViewModel

class AddPatientActivity : ScopeActivity() {

    private val viewModel by viewModel<PatientViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityAddPatientBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_add_patient
        )

        binding.lifecycleOwner = this

        binding.viewmodel = viewModel

        ArrayAdapter.createFromResource(
            this,
            R.array.gender_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            binding.spinner.adapter = adapter
        }

    }
}
