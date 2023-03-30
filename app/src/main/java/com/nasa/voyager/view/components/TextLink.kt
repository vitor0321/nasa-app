package com.nasa.voyager.view.components

import android.content.res.Configuration
import android.os.Build
import android.text.SpannableString
import android.text.style.URLSpan
import android.text.util.Linkify
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import com.nasa.voyager.view.resource.LocalStrings
import com.nasa.voyager.view.resource.theme.NasaBasicTheme

@Composable
internal fun LinkifyText(
    text: String,
    modifier: Modifier = Modifier,
    onClickLink: ((linkText: String) -> Unit)? = null,
) {
    val uriHandler = LocalUriHandler.current
    val annotatedString = buildAnnotatedString {
        append(text)
        SpannableStr.getLinkInfos(text).forEach {
            addStyle(
                style = SpanStyle(
                    color = Color.Blue,
                    textDecoration = TextDecoration.Underline
                ),
                start = it.start,
                end = it.end
            )
            addStringAnnotation(
                tag = "tag",
                annotation = it.url,
                start = it.start,
                end = it.end
            )
        }
    }
    ClickableText(
        modifier = modifier,
        onClick = { offset ->
            annotatedString.getStringAnnotations(
                start = offset,
                end = offset,
            ).firstOrNull()?.let { result ->
                uriHandler.openUri(result.item)
                onClickLink?.invoke(annotatedString.substring(result.start, result.end))
            }
        }
    )
}

@Composable
private fun ClickableText(
    modifier: Modifier = Modifier,
    onClick: (Int) -> Unit,
) {
    val strings = LocalStrings.current.components

    val layoutResult = remember { mutableStateOf<TextLayoutResult?>(null) }
    val pressIndicator = Modifier.pointerInput(onClick) {
        detectTapGestures { pos ->
            layoutResult.value?.let { layoutResult ->
                onClick(layoutResult.getOffsetForPosition(pos))
            }
        }
    }
    Text(
        text = strings.textClick,
        modifier = modifier.then(pressIndicator),
        color = Color.Blue,
        overflow = TextOverflow.Clip,
        onTextLayout = {
            layoutResult.value = it
        }
    )
}

private data class LinkInfo(
    val url: String,
    val start: Int,
    val end: Int,
)

private class SpannableStr (source: CharSequence) : SpannableString(source) {
    companion object {
        fun getLinkInfos(text: String): List<LinkInfo> {
            val spannableStr = SpannableStr(text)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                Linkify.addLinks(spannableStr, Linkify.ALL) { str: String -> URLSpan(str) }
            } else {
                Linkify.addLinks(spannableStr, Linkify.ALL)
            }
            return spannableStr.linkInfos
        }
    }

    private inner class Data(
        val what: Any?,
        val start: Int,
        val end: Int,
    )

    private val spanList = mutableListOf<Data>()

    private val linkInfos: List<LinkInfo>
        get() = spanList.filter { it.what is URLSpan }.map {
            LinkInfo(
                (it.what as URLSpan).url,
                it.start,
                it.end
            )
        }

    override fun removeSpan(what: Any?) {
        super.removeSpan(what)
        spanList.removeAll { it.what == what }
    }

    override fun setSpan(what: Any?, start: Int, end: Int, flags: Int) {
        super.setSpan(what, start, end, flags)
        spanList.add(Data(what, start, end))
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
@Preview
fun LinkifyTextPreview() {
    NasaBasicTheme {
        LinkifyText(text = "https://apod.nasa.gov/apod/image/2212/Mars-Stereo.png")
    }
}