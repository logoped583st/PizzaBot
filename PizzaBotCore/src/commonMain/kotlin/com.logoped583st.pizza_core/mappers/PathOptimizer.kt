package com.logoped583st.pizza_core.mappers

import com.logoped583st.pizza_core.models.PointModel
import kotlin.math.abs

internal class PathOptimizerImpl : Mapper<List<PointModel>, List<PointModel>> {

    override fun map(input: List<PointModel>): List<PointModel> {
        val groupedByX = mutableMapOf<Int, MutableList<Int>>()

        input.forEach {
            groupedByX[it.x] = (groupedByX[it.x]?.apply { add(it.y) }) ?: mutableListOf(it.y)
        }

        var currentY = 0

        val optimizedPoints = mutableListOf<PointModel>()

        groupedByX.keys.sorted().forEach { x ->
            groupedByX[x]?.sorted()?.run {

                currentY = if (abs(currentY - first()) > abs(currentY - last())) {
                    optimizedPoints.addAll(reversed().map { PointModel(x, it) })
                    first()
                } else {
                    optimizedPoints.addAll(map { PointModel(x, it) })
                    last()
                }

            }
        }

        return optimizedPoints
    }

}

typealias PathOptimizer = Mapper<List<PointModel>, List<PointModel>>