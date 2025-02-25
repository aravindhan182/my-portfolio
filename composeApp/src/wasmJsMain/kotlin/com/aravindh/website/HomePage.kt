package com.aravindh.website

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
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
import aravindhwebsite.composeapp.generated.resources._19197149
import aravindhwebsite.composeapp.generated.resources.closeup_hands_business_meeting
import aravindhwebsite.composeapp.generated.resources.compose_multiplatform
import aravindhwebsite.composeapp.generated.resources.tracking_icon
import aravindhwebsite.composeapp.generated.resources.webdev_4d72dbba32efee3890cef9bcacce7aa7
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource

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
                "ARAVINDHAN A",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 48.sp
            )
            Row(modifier = Modifier.padding(top = 16.dp)) {
                listOf("HOME", "ABOUT", "EXPERIENCE", "PROJECTS", "CONTACT").forEach { section ->
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

@Composable
fun Projects() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            "PROJECTS", fontSize = 32.sp, color = Color.White, fontWeight = FontWeight.Bold,
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
                    "POS",
                    fontSize = 24.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Image(
                    painter = painterResource(Res.drawable.closeup_hands_business_meeting),
                    contentDescription = null,
                    modifier = Modifier.size(240.dp).align(Alignment.CenterHorizontally))
                Spacer(modifier = Modifier.padding(16.dp))
                Text(
                    "This was my first project in my organization, where I worked on migrating an older version of a POS (Point of Sale) application to a newer, optimized version. Throughout this project, I gained valuable experience in code reusability, performance optimization, and efficient data synchronization.\n" +
                            "\n" +
                            "The new version of the app improved overall functionality and user experience, enabling seamless POS operations.This project fully developed by using Jetpack components, some pages in Jetpack Compose, Room database for managing the data, For API integration used Retrofit. One of the key enhancements was optimizing the synchronization process, making it 3x faster than the previous version. Additionally, I contributed to refining the codebase, improving maintainability, and implementing best practices to ensure long-term scalability",
                    color = Color.White,
                    modifier = Modifier.align(Alignment.CenterHorizontally).padding(start = 8.dp)
                )
            }
            Spacer(modifier = Modifier.padding(8.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    "SPEND SMART",
                    fontSize = 24.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.padding(16.dp))
                Text(
                    "I developed Spend Smart, a personal finance management app built entirely with Jetpack Compose. This app enables users to allocate budgets, track expenses, and monitor income efficiently, providing a clear financial overview with an intuitive and modern UI. It features budget allocation, expense and income tracking, and real-time insights through visual representations of spending patterns. By working on this project, I deepened my expertise in Jetpack Compose, state management, and database handling, enhancing my ability to develop efficient, scalable, and user-friendly financial applications.",
                    color = Color.White,
                    modifier = Modifier.align(Alignment.CenterHorizontally).padding(start = 8.dp)
                )
                Image(
                    painter = painterResource(Res.drawable._19197149),
                    contentDescription = null,
                    modifier = Modifier.size(240.dp).align(Alignment.CenterHorizontally))
            }
            Spacer(modifier = Modifier.padding(8.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    "REPRESENTATIVE TRACKING",
                    fontSize = 24.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Image(
                    painter = painterResource(Res.drawable.tracking_icon),
                    contentDescription = null,
                    modifier = Modifier.size(240.dp).align(Alignment.CenterHorizontally))
                Spacer(modifier = Modifier.padding(16.dp))
                Text(
                    "I worked on representative tracking system project focused on maintaining and bug fixing. This project was fully developed using Android Jetpack components, Kotlin, Google Maps, and Retrofit for API integration. I was responsible for identifying and resolving critical issues, optimizing performance, and enhancing the overall stability of the application.\n" +
                            "\n" +
                            "Through this experience, I gained a deep understanding of large-scale system architecture, real-time location tracking, and API efficiency. Additionally, collaborating with cross-functional teams improved my problem-solving skills and ability to work in a fast-paced environment.",
                    color = Color.White,
                    modifier = Modifier.align(Alignment.CenterHorizontally).padding(start = 8.dp)
                )

            }
        }
    }
}