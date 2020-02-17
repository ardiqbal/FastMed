package id.sardjito.fastmed.repositories

import android.net.Uri
import androidx.lifecycle.LiveData
import com.google.gson.JsonObject
import id.sardjito.fastmed.models.ResultPatient
import id.sardjito.fastmed.models.ResultPatients
import id.sardjito.fastmed.network.AppNetworkDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PatientRepository @Inject constructor(private val appNetworkDataSource: AppNetworkDataSource){

    suspend fun getPendingPatients() : LiveData<ResultPatients> {
        appNetworkDataSource.fetchPendingPatients()
        return withContext(Dispatchers.IO) {
            return@withContext appNetworkDataSource.downloadedPendingPatients
        }
    }

    suspend fun getProcessPatients() : LiveData<ResultPatients> {
        appNetworkDataSource.fetchProcessPatients()
        return withContext(Dispatchers.IO) {
            return@withContext appNetworkDataSource.downloadedProcessPatients
        }
    }

    suspend fun getPickedupPatients() : LiveData<ResultPatients> {
        appNetworkDataSource.fetchPickedupPatients()
        return withContext(Dispatchers.IO) {
            return@withContext appNetworkDataSource.downloadedPickedupPatients
        }
    }

    suspend fun getFinishPatients() : LiveData<ResultPatients> {
        appNetworkDataSource.fetchFinishPatients()
        return withContext(Dispatchers.IO) {
            return@withContext appNetworkDataSource.downloadedFinishPatients
        }
    }

    suspend fun getPatientDetail(id: String) : LiveData<ResultPatient> {
        appNetworkDataSource.fetchPatientDetail(id)
        return withContext(Dispatchers.IO) {
            return@withContext appNetworkDataSource.downloadedPatientDetail
        }
    }

    suspend fun postNewPatient(name: String,
                               age: Int,
                               gender: String,
                               description: String,
                               address: String,
                               ktpUri: Uri,
                               ecgUri: Uri,
                               createdBy: Int) : LiveData<JsonObject>{
        appNetworkDataSource.pushNewPatientData(name, age, gender, description, address, ktpUri, ecgUri, createdBy)
        return withContext(Dispatchers.IO) {
            return@withContext appNetworkDataSource.response
        }
    }
}