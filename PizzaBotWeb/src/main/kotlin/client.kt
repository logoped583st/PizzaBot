import com.logoped583st.pizza_core.di.initKoin
import react.dom.render
import kotlinx.browser.document
import kotlinx.browser.window

fun main() {

    initKoin()
    window.onload = {
        render(document.getElementById("root")) {
            child(PathComponent::class){}
        }
    }
}
