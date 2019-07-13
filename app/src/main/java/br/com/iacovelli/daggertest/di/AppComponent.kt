package br.com.iacovelli.daggertest.di

import android.app.Application
import br.com.iacovelli.daggertest.MyApplication
import br.com.iacovelli.daggertest.NetworkingModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    ActivitiesModules::class,
    FragmentsModule::class,
    AppModule::class,
    NetworkingModule::class
])
interface AppComponent: AndroidInjector<MyApplication> {

    fun inject(app: Application)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun applicationBind(application: Application): Builder
    }

}