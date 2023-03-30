package com.nasa.voyager.view.components

import android.content.res.Configuration
import android.view.ContextThemeWrapper
import android.widget.CalendarView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.nasa.voyager.R
import com.nasa.voyager.domain.constants.Constant.DATE_START_ASTRONOMY_DAY
import com.nasa.voyager.view.resource.LocalStrings
import com.nasa.voyager.view.resource.theme.NasaBasicTheme
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date
import java.util.Locale

@Composable
internal fun CalendarIndicator(
    onDateSelected: (LocalDate) -> Unit,
    onDismissRequest: () -> Unit
) {
    val strings  = LocalStrings.current.astronomy
    val selDate = remember { mutableStateOf(LocalDate.now()) }

    Dialog(
        onDismissRequest = { onDismissRequest() },
        properties = DialogProperties()
    ) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .background(
                    color = MaterialTheme.colorScheme.primaryContainer,
                    shape = RoundedCornerShape(size = 16.dp)
                )
        ) {
            Column(
                Modifier
                    .defaultMinSize(minHeight = 72.dp)
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = strings.selectDate,
                    style = MaterialTheme.typography.titleMedium,
                )

                Spacer(modifier = Modifier.size(24.dp))

                Text(
                    text = selDate.value.format(DateTimeFormatter.ofPattern("MMM, d, yyyy")),
                    style = MaterialTheme.typography.bodyMedium,
                )

                Spacer(modifier = Modifier.size(16.dp))
            }

            CustomCalendarView(onDateSelected = {
                selDate.value = it
            })

            Spacer(modifier = Modifier.size(8.dp))

            Row(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(bottom = 16.dp, end = 16.dp)
            ) {
                TextButton(
                    onClick = { onDismissRequest() }
                ) {
                    Text(
                        text = strings.cancel,
                        style = MaterialTheme.typography.titleMedium
                    )
                }

                TextButton(
                    onClick = { onDateSelected(selDate.value) }
                ) {
                    Text(
                        text = strings.ok,
                        style = MaterialTheme.typography.titleSmall
                    )
                }
            }
        }
    }
}

@Composable
fun CustomCalendarView(
    onDateSelected: (LocalDate) -> Unit
) {
    val context = LocalContext.current
    val calendarView = CalendarView(ContextThemeWrapper(context, R.style.CalenderViewCustom))

    val format: DateFormat = SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH)
    val date: Date = format.parse(DATE_START_ASTRONOMY_DAY) as Date

    calendarView.minDate = date.time
    calendarView.maxDate = Calendar.getInstance().time.time

    AndroidView(
        modifier = Modifier
            .wrapContentSize()
            .background(color = MaterialTheme.colorScheme.onPrimary),
        factory = { calendarView },
        update = { view ->
            view.setOnDateChangeListener { _, year, month, dayOfMonth ->
                onDateSelected(
                    LocalDate
                        .now()
                        .withMonth(month + 1)
                        .withYear(year)
                        .withDayOfMonth(dayOfMonth)
                )
            }
        }
    )
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
@Preview
fun CalendarIndicatorLightPreview() {
    NasaBasicTheme {
        CalendarIndicator(
            onDateSelected = {},
            onDismissRequest = {}
        )
    }
}