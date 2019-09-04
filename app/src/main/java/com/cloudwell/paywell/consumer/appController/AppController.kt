package com.cloudwell.paywell.consumer.appController

import android.app.Application
import com.cloudwell.paywell.consumer.db.entities.AppDatabase
import com.cloudwell.paywell.consumer.network.APIService
import com.cloudwell.paywell.consumer.network.interceptor.HeaderTokenInterceptor
import com.cloudwell.paywell.consumer.network.interceptor.NetworkConnectionInterceptor
import com.cloudwell.paywell.consumer.repository.UserRepository
import com.cloudwell.paywell.consumer.ui.auth.authViewModelFactory.AuthViewModelFactory
import com.itkacher.okhttpprofiler.OkHttpProfilerInterceptor
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

/**
 * Created by Android on 12/1/2015.
 */
class AppController : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@AppController))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { HeaderTokenInterceptor(instance()) }
        bind() from singleton { OkHttpProfilerInterceptor() }
        bind() from singleton { APIService(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { UserRepository(instance(), instance()) }

        bind() from provider { AuthViewModelFactory(instance()) }


    }




//    companion object {
//
//        private val APONA_LOHIT = "fonts/AponaLohit.ttf"
//        private val OXYGEN_LIGHT = "fonts/Oxygen-Light.ttf"
//        @get:Synchronized
//        var instance: AppController? = null
//            private set
//        private val preference: SharedPreferences? = null
//
//        private val sPref: SharedPreferences? = null
//        var context: AppController? = null
//            private set
//    }


}
