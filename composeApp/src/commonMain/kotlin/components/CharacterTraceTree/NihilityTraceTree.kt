package components.CharacterTraceTree

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import files.NihilityTraceTree
import files.Res
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.int
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import org.jetbrains.compose.resources.painterResource
import types.Constants
import types.Path

//(x,y) base on Figma, no need to handly calculate
val nihilityOffsetList = arrayListOf(
    (0 to 0),//Empty
    (72 to 163),//普攻
    (202 to 163),//戰技
    (136 to 154),//終結技
    (136 to 80),//天賦
    (136 to 228),//祕技
    (243 to 80),

    (22 to 80),
    (133 to 0),
    (147 to 312),
    (293 to 146),
    (274 to 193),
    (253 to 240),

    (0 to 146),
    (21 to 193),
    (47 to 240),
    (214 to 28),
    (83 to 28),
    (147 to 372),
)

@Composable
fun NihilityTraceTree(infoJson: JsonElement, displayWidth: Dp, selectedId: MutableState<Int>, charFileName: String){
    val displayHeight = displayWidth.times(Constants.TRACE_TREE_BASE_HEIGHT / Constants.TRACE_TREE_BASE_WIDTH)

    val selectedId = remember { mutableStateOf(0) }

    val skillTreePointsArray = infoJson.jsonObject["skillTreePoints"]!!.jsonArray.sortedBy { it.jsonObject["anchor"]!!.jsonPrimitive.int }
    val skillTreeCoreArray = infoJson.jsonObject["skills"]!!.jsonArray

    val groupNormalATK = jsonArrayToIntArrayList(infoJson.jsonObject["skillGrouping"]!!.jsonArray[0].jsonArray)
    val groupSkill = jsonArrayToIntArrayList(infoJson.jsonObject["skillGrouping"]!!.jsonArray[1].jsonArray)
    val groupUltimate = jsonArrayToIntArrayList(infoJson.jsonObject["skillGrouping"]!!.jsonArray[2].jsonArray)
    val groupTalent = jsonArrayToIntArrayList(infoJson.jsonObject["skillGrouping"]!!.jsonArray[3].jsonArray)
    val groupSpecial = jsonArrayToIntArrayList(infoJson.jsonObject["skillGrouping"]!!.jsonArray[4].jsonArray)

    val pointNormalATK = getDataFromSkills(skillTreeCoreArray.filter { obj -> groupNormalATK.indexOf(obj.jsonObject["id"]!!.jsonPrimitive.int) != -1 } as ArrayList<JsonElement>, charFileName, 1, infoJson) //普攻
    val pointSkill = getDataFromSkills(skillTreeCoreArray.filter { obj -> groupSkill.indexOf(obj.jsonObject["id"]!!.jsonPrimitive.int) != -1 } as ArrayList<JsonElement>, charFileName, 2, infoJson) //戰技
    val pointUltimate = getDataFromSkills(skillTreeCoreArray.filter { obj -> groupUltimate.indexOf(obj.jsonObject["id"]!!.jsonPrimitive.int) != -1 } as ArrayList<JsonElement>, charFileName, 3, infoJson) //終結技
    val pointTalent = getDataFromSkills(skillTreeCoreArray.filter { obj -> groupTalent.indexOf(obj.jsonObject["id"]!!.jsonPrimitive.int) != -1 } as ArrayList<JsonElement>, charFileName, 4, infoJson) //天賦
    val pointSpecial = getDataFromSkills(skillTreeCoreArray.filter { obj -> groupSpecial.indexOf(obj.jsonObject["id"]!!.jsonPrimitive.int) != -1 } as ArrayList<JsonElement>, charFileName, 6, infoJson) //祕技

    val point6 = getDataFromSkillTreePoints(skillTreePointsArray[0].jsonObject, infoJson)
    val point10 = getDataFromSkillTreePoints(skillTreePointsArray[0].jsonObject["children"]!!.jsonArray[0].jsonObject, infoJson)
    val point11 = getDataFromSkillTreePoints(skillTreePointsArray[0].jsonObject["children"]!!.jsonArray[0].jsonObject["children"]!!.jsonArray[0].jsonObject, infoJson)
    val point12 = getDataFromSkillTreePoints(skillTreePointsArray[0].jsonObject["children"]!!.jsonArray[0].jsonObject["children"]!!.jsonArray[0].jsonObject["children"]!!.jsonArray[0].jsonObject, infoJson)

    val point7 = getDataFromSkillTreePoints(skillTreePointsArray[1].jsonObject, infoJson)
    val point13 = getDataFromSkillTreePoints(skillTreePointsArray[1].jsonObject["children"]!!.jsonArray[0].jsonObject, infoJson)
    val point14 = getDataFromSkillTreePoints(skillTreePointsArray[1].jsonObject["children"]!!.jsonArray[0].jsonObject["children"]!!.jsonArray[0].jsonObject, infoJson)
    val point15 = getDataFromSkillTreePoints(skillTreePointsArray[1].jsonObject["children"]!!.jsonArray[0].jsonObject["children"]!!.jsonArray[0].jsonObject["children"]!!.jsonArray[0].jsonObject, infoJson)

    val point8 = getDataFromSkillTreePoints(skillTreePointsArray[2].jsonObject, infoJson)
    val point16 = getDataFromSkillTreePoints(skillTreePointsArray[2].jsonObject["children"]!!.jsonArray[0].jsonObject, infoJson)
    val point17 = getDataFromSkillTreePoints(skillTreePointsArray[2].jsonObject["children"]!!.jsonArray[1].jsonObject, infoJson)

    val point9 = getDataFromSkillTreePoints(skillTreePointsArray[3].jsonObject, infoJson)
    val point18 = getDataFromSkillTreePoints(skillTreePointsArray[3].jsonObject["children"]!!.jsonArray[0].jsonObject, infoJson)


    Box(modifier = Modifier.size(displayWidth,displayHeight)){
        Image(painterResource(Path.Nihility.iconAbyss),
            modifier = Modifier.aspectRatio(1f).fillMaxSize().padding(start = 12.dp, end = 12.dp).align(
            Alignment.BottomCenter
        ), contentDescription = "Path's Icon", alpha = 0.2f)
        Image(painterResource(Res.drawable.NihilityTraceTree),
            contentDescription = "Nihility Trace Tree",
            modifier = Modifier
                .size(displayWidth,displayHeight)
        )

        TraceTreeBtn(selectedId, 1, pointNormalATK, displayWidth, offset = nihilityOffsetList)
        TraceTreeBtn(selectedId, 2, pointSkill, displayWidth, offset = nihilityOffsetList)
        TraceTreeBtn(selectedId, 3, pointUltimate, displayWidth, offset = nihilityOffsetList)
        TraceTreeBtn(selectedId, 4, pointTalent, displayWidth, offset = nihilityOffsetList)
        TraceTreeBtn(selectedId, 5, pointSpecial, displayWidth, offset = nihilityOffsetList)

        TraceTreeBtn(selectedId, 6, arrayListOf(point6), displayWidth, offset = nihilityOffsetList)
        TraceTreeBtn(selectedId, 7, arrayListOf(point7), displayWidth, offset = nihilityOffsetList)
        TraceTreeBtn(selectedId, 8, arrayListOf(point8), displayWidth, offset = nihilityOffsetList)
        TraceTreeBtn(selectedId, 9, arrayListOf(point9), displayWidth, offset = nihilityOffsetList)
        TraceTreeBtn(selectedId, 10, arrayListOf(point10), displayWidth, offset = nihilityOffsetList)
        TraceTreeBtn(selectedId, 11, arrayListOf(point11), displayWidth, offset = nihilityOffsetList)
        TraceTreeBtn(selectedId, 12, arrayListOf(point12), displayWidth, offset = nihilityOffsetList)
        TraceTreeBtn(selectedId, 13, arrayListOf(point13), displayWidth, offset = nihilityOffsetList)
        TraceTreeBtn(selectedId, 14, arrayListOf(point14), displayWidth, offset = nihilityOffsetList)
        TraceTreeBtn(selectedId, 15, arrayListOf(point15), displayWidth, offset = nihilityOffsetList)
        TraceTreeBtn(selectedId, 16, arrayListOf(point16), displayWidth, offset = nihilityOffsetList)
        TraceTreeBtn(selectedId, 17, arrayListOf(point17), displayWidth, offset = nihilityOffsetList)
        TraceTreeBtn(selectedId, 18, arrayListOf(point18), displayWidth, offset = nihilityOffsetList)
    }
}
