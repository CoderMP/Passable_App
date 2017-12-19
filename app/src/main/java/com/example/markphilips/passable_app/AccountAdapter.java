package com.example.markphilips.passable_app;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.markphilips.passable_app.model.Account;

import java.util.List;

/**
 * Created by Mark on 12/11/2017.
 */

public class AccountAdapter extends ArrayAdapter<Account> {
    //Declare private field variables
    private Context context;
    private int resource;

    public AccountAdapter(Context context, int resource, List<Account> objects){
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Check to see if there is a valid View to work with. If not, inflate one
        if (convertView == null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            convertView = inflater.inflate(resource, parent, false);
        }

        //Get the current Account item
        Account account = getItem(position);

        //TODO: Declare & initialize the relevant Views that display the necessary information
        TextView txtAcctName = convertView.findViewById(R.id.txt_acct_name);
        TextView txtUserName = convertView.findViewById(R.id.txt_user_name);
        TextView txtPassword = convertView.findViewById(R.id.txt_password);

        txtAcctName.setText(account.getAcctName());
        txtUserName.setText(account.getAcctUserName());
        txtPassword.setText(String.valueOf(account.getAcctPassword()));

        //TODO: Determine whether or not SharedPrefs will be read here for display purposes

        //Return the convertView
        return convertView;
    }
}