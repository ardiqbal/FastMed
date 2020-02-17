package id.sardjito.fastmed.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.sardjito.fastmed.activities.AddPatientActivity
import id.sardjito.fastmed.activities.MainActivity
import id.sardjito.fastmed.activities.PatientDetailActivity
import id.sardjito.fastmed.fragments.PickedupFragment
import id.sardjito.fastmed.fragments.ProcessFragment
import id.sardjito.fastmed.fragments.FinishFragment
import id.sardjito.fastmed.fragments.PendingFragment

@Module
abstract class ActivityFragmentModule {

    @ContributesAndroidInjector
    abstract fun bindQueueFragment(): PendingFragment

    @ContributesAndroidInjector
    abstract fun bindDeliveryFragment(): ProcessFragment

    @ContributesAndroidInjector
    abstract fun bindCanceledFragment(): PickedupFragment

    @ContributesAndroidInjector
    abstract fun bindDoneFragment(): FinishFragment

    @ContributesAndroidInjector
    internal abstract fun bindPatientDetailActivity(): PatientDetailActivity

    @ContributesAndroidInjector
    internal abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    internal abstract fun bindAddPatientActivity(): AddPatientActivity
}