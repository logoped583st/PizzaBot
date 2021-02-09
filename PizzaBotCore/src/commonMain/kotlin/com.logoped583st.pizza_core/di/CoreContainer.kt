package com.logoped583st.pizza_core.di

import com.logoped583st.pizza_core.controllers.PathController
import com.logoped583st.pizza_core.controllers.PathControllerImpl
import com.logoped583st.pizza_core.interactors.PathInteractor
import com.logoped583st.pizza_core.interactors.PathInteractorImpl
import com.logoped583st.pizza_core.mappers.PathOptimizer
import com.logoped583st.pizza_core.mappers.PathOptimizerImpl
import com.logoped583st.pizza_core.utils.PathFormatter
import com.logoped583st.pizza_core.utils.PathFormatterImpl
import org.koin.core.context.startKoin
import org.koin.dsl.module

private val coreModule = module {
    single<PathInteractor> { PathInteractorImpl(get()) }
    single<PathOptimizer> { PathOptimizerImpl() }
    single<PathFormatter> { PathFormatterImpl() }
    single <PathController> {PathControllerImpl()}
}

fun initKoin(){
    startKoin { modules(coreModule) }
}