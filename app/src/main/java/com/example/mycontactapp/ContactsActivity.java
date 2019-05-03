package com.example.mycontactapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;

import com.example.mycontactapp.adapters.ContactRecyclerAdapter;
import com.example.mycontactapp.models.ModelContacts;

import java.util.ArrayList;
import java.util.List;

public class ContactsActivity extends AppCompatActivity implements ContactRecyclerAdapter.OnContactClickListener {

    private View v;
    private RecyclerView recyclerView;
    List<ModelContacts> list;

    public ContactsActivity() {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager layoutManager = linearLayoutManager;
        recyclerView.setLayoutManager(layoutManager);

        ContactRecyclerAdapter adapter = new ContactRecyclerAdapter(getApplicationContext(), getContacts(), this);

        recyclerView.setAdapter(adapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                getRequestedOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);



    }

    private List<ModelContacts> getContacts() {
        list = new ArrayList<>();

        Cursor cursor = getApplicationContext().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
            null, null, ContactsContract.Contacts.DISPLAY_NAME+ " ASC");

        cursor.moveToFirst();

        while (cursor.moveToNext()) {

            list.add(new ModelContacts(cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
                    )), cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER
                    )), cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Email.ADDRESS
                    )), cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Photo.PHOTO_THUMBNAIL_URI))));

        }

        return list;
    }

    @Override
    public void onContactClick(int position) {
        list.get(position);
        Intent intent = new Intent(getApplicationContext(), ContactDescActivity.class);
        startActivity(intent);
    }
}
