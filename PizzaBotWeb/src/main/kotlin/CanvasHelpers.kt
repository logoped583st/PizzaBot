import com.logoped583st.pizza_core.models.MatrixModel
import com.logoped583st.pizza_core.models.Path
import kotlinx.css.Color
import org.w3c.dom.CanvasRenderingContext2D
import kotlin.math.PI

const val xStart = 40.0
const val yStart = 40.0
const val graphWidth = 700.0 - xStart
const val graphHeight = 700.0 - yStart

data class Coordinates(
    val x: Double,
    val y: Double
)

fun getCoordinateForNextStep(
    direction: Path,
    currentCoordinate: Coordinates,
    delta: Double
): Coordinates {
    when (direction) {
        Path.TOP ->
            return Coordinates(
                currentCoordinate.x,
                currentCoordinate.y + delta
            )
        Path.BOTTOM ->
            return Coordinates(currentCoordinate.x, currentCoordinate.y - delta)
        Path.LEFT ->
            return Coordinates(
                currentCoordinate.x - delta,
                currentCoordinate.y,
            )
        Path.RIGHT ->
            return Coordinates(
                currentCoordinate.x + delta,
                currentCoordinate.y,
            )
        Path.DROP -> return Coordinates(
            currentCoordinate.x, currentCoordinate.y,
        )
    }
}

fun drawNextStep(
    ctx: CanvasRenderingContext2D,
    direction: Path,
    currentCoordinates: Coordinates,
    matrixModel: MatrixModel
): Coordinates {

    val delta =
        minOf(ctx.canvas.width, ctx.canvas.height).toDouble() / (maxOf(
            matrixModel.height,
            matrixModel.width
        )*2)
    ctx.beginPath()

    val nextStepCoordinates = getCoordinateForNextStep(direction, currentCoordinates, delta)
    ctx.lineWidth = 2.0
    ctx.strokeStyle = Color.red

    if (direction == Path.DROP) {
        ctx.arc(currentCoordinates.x, currentCoordinates.y, 3.0, 0.0, 2 * PI)
        ctx.fillStyle = Color.white
        ctx.fill()
        ctx.stroke()
        ctx.closePath()
        return currentCoordinates
    }
    ctx.moveTo(currentCoordinates.x, currentCoordinates.y)
    ctx.lineTo(nextStepCoordinates.x, nextStepCoordinates.y)
    ctx.fillStyle = Color.white

    ctx.stroke()
    ctx.closePath()

    return nextStepCoordinates
}


fun drawGraph(ctx: CanvasRenderingContext2D, matrixModel: MatrixModel) {
    ctx.lineWidth = 1.0

    val delta =
        minOf(ctx.canvas.width, ctx.canvas.height).toDouble() / (maxOf(
            matrixModel.height,
            matrixModel.width
        )*2)

    ctx.strokeStyle = Color.black
    ctx.fillStyle = Color.white
    ctx.beginPath()
    ctx.moveTo(xStart, yStart)
    ctx.lineTo(xStart, yStart + graphHeight)
    ctx.moveTo(xStart, yStart)
    ctx.lineTo(xStart + graphWidth, yStart)

    // drawing cell lines
    var i = xStart + delta

    while (i < xStart + graphWidth) {

        ctx.moveTo(i, yStart + 8)
        ctx.lineTo(i, yStart - 8)

        i += delta
    }

    i = yStart + delta

    while (i < yStart + graphHeight) {

        ctx.moveTo(xStart + 8, i)
        ctx.lineTo(xStart - 8, i)

        i += delta
    }

    ctx.stroke()
    ctx.closePath()
}
