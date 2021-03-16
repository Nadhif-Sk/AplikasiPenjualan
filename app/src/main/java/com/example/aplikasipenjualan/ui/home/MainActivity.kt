package com.example.aplikasipenjualan.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.aplikasipenjualan.ui.login.LoginActivity
import com.example.aplikasipenjualan.R
import com.example.aplikasipenjualan.data.database.PrefsManager
import com.example.aplikasipenjualan.ui.agent.AgentActivity
import com.example.aplikasipenjualan.ui.transaction.TransactionActivity
import com.example.aplikasipenjualan.ui.user.UserActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    lateinit var prefsManager: PrefsManager
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prefsManager = PrefsManager(this)
        presenter = MainPresenter(this)
    }

    override fun onStart() {
        super.onStart()
        when (prefsManager.prefIsLogin){
            true -> {
                crvProfil.visibility = View.VISIBLE
                btnLogin.visibility = View.GONE
            }
            false -> {
                crvProfil.visibility = View.GONE
                btnLogin.visibility = View.VISIBLE
            }
        }
    }
    override fun initListener() {

        crvTransaction.setOnClickListener {
            if (prefsManager.prefIsLogin) {
               startActivity(Intent(this, TransactionActivity::class.java))
            } else {
                showMessage("Maaf Anda belum Login")
            }
        }

        crvAgen.setOnClickListener {
            if (prefsManager.prefIsLogin) {
                startActivity(Intent(this, AgentActivity::class.java))
            } else {
                showMessage("Maaf Anda belum Login")
            }
        }

        crvProfil.setOnClickListener {
            startActivity(Intent(this, UserActivity::class.java))}

        btnLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

    }
    override fun showMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}