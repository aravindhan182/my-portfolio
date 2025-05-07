package com.aravindh.website

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import aravindhwebsite.composeapp.generated.resources.Res
import aravindhwebsite.composeapp.generated.resources.about
import aravindhwebsite.composeapp.generated.resources.about_me
import aravindhwebsite.composeapp.generated.resources.closeup_hands_business_meeting
import aravindhwebsite.composeapp.generated.resources.contact
import aravindhwebsite.composeapp.generated.resources.copyrights
import aravindhwebsite.composeapp.generated.resources.experience
import aravindhwebsite.composeapp.generated.resources.experience_desc
import aravindhwebsite.composeapp.generated.resources.experience_year
import aravindhwebsite.composeapp.generated.resources.home
import aravindhwebsite.composeapp.generated.resources.jetpack_compose
import aravindhwebsite.composeapp.generated.resources.kmp
import aravindhwebsite.composeapp.generated.resources.know_about_me
import aravindhwebsite.composeapp.generated.resources.kotlin
import aravindhwebsite.composeapp.generated.resources.ktor
import aravindhwebsite.composeapp.generated.resources.lspl
import aravindhwebsite.composeapp.generated.resources.mobile_developer
import aravindhwebsite.composeapp.generated.resources.my_skills
import aravindhwebsite.composeapp.generated.resources.name
import aravindhwebsite.composeapp.generated.resources.pos
import aravindhwebsite.composeapp.generated.resources.pos_summary
import aravindhwebsite.composeapp.generated.resources.postgres
import aravindhwebsite.composeapp.generated.resources.projects
import aravindhwebsite.composeapp.generated.resources.representative_tracking
import aravindhwebsite.composeapp.generated.resources.representative_tracking_summary
import aravindhwebsite.composeapp.generated.resources.resume
import aravindhwebsite.composeapp.generated.resources.short_summary
import aravindhwebsite.composeapp.generated.resources.short_summary_2
import aravindhwebsite.composeapp.generated.resources.spend_smart
import aravindhwebsite.composeapp.generated.resources.spend_smart_summary
import aravindhwebsite.composeapp.generated.resources.sqlite
import aravindhwebsite.composeapp.generated.resources.summary
import aravindhwebsite.composeapp.generated.resources.this_website_is_belonging_to
import aravindhwebsite.composeapp.generated.resources.webdev_4d72dbba32efee3890cef9bcacce7aa7
import aravindhwebsite.composeapp.generated.resources.xml
import kotlinx.browser.document
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.w3c.dom.HTMLAnchorElement

@Composable
fun HomePage(onNavClick: (String) -> Unit) {
    Column(
        horizontalAlignment = Alignment.End
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                stringResource(Res.string.name),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 48.sp
            )
            Row(modifier = Modifier.padding(top = 16.dp)) {
                listOf(
                    stringResource(Res.string.home),
                    stringResource(Res.string.about),
                    stringResource(Res.string.experience),
                    stringResource(Res.string.projects),
                    stringResource(Res.string.contact)
                ).forEach { section ->
                    Text(
                        text = section,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        modifier = Modifier.clickable { onNavClick(section) }
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                }
            }
        }
    }
}


@Composable
fun AnimatedTexts() {
    var firstTextToDisplay by remember { mutableStateOf("") }
    val firstOriginalText = "Hi, I'm Aravindh"
    var firstIndex by remember { mutableStateOf(0) }

    var secondTextToDisplay by remember { mutableStateOf("") }
    val secondOriginalText =
        stringResource(Res.string.short_summary_2)
    var secondIndex by remember { mutableStateOf(0) }

    var showSecondText by remember { mutableStateOf(false) }

    var showResume by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = Unit) {
        while (firstIndex <= firstOriginalText.length) {
            firstTextToDisplay = firstOriginalText.substring(0, firstIndex)
            firstIndex++
            delay(100)
        }
        showSecondText = true // Start second animation after first is finished
    }

    LaunchedEffect(key1 = showSecondText) {
        if (showSecondText) {
            while (secondIndex <= secondOriginalText.length) {
                secondTextToDisplay = secondOriginalText.substring(0, secondIndex)
                secondIndex++
                delay(20)
            }
            showResume = true
        }
    }

    Column {
        Text(
            text = firstTextToDisplay,
            color = Color.Cyan,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.SemiBold,
            fontSize = 40.sp
        )
        Spacer(Modifier.padding(8.dp))
        Text(
            text = secondTextToDisplay,
            color = Color.White,
            fontSize = 18.sp
        )
        Spacer(Modifier.padding(8.dp))
        if (showResume) {
            OutlinedButton(
                onClick = {},
                border = BorderStroke(1.dp, Color.Cyan),
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = Color(0xFF17202a),
                    contentColor = Color.White
                )
            ) {
                Text(
                    stringResource(Res.string.resume), fontWeight = FontWeight.SemiBold,
                    fontSize = 40.sp,
                    modifier = Modifier.clickable {
                        downloadResume()
                    }
                )
            }
        }
    }
}

