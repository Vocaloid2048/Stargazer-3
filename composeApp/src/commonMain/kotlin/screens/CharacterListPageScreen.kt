/*
 * Project Honkai Stargazer and app Stargazer (星穹觀星者) were
 * Organized & Develop by Coding Band.
 * Copyright © 2024 Coding Band 版權所有
 */

package screens

import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import com.cheonjaeung.compose.grid.SimpleGridCells
import com.cheonjaeung.compose.grid.VerticalGrid
import com.voc.honkai_stargazer.component.CharacterCard
import components.BackIcon
import components.HeaderData
import components.LIST_FILTER_TOOL_HEIGHT
import components.PAGE_HEADER_HEIGHT
import components.PageHeader
import components.defaultHeaderData
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.haze
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import moe.tlaster.precompose.navigation.Navigator
import types.Character
import types.Constants.Companion.CHAR_CARD_HEIGHT
import types.Constants.Companion.CHAR_CARD_WIDTH
import utils.PageBottomMask

lateinit var charList : MutableState<ArrayList<Character>>
lateinit var charListSortable : MutableState<ArrayList<Character>>

@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun initCharList() {
    var isInited by rememberSaveable { mutableStateOf(false) }
    charList = rememberSaveable(stateSaver = Character.ListSaver) { mutableStateOf(arrayListOf()) }
    charListSortable = rememberSaveable(stateSaver = Character.ListSaver) { (charList) }
    if(!isInited){
        charList.value = runBlocking {
            val job = CoroutineScope(Dispatchers.Default).async {
                val tmpCharList = arrayListOf<Character>()
                (Character.charListJson as JsonArray).fastForEach { jsonElement ->
                    tmpCharList.add(Character.getCharacterItemFromJSON(jsonElement.jsonObject["charId"]?.jsonPrimitive?.content!!, requireAttrData = true))
                }
                return@async tmpCharList
            }
            job.await()
            job.getCompleted()
        }
        isInited = true
        charListSortable.value = charList.value
    }
}

@OptIn(ExperimentalCoroutinesApi::class, ExperimentalLayoutApi::class)
@Composable
fun CharacterListPage(
    modifier: Modifier = Modifier,
    navigator: Navigator,
    headerData: HeaderData = defaultHeaderData
) {
    val hazeState = remember { HazeState() }

    Box {

        /*

        LazyColumn {
            item {
                Spacer(
                    modifier = Modifier
                        .statusBarsPadding()
                        .height(PAGE_HEADER_HEIGHT)
                )
            }
            item {
                FlowRow(
                    modifier = Modifier
                        .haze(state = hazeState)
                        .fillMaxWidth(1f)
                        .wrapContentHeight(align = Alignment.Top),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    charListSortable.value.map { character ->
                        CharacterCard(character = character)
                    }
                }
            }
            item {
                Spacer(
                    modifier = Modifier
                        .navigationBarsPadding()
                        .height(LIST_FILTER_TOOL_HEIGHT)
                )
            }
        }
         */

        LazyColumn {
            item{
                Spacer(
                    modifier = Modifier
                        .statusBarsPadding()
                        .height(PAGE_HEADER_HEIGHT+12.dp)
                )
            }
            item{
                VerticalGrid(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp)
                        .haze(state = hazeState),
                    columns = SimpleGridCells.Adaptive(CHAR_CARD_WIDTH),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                ){


                    for(character in charListSortable.value){
                        CharacterCard(character = character)
                    }

                }
            }
            item{
                Spacer(
                    modifier = Modifier
                        .navigationBarsPadding()
                        .height(LIST_FILTER_TOOL_HEIGHT+12.dp)
                )
            }
        }


        PageBottomMask()


        /*
        ListFilterTool(
            filterList = charList.value,
            filterType = ListFilterType.CHARACTER,
            onFilterApplied = { filteredList ->
                charListSortable.value = filteredList
            }
        )
         */



        PageHeader(navigator = navigator, headerData = headerData, hazeState = hazeState, backIconId = BackIcon.CANCEL)
    }
}