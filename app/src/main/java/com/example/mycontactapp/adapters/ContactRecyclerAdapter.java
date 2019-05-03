package com.example.mycontactapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mycontactapp.ContactDescActivity;
import com.example.mycontactapp.R;
import com.example.mycontactapp.models.ModelContacts;

import java.util.List;

public class ContactRecyclerAdapter extends RecyclerView.Adapter <ContactRecyclerAdapter.ViewHolder>{

    private Context mContext;
    private LayoutInflater inflater;
    private List<ModelContacts> mContactsList;
    private OnContactClickListener mOnContactClickListener;

    public ContactRecyclerAdapter(Context context, List<ModelContacts> contactsLists, OnContactClickListener mOnContactClickListener) {

        mContactsList = contactsLists;
        mContext = context;
        mOnContactClickListener = mOnContactClickListener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_contact_list, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view, mOnContactClickListener);

        return new ViewHolder(view, mOnContactClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {

        TextView contact_name, contact_phone;

        contact_name = viewHolder.contact_name;
        contact_phone = viewHolder.contact_phone;

        contact_name.setText(mContactsList.get(i).getName());
        contact_phone.setText(mContactsList.get(i).getPhone());





    }

    @Override
    public int getItemCount() {
        return mContactsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView contact_name, contact_phone;
        OnContactClickListener onContactClickListener;

        public ViewHolder(@NonNull View itemView, OnContactClickListener onContactClickListener) {
            super(itemView);

            contact_name = itemView.findViewById(R.id.contact_name);
            contact_phone = itemView.findViewById(R.id.contact_phone);
            this.onContactClickListener = onContactClickListener;


            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {

            //onContactClickListener.onContactClick(getAdapterPosition());

        }
    }

    public interface OnContactClickListener {
        void onContactClick(int position);
    }

}
