package com.logoped583st_piiza_core.utils

import com.logoped583st.pizza_core.exceptions.InvalidInputFormat
import com.logoped583st.pizza_core.exceptions.InvalidMatrixSizeException
import com.logoped583st.pizza_core.exceptions.InvalidPointException
import com.logoped583st.pizza_core.models.PointModel
import com.logoped583st.pizza_core.utils.PathFormatterImpl
import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class PathFormatterTest {

    private val pathFormatter = PathFormatterImpl()

    @Test
    fun test_success_formatting() {

        val matrixPathModel = pathFormatter.formatPath(
            "5x5 (1, 2) (5, 4)"
        )

        assertTrue {
            matrixPathModel.matrix.width == 5 && matrixPathModel.matrix.height == 5
        }

        assertTrue {
            matrixPathModel.path[0] == PointModel(1, 2) &&  matrixPathModel.path[1] == PointModel(5, 4)
        }
    }

    @Test
    fun test_incorrect_format1() {
        assertFailsWith(InvalidInputFormat::class) {
            pathFormatter.formatPath(
                "5x5 (1,2) (5, 4)"
            )
        }
    }

    @Test
    fun test_incorrect_format2() {
        assertFailsWith(InvalidInputFormat::class) {
            pathFormatter.formatPath(
                "5x5 ,2) (5, 4)"
            )
        }
    }

    @Test
    fun test_invalid_point() {
        assertFailsWith(InvalidPointException::class) {
            pathFormatter.formatPath(
                "5x5 (1, 2) (6, 4)"
            )
        }
    }

    @Test
    fun test_invalid_matrix() {
        assertFailsWith(InvalidMatrixSizeException::class) {
            pathFormatter.formatPath(
                "0x5 (1, 2) (6, 4)"
            )
        }
    }
}