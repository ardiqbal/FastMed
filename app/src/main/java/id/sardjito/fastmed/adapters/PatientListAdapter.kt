package id.sardjito.fastmed.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.sardjito.fastmed.activities.PatientDetailActivity
import id.sardjito.fastmed.databinding.ListItemPatientBinding
import id.sardjito.fastmed.models.Patient
import id.sardjito.fastmed.models.PatientsItem
import timber.log.Timber

class PatientListAdapter : RecyclerView.Adapter<PatientListAdapter.PatientViewHolder>() {

    private var data = emptyList<PatientsItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientViewHolder {
        return PatientViewHolder(ListItemPatientBinding.inflate(
            LayoutInflater.from(parent.context), parent, false), parent.context)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: PatientViewHolder, position: Int) {
        val patient = data[position]
        holder.bind(patient)
    }

    internal fun loadData(data: List<PatientsItem>?) {
        this.data = data!!
        notifyDataSetChanged()
    }

    class PatientViewHolder(
        private val binding: ListItemPatientBinding,
        context : Context
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener {
                binding.patient?.let { patient ->
                    Timber.d(patient.toString())
                    val intent = Intent(context, PatientDetailActivity::class.java)
                    intent.putExtra("id", patient.id)
                    context.startActivity(intent)
                }
            }
        }

        fun bind(item: PatientsItem) {
            binding.apply {
                patient = item
                executePendingBindings()
            }
        }
    }

}
