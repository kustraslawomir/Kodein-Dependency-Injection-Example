package slawomir.kustra.kodeinexample.view.activity

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance
import slawomir.kustra.kodeinexample.R
import slawomir.kustra.kodeinexample.data.model.Quote
import slawomir.kustra.kodeinexample.view.InjectedActivity
import java.lang.StringBuilder

class MainActivity(override val kodein: Kodein) : InjectedActivity(), KodeinAware {

    /*
     closestKodein automatically gets app kodein scope for example activity/fragment/application scope
     */

    private val quotesViewModelFactory: QuotesViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this, quotesViewModelFactory).get(QuotesViewModel::class.java)

        fab.setOnClickListener {
            viewModel.addQuote(Quote("Some fancy quote", "Johny  Bravo"))
        }

        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append(quote.toString())
            }
            quotesTextView.text = stringBuilder.toString()
        })
    }
}
