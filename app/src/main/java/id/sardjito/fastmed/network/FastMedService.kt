package id.sardjito.fastmed.network

import com.google.gson.JsonObject
import id.sardjito.fastmed.models.ResultPatient
import id.sardjito.fastmed.models.ResultPatients
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface FastMedService {

    @GET("patients_pending")
    fun getPendingPatients() : Call<ResultPatients>

    @GET("patients_process")
    fun getProcessPatients() : Call<ResultPatients>

    @GET("patients_pickedup")
    fun getPickedupPatients() : Call<ResultPatients>

    @GET("patients_finish")
    fun getFinishPatients() : Call<ResultPatients>

    @GET("patients/{id}")
    fun getPatientDetail(@Path("id") id: String): Call<ResultPatient>

    @Multipart
    @POST("patients")
    fun postNewPatient(@Field("name") name: String,
                       @Field("age") age: Int,
                       @Field("gender") gender: String,
                       @Field("description") description: String,
                       @Field("address") address: String,
                       @Part ktp_file: MultipartBody.Part,
                       @Part ecg_file: MultipartBody.Part,
                       @Field ("created_by") created_by: Int): Call<JsonObject>
}