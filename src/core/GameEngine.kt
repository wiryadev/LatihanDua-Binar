package core

import data.Student
import ui.GameUi
import kotlin.system.exitProcess

class GameEngine(val gameUi: GameUi) {

    private lateinit var student: Student

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

        student = Student(name, age, gpa)
        controlMenu()
    }

    private fun controlMenu() {
        when (gameUi.showMenu(student.name)) {
            1 -> {
                gameUi.showStudentData(student)
                controlMenu()
            }
            2 -> updateStudentData()
            3 -> exitProcess(0)
            else -> controlMenu()
        }
    }

    private fun updateStudentData() {
        gameUi.updateStudentGpa()?.let {
            if (Validation.validateGpa(it)) {
                student.gpa = it.toFloat()
                gameUi.printSuccessUpdateMessage()
            } else {
                gameUi.printFailedUpdateMessage("GPA")
            }
        } ?: run {
            gameUi.printFailedUpdateMessage("GPA")
        }
        controlMenu()
    }

    private fun getNameInput() = gameUi.input("name [3 - 15 characters] (cannot be changed)")
    private fun getAgeInput() = gameUi.input("age [min 16] (cannot be changed)")
    private fun getGpaInput() = gameUi.input("gpa [0.0 - 4.0 inclusive]")
}