package id.sardjito.fastmed.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import id.sardjito.fastmed.R
import id.sardjito.fastmed.databinding.ActivityAddPatientBinding
import id.sardjito.fastmed.scope.ScopeActivity
import id.sardjito.fastmed.viewmodels.PatientViewModel
import com.theartofdev.edmodo.cropper.CropImage
import android.app.Activity


class AddPatientActivity : ScopeActivity() {

    private val viewModel by viewModel<PatientViewModel>()

    private lateinit var binding : ActivityAddPatientBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            val result = CropImage.getActivityResult(data)
            if (resultCode == Activity.RESULT_OK) {
                val resultUri = result.uri
                binding.ktpImage.setImageURI(resultUri)
//                saveToStorage(resultUri)
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                val error = result.error
            }
        }
    }
}
