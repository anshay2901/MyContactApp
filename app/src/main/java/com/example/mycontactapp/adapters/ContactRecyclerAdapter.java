package com.example.mycontactapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mycontactapp.ContactDescActivity;
import com.example.mycontactapp.ContactsActivity;
import com.example.mycontactapp.R;
import com.example.mycontactapp.models.ModelContacts;

import java.util.List;

public class ContactRecyclerAdapter extends RecyclerView.Adapter<ContactRecyclerAdapter.ViewHolder> {

    private View.OnClickListener onClickListener;
    private Context mContext;
    private LayoutInflater inflater;
    private List<ModelContacts> mContactsList;

    public ContactRecyclerAdapter(Context context, List<ModelContacts> contactsLists) {

        mContactsList = contactsLists;
        mContext = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_contact_list, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(mContext, view);

        return new ViewHolder(mContext, view);
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
        private Context context;


        public ViewHolder(Context context, @NonNull View itemView) {
            super(itemView);

            contact_name = itemView.findViewById(R.id.contact_name);
            contact_phone = itemView.findViewById(R.id.contact_phone);
            LinearLayout linearLayout = itemView.findViewById(R.id.item_linear_layout);

            this.context = context;

            linearLayout.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {

            int position = getLayoutPosition();

            Intent intent = new Intent(v.getContext(), ContactDescActivity.class);

            class OpenIntent extends ContactsActivity {

                @Override
                public void startActivity(Intent intent) {
                    //super.startActivity(intent);
                    pleaseWork(getAdapterPosition());
                    Log.d("test", "test" + getAdapterPosition());
                }
            }

            OpenIntent openIntent = new OpenIntent();

            openIntent.startActivity(intent);




        }
    }
}

