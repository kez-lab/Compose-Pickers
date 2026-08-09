package io.github.kezlab.compose.pickers.sample.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import io.github.kezlab.compose.pickers.sample.ui.navigation.Screen
import compose.icons.FeatherIcons
import compose.icons.feathericons.ArrowRight
import compose.icons.feathericons.Box
import compose.icons.feathericons.Calendar
import compose.icons.feathericons.CheckCircle
import compose.icons.feathericons.Clock
import compose.icons.feathericons.Layers
import compose.icons.feathericons.Square
import compose.icons.feathericons.Watch

@Composable
internal fun HomeScreen(navController: NavController) {
    Scaffold { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .testTag("sample-menu-list"),
            contentPadding = PaddingValues(horizontal = 20.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item { HomeHero() }

            item { SectionHeader("Foundation") }
            item {
                MenuListItem(
                    title = "WheelPicker Sample",
                    description = "Live value updates plus a settled callback",
                    icon = FeatherIcons.Layers,
                    modifier = Modifier.testTag("sample-menu-wheel-picker"),
                    onClick = { navController.navigate(Screen.WheelPicker.route) }
                )
            }

            item { SectionHeader("Date & time presets") }
            item {
                MenuListItem(
                    title = "TimePicker Sample",
                    description = "12-hour and 24-hour state updates",
                    icon = FeatherIcons.Clock,
                    modifier = Modifier.testTag("sample-menu-time-picker"),
                    onClick = { navController.navigate(Screen.TimePicker.route) }
                )
            }
            item {
                MenuListItem(
                    title = "DatePicker Sample",
                    description = "Custom year range and leap-day target",
                    icon = FeatherIcons.Calendar,
                    modifier = Modifier.testTag("sample-menu-date-picker"),
                    onClick = { navController.navigate(Screen.DatePicker.route) }
                )
            }
            item {
                MenuListItem(
                    title = "DateRangePicker Sample",
                    description = "Ordered start and end date selection",
                    icon = FeatherIcons.Calendar,
                    modifier = Modifier.testTag("sample-menu-date-range-picker"),
                    onClick = { navController.navigate(Screen.DateRangePicker.route) }
                )
            }
            item {
                MenuListItem(
                    title = "YearMonthPicker Sample",
                    description = "Month selection with programmatic reset",
                    icon = FeatherIcons.Calendar,
                    modifier = Modifier.testTag("sample-menu-year-month-picker"),
                    onClick = { navController.navigate(Screen.YearMonthPicker.route) }
                )
            }
            item {
                MenuListItem(
                    title = "DurationPicker Sample",
                    description = "Atomic 0–90 minute selection in 5-minute steps",
                    icon = FeatherIcons.Watch,
                    modifier = Modifier.testTag("sample-menu-duration-picker"),
                    onClick = { navController.navigate(Screen.DurationPicker.route) }
                )
            }

            item { SectionHeader("Dependent columns · sample-only contracts") }
            item {
                MenuListItem(
                    title = "Exact Date-Time Slots (Sample Only)",
                    description = "One internal LocalDateTime over five candidate columns",
                    icon = FeatherIcons.Clock,
                    modifier = Modifier.testTag("sample-menu-date-time-picker"),
                    onClick = { navController.navigate(Screen.DateTimePicker.route) }
                )
            }
            item {
                MenuListItem(
                    title = "Quantity + Unit Sample",
                    description = "Unit-dependent quantity source, step, and repair",
                    icon = FeatherIcons.Box,
                    modifier = Modifier.testTag("sample-menu-quantity-unit-picker"),
                    onClick = { navController.navigate(Screen.QuantityUnitPicker.route) }
                )
            }

            item { SectionHeader("Styling & patterns") }
            item {
                MenuListItem(
                    title = "Integrated Sample",
                    description = "Public YearMonthPicker and TimePicker with separate states",
                    icon = FeatherIcons.CheckCircle,
                    modifier = Modifier.testTag("sample-menu-integrated"),
                    onClick = { navController.navigate(Screen.Integrated.route) }
                )
            }
            item {
                MenuListItem(
                    title = "BottomSheet Sample",
                    description = "Committed value plus draft sheet state",
                    icon = FeatherIcons.Layers,
                    modifier = Modifier.testTag("sample-menu-bottom-sheet"),
                    onClick = { navController.navigate(Screen.BottomSheet.route) }
                )
            }
            item {
                MenuListItem(
                    title = "Background Style",
                    description = "Divider-free picker styling",
                    icon = FeatherIcons.Square,
                    modifier = Modifier.testTag("sample-menu-background-style"),
                    onClick = { navController.navigate(Screen.BackgroundStyle.route) }
                )
            }
        }
    }
}

@Composable
private fun HomeHero() {
    Column(modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)) {
        Text(
            text = "Compose Pickers",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.ExtraBold,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = "Constraint-aware wheel selection for Compose Multiplatform",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(14.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            PlatformChip("Android")
            PlatformChip("iOS")
            PlatformChip("Desktop")
            PlatformChip("Web")
        }
    }
}

@Composable
private fun PlatformChip(label: String) {
    Surface(
        shape = RoundedCornerShape(50),
        color = MaterialTheme.colorScheme.secondaryContainer,
        contentColor = MaterialTheme.colorScheme.onSecondaryContainer
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
        )
    }
}

@Composable
private fun SectionHeader(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.labelLarge,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(top = 14.dp, bottom = 2.dp)
    )
}

@Composable
internal fun MenuListItem(
    title: String,
    description: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Surface(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        color = MaterialTheme.colorScheme.surface,
        tonalElevation = 1.dp
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(42.dp),
                contentAlignment = Alignment.Center
            ) {
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = MaterialTheme.colorScheme.primaryContainer,
                    modifier = Modifier.fillMaxSize()
                ) {}
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
            Spacer(modifier = Modifier.width(14.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(1.dp))
                Text(
                    description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Icon(
                FeatherIcons.ArrowRight,
                contentDescription = null,
                modifier = Modifier.size(18.dp),
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
