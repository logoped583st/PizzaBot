package com.logoped583st.pizza_core.utils

import com.logoped583st.pizza_core.exceptions.InvalidInputFormat
import com.logoped583st.pizza_core.exceptions.InvalidMatrixSizeException
import com.logoped583st.pizza_core.exceptions.InvalidPointException
import com.logoped583st.pizza_core.models.MatrixModel
import com.logoped583st.pizza_core.models.MatrixPointsModel
import com.logoped583st.pizza_core.models.PointModel


private val GENERAL_FORMAT_REGEX = Regex("(\\d+)x(\\d+)( \\(\\d+, \\d+\\))*")
private val MATRIX_SIZE_REGEX = Regex("(\\d+)x(\\d+)")
private val POINT_VALIDATOR_REGEX = Regex("(\\d+), (\\d+)")

internal interface PathFormatter {

    fun formatPath(input: String): MatrixPointsModel
}

internal class PathFormatterImpl : PathFormatter {

    override fun formatPath(input: String): MatrixPointsModel {

        if (!input.matches(GENERAL_FORMAT_REGEX)) {
            throw InvalidInputFormat(input)
        }

        val (height, width) = MATRIX_SIZE_REGEX.find(input)?.destructured
            ?: throw InvalidMatrixSizeException(
                null, null
            )

        val matrix = MatrixModel(height.toInt(), width.toInt())

        if (!matrix.isValidMatrix()) {
            throw InvalidMatrixSizeException(
                matrix.height, matrix.width
            )
        }

        val points = POINT_VALIDATOR_REGEX.findAll(input).map {
            val (x, y) = it.destructured
            PointModel(x.toInt(), y.toInt())
        }.toList()

        points.forEach {
            if (!it.isValidPoint(matrix)) {
                throw InvalidPointException(it.x, it.y, matrix.width, matrix.height)
            }
        }

        return MatrixPointsModel(matrix, points)

    }

}
