package com.app.myapplication

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.app.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    lateinit var pref: SharedPreferences

    val request_code: Int = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        println("Activity Created")
        pref = applicationContext.getSharedPreferences("UserSharedPreferences", Context.MODE_PRIVATE)
        binding.emailEditText.setText( pref.getString("UserName", ""))
        binding.passwordEditText.setText( pref.getString("Password", ""))


        val name = binding.emailEditText.text.toString()
        val passwoed = binding.passwordEditText.text.toString()
        val selectedRadioButtonId = binding.radioGroup.checkedRadioButtonId
        val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId)
        val gender = selectedRadioButton.text.toString()
        var favouriteSports = "Favourite Sports: "
        if(binding.footballCheckBox.isChecked)
            favouriteSports += "Football "
        if(binding.basketballCheckBox.isChecked)
            favouriteSports += "Basketball "


        binding.loginButton.setOnClickListener {

            val editor = pref.edit()

            editor.putString("UserName",binding.emailEditText.text.toString())
            editor.putString("Password", binding.passwordEditText.text.toString())
            editor.putBoolean("IsLogin", true)
            editor.commit()

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("gender", gender)
            intent.putExtra("favouriteSports", favouriteSports)

            startActivity(intent)
            finish()
        }

        binding.showUpButton.setOnClickListener {
            val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this)
            val dialog = Dialog(this)
            dialogBuilder.setTitle(getString(R.string.info_popUp_title))
            dialogBuilder.setMessage("Name is: $name, Gender is $gender, Favourites Sports is $favouriteSports")
            dialogBuilder.setCancelable(true)
            dialogBuilder.setPositiveButton("Cancel", DialogInterface.OnClickListener { dialogInterface, i ->
                dialog.cancel()
            })
            val alertDialog = dialogBuilder.create()
            alertDialog.show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main_activity, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        println(item.itemId)
        return when(item.itemId){
            R.id.exit -> {
                showExitDialog(binding.root)
                true
            }
            R.id.go_to_second -> {
                startActivity(Intent(this, SecondActivity:: class.java))
                true
            }else -> {
                true
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        println("Activity Result")
        if(requestCode == request_code){
            if(resultCode == RESULT_OK){
                val loginBy = data?.getStringExtra("login_by")
                Toast.makeText(this, "Login By: $loginBy", Toast.LENGTH_LONG).show()
            }
        }
    }
    
    private fun showExitDialog(view: View){
        val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(view.context)
        dialogBuilder.setTitle(getString(R.string.exit_popUp_title))
        dialogBuilder.setMessage(getString(R.string.exit_popUp_msg))
        dialogBuilder.setCancelable(true)
        dialogBuilder.setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface, i ->
            finish()
        })
        dialogBuilder.setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i ->
            val dialog = Dialog(view.context)
            dialog.cancel()
        })
        val alertDialog = dialogBuilder.create()
        alertDialog.show()
    }
}
