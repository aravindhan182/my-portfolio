package com.aravindh.website

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.text.style.TextAlign
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
import aravindhwebsite.composeapp.generated.resources.icons8_github_48
import aravindhwebsite.composeapp.generated.resources.icons8_github_64
import aravindhwebsite.composeapp.generated.resources.instagram
import aravindhwebsite.composeapp.generated.resources.jetpack_compose
import aravindhwebsite.composeapp.generated.resources.kmp
import aravindhwebsite.composeapp.generated.resources.know_about_me
import aravindhwebsite.composeapp.generated.resources.kotlin
import aravindhwebsite.composeapp.generated.resources.ktor
import aravindhwebsite.composeapp.generated.resources.linkedin
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
import aravindhwebsite.composeapp.generated.resources.tracking_icon
import aravindhwebsite.composeapp.generated.resources.webdev_4d72dbba32efee3890cef9bcacce7aa7
import aravindhwebsite.composeapp.generated.resources.xml
import kotlinx.browser.document
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.w3c.dom.HTMLAnchorElement

@Composable
fun HeaderWithMenus(onNavClick: (String) -> Unit) {
    BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
        val isMobile = maxWidth < 600.dp

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = if (isMobile) Alignment.Start else Alignment.End
        ) {
            if (isMobile) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        stringResource(Res.string.name),
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 32.sp
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Column {
                        navItems().forEach { section ->
                            Text(
                                text = section,
                                color = Color.White,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 14.sp,
                                modifier = Modifier
                                    .clickable { onNavClick(section) }
                                    .padding(vertical = 8.dp)
                            )
                        }
                    }
                }
            } else {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        stringResource(Res.string.name),
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 48.sp
                    )
                    Row(modifier = Modifier.padding(top = 16.dp)) {
                        navItems().forEach { section ->
                            Text(
                                text = section,
                                color = Color.White,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                modifier = Modifier
                                    .clickable { onNavClick(section) }
                                    .padding(horizontal = 8.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun navItems(): List<String> {
    return listOf(
        stringResource(Res.string.home),
        stringResource(Res.string.about),
        stringResource(Res.string.experience),
        stringResource(Res.string.projects),
        stringResource(Res.string.contact)
    )
}

@Composable
fun AnimatedTexts(modifier: Modifier = Modifier, isMobile: Boolean) {
    var firstTextToDisplay by remember { mutableStateOf("") }
    val firstOriginalText = "Hi, I'm Aravindh"
    var firstIndex by remember { mutableStateOf(0) }

    var secondTextToDisplay by remember { mutableStateOf("") }
    val secondOriginalText = stringResource(Res.string.short_summary_2)
    var secondIndex by remember { mutableStateOf(0) }

    var showSecondText by remember { mutableStateOf(false) }
    var showResume by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        while (firstIndex <= firstOriginalText.length) {
            firstTextToDisplay = firstOriginalText.substring(0, firstIndex)
            firstIndex++
            delay(100)
        }
        showSecondText = true
    }

    LaunchedEffect(showSecondText) {
        if (showSecondText) {
            while (secondIndex <= secondOriginalText.length) {
                secondTextToDisplay = secondOriginalText.substring(0, secondIndex)
                secondIndex++
                delay(20)
            }
            showResume = true
        }
    }

    Column(modifier = modifier) {
        Text(
            text = firstTextToDisplay,
            color = Color.Cyan,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.SemiBold,
            fontSize = if (isMobile) 28.sp else 40.sp
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = secondTextToDisplay,
            color = Color.White,
            fontSize = if (isMobile) 14.sp else 18.sp
        )
        Spacer(Modifier.height(12.dp))
        if (showResume) {
            OutlinedButton(
                onClick = { downloadResume() },
                border = BorderStroke(1.dp, Color.Cyan),
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = Color(0xFF17202a),
                    contentColor = Color.White
                )
            ) {
                Text(
                    stringResource(Res.string.resume),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = if (isMobile) 20.sp else 28.sp
                )
            }
        }
    }
}


@Composable
fun ImageFadeInAnimation(
    modifier: Modifier = Modifier,
    isMobile: Boolean
) {
    var visible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(500)
        visible = true
    }

    val imageSize = if (isMobile) 200.dp else 400.dp

    AnimatedVisibility(visible = visible) {
        Image(
            painter = painterResource(Res.drawable.webdev_4d72dbba32efee3890cef9bcacce7aa7),
            contentDescription = "Developer Illustration",
            modifier = modifier.size(imageSize)
        )
    }
}


@Composable
fun About() {
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val isMobile = maxWidth < 600.dp

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = if (isMobile) 16.dp else 64.dp)
                .padding(vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                stringResource(Res.string.about_me),
                fontSize = if (isMobile) 24.sp else 32.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                stringResource(Res.string.short_summary),
                color = Color.White,
                fontSize = if (isMobile) 14.sp else 16.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(24.dp))

            if (isMobile) {
                Column {
                    KnowAboutMeSection(isMobile)
                    Spacer(modifier = Modifier.height(24.dp))
                    MySkillsSection(isMobile)
                }
            } else {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    KnowAboutMeSection(isMobile, modifier = Modifier.weight(1f))
                    Spacer(modifier = Modifier.width(32.dp))
                    MySkillsSection(isMobile, modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
private fun KnowAboutMeSection(isMobile: Boolean, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            stringResource(Res.string.know_about_me),
            fontSize = if (isMobile) 20.sp else 24.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            stringResource(Res.string.summary),
            color = Color.White,
            fontSize = if (isMobile) 14.sp else 16.sp
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun MySkillsSection(isMobile: Boolean, modifier: Modifier = Modifier) {
    val skills = listOf(
        Res.string.kotlin, Res.string.xml, Res.string.jetpack_compose,
        Res.string.ktor, Res.string.kmp,
        Res.string.sqlite, Res.string.postgres
    )

    Column(modifier = modifier) {
        Text(
            stringResource(Res.string.my_skills),
            fontSize = if (isMobile) 20.sp else 24.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            skills.forEach {
                Text(
                    text = stringResource(it),
                    color = Color.White,
                    fontSize = if (isMobile) 12.sp else 14.sp,
                    modifier = Modifier
                        .background(Color(0xFF2e4053), shape = RoundedCornerShape(8.dp))
                        .padding(horizontal = 12.dp, vertical = 8.dp)
                )
            }
        }
    }
}

@Composable
fun Experience() {
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val isMobile = maxWidth < 600.dp

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = if (isMobile) 16.dp else 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                stringResource(Res.string.experience),
                fontSize = if (isMobile) 24.sp else 32.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline
            )
            Spacer(Modifier.height(16.dp))

            Card(
                shape = RoundedCornerShape(12.dp),
                backgroundColor = MaterialTheme.colors.surface,
                elevation = 12.dp,
                modifier = Modifier
                    .fillMaxWidth(if (isMobile) 0.95f else 0.6f)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(Res.string.lspl),
                        fontSize = if (isMobile) 20.sp else 24.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = stringResource(Res.string.mobile_developer),
                        fontSize = if (isMobile) 18.sp else 20.sp,
                        color = Color(0xFF2e4053)
                    )
                    Text(
                        text = stringResource(Res.string.experience_year),
                        fontSize = if (isMobile) 18.sp else 20.sp,
                        color = Color(0xFF2e4053)
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = stringResource(Res.string.experience_desc),
                        fontSize = if (isMobile) 14.sp else 16.sp
                    )
                }
            }
        }
    }
}

