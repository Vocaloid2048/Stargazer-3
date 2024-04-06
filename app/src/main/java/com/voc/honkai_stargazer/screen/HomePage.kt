package com.voc.honkai_stargazer.screen

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.voc.honkai_stargazer.R
import com.voc.honkai_stargazer.component.HomePageBlock1x1
import com.voc.honkai_stargazer.component.HomePageBlock2x1
import com.voc.honkai_stargazer.component.HomePageBlocks
import com.voc.honkai_stargazer.constants.Constants.Companion.HOME_PAGE_ITEMS
import com.voc.honkai_stargazer.ui.theme.BlackAlpha30
import com.voc.honkai_stargazer.ui.theme.FontSizeNormal
import com.voc.honkai_stargazer.ui.theme.FontSizeNormalLarge
import com.voc.honkai_stargazer.ui.theme.ProgressLevelBackground
import com.voc.honkai_stargazer.ui.theme.ProgressLevelPrimary
import com.voc.honkai_stargazer.ui.theme.Stargazer3Theme
import com.voc.honkai_stargazer.ui.theme.TextColorLevel
import com.voc.honkai_stargazer.ui.theme.TextColorNormal

class HomePage : ComponentActivity() {
    private lateinit var activity: Activity
    private lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity = this;
        context = this;
        setContent {
            Stargazer3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RootContent()
                }
            }
        }
    }
}

@Composable
fun RootContent(modifier: Modifier = Modifier) {
    Box {
        MakeBackground()
        Column() {
            Header()
            MenuScrollView()
        }
    }
}

@Composable
fun UserHelpTeamIcon(icon: Painter, modifier: Modifier = Modifier) {
    Image(
        painter = icon, contentDescription = "", contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(30.dp)
            .background(Color(0xFFD9D9D9), CircleShape)
            .clip(CircleShape)
            .border(1.5.dp, Color(0xFFD3D3D3), CircleShape)
            .padding()
    )
    Spacer(modifier = Modifier.width(4.dp))
}

@Composable
fun Header(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Column {
            Text(
                text = "108289390",
                modifier = Modifier
                    .background(BlackAlpha30, CircleShape)
                    .padding(all = 10.dp)
                    .wrapContentSize(),
                color = TextColorNormal,
                style = FontSizeNormal,
            )
            Spacer(modifier = Modifier.height(12.dp))
            Box {
                Row(Modifier.height(72.dp)) {
                    // User Avatar
                    Image(
                        painterResource(R.drawable.test_avatar),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(72.dp)
                            .background(Color(0xFFCAB89E), CircleShape)
                            .clip(CircleShape)
                            .border(1.dp, Color(0x66907C54), CircleShape)
                    )
                    // User Name & Helping Team
                    Column(
                        modifier = Modifier
                            .padding(start = 8.dp, end = 8.dp)
                            .weight(1f)
                    ) {
                        //User Name - Hmm interesting Kt
                        Text(
                            text = "2O48",
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxSize()
                                .wrapContentHeight(align = Alignment.CenterVertically),
                            color = TextColorNormal,
                            style = FontSizeNormalLarge,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                        //Helping Team
                        Row(
                            modifier = Modifier
                                .height(30.dp)
                                .fillMaxWidth()
                        ) {
                            UserHelpTeamIcon(painterResource(id = R.drawable.test_char_1))
                            UserHelpTeamIcon(painterResource(id = R.drawable.test_char_2))
                            UserHelpTeamIcon(painterResource(id = R.drawable.test_char_3))
                            UserHelpTeamIcon(painterResource(id = R.drawable.test_char_4))
                            UserHelpTeamIcon(painterResource(id = R.drawable.test_char_5))
                        }
                    }
                    Column(
                        Modifier
                            .padding(top = 12.dp)
                            .fillMaxHeight(), horizontalAlignment = Alignment.End
                    ) {
                        val context = LocalContext.current
                        IconButton(
                            modifier = Modifier
                                .height(23.dp)
                                .width(45.dp),
                            onClick = {
                                Toast.makeText(
                                    context,
                                    "Setting Dialog",
                                    Toast.LENGTH_SHORT
                                )
                            }
                        ) {
                            Image(painterResource(id = R.drawable.ic_rounded_option_btn), "")
                        }

                        Spacer(Modifier.weight(1f))

                        Text(
                            text = "開拓等級 58",
                            color = TextColorLevel,
                            style = FontSizeNormal,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

            }
            LinearProgressIndicator(
                progress = (58f / 60f),
                Modifier
                    .padding(top = 12.dp, bottom = 12.dp)
                    .fillMaxWidth(),
                trackColor = ProgressLevelBackground,
                color = ProgressLevelPrimary,
            )
        }
    }
}


@Composable
fun MenuScrollView(modifier: Modifier = Modifier) {
    Box(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(80.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(count = HOME_PAGE_ITEMS.size, span = { index ->
                when (HOME_PAGE_ITEMS[index].itemType) {
                    HomePageBlocks.HomePageBlockItem.HomePageBlockItemType.W1H1 -> GridItemSpan(1)
                    HomePageBlocks.HomePageBlockItem.HomePageBlockItemType.W2H1 -> GridItemSpan(2)
                }
            }) { index ->
                val blockData: HomePageBlocks.HomePageBlockItem = HOME_PAGE_ITEMS[index];
                Box{
                    when (blockData.itemType) {
                        HomePageBlocks.HomePageBlockItem.HomePageBlockItemType.W1H1 -> HomePageBlock1x1(blockData)
                        HomePageBlocks.HomePageBlockItem.HomePageBlockItemType.W2H1 -> HomePageBlock2x1(blockData)
                    }
                }
            }
        }
    }
}

@Composable
fun BottomView(modifier: Modifier = Modifier){

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomePagePreview() {
    Stargazer3Theme {
        RootContent()
    }
}