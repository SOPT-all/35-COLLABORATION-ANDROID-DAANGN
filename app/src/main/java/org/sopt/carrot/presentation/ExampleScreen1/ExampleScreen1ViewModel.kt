package org.sopt.carrot.presentation.ExampleScreen1

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import org.sopt.carrot.data.repositoryimpl.DummyRepositoryImpl

class ExampleScreen1ViewModel(dummyRepositoryImpl: DummyRepositoryImpl) : ViewModel() {

    private val _text = mutableStateOf("진짜 그냥 예시")
    val text: State<String> = _text

    fun updateText(newText: String) {
        _text.value = newText
    }

}
