fun main() {
    // a - Create a function to print the last digit and first digit of the given number.
    // Example: 1245 → 15
    val a = 6124523459
    val last = a%10
    var first = a/10
    while (first>=10){
        first /=10
    }
    println(String.format("a) %d %d",first,last))

    // b - Write a function to find the sum of odd-squared values in the given array of integers
    //  Example: Arrays contains {1, 2, 3, 4, 6, 5}
    //  Output: 1^2 + 3^2 + 5^2 → 1 + 9 + 25 = 35.
    val givenArray = arrayOf(1, 2, 3, 4, 6, 5)
    println(String.format("b) %s", givenArray.filter { it % 2 != 0 }.sumOf { it * it }))


    // C - Write a Program using when expression to find the weight of a person in various
    //planets according to the choice of user input. Assume inputs in pounds. Do the
    //Kotlin approach to avoid NullPointerException if the input is null.
    val weight = 130
    println(String.format("c) with null: %s",calculateWeight(null, "venus")))
    println(String.format("c) with value: %s",calculateWeight(weight, "venus")))
}


fun calculateWeight(weight: Int?, planet: String): Number {
    weight?:return 0 // on null it's going to be 0 by default - using elvis operator

    val result = when(planet){
        "mars" -> 0.39 * weight
        "venus" -> 0.78 * weight
        "jupiter" -> 2.65 * weight
        "saturn" -> 1.17 * weight
        "uranus" -> 1.05 * weight
        "neptune" -> 1.23 * weight
        else -> weight
    }
    return result
}