import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ComposeUIViewController
import com.tunc.compose.navigation.screen.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController {

    Column {
        Spacer(Modifier.height(40.dp))
        App()
    }

}
