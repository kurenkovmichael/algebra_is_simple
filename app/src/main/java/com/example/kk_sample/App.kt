package com.example.kk_sample

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

object Routes {
    const val TopicArgument = "TopicArgument"
    const val TopicsRoute = "TopicsRoute"
    const val TasksRoute = "TasksRoute"
}

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun App(
    repository: TasksRepository,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Routes.TopicsRoute,
    ) {
        composable(route = Routes.TopicsRoute) {
            TopicsScreen(
                repository = repository,
                onTaskClick = { topic: Topic, _: Task ->
                    navController.navigate("${Routes.TasksRoute}/${topic.title}")
                }
            )
        }
        composable(
            route = "${Routes.TasksRoute}/{${Routes.TopicArgument}}",
            arguments = listOf(navArgument(Routes.TopicArgument) { type = NavType.StringType })
        ) { backStackEntry ->
            val arguments = backStackEntry.arguments
            val topicTitle = arguments?.getString(Routes.TopicArgument)
            val topic = repository.topics.value.firstOrNull { it.title == topicTitle }
            if (topic != null) {
                ScreenWithBackButton(onBackClick = { navController.popBackStack() }) {
                    TasksScreen(topic = topic)
                }
            }
        }
    }
}