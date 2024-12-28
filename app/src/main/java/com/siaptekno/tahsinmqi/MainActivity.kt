package com.siaptekno.tahsinmqi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.siaptekno.tahsinmqi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        // Set up the Toolbar as the ActionBar
        val toolbar: Toolbar = binding.toolbar
        setSupportActionBar(toolbar)

        // Set navigation icon tint to white for better visibility
        toolbar.navigationIcon?.setTint(getColor(R.color.white))

        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_temp_bottom_nav)

        // Define top-level destinations for managing the back stack
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, // HomeFragment
                R.id.navigation_alquran // AlquranFragment
            )
        )

        // Set up the ActionBar with the NavController
        setupActionBarWithNavController(navController, appBarConfiguration)

        // Apply white tint programmatically to the navigation icon
        binding.toolbar.navigationIcon?.setTint(getColor(R.color.white))


        // Customize bottom navigation behavior
        navView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    // Navigate to HomeFragment and clear any fragment added on top of it
                    val navOptions = NavOptions.Builder()
                        .setPopUpTo(R.id.navigation_home, false) // Clear stack up to Home
                        .build()
                    navController.navigate(R.id.navigation_home, null, navOptions)
                    true
                }
                R.id.navigation_alquran -> {
                    // Navigate normally to AlquranFragment
                    navController.navigate(R.id.navigation_alquran)
                    true
                }
                R.id.navigation_schedule -> {
                    // Navigate normally to ScheduleFragment
                    navController.navigate(R.id.navigation_schedule)
                    true
                }
                else -> false
            }
        }

        // Add a listener to show/hide the ActionBar based on the current destination
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.navigation_home -> {
                    binding.toolbar.title = getString(R.string.title_home)
                }

                R.id.navigation_alquran -> {
                    binding.toolbar.title = getString(R.string.title_alquran)
                }

                R.id.navigation_schedule -> {
                    binding.toolbar.title = getString(R.string.title_schedule)
                }

                else -> {
                    // Handle other destinations if needed
                    binding.toolbar.title = getString(R.string.app_name)
                }
            }
        }
    }

    // Handle the back button press for fragments
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_activity_temp_bottom_nav)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}