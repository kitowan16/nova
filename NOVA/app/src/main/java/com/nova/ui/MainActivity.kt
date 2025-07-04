package com.nova.ui
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nova.ui.theme.NovaTheme
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class MainActivity:ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            NovaTheme{
                val vm:HomeViewModel= viewModel()
                LaunchedEffect(Unit){vm.onLaunch()}
                HomeScreen(vm)
            }
        }
    }
}