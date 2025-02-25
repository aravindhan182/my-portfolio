package com.aravindh.website

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun App() {
    MaterialTheme {
        val scrollState = rememberScrollState()
        val sectionPositions = remember { mutableStateMapOf<String, Int>() }
        val coroutineScope = rememberCoroutineScope()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF17202a))
                .verticalScroll(scrollState)
        ) {
            HomePage(onNavClick = { section ->
                coroutineScope.launch {
                    sectionPositions[section]?.let { scrollState.animateScrollTo(it) }
                }
            })
           Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(50.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 56.dp)
                    .background(Color(0xFF17202a))
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.weight(1f)
                ) {
                    AnimatedTexts()
                }
                ImageFadeInAnimation(modifier = Modifier.weight(1f))
            }
            Spacer(Modifier.padding(top = 50.dp))
            Section("ABOUT", sectionPositions) { About() }
            Spacer(Modifier.padding(top = 50.dp))
            Section("PROJECTS", sectionPositions) { Projects() }
            Spacer(Modifier.padding(top = 50.dp))
            Section("EXPERIENCE", sectionPositions) { Experience() }
            Spacer(Modifier.padding(top = 50.dp))
            Section("CONTACT", sectionPositions) {  }
        }
    }
}
@Composable
fun Section(name: String, sectionPositions: MutableMap<String, Int>, content: @Composable () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .onGloballyPositioned { coordinates ->
                sectionPositions[name] = coordinates.positionInRoot().y.toInt()
            }
    ) {
        content()
    }
}
