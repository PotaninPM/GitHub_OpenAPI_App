package com.example.hselyceumapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.hselyceumapp.R
import com.example.hselyceumapp.domain.repository.AuthRepository
import com.example.hselyceumapp.ui.navigation.Screen
import com.example.hselyceumapp.ui.screens.auth.SignInScreen
import com.example.hselyceumapp.ui.screens.auth.SignUpScreen
import kotlinx.coroutines.launch
import org.koin.compose.getKoin

@Composable
fun WelcomeScreen(
    navController: NavController,
    authRepository: AuthRepository = getKoin().get()
) {
    if (authRepository.getToken() != null) {
        navController.navigate(Screen.HomeScreen.route) {
            popUpTo(Screen.WelcomeScreen.route) { inclusive = true }
        }
    }

    WelcomeScreenContent(navController)
}

@Composable
private fun WelcomeScreenContent(navController: NavController) {
    val coroutineScope = rememberCoroutineScope()
    var selectedTab by remember { mutableIntStateOf(0) }
    val tabs = listOf(R.string.sign_in, R.string.sign_up)
    val pagerState = rememberPagerState { tabs.size }

    LaunchedEffect(pagerState.currentPage) {
        selectedTab = pagerState.currentPage
    }

    Scaffold(
        topBar = {
            // пока так
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surface)
                .padding(innerPadding)
        ) {
            Column {
                TabRow(selectedTabIndex = selectedTab) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedTab == index,
                            onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
                            text = { Text(text = stringResource(title)) }
                        )
                    }
                }

                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                ) { page ->
                    when (page) {
                        0 -> SignInScreen(navController)
                        1 -> SignUpScreen(navController)
                    }
                }
            }
        }
    }
}
//@Preview
//@Composable
//private fun WelcomeScreenScreenDarkPreview() {
//    MaterialTheme(
//        colorScheme = darkColorScheme()
//    ) {
//        WelcomeScreenContent()
//    }
//}

//@Preview
//@Composable
//private fun WelcomeScreenScreenLightPreview() {
//    MaterialTheme(
//        colorScheme = lightColorScheme()
//    ) {
//        WelcomeScreenContent()
//    }
//}

