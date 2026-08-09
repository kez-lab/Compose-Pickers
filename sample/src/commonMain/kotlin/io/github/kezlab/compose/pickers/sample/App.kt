package io.github.kezlab.compose.pickers.sample

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.github.kezlab.compose.pickers.sample.ui.navigation.Screen
import io.github.kezlab.compose.pickers.sample.ui.screen.BackgroundStylePickerScreen
import io.github.kezlab.compose.pickers.sample.ui.screen.BottomSheetSampleScreen
import io.github.kezlab.compose.pickers.sample.ui.screen.DatePickerSampleScreen
import io.github.kezlab.compose.pickers.sample.ui.screen.DateRangePickerSampleScreen
import io.github.kezlab.compose.pickers.sample.ui.screen.DateTimePickerSampleScreen
import io.github.kezlab.compose.pickers.sample.ui.screen.DurationPickerSampleScreen
import io.github.kezlab.compose.pickers.sample.ui.screen.HomeScreen
import io.github.kezlab.compose.pickers.sample.ui.screen.IntegratedPickerScreen
import io.github.kezlab.compose.pickers.sample.ui.screen.QuantityUnitPickerSampleScreen
import io.github.kezlab.compose.pickers.sample.ui.screen.TimePickerSampleScreen
import io.github.kezlab.compose.pickers.sample.ui.screen.WheelPickerSampleScreen
import io.github.kezlab.compose.pickers.sample.ui.screen.YearMonthPickerSampleScreen
import io.github.kezlab.compose.pickers.sample.ui.theme.AppTheme

@Composable
fun App() {
    fun handleNavigateBack(navController: NavHostController) {
        if (navController.currentBackStackEntry?.destination?.route != Screen.Home.route) {
            navController.navigate(Screen.Home.route) {
                popUpTo(Screen.Home.route) { inclusive = true }
            }
        } else {
            navController.popBackStack()
        }
    }

    AppTheme {
        val navController = rememberNavController()
        NavHost(
            modifier = Modifier.fillMaxSize(),
            navController = navController,
            startDestination = Screen.Home.route
        ) {
            composable(Screen.Home.route) { HomeScreen(navController) }
            composable(Screen.WheelPicker.route) {
                WheelPickerSampleScreen(
                    onBackPressed = { handleNavigateBack(navController) }
                )
            }
            composable(Screen.DateTimePicker.route) {
                DateTimePickerSampleScreen(
                    onBackPressed = { handleNavigateBack(navController) }
                )
            }
            composable(Screen.Integrated.route) {
                IntegratedPickerScreen(
                    onBackPressed = { handleNavigateBack(navController) }
                )
            }
            composable(Screen.TimePicker.route) {
                TimePickerSampleScreen(
                    onBackPressed = { handleNavigateBack(navController) }
                )
            }
            composable(Screen.DurationPicker.route) {
                DurationPickerSampleScreen(
                    onBackPressed = { handleNavigateBack(navController) }
                )
            }
            composable(Screen.QuantityUnitPicker.route) {
                QuantityUnitPickerSampleScreen(
                    onBackPressed = { handleNavigateBack(navController) }
                )
            }
            composable(Screen.YearMonthPicker.route) {
                YearMonthPickerSampleScreen(
                    onBackPressed = { handleNavigateBack(navController) }
                )
            }
            composable(Screen.DatePicker.route) {
                DatePickerSampleScreen(
                    onBackPressed = { handleNavigateBack(navController) }
                )
            }
            composable(Screen.DateRangePicker.route) {
                DateRangePickerSampleScreen(
                    onBackPressed = { handleNavigateBack(navController) }
                )
            }
            composable(Screen.BottomSheet.route) {
                BottomSheetSampleScreen(
                    onBackPressed = { handleNavigateBack(navController) }
                )
            }
            composable(Screen.BackgroundStyle.route) {
                BackgroundStylePickerScreen(
                    onBackPressed = { handleNavigateBack(navController) }
                )
            }
        }
    }
}
