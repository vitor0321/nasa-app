package com.nasa.nasaApp.ui.components

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.nasa.nasaApp.ui.common.Constant.DATE_START_ASTRONOMY_DAY
import com.nasa.nasaApp.ui.theme.NasaBasicTheme
import com.nasa.nasa_app.R
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale
import java.util.Date
import java.util.Calendar

@Composable
fun CalendarIndicator(
    onDateSelected: (LocalDate) -> Unit,
    onDismissRequest: (LocalDate) -> Unit
) {
    val selDate = remember { mutableStateOf(LocalDate.now()) }

    Dialog(
        onDismissRequest = { onDismissRequest(LocalDate.now()) },
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
                    text = stringResource(R.string.select_date),
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
                    onClick = { onDismissRequest(LocalDate.now()) }
                ) {
                    Text(
                        text = stringResource(R.string.cancel),
                        style = MaterialTheme.typography.titleMedium
                    )
                }

                TextButton(
                    onClick = { onDateSelected(selDate.value) }
                ) {
                    Text(
                        text = stringResource(R.string.ok),
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

@Composable
@Preview
fun CalendarIndicatorLightPreview() {
    NasaBasicTheme(useDarkTheme = false) {
        CalendarIndicator(
            onDateSelected = {},
            onDismissRequest = {}
        )
    }
}

@Composable
@Preview
fun CalendarIndicatorDarkPreview() {
    NasaBasicTheme(useDarkTheme = true) {
        CalendarIndicator(
            onDateSelected = {},
            onDismissRequest = {}
        )
    }
}