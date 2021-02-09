package com.logoped583st.pizza_core.exceptions

class InvalidMatrixSizeException(
    width: Int?,
    height: Int?
) : IllegalArgumentException(
    "Illegal matrix size. width: $width  height: $height"
)

class InvalidPointException(
    x: Int?,
    y: Int?,
    width: Int?,
    height: Int?
) : IllegalArgumentException(
    "Illegal point position. x: $x  y: $y, matrix width: $width matrix height: $height"
)

class InvalidInputFormat(
    input: String
): IllegalArgumentException("Invalid input $input")