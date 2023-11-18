import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.tunc.compose.navigation.screen.navigation.ChildController
import com.tunc.compose.navigation.screen.navigation.TabScreens
import com.tunc.navigator.page.PageIdentifier


@Composable
fun HomeScreen() {

    val childController = ChildController.get()

    Box(modifier = Modifier.fillMaxSize()) {
        Button(modifier = Modifier.align(Alignment.Center), onClick = {
            childController.navigate(PageIdentifier(TabScreens.MenuHomeDetail))
        }) {
            Text("Go to Home Detail")
        }
    }
}

@Composable
fun HomeScreenDetail() {
    Text("Home detail")
}

