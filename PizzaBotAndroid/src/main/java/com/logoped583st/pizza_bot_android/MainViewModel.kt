package com.logoped583st.pizza_bot_android

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.logoped583st.pizza_core.controllers.PathController
import com.logoped583st.pizza_core.models.MatrixModel
import com.logoped583st.pizza_core.models.MatrixPathModel
import com.logoped583st.pizza_core.models.Path
import org.koin.java.KoinJavaComponent

class MainViewModel : ViewModel() {

    private val pathController: PathController by KoinJavaComponent.inject(PathController::class.java)

    private val _data = MutableLiveData<MatrixPathModel>()

    val data: LiveData<MatrixPathModel> = _data

    fun requestData(path: String){
        _data.postValue(pathController.getPathWithMatrix(path))
    }

}