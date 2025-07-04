package com.nova.services
import android.content.Context
import android.speech.tts.TextToSpeech
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.Locale
import javax.inject.Inject
import javax.inject.Singleton
@Singleton
class NovaTtsEngine @Inject constructor(@ApplicationContext ctx:Context)
    :TextToSpeech.OnInitListener{
    private val tts = TextToSpeech(ctx,this)
    override fun onInit(status:Int){
        if(status==TextToSpeech.SUCCESS){
            tts.language= Locale("es","MX")
        }
    }
    fun speak(text:String){ tts.speak(text,TextToSpeech.QUEUE_FLUSH,null,"NOVA") }
}