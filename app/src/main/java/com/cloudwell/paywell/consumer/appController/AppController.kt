package com.cloudwell.paywell.consumer.appController

import android.app.Application
import com.cloudwell.paywell.consumer.base.ApplockManager
import com.cloudwell.paywell.consumer.data.db.AppDatabase
import com.cloudwell.paywell.consumer.data.network.APIService
import com.cloudwell.paywell.consumer.data.network.interceptor.HeaderTokenInterceptor
import com.cloudwell.paywell.consumer.data.network.interceptor.NetworkConnectionInterceptor
import com.cloudwell.paywell.consumer.ui.addMoney.view.AddMoneyRepository
import com.cloudwell.paywell.consumer.ui.dashboard.view.ProfileHostFactory
import com.cloudwell.paywell.consumer.ui.dashboard.view.ProfileRepository
import com.cloudwell.paywell.consumer.ui.sendMoney.view.SendMoneyRepository
import com.cloudwell.paywell.consumer.ui.sendMoney.view.SendMoneyFactory
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

        bind() from singleton {
            ProfileRepository(
                instance(),
                instance()
            )
        }
        bind() from provider { ProfileHostFactory(instance()) }
    }

    private fun initilizationLogger() {
        Logger.addLogAdapter(AndroidLogAdapter())

        Logger.addLogAdapter(object : AndroidLogAdapter() {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }
        })
    }



     fun touch(){
        ApplockManager.getInstance().updateTouch();
    }

}
