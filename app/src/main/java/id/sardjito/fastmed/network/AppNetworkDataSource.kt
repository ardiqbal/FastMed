package id.sardjito.fastmed.network

import android.net.Uri
import android.webkit.MimeTypeMap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.JsonObject
import id.sardjito.fastmed.models.ResultPatient
import id.sardjito.fastmed.models.ResultPatients
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.await
import timber.log.Timber
import java.io.File
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppNetworkDataSource @Inject constructor(private val fastMedService: FastMedService){

    private val _downloadedPendingPatients = MutableLiveData<ResultPatients>()
    private val _downloadedProcessPatients = MutableLiveData<ResultPatients>()
    private val _downloadedPickedupPatients = MutableLiveData<ResultPatients>()
    private val _downloadedFinishPatients = MutableLiveData<ResultPatients>()
    private val _downloadedPatientDetail = MutableLiveData<ResultPatient>()

    private val _response = MutableLiveData<JsonObject>()

    val downloadedPendingPatients : LiveData<ResultPatients>
        get() = _downloadedPendingPatients

    val downloadedProcessPatients : LiveData<ResultPatients>
        get() = this._downloadedProcessPatients

    val downloadedPickedupPatients : LiveData<ResultPatients>
        get() = this._downloadedPickedupPatients

    val downloadedFinishPatients : LiveData<ResultPatients>
        get() = this._downloadedFinishPatients

    val downloadedPatientDetail : LiveData<ResultPatient>
        get() = _downloadedPatientDetail

    val response : LiveData<JsonObject>
        get() = _response

    suspend fun fetchPendingPatients(){
        try{
            val response = fastMedService.getPendingPatients().await()
            _downloadedPendingPatients.value = response
        }catch (e: Exception){
            Timber.e(e.message!!)
        }
    }

    suspend fun fetchProcessPatients(){
        try{
            val response = fastMedService.getProcessPatients().await()
            _downloadedProcessPatients.value = response
        }catch (e: Exception){
            Timber.e(e.message!!)
        }
    }

    suspend fun fetchPickedupPatients(){
        try{
            val response = fastMedService.getPickedupPatients().await()
            _downloadedPickedupPatients.value = response
        }catch (e: Exception){
            Timber.e(e.message!!)
        }
    }

    suspend fun fetchFinishPatients(){
        try{
            val response = fastMedService.getFinishPatients().await()
            _downloadedFinishPatients.value = response
        }catch (e: Exception){
            Timber.e(e.message!!)
        }
    }

    suspend fun fetchPatientDetail(id: String){
        try{
            val response = fastMedService.getPatientDetail(id).await()
            _downloadedPatientDetail.value = response
        }catch (e: Exception){
            Timber.e(e.message!!)
        }
    }

    suspend fun pushNewPatientData(name: String,
                                   age: Int,
                                   gender: String,
                                   description: String,
                                   address: String,
                                   ktpUri: Uri,
                                   ecgUri: Uri,
                                   createdBy: Int){
        try{
            val ktpFile = createFile(ktpUri, "ktp_file")
            val ecgFile = createFile(ecgUri, "ecg_file")

            val response = fastMedService.postNewPatient(name, age, gender, description, address, ktpFile, ecgFile, createdBy).await()
            _response.value = response
        }catch (e: Exception){
            Timber.e(e.message!!)
        }
    }

    private fun createFile(uri: Uri, key: String): MultipartBody.Part{
        val file = File(uri.path!!)

        val fileExtension = MimeTypeMap.getFileExtensionFromUrl(uri.toString())
        val mimeType = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtension.toLowerCase())

        val requestFile = RequestBody.create(
            MediaType.parse(mimeType!!),
            file
        )

        return MultipartBody.Part.createFormData(key, file.name, requestFile)
    }
}