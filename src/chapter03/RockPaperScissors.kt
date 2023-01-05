fun main(args: Array<String>) {
    val options = arrayOf("Rock", "Paper", "Scissors")
    val gameChoice = getGameChoice(options)
    var userChoice = getUserChoice(options)
    printResult(userChoice, gameChoice)
}

fun getGameChoice(optionsParam: Array<String>) = optionsParam[(Math.random() * optionsParam.size).toInt()]

fun getUserChoice(optionsParams: Array<String>): String {
    var isValidChoice = false
    var userChoice = ""
    while (!isValidChoice) {
        print("Please enter one of the following:")
        for (item in optionsParams) print(" $item")
        println(".")
        val userInput = readLine()
        if (userInput != null && userInput in optionsParams) {
            isValidChoice = true;
            userChoice = userInput
        }
        if (!isValidChoice) println("You must enter a valid choise.")
    }
    return userChoice
}

fun printResult(userChoice: String, gameChoice: String) {
    val result: String
    if (userChoice == gameChoice) result = "Tie!"
    else if ((userChoice == "Rock" && gameChoice == "Scissors") ||
        (userChoice == "Paper" && gameChoice == "Rock") ||
        (userChoice == "Scissors" && gameChoice == "Paper")
    ) result = "You win!"
    else result = "You lose!"
    println("You chose $userChoice. I chose $gameChoice. $result")
}