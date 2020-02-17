package id.sardjito.fastmed.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import id.sardjito.fastmed.*
import id.sardjito.fastmed.fragments.PickedupFragment
import id.sardjito.fastmed.fragments.ProcessFragment
import id.sardjito.fastmed.fragments.FinishFragment
import id.sardjito.fastmed.fragments.PendingFragment

const val PENDING_PAGE_INDEX = 0
const val PROCESS_PAGE_INDEX = 1
const val PICKEDUP_PAGE_INDEX = 2
const val FINISH_PAGE_INDEX = 3

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val tabFragmentsCreators: Map<Int, () -> Fragment> = mapOf(
        PENDING_PAGE_INDEX to { PendingFragment() },
        PROCESS_PAGE_INDEX to { ProcessFragment() },
        PICKEDUP_PAGE_INDEX to { PickedupFragment() },
        FINISH_PAGE_INDEX to { FinishFragment() }
    )

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return tabFragmentsCreators[position]?.invoke()!!
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return getTabTitle(position)
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return tabFragmentsCreators.size
    }

    private fun getTabTitle(position: Int): String? {
        return when (position) {
            PENDING_PAGE_INDEX -> context.resources.getString(R.string.pending_page_title)
            PROCESS_PAGE_INDEX -> context.resources.getString(R.string.process_page_title)
            PICKEDUP_PAGE_INDEX -> context.resources.getString(R.string.pickedup_page_title)
            FINISH_PAGE_INDEX -> context.resources.getString(R.string.finish_page_title)
            else -> null
        }
    }
}