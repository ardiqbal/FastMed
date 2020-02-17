package id.sardjito.fastmed.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.sardjito.fastmed.R
import id.sardjito.fastmed.adapters.PatientListAdapter
import id.sardjito.fastmed.databinding.FragmentQueueBinding
import id.sardjito.fastmed.models.PatientsItem
import id.sardjito.fastmed.scope.ScopeFragment
import id.sardjito.fastmed.viewmodels.PatientViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class ProcessFragment : ScopeFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val patientViewModel : PatientViewModel by viewModels {
        viewModelFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentQueueBinding.inflate(inflater, container, false)
        context ?: return binding.root

        val adapter = PatientListAdapter()
        binding.patientList.adapter = adapter

        subscribeUi(adapter)

        return binding.root
    }

    private fun subscribeUi(adapter: PatientListAdapter) = launch {
        patientViewModel.getProcessPatients().observe(viewLifecycleOwner, Observer {
            Timber.d("Process")
            adapter.loadData(it.patients as List<PatientsItem>?)
        })
    }
}
