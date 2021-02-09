package com.logoped583st.pizza_core.interactors

import com.logoped583st.pizza_core.mappers.PathOptimizer
import com.logoped583st.pizza_core.models.Path
import com.logoped583st.pizza_core.models.PathModel
import com.logoped583st.pizza_core.models.PointModel

internal interface PathInteractor {
    fun formatPath(points: List<PointModel>): PathModel
}

internal class PathInteractorImpl(
    private val pathOptimizer: PathOptimizer
) : PathInteractor {


    override fun formatPath(points: List<PointModel>): PathModel {
        var currentX = 0
        var currentY = 0

        val path = mutableListOf<Path>()

        pathOptimizer.map(points).map {
            while (currentX < it.x) {
                currentX++
                path.add(Path.RIGHT)
            }

            while (currentY > it.y) {
                path.add(Path.BOTTOM)
                currentY--
            }

            while (currentY < it.y) {
                path.add(Path.TOP)
                currentY++
            }

            if (currentX == it.x && currentY == it.y) {
                path.add(Path.DROP)
            }
        }

        return PathModel(path)
    }

}