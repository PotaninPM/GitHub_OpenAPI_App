package com.example.hselyceumapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.hselyceumapp.ui.viewmodel.UsersViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun UserScreen(
    viewModel: UsersViewModel = koinViewModel()
) {
    val selectedUser by viewModel.selectedUser.collectAsState()

    selectedUser?.let { user ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = user.avatarUrl,
                contentDescription = "User Avatar",
                modifier = Modifier.size(128.dp)
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(text = "Username: ${user.login}", fontSize = 20.sp)
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "Profile URL: ${user.avatarUrl}", fontSize = 16.sp)
        }
    } ?: run {
        Text(
            text = "No user selected",
            modifier = Modifier.padding(16.dp)
        )
    }
}
