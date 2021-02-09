package com.logoped583st_piiza_core.mappers

import com.logoped583st.pizza_core.mappers.PathOptimizerImpl
import com.logoped583st.pizza_core.models.PointModel
import kotlin.test.Test
import kotlin.test.assertTrue

class PathOptimizerTest {

    private val pathOptimizer = PathOptimizerImpl()

    @Test
    fun test_optimizer_by_x() {
        val notOptimized = listOf(
            PointModel(5, 10),
            PointModel(3, 6)
        )

        val optimized = pathOptimizer.map(notOptimized)

        assertTrue {
            optimized[0].x == 3 && optimized[1].x == 5
        }
    }

    @Test
    fun test_optimizer_by_y_when_not_optimized1() {

        val notOptimized = listOf(
            PointModel(1, 10),
            PointModel(2, 6),
            PointModel(2, 3),

            )

        val optimized = pathOptimizer.map(notOptimized)

        assertTrue {
            optimized[1].y == 6 && optimized[2].y == 3
        }
    }


    @Test
    fun test_optimizer_by_y_when_not_optimized2() {

        val notOptimized = listOf(
            PointModel(1, 2),
            PointModel(2, 6),
            PointModel(2, 3)
        )

        val optimized = pathOptimizer.map(notOptimized)

        assertTrue {
            optimized[1].y == 3 && optimized[2].y == 6
        }
    }

    @Test
    fun test_optimizer_by_y_when_optimized() {

        val notOptimized = listOf(
            PointModel(1, 3),
            PointModel(2, 4),
            PointModel(2, 5)
        )

        val optimized = pathOptimizer.map(notOptimized)

        assertTrue {
            optimized[1].y == 4 && optimized[2].y == 5
        }
    }
}