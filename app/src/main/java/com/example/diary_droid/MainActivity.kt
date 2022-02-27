package com.example.diary_droid

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.provider.CalendarContract.Events.*
import android.provider.ContactsContract
import android.view.View
import android.widget.AbsListView
import android.widget.Button
import android.widget.EditText
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    val REQUEST_CONTACT = 1 // identifier code
    val LINEAR_LAYOUT_VERTICAL = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
        != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this, arrayOf(Manifest.permission.READ_CONTACTS),
                REQUEST_CONTACT)
        }else{
            setContacts()
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        if (requestCode == REQUEST_CONTACT) setContacts()

    }

    private fun setContacts() {
        val contactList: ArrayList<Contact> = ArrayList()

        // cursor read dataframe search
        val cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
        null,
        null,
        null,
        null)

        if (cursor != null){
            while (cursor.moveToNext()){
                contactList.add(Contact(
                    cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)),
                    cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                ))

            }

            cursor.close()
        }

        val adapter = ContactsAdapter(contactList)
        val contactRecyclerView = findViewById<RecyclerView>(R.id.contacts_recycle_view)

        contactRecyclerView.layoutManager = LinearLayoutManager(this,
            LINEAR_LAYOUT_VERTICAL,
            false
        )

        contactRecyclerView.adapter = adapter

    }

}