package com.shift.persongeneratorxml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.controls.actions.FloatAction
import android.widget.Button
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.shift.persongeneratorxml.db.DbManager
import com.shift.persongeneratorxml.network.PersonApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeout
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okio.Okio
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {
    val dbManager = DbManager(context = this)

    fun readInTextView(){
        val dbview = findViewById<TextView>(R.id.dbview)
        dbview.text = " "
        dbManager.openDb()
        val data = dbManager.readFromDb()
        for (item in data){
            dbview.append(item)
            dbview.append("\n ")
        }
    }
    override fun onResume() {
        super.onResume()
        readInTextView()
    }
    override fun onDestroy() {
        super.onDestroy()
        dbManager.closeDb()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val dbManager = DbManager(context = this)

        val test = findViewById<TextView>(R.id.test)
        val dbview = findViewById<TextView>(R.id.dbview)
        val create_button = findViewById<FloatingActionButton>(R.id.floatingActionButton)

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://randomuser.me/").client(client)
            .addConverterFactory(GsonConverterFactory.create()).build()
        val personApi = retrofit.create(PersonApi::class.java)

        create_button.setOnClickListener {
            create_button.setClickable(false)
            CoroutineScope(Dispatchers.Main).launch {
                val person = personApi.getPerson()
                runOnUiThread {
                    test.text = buildString {
                        append(person.results[0].name?.title)
                        append(" ")
                        append(person.results[0].name?.first)
                        append(" ")
                        append(person.results[0].name?.last)
                        append("\n")
                        append(person.results[0].location?.country)
                        append(" ")
                        append(person.results[0].location?.city)
                    }
                    dbManager.insertToDb(
                        person.info?.seed.toString(),
                        buildString {
                            append(person.results[0].name?.title.toString())
                            append(" ")
                            append(person.results[0].name?.first.toString())
                            append(" ")
                            append(person.results[0].name?.last.toString())
                            append(" ")
                                    },
                        person.results[0].email.toString(),
                        person.results[0].dob?.date.toString(),
                        buildString {
                            append(person.results[0].location?.street?.number.toString())
                            append(" ")
                            append(person.results[0].location?.street?.name.toString())
                            append(", ")
                            append(person.results[0].location?.city.toString())
                            append(", ")
                            append(person.results[0].location?.country.toString())
                        },
                        person.results[0].phone.toString(),
                        person.results[0].login?.password.toString(),
                        person.results[0].picture?.thumbnail.toString(),
                        person.results[0].picture?.medium.toString(),
                        )
                    val data = dbManager.readFromDb()
                    readInTextView()
                }
            }
            create_button.setClickable(true)
        }
    }
}

