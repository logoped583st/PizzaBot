package com.logoped583st.pizza_core.utils

import com.logoped583st.pizza_core.models.MatrixModel
import com.logoped583st.pizza_core.models.PointModel

internal fun MatrixModel.isValidMatrix(): Boolean {
    return height > 0 && width > 0
}

internal fun PointModel.isValidPoint(matrixModel: MatrixModel): Boolean {
    return (x > 0 && x <= matrixModel.width) and (y > 0 && y <= matrixModel.height)
}