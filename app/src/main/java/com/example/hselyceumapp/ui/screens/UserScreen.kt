package com.example.hselyceumapp.ui.screens

import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.hselyceumapp.R
import com.example.hselyceumapp.ui.components.Snowfall
import com.example.hselyceumapp.ui.viewModels.UsersViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun UserScreen(
    viewModel: UsersViewModel = koinViewModel()
) {
    val context = LocalContext.current

    val selectedUser by viewModel.selectedUser.collectAsState()
    var isPlaying by rememberSaveable { mutableStateOf(false) }
    var mediaPlayer: MediaPlayer? = null
    var isSnowfallActive by remember { mutableStateOf(false) }

    val musicFiles = listOf(R.raw.song1, R.raw.songs2)

    Snowfall(isSnowfallActive)

    selectedUser?.let { user ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .windowInsetsPadding(WindowInsets.systemBars.only(WindowInsetsSides.Top)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .border(
                        width = 4.dp,
                        color = Color(0xFF4CAF50),
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = rememberAsyncImagePainter(user.avatarUrl),
                    contentDescription = stringResource(R.string.profile_picture),
                    modifier = Modifier
                        .size(110.dp)
                        .clip(CircleShape)
                )
            }
            Spacer(modifier = Modifier.size(16.dp))

            Column {
                UserInfoCard(
                    info = user.id.toString(),
                    type = 0,
                    label = {
                        Text(
                            text = stringResource(R.string.id),
                            style = MaterialTheme.typography.bodySmall
                        )
                    },
                )

                UserInfoCard(
                    info = user.login,
                    type = 1,
                    label = {
                        Text(
                            text = stringResource(R.string.login),
                            style = MaterialTheme.typography.bodySmall
                        )
                    },
                )

                UserInfoCard(
                    info = user.htmlUrl,
                    type = 2,
                    label = {
                        Text(
                            text = stringResource(R.string.github),
                            style = MaterialTheme.typography.bodySmall
                        )
                    },
                )
            }

            if (!isPlaying) {
                Button(
                    onClick = {
                        if (mediaPlayer == null) {
                            mediaPlayer = MediaPlayer.create(context, musicFiles.random())
                            mediaPlayer?.start()
                            isSnowfallActive = true

                            mediaPlayer?.setOnCompletionListener {
                                mediaPlayer?.release()
                                mediaPlayer = MediaPlayer.create(context, musicFiles.random())
                                mediaPlayer?.start()
                            }
                        }
                        isPlaying = true
                    },
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(16.dp)
                ) {
                    Text(stringResource(R.string.new_year))
                }
            }
        }
    } ?: run {
        Text(
            text = stringResource(R.string.none_chosen),
            modifier = Modifier.padding(16.dp)
        )
    }

    DisposableEffect(Unit) {
        onDispose {
            mediaPlayer?.release()
        }
    }
}


@Composable
fun UserInfoCard(
    info: String,
    type: Int,
    label: @Composable () -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = when (type) {
                0 -> Color.Cyan
                1 -> Color.Green
                2 -> Color.Red
                3 -> Color.Yellow
                else -> {
                    Color.Black
                }
            }.copy(alpha = 0.25f)
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = info,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.ExtraBold
            )
            label()
        }
    }
}
