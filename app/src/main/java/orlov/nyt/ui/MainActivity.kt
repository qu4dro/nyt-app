package orlov.nyt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import orlov.nyt.R
import orlov.nyt.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setNavController()
    }

    private fun setNavController() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.splashFragment -> hideNavBar()
                R.id.authFragment -> hideNavBar()
                else -> showNavBar()
            }
        }
        binding.nvBottomNavigation.apply {
            setupWithNavController(navController)
            setOnItemReselectedListener {}
        }
    }

    private fun showNavBar() {
        binding.nvBottomNavigation.apply {
            if (this.visibility == View.GONE || this.visibility == View.INVISIBLE) {
                this.visibility = View.VISIBLE
            }
        }
    }

    private fun hideNavBar() {
        binding.nvBottomNavigation.apply {
            if (this.visibility == View.VISIBLE) this.visibility = View.GONE
        }
    }
}