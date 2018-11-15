package com.example.uyen.democontact;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerContact;
    private List<Contact> mContacts;
    private ContactAdapter mContactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();
        initView();
    }

    public void initView() {
        mContactAdapter = new ContactAdapter(mContacts);
        mRecyclerContact = findViewById(R.id.recycleView_contact);
        mRecyclerContact.setAdapter(mContactAdapter);
    }

    public void getData() {
        mContacts = new ArrayList<>();
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query(uri,
                null,
                null,
                null,
                null);
        while (cursor.moveToNext()) {
            Contact contact = new Contact();
            contact.setName(cursor.getString(
                    cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)));
            contact.setPhone(cursor.getString(cursor.getColumnIndex(
                    ContactsContract.CommonDataKinds.Phone.NUMBER)));
            mContacts.add(contact);
        }
        cursor.close();
    }
}
