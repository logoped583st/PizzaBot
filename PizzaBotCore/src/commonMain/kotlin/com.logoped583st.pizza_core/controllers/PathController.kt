package com.logoped583st.pizza_core.controllers

import com.logoped583st.pizza_core.interactors.PathInteractor
import com.logoped583st.pizza_core.models.MatrixPathModel
import com.logoped583st.pizza_core.models.PathModel
import com.logoped583st.pizza_core.utils.PathFormatter
import org.koin.core.KoinComponent
import org.koin.core.inject

interface PathController {
    @Throws(Exception::class)
    fun getPath(input: String): PathModel

    @Throws(Exception::class)
    fun getPathWithMatrix(input: String): MatrixPathModel
}

class PathControllerImpl : PathController, KoinComponent {

    private val pathFormatter: PathFormatter by inject()

    private val pathInteractor: PathInteractor by inject()

    override fun getPath(input: String): PathModel {
        val formattedInput = pathFormatter.formatPath(input)

        return pathInteractor.formatPath(formattedInput.path)
    }

    override fun getPathWithMatrix(input: String): MatrixPathModel {
        val formattedInput = pathFormatter.formatPath(input)

        return MatrixPathModel(formattedInput.matrix, pathInteractor.formatPath(formattedInput.path).path)
    }

}