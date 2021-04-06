package com.cloudwell.paywell.uiCommon.contact

import android.annotation.SuppressLint
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.cursoradapter.widget.CursorAdapter
import androidx.cursoradapter.widget.SimpleCursorAdapter
import androidx.fragment.app.Fragment
import androidx.loader.app.LoaderManager
import androidx.loader.content.CursorLoader
import androidx.loader.content.Loader
import com.cloudwell.paywell.R
import kotlinx.android.synthetic.main.local_contact_layout.view.*
import kotlinx.android.synthetic.main.slycalendar_frame.*

class LocalContactFragment : Fragment(), LoaderManager.LoaderCallbacks<Cursor>, AdapterView.OnItemClickListener {

    // Define global mutable variables
    // Define a ListView object
    lateinit var contactsList: ListView
    // Define variables for the contact the user selects
    // The contact's _ID value
    var contactId: Long = 0
    // The contact's LOOKUP_KEY
    var contactKey: String? = null
    // A content URI for the selected contact
    var contactUri: Uri? = null
    // An adapter that binds the result Cursor to the ListView
    private var cursorAdapter: SimpleCursorAdapter? = null

    private val CONTACT_ID_INDEX: Int = 0
    // The column index for the CONTACT_KEY column
    private  val CONTACT_KEY_INDEX: Int = 1
    // Defines the text expression
    @SuppressLint("InlinedApi")
    private val SELECTION: String =
        "${ContactsContract.Contacts.DISPLAY_NAME_PRIMARY} LIKE ?"

    private var searchString: String? = null
    private val selectionArgs: Array<String> = arrayOf("")

    @SuppressLint("InlinedApi")
    private val FROM_COLUMNS: Array<String> = arrayOf(
        ContactsContract.Contacts.DISPLAY_NAME_PRIMARY
    )
    private val TO_IDS: IntArray = intArrayOf(android.R.id.text1)
    private val CONTACT_MIMETYPE = 1
    private val CONTACT_DATA1 = 2
   // private val CONTACT_ID = 0
    private val CONTACT_LOOKUP_KEY = 1
    private val CONTACT_DISPLAY_NAME = 2


    // Columns to read from the Contacts Data table
    private val DATA_PROJECTION = arrayOf(
        ContactsContract.Data._ID,
        ContactsContract.Data.MIMETYPE,
        ContactsContract.Data.DATA1
    )






    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.local_contact_layout, container, false)



//        contactsList = view.listview
//        // Gets a CursorAdapter
//        cursorAdapter = SimpleCursorAdapter(
//            requireContext(), R.layout.contacts_list_item, null, FROM_COLUMNS, TO_IDS, 0
//        )
//        // Sets the adapter for the ListView
//        contactsList.adapter = cursorAdapter
//        contactsList.onItemClickListener = this

        // Initializes the loader
        loaderManager.initLoader(0, null, this)



        return view
    }

//
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.also {
            contactsList = it.findViewById<ListView>(R.id.listview)
            // Gets a CursorAdapter
            cursorAdapter = SimpleCursorAdapter(it, R.layout.contacts_list_item, null, FROM_COLUMNS, TO_IDS, 0
            )
            // Sets the adapter for the ListView
            contactsList.adapter = cursorAdapter
            contactsList.onItemClickListener = this
        }
    }

    @SuppressLint("InlinedApi")
    private val PROJECTION: Array<out String> = arrayOf(
        /*
       * The detail data row ID. To make a ListView work,
       * this column is required.
       */
        ContactsContract.Data._ID,
        // The primary display name
        ContactsContract.Data.DISPLAY_NAME_PRIMARY,
        // The contact's _ID, to construct a content URI
        ContactsContract.Data.CONTACT_ID,
        // The contact's LOOKUP_KEY, to construct a content URI
        ContactsContract.Data.LOOKUP_KEY
    )


    override fun onCreateLoader(id: Int, args: Bundle?): Loader<Cursor> {
       // selectionArgs[0] = "%$mSearchString%"
        // Starts the query
        val contentUri: Uri = Uri.withAppendedPath(
            ContactsContract.Contacts.CONTENT_FILTER_URI,
            Uri.encode(searchString)
        )
        // Starts the query
        return activity?.let {
            CursorLoader(
                it,
                contentUri,
                PROJECTION,
                null,
                null,
                null
            )
        } ?: throw IllegalStateException()
    }

    override fun onLoadFinished(loader: Loader<Cursor>, data: Cursor) {

 //       cursorAdapter?.swapCursor(data)



    }

    override fun onLoaderReset(loader: Loader<Cursor>) {

        cursorAdapter?.swapCursor(null)
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        // Get the Cursor
        val cursor: Cursor? = (parent?.adapter as? CursorAdapter)?.cursor?.apply {
            // Move to the selected contact
            moveToPosition(position)
            // Get the _ID value
            contactId = getLong(CONTACT_ID_INDEX)
            // Get the selected LOOKUP KEY
            contactKey = getString(CONTACT_KEY_INDEX)
            // Create the contact's content Uri
            contactUri = ContactsContract.Contacts.getLookupUri(contactId, contactKey)
            /*
             * You can use contactUri as the content URI for retrieving
             * the details for a contact.
             */
        }
    }

}
