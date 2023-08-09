package com.app.myapplication

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.app.myapplication.databinding.ActivitySecondBinding
import java.util.Date

class SecondActivity : AppCompatActivity(), PostCustomClickListener{
    private lateinit var binding: ActivitySecondBinding
    private lateinit var postAdapter: PostCustomAdapter
    val postsList = arrayListOf<Post>(
        Post("Ahmed Saleh", Date(2023, 11,21),"His mother had always taught him not to ever think of himself as better than others. He'd tried to live by this motto. He never looked down on those who were less fortunate or who had less money than him. But the stupidity of the group of people he was talking to made him change his mind.", "https://t3.ftcdn.net/jpg/02/43/12/34/360_F_243123463_zTooub557xEWABDLk0jJklDyLSGl2jrr.jpg"),
        Post("Hoda Ali", Date(2023, 7,7),"He was an expert but not in a discipline that anyone could fully appreciate. He knew how to hold the cone just right so that the soft server ice-cream fell into it at the precise angle to form a perfect cone each and every time. It had taken years to perfect and he could now do it without even putting any thought behind it.", "https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8cGVyc29ufGVufDB8fDB8fHww&w=1000&q=80"),
        Post("Mona sayed", Date(2023, 5,15),"Dave watched as the forest burned up on the hill, only a few miles from her house. The car had been hastily packed and Marta was inside trying to round up the last of the pets. Dave went through his mental list of the most important papers and documents that they couldn't leave behind. He scolded himself for not having prepared these better in advance and hoped that he had remembered everything that was needed. He continued to wait for Marta to appear with the pets, but she still was nowhere to be seen.", "https://us.123rf.com/450wm/olga_sweet/olga_sweet1705/olga_sweet170500015/78012294-teenage-girl-portrait.jpg?ver=6"),
        Post("Zain Ibrahim", Date(2023, 10,26),"All he wanted was a candy bar. It didn't seem like a difficult request to comprehend, but the clerk remained frozen and didn't seem to want to honor the request. It might have had something to do with the gun pointed at his face.", "https://t3.ftcdn.net/jpg/02/09/58/46/360_F_209584670_nfMttDaeAlUzGob69TK34wds764ewpLZ.webp"),
        Post("Malak Mohammed", Date(2023, 1,30),"Hopes and dreams were dashed that day. It should have been expected, but it still came as a shock. The warning signs had been ignored in favor of the possibility, however remote, that it could actually happen. That possibility had grown from hope to an undeniable belief it must be destiny. That was until it wasn't and the hopes and dreams came crashing down.", "https://st3.depositphotos.com/1037987/15097/i/600/depositphotos_150975580-stock-photo-portrait-of-businesswoman-in-office.jpg"),
        Post("Karma Hady", Date(2023, 6,18),"One can cook on and with an open fire. These are some of the ways to cook with fire outside. Cooking meat using a spit is a great way to evenly cook meat. In order to keep meat from burning, it's best to slowly rotate it.", "https://st2.depositphotos.com/1715570/7603/i/600/depositphotos_76030699-stock-photo-fresh-face-older-woman-smiling.jpg"),
        Post("Kareem Mahmoud", Date(2023, 4,14),"There are different types of secrets. She had held onto plenty of them during her life, but this one was different. She found herself holding onto the worst type. It was the type of secret that could gnaw away at your insides if you didn't tell someone about it, but it could end up getting you killed if you did.", "https://images.pexels.com/photos/614810/pexels-photo-614810.jpeg?cs=srgb&dl=pexels-simon-robben-614810.jpg&fm=jpg"),
        Post("Amgad Shady", Date(2023, 2,28),"It wasn't quite yet time to panic. There was still time to salvage the situation. At least that is what she was telling himself. The reality was that it was time to panic and there wasn't time to salvage the situation, but he continued to delude himself into believing there was.", "https://img.freepik.com/free-photo/portrait-casual-guy-posing-studio_176420-28914.jpg"),
        Post("Suzy kareem", Date(2023, 3,5),"The paper was blank. It shouldn't have been. There should have been writing on the paper, at least a paragraph if not more. The fact that the writing wasn't there was frustrating. Actually, it was even more than frustrating. It was downright distressing.", "https://t4.ftcdn.net/jpg/03/83/25/83/360_F_383258331_D8imaEMl8Q3lf7EKU2Pi78Cn0R7KkW9o.jpg"),
        Post("Shahd Bahij", Date(2023, 5,13),"She was in a hurry. Not the standard hurry when you're in a rush to get someplace, but a frantic hurry. The type of hurry where a few seconds could mean life or death. She raced down the road ignoring speed limits and weaving between cars. She was only a few minutes away when traffic came to a dead standstill on the road ahead.", "https://img.freepik.com/free-photo/charming-young-woman-wearing-white-t-shirt-keeping-finger-lip_176532-10467.jpg?w=360"),
    )

    lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferences = applicationContext.getSharedPreferences("UserSharedPreferences", MODE_PRIVATE)
        val userName = preferences.getString("UserName", "")

        binding.welcomeTextview.text = "Welcome $userName"


//        val resultIntent = Intent()
//        val name = intent.getStringExtra("name")
//        val gender = intent.getStringExtra("gender")
//        val favouriteSports = intent.getStringExtra("favouriteSports")
//        //Toast.makeText(this, "Name is: $name, Gender is $gender, Favourites Sports is $favouriteSports", Toast.LENGTH_LONG).show()
//
//        val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this)
//        val dialog = Dialog(this)
//        dialogBuilder.setTitle(getString(R.string.info_popUp_title))
//        dialogBuilder.setMessage("Name is: $name, Gender is $gender, Favourites Sports is $favouriteSports")
//        dialogBuilder.setCancelable(true)
//        dialogBuilder.setPositiveButton("Cancel", DialogInterface.OnClickListener { dialogInterface, i ->
//            dialog.cancel()
//         })
//        val alertDialog = dialogBuilder.create()
//        alertDialog.show()


//        binding.loginByButton.setOnClickListener {
//            val selectedRadioButtonId = binding.radioGroup.checkedRadioButtonId
//            val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId)
//            resultIntent.putExtra("login_by", selectedRadioButton.text.toString())
//            setResult(Activity.RESULT_OK, resultIntent)
//            finish()
//        }





        postAdapter = PostCustomAdapter(postsList, this@SecondActivity)
        binding.postsRecyclerview.adapter = postAdapter



    }

    override fun onItemClickListener(post: Post, position: Int) {
        val intent = Intent(this@SecondActivity, ThirdActivity::class.java)
        val userName = postsList[position].userName
        val postContent = postsList[position].postContent
        val userImage = postsList[position].userImage
        intent.putExtra("userName", userName)
        intent.putExtra("userImage", userImage)
        intent.putExtra("postContent", postContent)


        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_second_activity, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId){
            R.id.logout -> {
                val editor = preferences.edit()
                editor.remove("UserName")
                editor.remove("Password")
                editor.putBoolean("IsLogin", false)
                editor.commit()
                startActivity(Intent(this@SecondActivity, MainActivity::class.java))
                finish()
                true
            }else -> {
                super.onOptionsItemSelected(item)
            }
        }

    }
}