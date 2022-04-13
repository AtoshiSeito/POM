package com.example.kotlinsprogramm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.kotlinsprogramm.databinding.ActivityMainBinding
import com.example.kotlinsprogramm.ui.Fragments.ChatsFragment
import com.example.kotlinsprogramm.ui.objects.AppDrawer

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mToolbar: Toolbar
    private lateinit var mAppDrawer: AppDrawer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFunc()
    }

    private fun initFunc() {
        setSupportActionBar(mToolbar)
        mAppDrawer.create()
        supportFragmentManager.beginTransaction()
            .replace(R.id.dataConteiner, ChatsFragment()).commit()
    }

    private fun initFields() {
        mToolbar = mBinding.mainToolbar
        mAppDrawer = AppDrawer(this, mToolbar)
    }
}