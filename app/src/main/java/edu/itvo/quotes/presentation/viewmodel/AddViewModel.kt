package edu.itvo.quotes.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.itvo.quotes.domain.model.QuoteModel
import edu.itvo.quotes.domain.usecase.GetQuoteAddUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

/*
class AddViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is gallery Fragment"
    }
    val text: LiveData<String> = _text
}
 */
@HiltViewModel
class AddViewModel
@Inject constructor(
    private val getQuoteAddUseCase: GetQuoteAddUseCase
) : ViewModel() {

    fun addQuote(quoteModel: QuoteModel) {
        viewModelScope.launch {
            getQuoteAddUseCase.addQuote(quoteModel)
        }
    }

}