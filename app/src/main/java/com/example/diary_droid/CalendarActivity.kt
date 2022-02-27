package com.example.diary_droid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.widget.Button

class CalendarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        // button for action in calendar
        val btnSetEvent = findViewById(R.id.bt_acess_calendar) as Button // button for action started
        btnSetEvent.setOnClickListener{

            // define action for 'Diary' worker Action in calendar
            val intent = Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI) // For import apply for < (in android.provider.CalendarContract) >
                .putExtra(CalendarContract.Events.TITLE, "Bootcamp NTT") // o < TITLE > also CalendarContract.Events.*
                .putExtra(CalendarContract.Events.EVENT_LOCATION, "on line")
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, System.currentTimeMillis()) // in real time condition, however increment in due course
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, System.currentTimeMillis()+(60*60*1000)) /// putExtra - content int // equal one hours <(60*60*1000)>

            startActivity(intent)
        }

    }
}