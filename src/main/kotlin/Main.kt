// Importing necessary classes for creating the application window and executing the main UI.
import views.MainPage
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

// The main function that starts the application.
fun main() = application {
    // Creating the main application window.
    Window(
        // Setting the window to be non-resizable.
        resizable = false,
        // Setting the window title.
        title = "Regra de Três",
        // Defining the action to perform when the window close request is received, such as closing the application.
        onCloseRequest = ::exitApplication
    ) {
        // Executing the main UI of the application, which is defined in the MainPage class.
        MainPage.executeApp(MainPage())
    }
}
