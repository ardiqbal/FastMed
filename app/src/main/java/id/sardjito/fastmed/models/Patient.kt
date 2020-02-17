package id.sardjito.fastmed.models

import com.google.gson.annotations.SerializedName

data class Patient(
	val creator: Any? = null,
	val address: String? = null,
	val gender: String? = null,
	@SerializedName("cancel_note")
	val cancelNote: Any? = null,
	val description: String? = null,
	@SerializedName("created_at")
	val createdAt: Any? = null,
	@SerializedName("ekg_image")
	val ekgImage: Any? = null,
	@SerializedName("created_by")
	val createdBy: Any? = null,
	val processor: Any? = null,
	@SerializedName("process_note")
	val processNote: Any? = null,
	@SerializedName("ktp_image")
	val ktpImage: Any? = null,
	@SerializedName("transfer_note")
	val transferNote: Any? = null,
	@SerializedName("updated_at")
	val updatedAt: Any? = null,
	val driver: Any? = null,
	@SerializedName("processed_by")
	val processedBy: Any? = null,
	@SerializedName("view_patient")
	val viewPatient: ViewPatient? = null,
	val name: String? = null,
	val id: Int? = null,
	val age: Int? = null,
	val status: String? = null,
	@SerializedName("picked_by")
	val pickedBy: Any? = null
)
