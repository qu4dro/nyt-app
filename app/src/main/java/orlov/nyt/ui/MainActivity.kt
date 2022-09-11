package orlov.nyt.ui

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import orlov.nyt.R
import orlov.nyt.databinding.ActivityMainBinding
import orlov.nyt.utils.hide
import orlov.nyt.utils.show


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.nvBottomNavigation.visibility = View.GONE
        setNavController()
    }

    private fun setNavController() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.splashFragment, R.id.authFragment, R.id.articleFragment -> binding.nvBottomNavigation.hide()
                else -> binding.nvBottomNavigation.show()
            }
        }
        binding.nvBottomNavigation.apply {
            setupWithNavController(navController)
            setOnItemReselectedListener {}
        }
    }

    override fun onBackPressed() {
        binding.apply {
            when (navController.currentDestination?.id) {
                R.id.searchFragment, R.id.profileFragment, R.id.bookmarksFragment -> nvBottomNavigation.selectedItemId =
                    R.id.homeFragment
                R.id.homeFragment -> finish()
                else -> super.onBackPressed()
            }
        }
    }
}