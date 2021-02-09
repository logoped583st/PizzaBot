package com.logoped583st.pizza_core.mappers

interface Mapper<I, O> {
    fun map(input: I): O
}