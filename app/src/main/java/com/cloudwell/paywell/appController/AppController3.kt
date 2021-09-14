package com.cloudwell.paywell.appController

import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule


/**
 * Created by MD ISMAIL HOSSAIN SEPON on 08-Jun-21.
 * ismailhossainsepon@gmail.com
 */
@SuppressWarnings("ALL")
class AppController3  : AppController2(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@AppController3))

//        bind() from singleton { NetworkConnectionInterceptor(instance()) }
//        bind() from singleton { ApiService(instance()) }
//        bind() from singleton { UserRepository(instance()) }
//        bind() from provider { AuthViewModelFactory(instance()) }


    }



}