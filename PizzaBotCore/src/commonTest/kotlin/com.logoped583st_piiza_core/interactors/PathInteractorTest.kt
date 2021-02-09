package com.logoped583st_piiza_core.interactors

import com.logoped583st.pizza_core.interactors.PathInteractorImpl
import com.logoped583st.pizza_core.mappers.PathOptimizer
import com.logoped583st.pizza_core.models.Path
import com.logoped583st.pizza_core.models.PointModel
import kotlin.test.Test
import kotlin.test.assertTrue

class PathInteractorTest {

    @Test
    fun test_path_interactor() {
        val pathInteractor = PathInteractorImpl(object : PathOptimizer {
            override fun map(input: List<PointModel>): List<PointModel> {
                return listOf(
                    PointModel(1, 1),
                    PointModel(
                        2, 2
                    )
                )
            }

        })

        val formattedPath = pathInteractor.formatPath(
            listOf(
                PointModel(1, 1),
                PointModel(
                    2, 2
                )
            )
        ).path

        val expectedPath =
            listOf(Path.RIGHT, Path.TOP, Path.DROP, Path.RIGHT, Path.TOP, Path.DROP)

        var isEqual = true

        formattedPath.forEachIndexed { index, value ->
            if (value != expectedPath[index]) {
                isEqual = false
            }
        }

        assertTrue(isEqual)
    }

    @Test
    fun test_path_interactor_with_double_drop() {
        val pathInteractor = PathInteractorImpl(object : PathOptimizer {
            override fun map(input: List<PointModel>): List<PointModel> {
                return listOf(
                    PointModel(1, 1),
                    PointModel(
                        2, 2
                    )
                )
            }

        })

        val formattedPath = pathInteractor.formatPath(
            listOf(
                PointModel(1, 1),
                PointModel(
                    2, 2
                ),
                PointModel(
                    2, 2
                )
            )
        ).path

        val doubleDropCheck = listOf(Path.DROP, Path.DROP)

        assertTrue {
            formattedPath.containsAll(doubleDropCheck)
        }
    }
}