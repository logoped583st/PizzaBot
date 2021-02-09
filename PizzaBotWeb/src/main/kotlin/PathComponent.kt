import com.logoped583st.pizza_core.controllers.PathControllerImpl
import com.logoped583st.pizza_core.models.MatrixModel
import com.logoped583st.pizza_core.models.MatrixPathModel
import kotlinx.css.Display
import kotlinx.css.FlexDirection
import kotlinx.css.display
import kotlinx.css.flexDirection
import kotlinx.html.ButtonType
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import kotlinx.html.js.onSubmitFunction
import org.w3c.dom.HTMLInputElement
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.h1
import styled.*


data class PathState(
    val path: String, val error: String,
    val matrixPathModel: MatrixPathModel
) : RState


@JsExport
class PathComponent : RComponent<RProps, PathState>() {

    init {
        state = PathState("", "", MatrixPathModel(MatrixModel(5, 5), emptyList()))
    }

    override fun RBuilder.render() {

        styledSection {

            css {
                +MainStyle.container
            }

            child(CanvasComponent::class) {
                attrs {
                    path = state.matrixPathModel.path
                    matrix = state.matrixPathModel.matrixModel
                }
            }

            if (state.error.isNotEmpty()) {
                styledSection {
                    h1 {
                        attrs {
                            text(state.error)
                        }
                    }
                }
            }

            styledForm {
                css {
                    display = Display.flex
                    flexDirection = FlexDirection.column
                }
                attrs {
                    onSubmitFunction = {
                        it.preventDefault()
                    }
                }
                styledInput {
                    css {
                        +MainComponentsStyle.input
                    }

                    attrs {
                        value = state.path
                        onChangeFunction = {
                            placeholder = "Enter path"
                            val target = it.target as HTMLInputElement
                            val searchTerm = target.value
                            setState(PathState(searchTerm, state.error, state.matrixPathModel))
                        }
                    }
                }

                styledButton {
                    css {
                        +MainComponentsStyle.button
                    }
                    attrs {
                        type = ButtonType.submit
                        onClickFunction = {

                            if (state.path.isNotEmpty()) {
                                try {
                                    val path = PathControllerImpl().getPathWithMatrix(state.path)
                                    setState(
                                        PathState(
                                            state.path,
                                            "",
                                            path
                                        )
                                    )
                                } catch (e: Exception) {

                                    setState(
                                        PathState(
                                            state.path, e.message ?: "", MatrixPathModel(
                                                state.matrixPathModel.matrixModel,
                                                emptyList()
                                            )
                                        )
                                    )
                                }
                            }
                        }
                    }
                    +"Enter"
                }
            }
        }
    }
}
