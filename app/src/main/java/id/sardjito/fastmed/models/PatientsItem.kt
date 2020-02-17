package id.sardjito.fastmed.models

import com.google.gson.annotations.SerializedName

data class PatientsItem(
	@SerializedName("ktp_image_link")
	val ktpImageLink: Any? = null,
	@SerializedName("ecg_image_link")
	val ecgImageLink: Any? = null,
	@SerializedName("view_patient")
	val viewPatient: ViewPatient? = null,
	val name: String? = null,
	@SerializedName("created_at")
	val createdAt: String? = null,
	val id: Int? = null,
	@SerializedName("created_date")
	val createdDate: String? = null
)
