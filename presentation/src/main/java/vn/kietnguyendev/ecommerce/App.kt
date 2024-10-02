package vn.kietnguyendev.ecommerce

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import vn.kietnguyendev.data.di.dataModule
import vn.kietnguyendev.domain.di.domainModule
import vn.kietnguyendev.ecommerce.di.presentationModule

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(
                presentationModule,
                dataModule,
                domainModule
            ))
        }
    }
}