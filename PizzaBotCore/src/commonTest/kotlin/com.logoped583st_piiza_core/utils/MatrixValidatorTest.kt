package com.logoped583st_piiza_core.utils

import com.logoped583st.pizza_core.models.MatrixModel
import com.logoped583st.pizza_core.utils.isValidMatrix
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class MatrixValidatorTest {

    @Test
    fun test_valid_matrix() {
        assertTrue {
            MatrixModel(10, 10).isValidMatrix()
        }
    }

    @Test
    fun test_not_valid_matrix() {
        assertFalse {
            MatrixModel(-1, 10).isValidMatrix()
        }
    }
}