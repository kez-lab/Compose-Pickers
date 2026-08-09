package io.github.kezlab.compose.pickers.duration

import io.github.kezlab.compose.pickers.DurationPickerColumn
import io.github.kezlab.compose.pickers.DurationPickerItems
import io.github.kezlab.compose.pickers.MINUTES_PER_HOUR
import io.github.kezlab.compose.pickers.closestPickerValueTo
import io.github.kezlab.compose.pickers.durationPickerValue
import kotlin.time.Duration

/** Applies one settled column value and repairs the result as one selectable scalar duration. */
internal fun DurationPickerItems.repairedDurationAfter(
    currentDuration: Duration,
    column: DurationPickerColumn,
    value: Int
): Duration {
    val currentTotalMinutes = currentDuration.inWholeMinutes
    val currentHours = (currentTotalMinutes / MINUTES_PER_HOUR).toInt()
    val currentMinutes = (currentTotalMinutes % MINUTES_PER_HOUR).toInt()

    return when (column) {
        DurationPickerColumn.HOUR -> {
            if (value !in hourItems) return currentDuration
            val activeMinutes = selectableMinuteItemsFor(value)
            if (activeMinutes.isEmpty()) return currentDuration
            val nextMinutes = activeMinutes.closestPickerValueTo(
                value = currentMinutes,
                sourceName = "DurationPicker dependent minute items for hours=$value"
            )
            durationPickerValue(hours = value, minutes = nextMinutes)
        }

        DurationPickerColumn.MINUTE -> {
            if (value !in selectableMinuteItemsFor(currentHours)) return currentDuration
            durationPickerValue(hours = currentHours, minutes = value)
        }
    }
}
