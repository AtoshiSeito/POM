package com.example.kotlinsprogramm.ui.objects

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.kotlinsprogramm.R
import com.example.kotlinsprogramm.ui.Fragments.ChatsFragment
import com.example.kotlinsprogramm.ui.Fragments.SettingsFragment
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem

class AppDrawer (val mainActivity: AppCompatActivity, val toolbar: Toolbar) {
    private lateinit var mDrawer: Drawer
    private lateinit var mHeader: AccountHeader

    fun create(){
        createHeader()
        createDrawer()
    }
    private fun createDrawer() {
        mDrawer = DrawerBuilder()
            .withActivity(mainActivity)
            .withToolbar(toolbar)
            .withActionBarDrawerToggle(true)
            .withSelectedItem(-1)
            .withAccountHeader(mHeader)
            .addDrawerItems(
                PrimaryDrawerItem().withIdentifier(100)
                    .withIconTintingEnabled(true)
                    .withName("Содать Группу")
                    .withSelectable(false),
                PrimaryDrawerItem().withIdentifier(101)
                    .withIconTintingEnabled(true)
                    .withName("Содать Секретный чат")
                    .withSelectable(false),
                PrimaryDrawerItem().withIdentifier(102)
                    .withIconTintingEnabled(true)
                    .withName("Содать Канал")
                    .withSelectable(false),
                PrimaryDrawerItem().withIdentifier(103)
                    .withIconTintingEnabled(true)
                    .withName("Сообщения")
                    .withSelectable(false),
                PrimaryDrawerItem().withIdentifier(104)
                    .withIconTintingEnabled(true)
                    .withName("Контакты")
                    .withSelectable(false),
                PrimaryDrawerItem().withIdentifier(105)
                    .withIconTintingEnabled(true)
                    .withName("Звонки")
                    .withSelectable(false),
                DividerDrawerItem(),
                PrimaryDrawerItem().withIdentifier(106)
                    .withIconTintingEnabled(true)
                    .withName("Настройки")
                    .withSelectable(false),
                PrimaryDrawerItem().withIdentifier(107)
                    .withIconTintingEnabled(true)
                    .withName("О программе")
                    .withSelectable(false)
            ).withOnDrawerItemClickListener(object :Drawer.OnDrawerItemClickListener{
                override fun onItemClick(
                    view: View?,
                    position: Int,
                    drawerItem: IDrawerItem<*>
                ): Boolean {
                    when (position){
                        8 -> mainActivity.supportFragmentManager.beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.dataConteiner, SettingsFragment()).commit()

                        4 -> mainActivity.supportFragmentManager.beginTransaction()
                            .replace(R.id.dataConteiner, ChatsFragment()).commit()
                    }
                    return false
                }
            }).build()

    }

    private fun createHeader() {
        mHeader = AccountHeaderBuilder()
            .withActivity(mainActivity)
            .withHeaderBackground(R.drawable.header)
            .addProfiles(
                ProfileDrawerItem().withName("Yura Petrov")
                    .withEmail("ivgor02@gmail.com")
            ).build()
    }

}