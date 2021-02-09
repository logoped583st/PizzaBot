package com.logoped583st_piiza_core.utils

import com.logoped583st.pizza_core.models.MatrixModel
import com.logoped583st.pizza_core.models.PointModel
import com.logoped583st.pizza_core.utils.isValidPoint
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PointValidatorTest {

    private val matrix = MatrixModel(5, 5)

    @Test
    fun test_valid_point() {
        assertTrue {
            PointModel(1, 3).isValidPoint(matrix)
        }
    }

    @Test
    fun test_invalid_point_with_invalid_height() {
        assertFalse {
            PointModel(1, 6).isValidPoint(matrix)
        }
    }

    @Test
    fun test_invalid_point_with_invalid_width() {
        assertFalse {
            PointModel(6, 3).isValidPoint(matrix)
        }
    }
}