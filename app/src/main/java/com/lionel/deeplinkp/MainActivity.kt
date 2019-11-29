package com.lionel.deeplinkp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initView()

    }

    private fun initView() {
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)

        btn1.setOnClickListener { onDeepLink("lionel://big_chief/recipe/grilled-potato-salad") }
        btn2.setOnClickListener { onDeepLink("lionel://big_chief/recipe/haloumi-salad") }
        btn3.setOnClickListener { onDeepLink("lionel://big_chief/recipe/wedge-salad") }
        btn4.setOnClickListener { onDeepLink("lionels://big_chief/recipe/pierogi-poutine") }
    }


    private fun onDeepLink(url: String) {
        var packageManager = packageManager
        var intent = Intent().apply {
            action = Intent.ACTION_VIEW
            data = Uri.parse(url)
        }

        if (intent.resolveActivity(packageManager) == null)
            intent.data = Uri.parse("https://play.google.com/store/apps/details?id=uk.co.bbc.learningenglish")

        startActivity(intent)
    }
}
