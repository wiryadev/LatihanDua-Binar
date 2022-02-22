package ui

import data.Student

class GameUiImpl : GameUi {
    override fun showWelcome() {
        println("Hello, Welcome to Student DUmmy Data !")
    }

    override fun input(data: String): String? {
        print("Input your $data: ")
        return readlnOrNull()
    }

    override fun showMenu(name: String): Int {
        println("Welcome, $name")
        println("Student DUmmy Data")
        printDivider()
        println("1. View Data")
        println("2. Update Data")
        println("3. Exit")
        print(">> ")
        return readlnOrNull()?.toInt() ?: 0
    }

    override fun showStudentData(student: Student) {
        printDivider()
        println("Your name is ${student.name}")
        println("Your age is ${student.age}")
        println("Your GPA is ${student.gpa}")
        printDivider()
    }

    override fun updateStudentGpa(): String? {
        print("Input your GPA [0.0 - 4.0 inclusive]: ")
        return readlnOrNull()
    }

    override fun printSuccessUpdateMessage() {
        println("Student data updated successfully")
    }

    override fun printFailedUpdateMessage(data: String) {
        println("Failed to update $data")
    }

    private fun printDivider() {
        println("=====================================")
    }

}