package slawomir.kustra.kodeinexample.view

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import slawomir.kustra.kodeinexample.KodeinApplication

abstract class InjectedActivity : AppCompatActivity(), KodeinAware{

    private val appKodein by closestKodein()

}

fun Activity.app() = applicationContext as KodeinApplication