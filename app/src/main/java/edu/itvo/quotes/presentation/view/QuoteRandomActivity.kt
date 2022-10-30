package edu.itvo.quotes.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint

import edu.itvo.quotes.databinding.ActivityQuoteRandomBinding
import edu.itvo.quotes.presentation.viewmodel.QuoteViewModel
import kotlinx.coroutines.launch

@AndroidEntryPoint
class QuoteRandomActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuoteRandomBinding
    private val quoteViewModel: QuoteViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuoteRandomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //----------------------------
        quoteViewModel.randomQuote()
        observer()
        binding.viewContainer.setOnClickListener {
            quoteViewModel.randomQuote()
        }

    }
    private fun observer(){
        lifecycleScope.launch {
            quoteViewModel.quoteModel.collect {
                binding.tvQuote.text = it.quote
                binding.tvAuthor.text= it.author
            }
        }
    }


}