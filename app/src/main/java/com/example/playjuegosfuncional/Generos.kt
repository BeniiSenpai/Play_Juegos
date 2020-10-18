package com.example.playjuegosfuncional

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class Generos : AppCompatActivity() {
    private var option : String = "No has pulsado ninguna opcion"
    private var isChecked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generos)

        val bottomAppBar = findViewById(R.id.bottom_appbar) as BottomAppBar
        bottomAppBar.replaceMenu(R.menu.menu_main)

        val chipGroup = findViewById(R.id.chipGroup) as ChipGroup
        val fab : FloatingActionButton = findViewById(R.id.fab)

        fab.setOnClickListener({ Snackbar.make(it,"Boton en Movimiento", Snackbar.LENGTH_LONG).show()})

        chipGroup.setOnCheckedChangeListener(object : ChipGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(group: ChipGroup?, checkedId: Int) {
                val checkedChip = group?.findViewById<Chip>(checkedId)
                option = checkedChip?.text.toString()
                Toast.makeText(applicationContext, option, Toast.LENGTH_SHORT).show()
            }
        })

        fab.setOnClickListener ( object: View.OnClickListener {
            override fun onClick(view: View?) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), option, Toast.LENGTH_LONG).show()
                }
                Toast.makeText(getApplicationContext(), option, Toast.LENGTH_LONG).show()
            }
        })
    }
}



