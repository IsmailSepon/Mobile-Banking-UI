package com.cloudwell.paywell.appController

import android.app.Application
import com.cloudwell.paywell.base.ApplockManager
import com.cloudwell.paywell.data.db.AppDatabase
import com.cloudwell.paywell.data.network.APIService
import com.cloudwell.paywell.data.network.interceptor.HeaderTokenInterceptor
import com.cloudwell.paywell.data.network.interceptor.NetworkConnectionInterceptor
import com.cloudwell.paywell.ui.addMoney.factory.AddMoneyRepository
import com.cloudwell.paywell.ui.sendMoney.view.SendMoneyFactory
import com.cloudwell.paywell.ui.sendMoney.view.SendMoneyRepository
import com.google.firebase.messaging.FirebaseMessaging
import com.itkacher.okhttpprofiler.OkHttpProfilerInterceptor
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.BuildConfig
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

/**
 * Created by Android on 12/1/2015.
 */
class AppController : Application(), KodeinAware {

    override fun onCreate() {
        super.onCreate()
        FirebaseMessaging.getInstance().isAutoInitEnabled = true

    }

    override val kodein = Kodein.lazy {
        initilizationDI()
        initilizationLogger()
    }

    private fun Kodein.MainBuilder.initilizationDI() {
        import(androidXModule(this@AppController))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { HeaderTokenInterceptor(instance()) }
        bind() from singleton { OkHttpProfilerInterceptor() }
        bind() from singleton { APIService(instance()) }
        bind() from singleton { AppDatabase(instance()) }
//        bind() from singleton { BaseRepository(instance(), instance()) }
        bind() from singleton {
            SendMoneyRepository(
                instance(),
                instance()
            )
        }
        bind() from singleton {
            AddMoneyRepository(
                instance(),
                instance()
            )
        }

        bind() from provider { SendMoneyFactory(instance()) }
    }

    private fun initilizationLogger() {
        Logger.addLogAdapter(AndroidLogAdapter())

        Logger.addLogAdapter(object : AndroidLogAdapter() {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }
        })
    }


    fun touch() {
        ApplockManager.getInstance().updateTouch()
    }

}
