package com.p3d50.applicationcontentprovider

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.ContentValues
import android.content.DialogInterface
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import com.p3d50.applicationcontentprovider.database.PeopleProvider.Companion.URI_PERSONS
import com.p3d50.applicationcontentprovider.database.PersonsDatabaseHelper.Companion.FIRST_NAME
import com.p3d50.applicationcontentprovider.database.PersonsDatabaseHelper.Companion.LAST_NAME

class PersonDetailFragment:DialogFragment(),DialogInterface.OnClickListener {

    private lateinit var personEditFirstName:EditText
    private lateinit var personEditLastName:EditText
    private var id:Long = 0

    companion object{
        private const val EXTRA_ID ="id"
        fun newInstance(id:Long):PersonDetailFragment{
            val bundle = Bundle()
            bundle.putLong(EXTRA_ID,id)
            val personFragment = PersonDetailFragment()
            personFragment.arguments = bundle
            return personFragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view: View? = activity?.layoutInflater?.inflate(R.layout.person_detail,null)

        personEditFirstName = view?.findViewById(R.id.person_edit_text_first_name) as EditText
        personEditLastName = view.findViewById(R.id.person_edit_text_last_name) as EditText

        var newPerson = true
        if(arguments!=null && arguments?.getLong(EXTRA_ID)!=0L){
            id=arguments?.getLong(EXTRA_ID) as Long
            val uri:Uri = Uri.withAppendedPath(URI_PERSONS,id.toString())
            val cursor = activity?.contentResolver?.query(uri,null,null,null,null)
            if(cursor?.moveToNext() as Boolean){
                newPerson = false
                personEditFirstName.setText(cursor.getString(cursor.getColumnIndex(FIRST_NAME)))
                personEditLastName.setText(cursor.getString(cursor.getColumnIndex(LAST_NAME)))
            }
            cursor.close()
        }

        return AlertDialog.Builder(activity as Activity)
            .setTitle(if(newPerson)"Nova Pessoa" else "Editar Pessoa")
            .setView(view)
            .setPositiveButton("Salvar",this)
            .setNegativeButton("Cancelar",this)
                .create()
    }

    override fun onClick(dialogInterface: DialogInterface?, which:Int){
        val values = ContentValues()
        values.put(FIRST_NAME, personEditFirstName.text.toString())
        values.put(LAST_NAME, personEditLastName.text.toString())

        if(id!=0L){
            val uri = Uri.withAppendedPath(URI_PERSONS,id.toString())
            context?.contentResolver?.update(uri,values,null,null)
        }else{
            context?.contentResolver?.insert(URI_PERSONS,values)
        }

    }
}