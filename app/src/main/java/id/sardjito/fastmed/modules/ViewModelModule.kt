package id.sardjito.fastmed.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import id.sardjito.fastmed.factory.AppViewModelFactory
import id.sardjito.fastmed.viewmodels.PatientViewModel

@Module
internal abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(PatientViewModel::class)
    internal abstract fun bindPatientListViewModel(patientViewModel: PatientViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory
}