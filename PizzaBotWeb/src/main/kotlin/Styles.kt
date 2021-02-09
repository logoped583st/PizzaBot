import kotlinx.css.*
import kotlinx.css.properties.*
import styled.StyleSheet
import styled.animation

object MainStyle : StyleSheet("MainStyle", isStatic = true) {
    val container by css {
        display = Display.flex
        justifyContent = JustifyContent.center
        alignItems = Align.center
        flexDirection = FlexDirection.column
        height = 100.vh
    }

    val canvas by css {
        transform {
            rotateX(180.deg)
        }
    }
}

object MainComponentsStyle : StyleSheet("MainStyle", isStatic = true) {
    val button by css {
        borderStyle = BorderStyle.none
        borderRadius = 8.px
        margin(16.px)
        paddingTop = 8.px
        paddingBottom = 8.px
        paddingLeft = 32.px
        paddingRight = 32.px
        delayUnhover()
        hover {
            backgroundColor = Color.aqua
            cursor = Cursor.pointer
            transform {
                scale(1.2)
            }
        }
    }

    val input by css {
        padding(8.px)
    }
}