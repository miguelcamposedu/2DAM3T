package com.miguelcampos.retrofitgetrequest.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.miguelcampos.retrofitgetrequest.R
import com.miguelcampos.retrofitgetrequest.data.user.UserService
import com.miguelcampos.retrofitgetrequest.data.user.response.UserListResponse
import com.miguelcampos.retrofitgetrequest.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    var baseUrl = "https://reqres.in/api/"
    lateinit var retrofit: Retrofit
    lateinit var service: UserService

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        _initRetrofit()


        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    private fun _loadUserList() {
        val call = service.getUserList("2")

        call.enqueue(object: Callback<UserListResponse>{
            override fun onResponse(
                call: Call<UserListResponse>,
                response: Response<UserListResponse>
            ) {
                if(response.code() == 200) {
                    // Aquí deberíamos poner el código de carga del adapter
                    // adapter = MyRecyclerViewAdapter(response.body()?.data)
                } else {
                    // Aquí trato el resto de código
                    Toast.makeText(activity, "Error "+response.code(), Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<UserListResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun _initRetrofit() {
        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(UserService::class.java)
        _loadUserList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}