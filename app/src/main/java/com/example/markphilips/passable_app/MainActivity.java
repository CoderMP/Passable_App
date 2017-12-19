package com.example.markphilips.passable_app;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.markphilips.passable_app.model.Account;

import java.util.ArrayList;

public class MainActivity extends Activity {
    //Declare required private View field variables
    private ListView lstAccounts;

    //Declare private field variables for frequently accessed objects
    private Account account;
    private SharedPreferences sharedPrefs;
    private ArrayList<Account> accounts;
    private AccountAdapter acctAdapter;

    private static final int ACCOUNT_ACTIVITY = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize a SharedPreference
        sharedPrefs = getSharedPreferences("appPrefs", MODE_PRIVATE);

        //Call the setupViews method
        setupViews();

        //Load the information into the ListView
        loadAccounts();
    }

    /**
     * Private method that is responsible for setting up the required Views
     */
    private void setupViews(){
        //Initialize all required Views
        lstAccounts = findViewById(R.id.lst_accounts);

        //Declare & initialize all required Listeners
        lstAccounts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long id) {
                //Call the navigation method to go to AccountActivity
                navToAccountActivity(adapterView, index);
            }
        });
    }


    //region Navigation Methods
    /**
     * Private method that is responsible for handling navigation to the AccountActivity.
     *
     * @param adapterView The "context" of the current View reference that is passed to this method
     * @param index The element index of the tapped ListView Item.
     */
    private void navToAccountActivity(AdapterView adapterView, int index){
        //Declare & initialize a new Intent to navigate to the detail activity
        Intent intent = new Intent(getApplicationContext(), AccountActivity.class);

        //Retrieve the index of the ListView item that was tapped
        account = (Account) adapterView.getAdapter().getItem(index);

        //Send the required additional data from the AccountAdapter Views to the AccountActivity
        //TODO: Populate the intent with the appropriate extra data

        //Launch the sub-activity
        startActivityForResult(intent, ACCOUNT_ACTIVITY);
    }


    /**
     * Private method that is responsible for handling the returned Intent from the AccountActivity
     *
     * @param requestCode The request code of the SubActivity
     * @param resultCode The success or failure code that is sent back from the SubActivity
     * @param data The additional data that is attached to the received Intent
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ACCOUNT_ACTIVITY){
            if (resultCode == RESULT_OK){
                //TODO: Manage the retrieved data from the SubActivity's returned Intent

            }
            else {
                Toast.makeText(this, "Canceled Changes", Toast.LENGTH_LONG).show();
            }
        }
    }
    //endregion

    private void loadAccounts(){
        //If there is no Account ArrayList exists, initialize one
        if (accounts == null){
            accounts = Account.getAccounts();
        }

        //Declare & initialize an AccountAdapter for the ListView
        acctAdapter = new AccountAdapter(this, R.layout.list_acct_info, accounts);

        lstAccounts.setAdapter(acctAdapter);
    }
}
