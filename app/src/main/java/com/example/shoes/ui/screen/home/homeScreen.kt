package com.example.shoes.ui.screen.home

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.content.MediaType.Companion.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.shoes.R
import com.example.shoes.ui.screen.signIn.SignInContent
import com.example.shoes.ui.theme.ShoesTheme
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle

@Composable
fun HomeScreen() {
    var searchQuery by rememberSaveable { mutableStateOf("") }
    var selectedCategory by rememberSaveable { mutableStateOf("Все") }
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    Box(modifier = Modifier
        .fillMaxSize()
        .background(ShoesTheme.colors.background)) {
        Scaffold(
            topBar = {
                Column {
                    Row(
                        modifier = Modifier
                            .padding(top = 35.dp, start = 20.dp, end = 20.dp)
                            .fillMaxWidth()
                            .height(60.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        IconButton(onClick = {}) {
                            Icon(
                                painter = painterResource(R.drawable.hamburger),
                                contentDescription = null
                            )
                        }
                        Text(
                            text = "Главная",
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 48.dp, end = 61.29.dp),
                            textAlign = TextAlign.Center,
                            style = ShoesTheme.typography.headingBold32
                        )
                        Box(
                            modifier = Modifier
                                .size(44.dp)
                                .shadow(
                                    elevation = 1.dp,
                                    shape = RoundedCornerShape(24.dp),
                                    clip = true
                                )
                                .background(
                                    color = ShoesTheme.colors.block,
                                    shape = CircleShape
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            IconButton(onClick = {}) {
                                Icon(
                                    painter = painterResource(R.drawable.bag_2),
                                    contentDescription = "Уведомления",
                                    modifier = Modifier.size(24.dp),
                                    tint = ShoesTheme.colors.text
                                )
                            }
                        }
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 21.dp, start = 25.dp, end = 15.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .width(285.dp)
                                .height(52.dp)
                                .shadow(
                                    elevation = 1.dp,
                                    shape = RoundedCornerShape(14.dp),
                                    clip = true
                                )
                                .background(
                                    color = ShoesTheme.colors.block,
                                    shape = RoundedCornerShape(14.dp)
                                )
                                .clickable {
                                    focusRequester.requestFocus()
                                    keyboardController?.show()
                                },
                            contentAlignment = Alignment.CenterStart
                        ) {
                            BasicTextField(
                                value = searchQuery,
                                onValueChange = { searchQuery = it },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp)
                                    .focusRequester(focusRequester),
                                singleLine = true,
                                textStyle = TextStyle(
                                    color = ShoesTheme.colors.text,
                                    fontSize = ShoesTheme.typography.bodyRegular16.fontSize
                                ),
                                decorationBox = { innerTextField ->
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Icon(
                                            painter = painterResource(R.drawable.vector),
                                            contentDescription = "Поиск",
                                            tint = ShoesTheme.colors.hint,
                                            modifier = Modifier.size(20.dp)
                                        )
                                        Spacer(modifier = Modifier.width(12.dp))
                                        if (searchQuery.isEmpty()) {
                                            Text(
                                                text = "Поиск",
                                                style = ShoesTheme.typography.bodyRegular16,
                                                color = ShoesTheme.colors.hint
                                            )
                                        }
                                        innerTextField()
                                    }
                                }
                            )
                        }

                        Spacer(modifier = Modifier.width(14.dp))

                        Box(
                            modifier = Modifier
                                .size(52.dp)
                                .shadow(
                                    elevation = 1.dp,
                                    shape = RoundedCornerShape(24.dp),
                                    clip = true
                                )
                                .background(
                                    color = ShoesTheme.colors.accent,
                                    shape = CircleShape
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            IconButton(onClick = { /* Фильтры */ }) {
                                Icon(
                                    painter = painterResource(R.drawable.sliders),
                                    contentDescription = "Фильтры",
                                    tint = Color.White,
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        }
                    }
                }
            },
            bottomBar = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Transparent),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.vector_1789),
                        contentDescription = "Bottom bar background",
                        modifier = Modifier
                            .fillMaxWidth()
                            .blur(radius = 15.dp)
                            .offset(x = 0.dp, y = 5.dp)
                            .alpha(0.15f),
                        contentScale = ContentScale.Crop,
                        colorFilter = ColorFilter.tint(Color.Black)
                    )
                    Image(
                        painter = painterResource(R.drawable.vector_1789),
                        contentDescription = "Bottom bar background",
                        modifier = Modifier
                            .fillMaxWidth()
                            .blur(radius = 4.dp)
                            .offset(x = (-1.5).dp, y = 0.dp)
                            .alpha(0.12f),
                        contentScale = ContentScale.Crop,
                        colorFilter = ColorFilter.tint(ShoesTheme.colors.accent)
                    )
                    Image(
                        painter = painterResource(R.drawable.vector_1789),
                        contentDescription = "Bottom bar background",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp),
                        contentScale = ContentScale.FillWidth
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 31.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Первая группа иконок (Home и Favorite)
                        Row {
                            IconButton(
                                onClick = { },
                                modifier = Modifier
                                    .size(26.dp)
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.home_2),
                                    contentDescription = "Home",
                                    tint = ShoesTheme.colors.accent,
                                )
                            }

                            Spacer(modifier = Modifier.width(40.dp))

                            IconButton(
                                onClick = { },
                                modifier = Modifier.size(26.dp)
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.icon),
                                    contentDescription = "Favorite",
                                    tint = ShoesTheme.colors.hint
                                )
                            }
                        }
                        Spacer(modifier = Modifier.size(56.dp))

                        // Вторая группа иконок (Notifications и Profile)
                        Row {
                            IconButton(
                                onClick = { },
                                modifier = Modifier.size(26.dp)
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.icon_1),
                                    contentDescription = "Notifications",
                                    tint = ShoesTheme.colors.hint
                                )
                            }

                            Spacer(modifier = Modifier.width(40.dp))

                            IconButton(
                                onClick = { },
                                modifier = Modifier.size(26.dp)
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.frame),
                                    contentDescription = "Profile",
                                    tint = ShoesTheme.colors.hint
                                )
                            }
                        }
                    }

                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .offset(y = (-55).dp)
                            .size(56.dp)
                            .shadow(
                                elevation = 1.dp,
                                shape = RoundedCornerShape(56.dp),
                                clip = true
                            )
                    ) {
                        IconButton(
                            onClick = { },
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(56.dp)
                                        .background(
                                            color = ShoesTheme.colors.accent,
                                            shape = CircleShape
                                        )
                                )
                                Icon(
                                    painter = painterResource(R.drawable.bag_2),
                                    contentDescription = null,
                                    modifier = Modifier.size(24.dp),
                                    tint = ShoesTheme.colors.block
                                )
                            }
                        }
                    }
                }
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                // Добавляем текст "Категории" и кнопки
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 22.dp, start = 26.dp)
                ) {
                    // Текст "Категории"
                    Text(
                        text = "Категории",
                        style = ShoesTheme.typography.bodyRegular16,
                        color = ShoesTheme.colors.text,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    // Ряд с кнопками категорий
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 25.dp),
                        horizontalArrangement = Arrangement.Start
                    ) {
                        // Кнопка "Все"
                        CategoryButton(
                            text = "Все",
                            modifier = Modifier.padding(end = 16.dp),
                            onClick = { selectedCategory = "Все" }
                        )

                        // Кнопка "OutDoor"
                        CategoryButton(
                            text = "OutDoor",
                            modifier = Modifier.padding(end = 16.dp),
                            onClick = { selectedCategory = "OutDoor" }
                        )

                        // Кнопка "Tennis"
                        CategoryButton(
                            text = "Tennis",
                            onClick = { selectedCategory = "Tennis" }
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 24.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Популярное",
                            style = ShoesTheme.typography.bodyRegular16,
                            color = ShoesTheme.colors.text
                        )

                        Text(
                            text = "Все",
                            style = ShoesTheme.typography.bodyRegular12,
                            color = ShoesTheme.colors.accent,
                            modifier = Modifier
                                .padding(end = 30.dp)
                                .clickable {
                            }
                        )
                    }
                    LazyRow(
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(
                            space = 15.dp,
                            alignment = Alignment.Start
                        ),
                        contentPadding = PaddingValues(
                            end = 20.dp
                        )
                    ) {
                        items(2) { index ->
                            ShoeCard(
                                modifier = Modifier.width(160.dp)
                            )
                        }
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 29.dp, end = 30.dp)
                    ) {
                        // Текст "Акции"
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Акции",
                                style = ShoesTheme.typography.bodyRegular16,
                                color = ShoesTheme.colors.text
                            )

                            Text(
                                text = "Все",
                                style = ShoesTheme.typography.bodyRegular12,
                                color = ShoesTheme.colors.accent,
                                modifier = Modifier.clickable { /* Переход на все акции */ }
                            )
                        }

                        // Рекламная картинка
                        Box(
                            modifier = Modifier
                                .width(335.dp)
                                .height(95.dp)
                                .padding(top = 20.dp)
                                .shadow(
                                    elevation = 1.dp,
                                    shape = RoundedCornerShape(16.dp),
                                    clip = true
                                )
                                .background(
                                    color = ShoesTheme.colors.block,
                                    shape = RoundedCornerShape(12.dp)
                                )
                        ) {
                            Image(
                                painter = painterResource(R.drawable.frame_1000000849),
                                contentDescription = "Специальное предложение",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ShoeCard(
    modifier: Modifier = Modifier,
) {
    var isFavorite by remember { mutableStateOf(false) }
    Box(
        modifier = modifier
            .width(160.dp)
            .height(182.dp)
            .shadow(
                elevation = 1.dp,
                shape = RoundedCornerShape(16.dp),
                clip = true
            )
            .background(
                color = ShoesTheme.colors.block,
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Верхняя часть карточки (изображение)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(9.dp)
            ) {
                // Кнопка лайка
                Box(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .size(28.dp)
                        .shadow(
                            elevation = (0.5).dp,
                            shape = CircleShape,
                            clip = true
                        )
                        .background(
                            color = ShoesTheme.colors.background,
                            shape = CircleShape
                        )
                        .clickable { isFavorite = !isFavorite },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(
                            if (isFavorite) R.drawable.favorite_fill
                            else R.drawable.favorite
                        ),
                        contentDescription = "Добавить в избранное",
                        tint = if (isFavorite) ShoesTheme.colors.text else ShoesTheme.colors.text,
                        modifier = Modifier.size(width = 18.dp, height = 16.dp)
                    )
                }

                // Изображение кроссовка
                    Image(
                        painter = painterResource(R.drawable.nike_zoom_winflo_3_831561_001_mens_running_shoes_11550187236tiyyje6l87_prev_ui_3),
                        contentDescription = "Кроссовки",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 18.dp)
                            .size(width = 117.91.dp, height = 70.dp),
                        contentScale = ContentScale.Fit
                    )
            }

            // Нижняя часть карточки (текст)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
            ) {
                // Бейдж BEST SELLER
                Text(
                    text = "BEST SELLER",
                    style = ShoesTheme.typography.bodyRegular12,
                    color = ShoesTheme.colors.accent,

                )

                // Название кроссовок
                Text(
                    text = "Nike Air Max 270",
                    style = ShoesTheme.typography.bodyRegular16,
                    color = ShoesTheme.colors.text,
                    modifier = Modifier.padding(top = 8.dp)
                )

                // Цена
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "₽ 180.00",
                        style = ShoesTheme.typography.bodyRegular14,
                        color = ShoesTheme.colors.text
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    // Кнопка добавления
                    Box(
                        modifier = Modifier
                            .size(34.dp)
                            .offset(x = 12.dp, y = 12.dp)
                            .background(
                                color = ShoesTheme.colors.accent,
                                shape = RoundedCornerShape(topStart = 16.dp)
                            )
                            .clickable {  },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.group_107),
                            contentDescription = "Добавить в корзину",
                            tint = ShoesTheme.colors.block,
                            modifier = Modifier.size(width = 21.dp, height = 15.32.dp)
                        )
                    }
                }
            }
        }
    }
}
@Composable
fun CategoryButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .width(108.dp)
            .height(40.dp)
            .clickable { onClick() }
            .shadow(
                elevation = 1.dp,
                shape = RoundedCornerShape(8.dp),
                clip = true
            )
            .background(
                color = ShoesTheme.colors.block,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 16.dp, vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = ShoesTheme.typography.bodyRegular12,
            color = ShoesTheme.colors.text
        )
    }
}
