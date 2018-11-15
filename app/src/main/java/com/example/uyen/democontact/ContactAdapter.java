package com.example.uyen.democontact;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private LayoutInflater mLayoutInflater;
    private List<Contact> mContacts;

    public ContactAdapter(List<Contact> contacts) {
        mContacts = contacts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        if (mLayoutInflater == null) {
            mLayoutInflater = LayoutInflater.from(parent.getContext());
        }
        View v = mLayoutInflater.inflate(R.layout.list_contact, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bindData(mContacts.get(i));
    }

    @Override
    public int getItemCount() {
        return mContacts != null ? mContacts.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextName;
        private TextView mTextPhone;

        public ViewHolder(View view) {
            super(view);
            mTextName = view.findViewById(R.id.text_name);
            mTextPhone = view.findViewById(R.id.text_phone);
        }

        public void bindData(Contact contact) {
            if (contact == null) return;
            mTextName.setText(contact.getName());
            mTextPhone.setText(contact.getPhone());
        }
    }
}