@Composable
fun ImageFadeInAnimation(modifier: Modifier = Modifier) {
    var imageSize by remember { mutableStateOf(0.dp) }
    val targetSize = 100.dp

    LaunchedEffect(Unit) {
        while (imageSize < targetSize) {
            imageSize += 0.5.dp
            delay(50)
        }
    }

    var visible by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        delay(500)
        visible = true
    }

    AnimatedVisibility(visible = visible) {
        Image(
            painter = painterResource(Res.drawable.webdev_4d72dbba32efee3890cef9bcacce7aa7),
            contentDescription = "Your image description",
            modifier = modifier.size(500.dp)
        )
    }
}


@Composable
fun About() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            stringResource(Res.string.about_me),
            fontSize = 32.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline
        )
        Spacer(modifier = Modifier.padding(16.dp))
        Text(
            stringResource(Res.string.short_summary),
            color = Color.White
        )
        Spacer(modifier = Modifier.padding(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 64.dp, end = 64.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    stringResource(Res.string.know_about_me),
                    fontSize = 24.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.padding(16.dp))
                Text(
                    stringResource(Res.string.summary),
                    color = Color.White
                )
                Spacer(modifier = Modifier.padding(8.dp))
            }
            Spacer(modifier = Modifier.padding(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    stringResource(Res.string.my_skills),
                    fontSize = 24.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.padding(16.dp))
                Row {
                    Text(
                        text = stringResource(Res.string.kotlin),
                        color = Color.White,
                        modifier = Modifier
                            .background(color = Color(0xFF2e4053), shape = RoundedCornerShape(8.dp))
                            .padding(8.dp)
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        text = stringResource(Res.string.xml),
                        color = Color.White,
                        modifier = Modifier
                            .background(color = Color(0xFF2e4053), shape = RoundedCornerShape(8.dp))
                            .padding(8.dp)
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        text = stringResource(Res.string.jetpack_compose),
                        color = Color.White,
                        modifier = Modifier
                            .background(color = Color(0xFF2e4053), shape = RoundedCornerShape(8.dp))
                            .padding(8.dp)
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        text = stringResource(Res.string.ktor),
                        color = Color.White,
                        modifier = Modifier
                            .background(color = Color(0xFF2e4053), shape = RoundedCornerShape(8.dp))
                            .padding(8.dp)
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        text = stringResource(Res.string.kmp),
                        color = Color.White,
                        modifier = Modifier
                            .background(color = Color(0xFF2e4053), shape = RoundedCornerShape(8.dp))
                            .padding(8.dp)
                    )
                }
                Spacer(modifier = Modifier.padding(8.dp))
                Row {
                    Text(
                        text = stringResource(Res.string.sqlite),
                        color = Color.White,
                        modifier = Modifier
                            .background(color = Color(0xFF2e4053), shape = RoundedCornerShape(8.dp))
                            .padding(8.dp)
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        text = stringResource(Res.string.postgres),
                        color = Color.White,
                        modifier = Modifier
                            .background(color = Color(0xFF2e4053), shape = RoundedCornerShape(8.dp))
                            .padding(8.dp)
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                }
            }
        }
    }
}

@Composable
fun Experience() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            stringResource(Res.string.experience),
            fontSize = 32.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline
        )
        Spacer(Modifier.padding(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Card(
                shape = RoundedCornerShape(8.dp),
                backgroundColor = MaterialTheme.colors.surface,
                modifier = Modifier.width(500.dp),
                elevation = 16.dp
            ) {
                Column(
                    modifier = Modifier.wrapContentHeight().padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(Res.string.lspl),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(Modifier.padding(4.dp))
                    Text(
                        text = stringResource(Res.string.mobile_developer),
                        fontSize = 24.sp,
                        color = Color(0xFF2e4053)
                    )
                    Text(
                        text = stringResource(Res.string.experience_year),
                        fontSize = 24.sp,
                        color = Color(0xFF2e4053)
                    )
                    Spacer(Modifier.padding(4.dp))
                    Text(text = stringResource(Res.string.experience_desc))
                }
            }
        }
    }
}

