package com.aravindh.website

import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.unit.dp
import aravindhwebsite.composeapp.generated.resources.Res
import aravindhwebsite.composeapp.generated.resources.about
import aravindhwebsite.composeapp.generated.resources.contact
import aravindhwebsite.composeapp.generated.resources.experience
import aravindhwebsite.composeapp.generated.resources.projects

import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.stringResource

@Composable
fun App() {
    MaterialTheme {
        val scrollState = rememberScrollState()
        val sectionPositions = remember { mutableStateMapOf<String, Int>() }
        val coroutineScope = rememberCoroutineScope()
        val focusRequester = remember { FocusRequester() }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF17202a))
                .verticalScroll(scrollState)
                .focusRequester(focusRequester)
                .focusable()
                .onKeyEvent { event ->
                    if (event.type == KeyEventType.KeyDown) {
                        coroutineScope.launch {
                            when (event.key) {
                                Key.DirectionUp -> scrollState.animateScrollTo(scrollState.value - 100)
                                Key.DirectionDown -> scrollState.animateScrollTo(scrollState.value + 100)
                            }
                        }
                        true
                    } else {
                        false
                    }
                }
        ) {
            LaunchedEffect(Unit) {
                focusRequester.requestFocus()
            }

            HeaderWithMenus(onNavClick = { section ->
                coroutineScope.launch {
                    sectionPositions[section]?.let { scrollState.animateScrollTo(it) }
                }
            })

            Divider(color = Color.Gray, thickness = 1.dp, modifier = Modifier.padding(horizontal = 16.dp))
            Spacer(modifier = Modifier.height(50.dp))
            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF17202a))
                    .padding(vertical = 16.dp)
            ) {
                val isMobile = maxWidth < 600.dp

                val horizontalPadding = if (isMobile) 16.dp else 56.dp
                val verticalPadding = if (isMobile) 16.dp else 32.dp

                val layoutModifier = Modifier
                    .fillMaxWidth()
                    .padding(start = horizontalPadding, end = horizontalPadding, top = verticalPadding, bottom = verticalPadding)

                if (isMobile) {
                    Column(
                        modifier = layoutModifier,
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        AnimatedTexts(isMobile = true)
                        ImageFadeInAnimation(isMobile = true)
                    }
                } else {
                    Row(
                        modifier = layoutModifier,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        AnimatedTexts(modifier = Modifier.weight(1f), isMobile = false)
                        ImageFadeInAnimation(modifier = Modifier.weight(1f), isMobile = false)
                    }
                }
            }

            Spacer(Modifier.padding(top = 50.dp))
            Section(stringResource(Res.string.about), sectionPositions) { About() }
            Spacer(Modifier.padding(top = 50.dp))
            Section(stringResource(Res.string.projects), sectionPositions) { Projects() }
            Spacer(Modifier.padding(top = 50.dp))
            Section(stringResource(Res.string.experience), sectionPositions) { Experience() }
            Spacer(Modifier.padding(top = 50.dp))
            Section(stringResource(Res.string.contact), sectionPositions) { Contact() }
            Footer()
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
