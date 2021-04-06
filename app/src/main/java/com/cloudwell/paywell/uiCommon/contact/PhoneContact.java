package com.cloudwell.paywell.uiCommon.contact;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import com.cloudwell.paywell.R;
import com.cloudwell.paywell.utils.ViewUtiliesKt;

public class PhoneContact extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>, AdapterView.OnItemClickListener {


    private static final String TAG = "ContentProviderDemo";

    private String[] mColumnProjection = new String[]{
            ContactsContract.Contacts.DISPLAY_NAME_PRIMARY,
            ContactsContract.Contacts.CONTACT_STATUS,
            ContactsContract.Contacts.HAS_PHONE_NUMBER };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();

      //  getLoaderManager().initLoader(1, null, this);
          LoaderManager.getInstance(this);
              LoaderManager.enableDebugLogging(true);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {

        Toast.makeText(this, "onCreateLoader", Toast.LENGTH_SHORT).show();
        return null;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {

        Toast.makeText(this, "onLoadFinished", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {

    }
}
