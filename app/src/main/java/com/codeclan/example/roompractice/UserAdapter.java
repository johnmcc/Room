package com.codeclan.example.roompractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 21/11/2017.
 */

class UserAdapter extends ArrayAdapter<User> {

    public UserAdapter(Context context, ArrayList<User> users){
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent) {
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.user_item, parent, false );
        }

        User currentUser = getItem(position);
        TextView nameTV = listItemView.findViewById(R.id.name);
        nameTV.setText(currentUser.getFirstName());

        return listItemView;
    }
}
