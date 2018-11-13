package slawomir.kustra.kodeinexample

import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

class KodeinApplication : Application(), KodeinAware {

    /*
    We uses modules to segregate dependencies.
     */
    override val kodein = Kodein.lazy {

    }
}