@Composable
fun Projects() {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF17202a))
            .padding(16.dp)
    ) {
        val isMobile = maxWidth < 600.dp

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = stringResource(Res.string.projects),
                fontSize = 32.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline
            )

            Spacer(modifier = Modifier.height(24.dp))

            if (isMobile) {
                Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
                    ProjectCard(
                        title = stringResource(Res.string.pos),
                        imageRes = Res.drawable.closeup_hands_business_meeting,
                        summary = stringResource(Res.string.pos_summary)
                    )
                    ProjectCard(
                        title = stringResource(Res.string.spend_smart),
                        imageRes = Res.drawable.spend_smart,
                        summary = stringResource(Res.string.spend_smart_summary)
                    )
                    ProjectCard(
                        title = stringResource(Res.string.representative_tracking),
                        imageRes = Res.drawable.tracking_icon,
                        summary = stringResource(Res.string.representative_tracking_summary)
                    )
                }
            } else {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.Top
                ) {
                    ProjectCard(
                        title = stringResource(Res.string.pos),
                        imageRes = Res.drawable.closeup_hands_business_meeting,
                        summary = stringResource(Res.string.pos_summary),
                        modifier = Modifier.weight(1f)
                    )
                    ProjectCard(
                        title = stringResource(Res.string.spend_smart),
                        imageRes = Res.drawable.spend_smart,
                        summary = stringResource(Res.string.spend_smart_summary),
                        modifier = Modifier.weight(1f)
                    )
                    ProjectCard(
                        title = stringResource(Res.string.representative_tracking),
                        imageRes = Res.drawable.tracking_icon,
                        summary = stringResource(Res.string.representative_tracking_summary),
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@Composable
fun ProjectCard(
    title: String,
    imageRes: DrawableResource,
    summary: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontSize = 24.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Image(
            painter = painterResource(imageRes),
            contentDescription = null,
            modifier = Modifier.size(240.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = summary,
            color = Color.White,
            fontSize = 14.sp,
            modifier = Modifier.padding(horizontal = 8.dp),
            textAlign = TextAlign.Center
        )
    }
}


@Composable
fun Contact() {
    val uriHandler = LocalUriHandler.current

    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val isMobile = maxWidth < 600.dp

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(if (isMobile) 12.dp else 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(Res.string.contact),
                fontSize = if (isMobile) 24.sp else 32.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline
            )

            Spacer(modifier = Modifier.height(16.dp))

            if (isMobile) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ContactIcon(Res.drawable.linkedin) {
                        uriHandler.openUri("https://www.linkedin.com/in/a-aravindhan-1099a920b/")
                    }
                    ContactIcon(Res.drawable.icons8_github_48) {
                        uriHandler.openUri("https://github.com/aravindhan182")
                    }
                    ContactIcon(Res.drawable.icons8_github_64) {
                        uriHandler.openUri("https://github.com/aravindh2106")
                    }
                    ContactIcon(Res.drawable.instagram) {
                        uriHandler.openUri("https://www.instagram.com/aravindh_azeal?igsh=MW83ejMzN3AwMDJiZg==")
                    }
                }
            } else {
                // Arrange icons in a row on desktop
                Row(
                    modifier = Modifier.width(600.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ContactIcon(Res.drawable.linkedin) {
                        uriHandler.openUri("https://www.linkedin.com/in/a-aravindhan-1099a920b/")
                    }
                    ContactIcon(Res.drawable.icons8_github_48) {
                        uriHandler.openUri("https://github.com/aravindhan182")
                    }
                    ContactIcon(Res.drawable.icons8_github_64) {
                        uriHandler.openUri("https://github.com/aravindh2106")
                    }
                    ContactIcon(Res.drawable.instagram) {
                        uriHandler.openUri("https://www.instagram.com/aravindh_azeal?igsh=MW83ejMzN3AwMDJiZg==")
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ContactIcon(drawableRes: DrawableResource, onClick: () -> Unit) {
    Image(
        painter = painterResource(drawableRes),
        contentDescription = null,
        modifier = Modifier
            .size(100.dp)
            .clickable { onClick() }
    )
}

fun downloadResume() {
    val anchor = document.createElement("a") as HTMLAnchorElement
    anchor.href = "Aravindh_resume.pdf"
    anchor.download = "Aravindhan_Resume.pdf"
    document.body?.appendChild(anchor)
    anchor.click()
    document.body?.removeChild(anchor)
}

@Composable
fun Footer() {
    val uriHandler = LocalUriHandler.current

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight().background(Color.Black)
    ) {
        val isMobile = maxWidth < 600.dp
        val fontSize = if (isMobile) 18.sp else 24.sp

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth().padding(horizontal = if (isMobile) 8.dp else 16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(Res.string.this_website_is_belonging_to),
                    color = Color.White,
                    fontSize = fontSize
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = stringResource(Res.string.name),
                    modifier = Modifier.clickable {
                        uriHandler.openUri("https://www.linkedin.com/in/a-aravindhan-1099a920b/")
                    },
                    color = Color(0xFF1897bc),
                    style = TextStyle(textDecoration = TextDecoration.Underline),
                    fontSize = fontSize
                )
            }
            Spacer(modifier = Modifier.height(if (isMobile) 8.dp else 16.dp))
            Text(
                text = stringResource(Res.string.copyrights),
                color = Color.White,
                fontSize = fontSize
            )
        }
    }
}
