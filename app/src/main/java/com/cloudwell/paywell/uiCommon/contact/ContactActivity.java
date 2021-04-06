package com.cloudwell.paywell.uiCommon.contact;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.cloudwell.paywell.R;

public class ContactActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, android.app.LoaderManager.LoaderCallbacks<Cursor> {

    private static final String TAG = "ContentProviderDemo";

    private String[] mColumnProjection = new String[]{
            ContactsContract.Contacts.DISPLAY_NAME_PRIMARY,
            ContactsContract.Contacts.CONTACT_STATUS,
            ContactsContract.Contacts.HAS_PHONE_NUMBER };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        getContactList();

     //   getLoaderManager().initLoader(1, null, this);

      //  LoaderManager.getInstance(this);
    }



    @Override
    public android.content.Loader<Cursor> onCreateLoader(int id, Bundle args) {


        if (id == 1){

            //return new CursorLoader(this,ContactsContract.Contacts.CONTENT_URI, mColumnProjection, null, null, null);
            return new android.content.CursorLoader(this, ContactsContract.Contacts.CONTENT_URI, mColumnProjection, null, null, null);

        }

        return null;
    }

    @Override
    public void onLoadFinished(android.content.Loader<Cursor> loader, Cursor cursor) {
        if (cursor != null && cursor.getCount() > 0) {
            StringBuilder stringBuilderQueryResult = new StringBuilder("");
            //cursor.moveToFirst();
            while (cursor.moveToNext()) {
                stringBuilderQueryResult.append(cursor.getString(0) + " , " +
                        cursor.getString(1) + " , " +
                        cursor.getString(2) + "\n");


                String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                Toast.makeText(this, ""+id, Toast.LENGTH_SHORT).show();
                Toast.makeText(this, ""+name, Toast.LENGTH_SHORT).show();
            }

            Log.e("Contact", stringBuilderQueryResult.toString());

        } else {

            Log.e("Contact", "No Contacts in device");
        }
        cursor.close();

    }

    @Override
    public void onLoaderReset(android.content.Loader<Cursor> loader) {

    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }


    private void getContactList() {
        ContentResolver cr = getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,
                null, null, null, null);

        if ((cur != null ? cur.getCount() : 0) > 0) {
            while (cur != null && cur.moveToNext()) {
                String id = cur.getString(
                        cur.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cur.getString(cur.getColumnIndex(
                        ContactsContract.Contacts.DISPLAY_NAME));

                if (cur.getInt(cur.getColumnIndex(
                        ContactsContract.Contacts.HAS_PHONE_NUMBER)) > 0) {
                    Cursor pCur = cr.query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                            new String[]{id}, null);
                    while (pCur.moveToNext()) {
                        String phoneNo = pCur.getString(pCur.getColumnIndex(
                                ContactsContract.CommonDataKinds.Phone.NUMBER));
                        Log.i(TAG, "Name: " + name);
                        Log.i(TAG, "Phone Number: " + phoneNo);
                    }
                    pCur.close();
                }
            }
        }
        if(cur!=null){
            cur.close();
        }
    }
}