package com.ezadetoro.noteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.ezadetoro.noteapp.navigation.NoteNavGraph
import com.ezadetoro.noteapp.ui.screens.HomeScreen
import com.ezadetoro.noteapp.ui.theme.NoteAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NoteAppTheme {
                Scaffold {paddingValues ->
                    NoteNavGraph(
                        modifier = Modifier.padding(paddingValues)
                    )

                }

            }
        }
    }
}

