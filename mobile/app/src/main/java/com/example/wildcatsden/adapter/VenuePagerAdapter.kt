package com.example.wildcatsden.adapter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wildcatsden.R
import com.example.wildcatsden.VenueDetailActivity

class VenueFragment : Fragment() {
//
//    private lateinit var recyclerView: RecyclerView
//    private lateinit var venueAdapter: VenueAdapter
//
//    companion object {
//        private const val ARG_POSITION = "position"
//
//        fun newInstance(position: Int): VenueFragment {
//            return VenueFragment().apply {
//                arguments = Bundle().apply {
//                    putInt(ARG_POSITION, position)
//                }
//            }
//        }
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.fragment_venue, container, false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        recyclerView = view.findViewById(R.id.recyclerViewVenues)
//        recyclerView.layoutManager = LinearLayoutManager(requireContext())
//
//        val position = arguments?.getInt(ARG_POSITION) ?: 0
//        val venues = getVenuesForTab(position)
//
//        venueAdapter = VenueAdapter(venues) { venue ->
//            // Handle venue click
//            val intent = Intent(requireContext(), VenueDetailActivity::class.java)
//            intent.putExtra("venue_id", venue.id)
//            startActivity(intent)
//        }
//        recyclerView.adapter = venueAdapter
//    }
//
//    private fun getVenuesForTab(position: Int): List<Venue> {
//        return when (position) {
//            0 -> getNgeVenues() // NGE
//            1 -> getSalVenues() // SAL
//            2 -> getGleVenues() // GLE
//            3 -> getAcadVenues() // ACAD
//            4 -> getCourtVenues() // Court
//            else -> emptyList()
//        }
//    }
//
//    private fun getNgeVenues(): List<Venue> {
//        return listOf(
//            Venue(1, "NGE Computer Lab 1", "NGE Building, 2nd Floor", 40, R.drawable.nge),
//            Venue(2, "NGE Computer Lab 2", "NGE Building, 3rd Floor", 35, R.drawable.nge1),
//            Venue(3, "NGE Lecture Hall", "NGE Building, Ground Floor", 100, R.drawable.nge)
//        )
//    }
//
//    private fun getSalVenues(): List<Venue> {
//        return listOf(
//            Venue(4, "SAL Court", "SAL Building", 200, R.drawable.sal),
//            Venue(5, "SAL Room 101", "SAL Building, 1st Floor", 50, R.drawable.sal)
//        )
//    }
//
//    private fun getGleVenues(): List<Venue> {
//        return listOf(
//            Venue(6, "GLE Auditorium", "GLE Building", 300, R.drawable.gle),
//            Venue(7, "GLE Classroom A", "GLE Building, 2nd Floor", 45, R.drawable.gle)
//        )
//    }
//
//    private fun getAcadVenues(): List<Venue> {
//        return listOf(
//            Venue(8, "ACAD Room 201", "ACAD Building", 40, R.drawable.library),
//            Venue(9, "ACAD Conference Room", "ACAD Building", 25, R.drawable.library)
//        )
//    }
//
//    private fun getCourtVenues(): List<Venue> {
//        return listOf(
//            Venue(10, "Basketball Court", "Sports Complex", 500, R.drawable.gym),
//            Venue(11, "Volleyball Court", "Sports Complex", 400, R.drawable.gym),
//            Venue(12, "Badminton Court", "Sports Complex", 50, R.drawable.gym)
//        )
//    }
}