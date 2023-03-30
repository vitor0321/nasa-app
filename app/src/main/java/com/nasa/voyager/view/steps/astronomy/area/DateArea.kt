package com.nasa.voyager.view.steps.astronomy.area

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nasa.voyager.view.resource.theme.AppDefaultTypography

@Composable
internal fun DateArea(
    modifier: Modifier,
    onClickOpenCalendar: () -> Unit,
    dateFormat: String) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = modifier
                .border(
                    width = 2.dp,
                    color = MaterialTheme.colorScheme.secondary,
                    shape = RoundedCornerShape(5.dp)
                )
                .align(Alignment.End)
                .clickable { onClickOpenCalendar() }
        ) {
            Text(
                text = dateFormat,
                Modifier.padding(6.dp),
                style = AppDefaultTypography.titleSmall,
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}