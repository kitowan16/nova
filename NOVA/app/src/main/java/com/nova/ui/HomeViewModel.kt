package com.nova.ui
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nova.core.UserPreferences
import com.nova.services.NovaTtsEngine
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val prefs:UserPreferences,
    private val tts:NovaTtsEngine
):ViewModel(){
    private val _greeting= MutableStateFlow("")
    val greeting:StateFlow<String> get()=_greeting
    fun onLaunch(){
        viewModelScope.launch {
            val name=prefs.get() ?: return@launch
            val phrase="Hola $name, soy NOVA, te extrañé. Tu sonrisa es mi energía."
            _greeting.value=phrase
            tts.speak(phrase)
        }
    }
    fun save(name:String){
        viewModelScope.launch { prefs.save(name) }
    }
}