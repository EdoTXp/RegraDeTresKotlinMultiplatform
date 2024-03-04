@file:Suppress("UNUSED_EXPRESSION")

package views

import controllers.MainController
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min

/**
 * MainPage is a composable class that represents the main UI of the application.
 * It uses the MainController to manage the state and logic of the UI.
 */
class MainPage {
    private var controller: MainController = MainController()

    /**
     * Creates the top bar of the UI, displaying the title of the application.
     */
    private fun topBar(): @Composable () -> Unit = {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Regra de 3",
            fontSize = TextUnit(value = 32F, type = TextUnitType.Sp),
            fontWeight = FontWeight.W500,
            textAlign = TextAlign.Center
        )
    }

    /**
     * Displays a text box with a background color and centered text.
     * Used to visually separate input fields.
     */
    @Composable
    private fun CompareText() = Box(
        modifier = Modifier
            .background(color = Color.Gray)
            .padding(all = 5.dp),
    ) {
        Text(text = "Está para", color = Color.White)
    }

    /**
     * Creates a row of TextFields for inputting the first two values.
     * Each TextField is configured to only accept numeric input and updates the controller's state.
     */
    @Composable
    private fun TopTexFieldsRow() = Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth(),
    ) {
        // TextField for the first value
        TextField(
            value = controller.getFirstValue(),
            label = { Text("A") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
            ),
            modifier = Modifier.widthIn(min(a = 32.dp, b = 20.dp)),
            singleLine = true,
            onValueChange = { actualValue ->
                controller.setFirstValue(actualValue)
            },
        )
        Spacer(modifier = Modifier.width(5.dp))
        CompareText()
        Spacer(modifier = Modifier.width(5.dp))
        // TextField for the second value
        TextField(
            value = controller.getSecondValue(),
            label = { Text("B") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
            ),
            modifier = Modifier.widthIn(min(a = 32.dp, b = 32.dp)),
            singleLine = true,
            onValueChange = { actualValue ->
                controller.setSecondValue(actualValue)
            })
    }

    /**
     * Displays a text indicating the comparison operation.
     * Separates the input fields for the first two values from the last two.
     */
    @Composable
    private fun AsWellAsText() = Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Spacer(modifier = Modifier.height(25.dp))
        Text(text = "ASSIM COMO", fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(25.dp))
    }

    /**
     * Creates a row of TextFields for inputting the third value and displaying the result.
     * The third TextField is read-only and displays the calculated result.
     */
    @Composable
    private fun BottomTextFieldsRow() = Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth(),
    ) {
        // TextField for the third value
        TextField(
            value = controller.getThridValue(),
            label = { Text("C") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
            ),
            modifier = Modifier.widthIn(min(a = 32.dp, b = 20.dp)),
            singleLine = true,
            onValueChange = { actualValue ->
                controller.setThridValue(actualValue)
            })
        Spacer(modifier = Modifier.width(5.dp))
        CompareText()
        Spacer(modifier = Modifier.width(5.dp))
        // TextField for displaying the result
        TextField(
            value = controller.getResultValue(),
            label = {
                Text(
                    "X",
                    color = Color.White,
                    style = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
                )
            },
            enabled = false,
            modifier = Modifier.widthIn(min(a = 32.dp, b = 20.dp)).background(color = Color.Cyan),
            singleLine = true,
            onValueChange = {},
            readOnly = true
        )
    }

    /**
     * Preview function for the CompareText composable.
     */
    @Preview
    @Composable
    fun CompareTextPreview() = CompareText()

    /**
     * Preview function for the TopTexFieldsRow composable.
     */
    @Preview
    @Composable
    fun TopTextFieldsRowPreview() = TopTexFieldsRow()

    /**
     * Preview function for the AsWellAsText composable.
     */
    @Preview
    @Composable
    fun AsWellAsTextPreview() = AsWellAsText()

    /**
     * Preview function for the BottomTextFieldsRow composable.
     */
    @Preview
    @Composable
    fun BottomTextFieldsRowPreview() = BottomTextFieldsRow()

    companion object {
        /**
         * Executes the application, setting up the UI with the MainPage's components.
         * @param mainPage The MainPage instance to use for the UI setup.
         */
        @Composable
        fun executeApp(mainPage: MainPage) {
            MaterialTheme {
                Scaffold(
                    topBar = mainPage.topBar()
                ) {
                    it
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(all = 16.dp),
                    ) {
                        mainPage.TopTexFieldsRow()
                        mainPage.AsWellAsText()
                        mainPage.BottomTextFieldsRow()
                    }
                }
            }
        }
    }
}