@Composable
fun Projects() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            stringResource(Res.string.projects),
            fontSize = 32.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline
        )
        Spacer(modifier = Modifier.padding(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(modifier = Modifier.weight(1f)) {

                Text(
                    stringResource(Res.string.pos),
                    fontSize = 24.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Image(
                    painter = painterResource(Res.drawable.closeup_hands_business_meeting),
                    contentDescription = null,
                    modifier = Modifier.size(240.dp).align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.padding(16.dp))
                Text(
                    stringResource(Res.string.pos_summary), color = Color.White,
                    modifier = Modifier.align(Alignment.CenterHorizontally).padding(start = 8.dp)
                )
            }
            Spacer(modifier = Modifier.padding(8.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    stringResource(Res.string.spend_smart),
                    fontSize = 24.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.padding(16.dp))
                Text(
                    stringResource(Res.string.spend_smart_summary), color = Color.White,
                    modifier = Modifier.align(Alignment.CenterHorizontally).padding(start = 8.dp)
                )
            }
            Spacer(modifier = Modifier.padding(8.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    stringResource(Res.string.representative_tracking),
                    fontSize = 24.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.padding(16.dp))
                Text(
                    stringResource(Res.string.representative_tracking_summary), color = Color.White,
                    modifier = Modifier.align(Alignment.CenterHorizontally).padding(start = 8.dp)
                )
            }
        }
    }
}

/*@Composable
fun Contact() {

    val uriHandler = LocalUriHandler.current
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            stringResource(Res.string.contact),
            fontSize = 32.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline
        )
        Spacer(modifier = Modifier.padding(16.dp))
        Row(
            modifier = Modifier.width(600.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(Res.drawable.linkedin),
                contentDescription = null,
                modifier = Modifier.size(100.dp).weight(1F).clickable {
                    uriHandler.openUri("https://www.linkedin.com/in/a-aravindhan-1099a920b/")
                }
            )

            Image(
                painter = painterResource(Res.drawable.icons8_github_48),
                contentDescription = null,
                modifier = Modifier.size(100.dp).weight(1F).clickable {
                    uriHandler.openUri("https://github.com/aravindhan182")
                }
            )

            Image(
                painter = painterResource(Res.drawable.icons8_github_64),
                contentDescription = null,
                modifier = Modifier.size(100.dp).weight(1F).clickable {
                    uriHandler.openUri("https://github.com/aravindh2106")
                }
            )

            Image(
                painter = painterResource(Res.drawable.instagram),
                contentDescription = null,
                modifier = Modifier.size(100.dp).weight(1F).clickable {
                    uriHandler.openUri("https://www.instagram.com/aravindh_azeal?igsh=MW83ejMzN3AwMDJiZg==")
                }
            )

            Image(
                painter = painterResource(Res.drawable.icons8_mail_94),
                contentDescription = null,
                modifier = Modifier.size(100.dp).weight(1F).clickable {
                    window.open("mailto:aravindhanathmanathan@gmail.com", "_self")
                }
            )
        }
    }
}*/

fun downloadResume() {
    val anchor = document.createElement("a") as HTMLAnchorElement
    anchor.href = "My_resume_compressed.pdf"
    anchor.download = "Aravindhan_Resume.pdf"
    document.body?.appendChild(anchor)
    anchor.click()
    document.body?.removeChild(anchor)
}

@Composable
fun Resume() {
    val uriHandler = LocalUriHandler.current
    Column(
        modifier = Modifier.fillMaxWidth().wrapContentHeight().background(Color.Black)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(horizontalArrangement = Arrangement.Center) {

            Text(
                stringResource(Res.string.this_website_is_belonging_to),
                color = Color.White,
                fontSize = 24.sp
            )
            Text(
                stringResource(Res.string.name),
                modifier = Modifier.clickable {
                    uriHandler.openUri("https://www.linkedin.com/in/a-aravindhan-1099a920b/")
                },
                color = Color(0xFF1897bc),
                style = TextStyle(textDecoration = TextDecoration.Underline),
                fontSize = 24.sp,
            )
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Text(stringResource(Res.string.copyrights), color = Color.White, fontSize = 24.sp)
    }
}