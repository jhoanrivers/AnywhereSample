package com.example.a3dolphinsextra.fragment

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a3dolphinsextra.Adapter.ContactAdapter
import com.example.a3dolphinsextra.R
import com.example.a3dolphinsextra.global.prefs
import com.example.a3dolphinsextra.model.ContactModel
import com.example.a3dolphinsextra.model.ContactResponse
import com.example.a3dolphinsextra.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

private const val TOKEN = "token"

class TeamFragment : Fragment() {

    lateinit var recyclerContact: RecyclerView
    var dialog: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_team, container, false)
        recyclerContact = view.findViewById(R.id.contact_recycler)

        doShowProgressDialog(view)

        recyclerContact.layoutManager = LinearLayoutManager(activity)
        getListContact()
        return view
    }

    private fun doShowProgressDialog(view: View) {
        dialog = Dialog(context!!)
        dialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog!!.setContentView(R.layout.loading_dialog)
        dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog!!.setCancelable(false)
        try {
            dialog!!.show()
        } catch (e: Exception){
            Log.e("Team Fragment", e.localizedMessage)
        }

    }

    private fun getListContact() {
        val token: String = "Bearer " + prefs.token
        NetworkConfig.getService().getContacts(token).enqueue(object : Callback<ContactResponse>{
            override fun onResponse(
                    call: Call<ContactResponse>, response: Response<ContactResponse>) {
                var listContact: List<ContactModel> = response.body()?.data ?: listOf<ContactModel>()
                var contactAdapter = ContactAdapter(listContact)
                recyclerContact.adapter = contactAdapter
                contactAdapter.notifyDataSetChanged()
                hideDialog()
            }

            override fun onFailure(call: Call<ContactResponse>, t: Throwable) {
                Log.d("Contact Fragment", t.localizedMessage)
            }

        })
    }

    private fun hideDialog() {
        try {
            if(dialog != null){
                dialog!!.dismiss()
            }
        } catch (e: Exception){
            Log.e("Team Fragment", e.localizedMessage)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
            TeamFragment().apply {
                arguments = Bundle().apply {
                    putString(TOKEN, param1)
                }
            }
    }
}