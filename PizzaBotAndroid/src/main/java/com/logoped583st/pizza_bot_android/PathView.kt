package com.logoped583st.pizza_bot_android

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.logoped583st.pizza_core.models.MatrixModel
import com.logoped583st.pizza_core.models.MatrixPathModel
import com.logoped583st.pizza_core.models.Path

class PathView
@JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : View(context, attrs, defStyle) {

    private val paint = Paint()

    private var startX = 0F
    private var startY = 0f

    var model: MatrixPathModel? = null
        set(value) {
            field = value
            invalidate()
        }

    override fun onDraw(canvas: Canvas) {
        canvas.drawLine(startX, startY, startX, startY + height, paint)
        canvas.drawLine(startX, startY + height - 1, startX + width, startY + height - 1, paint)

        model?.run {
            drawPath(path, matrixModel, canvas)
        }
    }

    private fun drawPath(path: List<Path>, matrixModel: MatrixModel, canvas: Canvas) {
        var currentX = 0F
        var currentY = startY + height - 1

        val pathPaint = Paint().apply {
            strokeWidth = 2F
            color = Color.BLUE
        }
        val delta =
            minOf(canvas.width, canvas.height) / maxOf(matrixModel.height, matrixModel.width)

        path.forEach {
            when (it) {
                Path.TOP -> {
                    canvas.drawLine(currentX, currentY, currentX, currentY - delta, pathPaint)
                    currentY -= delta
                }
                Path.RIGHT -> {
                    canvas.drawLine(currentX, currentY, currentX + delta, currentY, pathPaint)
                    currentX += delta
                }
                Path.BOTTOM -> {
                    canvas.drawLine(currentX, currentY, currentX, currentY + delta, pathPaint)
                    currentY += delta
                }
                Path.DROP -> {
                    canvas.drawCircle(currentX, currentY, 4F, Paint().apply {
                        strokeWidth = 4F
                        color = Color.RED
                    })
                }
            }
        }
    }
}