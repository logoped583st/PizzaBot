import com.logoped583st.pizza_core.models.MatrixModel
import com.logoped583st.pizza_core.models.Path
import org.w3c.dom.CanvasRenderingContext2D
import org.w3c.dom.Element
import org.w3c.dom.HTMLCanvasElement
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import styled.css
import styled.styledCanvas

data class CanvasProps(
    var path: List<Path>,
    var matrix: MatrixModel
) : RProps

class CanvasComponent(
    props: CanvasProps
) : RComponent<CanvasProps, RState>(props) {

    private lateinit var testRef: Element

    private lateinit var canvasContext: CanvasRenderingContext2D

    override fun shouldComponentUpdate(nextProps: CanvasProps, nextState: RState): Boolean {

        if(nextProps.matrix != props.matrix){
            return true
        }

        if (props.path.size != nextProps.path.size) {
            return true
        }

        nextProps.path.forEachIndexed { index, path ->
            if (path != props.path[index]) {
                return true
            }
        }

        return false
    }

    override fun componentWillUpdate(nextProps: CanvasProps, nextState: RState) {
        if (::canvasContext.isInitialized) {
            canvasContext.clearRect(
                0.0,
                0.0,
                canvasContext.canvas.width.toDouble(),
                canvasContext.canvas.height.toDouble()
            )
            drawGraph(canvasContext, nextProps.matrix)
        }
    }

    override fun componentDidMount() {
        val canvasRef = testRef

        canvasContext =
            (canvasRef as HTMLCanvasElement).getContext("2d") as CanvasRenderingContext2D

        canvasContext.canvas.width = 700
        canvasContext.canvas.height = 700

        drawGraph(canvasContext, props.matrix)

    }

    override fun RBuilder.render() {

        styledCanvas {
            css {
                +MainStyle.canvas
            }
            ref {
                testRef = it
            }
        }
        var startCoordinates = Coordinates(xStart, yStart)

        props.path.forEach {
            val new = drawNextStep(canvasContext, it, startCoordinates, props.matrix)
            startCoordinates = new
        }
    }
}