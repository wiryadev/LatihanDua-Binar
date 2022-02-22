package core

import data.Student
import ui.GameUi

class GameEngine(val gameUi: GameUi) {

    init {
        showUserInput()
    }

    private fun showUserInput() {
        var name = ""

        do {
            getNameInput()?.let {
                if (Validation.validateName(it)) {
                    name = it
                }
            }
        } while (name.isEmpty())

        var age = 0
        do {
            getAgeInput()?.let {
                if (Validation.validateAge(it)) {
                    age = it.toInt()
                }
            }
        } while (age == 0)

        var gpa = 0.0f
        do {
            getGpaInput()?.let {
                if (Validation.validateGpa(it)) {
                    gpa = it.toFloat()
                }
            }
        } while (gpa == 0.0f)

        val student = Student(name, age, gpa)
        println(student)
    }

    private fun getNameInput() = gameUi.input("name [3 - 15 characters] (cannot be changed)")
    private fun getAgeInput() = gameUi.input("age [min 16] (cannot be changed)")
    private fun getGpaInput() = gameUi.input("gpa [0.0 - 4.0 inclusive]")
}