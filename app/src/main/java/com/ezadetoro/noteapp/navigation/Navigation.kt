package com.ezadetoro.noteapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ezadetoro.noteapp.ui.screens.AddNoteScreen
import com.ezadetoro.noteapp.ui.screens.EditNoteScreen
import com.ezadetoro.noteapp.ui.screens.HomeScreen

//sealed class  Screen(val route: String) {
//    object Home : Screen("home")
//    object AddNote : Screen("add_note")
//    object EditNote : Screen("edit_note/{id}")
//}


@Composable
fun NoteNavGraph(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {

        composable(route = "home") {
            HomeScreen(navController)
        }
        composable(route = "add_note") {
            AddNoteScreen(navController=navController)
        }
        composable(
            route = "edit_note/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) {
            val id = it.arguments?.getInt("id") ?: 0
            EditNoteScreen(
                navController = navController, noteId = id
            )
        }
    }
}
