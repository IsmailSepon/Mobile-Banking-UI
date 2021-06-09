package com.cloudwell.paywell.appController

import com.cloudwell.paywell.prepspversion.network.ApiService
import com.cloudwell.paywell.prepspversion.network.NetworkConnectionInterceptor
import com.cloudwell.paywell.prepspversion.ui.registration_Login.factory.AuthViewModelFactory
import com.cloudwell.paywell.prepspversion.ui.registration_Login.repository.UserRepository
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton


/**
 * Created by MD ISMAIL HOSSAIN SEPON on 08-Jun-21.
 * ismailhossainsepon@gmail.com
 */
@SuppressWarnings("ALL")
class AppController3  : AppController2(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@AppController3))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { ApiService(instance()) }
        bind() from singleton { UserRepository(instance()) }
        bind() from provider { AuthViewModelFactory(instance()) }


    }



}