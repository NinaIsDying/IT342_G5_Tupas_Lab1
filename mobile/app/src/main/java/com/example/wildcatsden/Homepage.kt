package com.example.wildcatsden

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView  // Add this import
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.cardview.widget.CardView

class HomePage : AppCompatActivity() {

    private lateinit var headerView: Header
    private lateinit var footerView: FooterView
    private lateinit var eventsRecyclerView: RecyclerView
    private lateinit var btnFindVenue: Button
    private lateinit var btnViewGuide: Button
    private lateinit var btnDiscoverMore: Button

    // Change these from Button to TextView
    private lateinit var btnFaq: TextView
    private lateinit var btnFindVenueDiscover: TextView

    private lateinit var btnBrowseVenues: CardView
    private lateinit var btnSubmitRequest: CardView
    private lateinit var btnTrackBooking: CardView
    private lateinit var venueCarouselRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setupWindowInsets()
        initViews()
        setupHeaderListener()
        setupClickListeners()
        setupVenueCarousel()
        setupEventsGrid()

        Toast.makeText(this, "HomePage Loaded", Toast.LENGTH_SHORT).show()
    }

    private fun setupWindowInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initViews() {
        headerView = findViewById(R.id.headerView)
        footerView = findViewById(R.id.footerView)
        eventsRecyclerView = findViewById(R.id.recyclerViewEvents)
        venueCarouselRecyclerView = findViewById(R.id.recyclerViewVenueCarousel)
        btnFindVenue = findViewById(R.id.btnFindVenue)
        btnViewGuide = findViewById(R.id.btnViewGuide)
        btnDiscoverMore = findViewById(R.id.btnDiscoverMore)

        // These are TextViews in XML
        btnFaq = findViewById(R.id.btnFaq)
        btnFindVenueDiscover = findViewById(R.id.btnFindVenueDiscover)

        // Guide cards - CardViews
        btnBrowseVenues = findViewById(R.id.btnBrowseVenues)
        btnSubmitRequest = findViewById(R.id.btnSubmitRequest)
        btnTrackBooking = findViewById(R.id.btnTrackBooking)
    }

    private fun setupHeaderListener() {
        headerView.listener = object : Header.HeaderListener {
            override fun onHomeClick() {
                Toast.makeText(this@HomePage, "Home clicked", Toast.LENGTH_SHORT).show()
            }

            override fun onVenuesClick() {
                Toast.makeText(this@HomePage, "Venues clicked", Toast.LENGTH_SHORT).show()
            }

            override fun onFaqClick() {
                Toast.makeText(this@HomePage, "FAQ clicked", Toast.LENGTH_SHORT).show()
            }

            override fun onSignInClick() {
                Toast.makeText(this@HomePage, "Sign In clicked", Toast.LENGTH_SHORT).show()
            }

            override fun onSignUpClick() {
                Toast.makeText(this@HomePage, "Sign Up clicked", Toast.LENGTH_SHORT).show()
            }

            override fun onLogoutClick() {
                Toast.makeText(this@HomePage, "Logout clicked", Toast.LENGTH_SHORT).show()
                headerView.updateLoginState(false)
            }

            override fun onProfileClick() {
                Toast.makeText(this@HomePage, "Profile clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupClickListeners() {
        btnFindVenue.setOnClickListener {
            Toast.makeText(this, "Find Venue clicked", Toast.LENGTH_SHORT).show()
        }

        btnViewGuide.setOnClickListener {
            Toast.makeText(this, "View Guide clicked", Toast.LENGTH_SHORT).show()
        }

        btnDiscoverMore.setOnClickListener {
            Toast.makeText(this, "Discover More clicked", Toast.LENGTH_SHORT).show()
        }

        // These are now TextViews
        btnFaq.setOnClickListener {
            Toast.makeText(this, "FAQ clicked", Toast.LENGTH_SHORT).show()
        }

        btnFindVenueDiscover.setOnClickListener {
            Toast.makeText(this, "Find Venue (Discover) clicked", Toast.LENGTH_SHORT).show()
        }

        btnBrowseVenues.setOnClickListener {
            Toast.makeText(this, "Browse Venues clicked", Toast.LENGTH_SHORT).show()
        }

        btnSubmitRequest.setOnClickListener {
            Toast.makeText(this, "Submit Request clicked", Toast.LENGTH_SHORT).show()
        }

        btnTrackBooking.setOnClickListener {
            Toast.makeText(this, "Track Booking clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupVenueCarousel() {
        val carouselImages = listOf(
            R.drawable.gym,
            R.drawable.elem,
            R.drawable.covered_court,
            R.drawable.lrac4,
            R.drawable.library,
            R.drawable.lrac5
        )

        val layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        venueCarouselRecyclerView.layoutManager = layoutManager

        val carouselAdapter = VenueCarouselAdapter(carouselImages)
        venueCarouselRecyclerView.adapter = carouselAdapter
    }

    private fun setupEventsGrid() {
        val eventImages = listOf(
            R.drawable.event1,
            R.drawable.event2,
            R.drawable.event3,
            R.drawable.event4
        )

        eventsRecyclerView.layoutManager = GridLayoutManager(this, 2)
        val eventsAdapter = EventsAdapter(eventImages)
        eventsRecyclerView.adapter = eventsAdapter
    }
}