package edu.temple.dicethrow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), ButtonFragment.ButtonInterface {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO 1: Load fragment(s)
        if (resources.configuration.orientation == android.content.res.Configuration.ORIENTATION_PORTRAIT) {
            // Portrait mode - show only ButtonFragment
            if (supportFragmentManager.findFragmentById(R.id.buttonFragmentContainer) == null) {
                supportFragmentManager.beginTransaction()
                    .add(R.id.buttonFragmentContainer, ButtonFragment())
                    .commit()
            }
        } else {
            //Landscape mode - show both fragments
            if (supportFragmentManager.findFragmentById(R.id.buttonFragmentContainer) == null) {
                supportFragmentManager.beginTransaction()
                    .add(R.id.buttonFragmentContainer, ButtonFragment())
                    .add(R.id.dieFragmentContainer, DieFragment())
                    .commit()
            }
        }
    }

    // TODO 2: switch fragments if die rolled and in portrait
    override fun buttonClicked() {
        if (resources.configuration.orientation == android.content.res.Configuration.ORIENTATION_PORTRAIT) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.buttonFragmentContainer, DieFragment())
                .addToBackStack(null)
                .commit()
        }
        // No action needed in landscape as both fragments are already visible
    }
}