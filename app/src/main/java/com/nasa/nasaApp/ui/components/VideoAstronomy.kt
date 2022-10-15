package com.nasa.nasaApp.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView

@Composable
fun VideoAstronomy() {
    val videoUrl = "https://www.youtube.com/watch?v=5KGNozEHZmQ.mp4"
    val context = LocalContext.current
    val player = ExoPlayer.Builder(context).build()
    val playerView = StyledPlayerView(context)
    val mediaItem = MediaItem.fromUri(videoUrl)
    val playWhenReady by rememberSaveable{
        mutableStateOf(true)
    }
    player.setMediaItem(mediaItem)
    playerView.player =player

    LaunchedEffect(player){
        player.prepare()
        player.playWhenReady = playWhenReady
    }

    AndroidView(factory = {
        playerView
    })
}