package id.sardjito.fastmed.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.sardjito.fastmed.models.Patient
import id.sardjito.fastmed.repositories.PatientRepository
import timber.log.Timber
import javax.inject.Inject

class PatientViewModel @Inject constructor(
    val patientRepository: PatientRepository
) : ViewModel() {

    val name = MutableLiveData<String>()

    suspend fun getPendingPatients() = patientRepository.getPendingPatients()

    suspend fun getProcessPatients() = patientRepository.getProcessPatients()

    suspend fun getPickedupPatients() = patientRepository.getPickedupPatients()

    suspend fun getFinishPatients() = patientRepository.getFinishPatients()

    suspend fun getPatientDetail(id: String) = patientRepository.getPatientDetail(id)

    fun onLike() {
        Timber.d(name.value)
    }
}