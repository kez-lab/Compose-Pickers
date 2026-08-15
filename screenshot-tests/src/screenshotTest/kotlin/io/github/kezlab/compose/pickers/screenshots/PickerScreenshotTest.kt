package io.github.kezlab.compose.pickers.screenshots

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.android.tools.screenshot.PreviewTest
import io.github.kezlab.compose.pickers.PickerDefaults
import io.github.kezlab.compose.pickers.date.DatePicker
import io.github.kezlab.compose.pickers.date.DateRangePicker
import io.github.kezlab.compose.pickers.date.rememberDatePickerState
import io.github.kezlab.compose.pickers.date.rememberDateRangePickerState
import io.github.kezlab.compose.pickers.time.TimePicker
import io.github.kezlab.compose.pickers.time.rememberTimePickerState
import io.github.kezlab.compose.pickers.util.TimeFormat
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime

@PreviewTest
@Preview(
    name = "Date picker - selected date",
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
    widthDp = 360,
    heightDp = 260
)
@Composable
fun DatePickerScreenshot() {
    PickerScreenshotTheme {
        DatePicker(
            state = rememberDatePickerState(initialDate = LocalDate(2024, 2, 29)),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@PreviewTest
@Preview(
    name = "Time picker - 12 hour",
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
    widthDp = 360,
    heightDp = 260
)
@Composable
fun TimePickerScreenshot() {
    PickerScreenshotTheme {
        TimePicker(
            state = rememberTimePickerState(
                initialTime = LocalTime(13, 5),
                timeFormat = TimeFormat.HOUR_12
            ),
            format = PickerDefaults.timePickerFormat(minuteItemText = { it.toString().padStart(2, '0') }),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@PreviewTest
@Preview(
    name = "Date range picker - selected range",
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
    widthDp = 360,
    heightDp = 260
)
@Composable
fun DateRangePickerScreenshot() {
    PickerScreenshotTheme {
        DateRangePicker(
            state = rememberDateRangePickerState(
                initialStartDate = LocalDate(2024, 6, 15),
                initialEndDate = LocalDate(2024, 6, 21)
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun PickerScreenshotTheme(content: @Composable () -> Unit) {
    MaterialTheme {
        Surface(content = content)
    }
}
