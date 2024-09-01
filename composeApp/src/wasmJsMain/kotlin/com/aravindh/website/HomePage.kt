package com.aravindh.website

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Divider
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import aravindhwebsite.composeapp.generated.resources.Res
import aravindhwebsite.composeapp.generated.resources.webdev_4d72dbba32efee3890cef9bcacce7aa7
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomePage() {
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
                "ARAVINDHAN A",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 48.sp
            )
            Row(modifier = Modifier.padding(top = 16.dp)) {
                Text(
                    "HOME",
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    "ABOUT",
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,

                    )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    "EXPERIENCE",
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    "PROJECTS",
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    "CONTACT",
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                )
            }
        }
        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(Modifier.padding(50.dp))
        Row( // Use Row to place text and image in the same line
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 56.dp)
                .background(Color(0xFF17202a)),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                horizontalAlignment = Alignment.Start
            ) {
                AnimatedTexts()
            }
            ImageFadeInAnimation()

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
        "A skilled mobile app developer, crafting and managing applications \nto ensure the success of the entire product with finesse."
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
                    "RESUME", fontWeight = FontWeight.SemiBold,
                    fontSize = 40.sp
                )
            }
        }
    }
}

@Composable
fun ImageFadeInAnimation() {
    var imageSize by remember { mutableStateOf(0.dp) }
    val targetSize = 100.dp

    LaunchedEffect(key1 = Unit) {
        while (imageSize < targetSize) {
            imageSize += 0.5.dp // Smaller increment for slower reveal
            delay(50) // Increased delay for slower animation
        }
    }
    var visible by remember { mutableStateOf(false) }
    LaunchedEffect(key1 = Unit) {
        delay(500) // Delay before showing the image
        visible = true
    }
    AnimatedVisibility(visible = visible) {
        Image(
            painter = painterResource(Res.drawable.webdev_4d72dbba32efee3890cef9bcacce7aa7),
            contentDescription = "Your image description"
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
            "ABOUT ME", fontSize = 32.sp, color = Color.White, fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline
        )
        Spacer(modifier = Modifier.padding(16.dp))
        Text(
            "Here you will find more information about me, what I do, and my current skills mostly in terms of programming and technology",
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
                    "Know about me!",
                    fontSize = 24.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.padding(16.dp))
                Text(
                    "Greetings! I'm Aravindhan, a dedicated software engineer located in India. \n My expertise spans Android, kotlin, compose, KMP and backend API ktor.",
                    color = Color.White
                )
                Spacer(modifier = Modifier.padding(8.dp))
                Text(
                    "I have a proven track record of crafting high-quality digital solutions, \nfrom creating seamless user interfaces with xml/compose to architecting robust. My focus is always on delivering clean,\n efficient, and scalable code that exceeds expectations.",
                    color = Color.White
                )
                Spacer(modifier = Modifier.padding(8.dp))
                Text(
                    "Throughout my career, I've had the opportunity to work on a variety of projects, \neach presenting unique challenges and opportunities for growth. \nI thrive on the continuous learning and problem-solving inherent in the tech industry",
                    color = Color.White
                )
                Spacer(modifier = Modifier.padding(8.dp))
                Text(
                    "Beyond coding, I enjoy staying abreast of the latest technological advancements\n and collaborating with fellow enthusiasts. Interested in discussing \nhow we can collaborate on your next project? Feel free to get in touch. \nLet's transform ideas into reality and make a meaningful impact together",
                    color = Color.White
                )

            }
            Spacer(modifier = Modifier.padding(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    "My Skills",
                    fontSize = 24.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.padding(16.dp))
                Row {
                    Text(
                        text = "Kotlin",
                        modifier = Modifier
                            .background(color = Color(0xFF2e4053), shape = RoundedCornerShape(8.dp))
                            .padding(8.dp)
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        text = "XML",
                        modifier = Modifier
                            .background(color = Color(0xFF2e4053), shape = RoundedCornerShape(8.dp))
                            .padding(8.dp)
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        text = "Jetpack compose",
                        modifier = Modifier
                            .background(color = Color(0xFF2e4053), shape = RoundedCornerShape(8.dp))
                            .padding(8.dp)
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        text = "Ktor API Integration",
                        modifier = Modifier
                            .background(color = Color(0xFF2e4053), shape = RoundedCornerShape(8.dp))
                            .padding(8.dp)
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        text = "KMP",
                        modifier = Modifier
                            .background(color = Color(0xFF2e4053), shape = RoundedCornerShape(8.dp))
                            .padding(8.dp)
                    )
                }
                Spacer(modifier = Modifier.padding(8.dp))
                Row {
                    Text(
                        text = "Sqlite",
                        modifier = Modifier
                            .background(color = Color(0xFF2e4053), shape = RoundedCornerShape(8.dp))
                            .padding(8.dp)
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        text = "Postgres",
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
            "EXPERIENCE", fontSize = 32.sp, color = Color.White, fontWeight = FontWeight.Bold,
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
                        text = "Logic soft pvt ltd",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(Modifier.padding(4.dp))
                    Text(text = "Mobile developer", fontSize = 24.sp, color = Color(0xFF2e4053))
                    Text(text = "Aug 2021 - present", fontSize = 24.sp, color = Color(0xFF2e4053))
                    Spacer(Modifier.padding(4.dp))
                    Text(text = "I worked as a mobile developer designing mobile application and building both crossplatform and native mobile applications")
                }
            }
        }

    }
}