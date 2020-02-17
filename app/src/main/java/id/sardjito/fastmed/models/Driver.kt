package id.sardjito.fastmed.models

import com.google.gson.annotations.SerializedName

data class Driver(
	val password: Any? = null,
	val role: String? = null,
	@SerializedName("updated_at")
	val updatedAt: String? = null,
	val phone: Any? = null,
	val name: String? = null,
	@SerializedName("created_at")
	val createdAt: String? = null,
	val id: Int? = null,
	@SerializedName("hospital_id")
	val hospitalId: Int? = null,
	val email: Any? = null,
	@SerializedName("red_id")
	val regId: Any? = null
)
