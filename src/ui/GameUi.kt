package ui

import data.Student

interface GameUi {
    fun showWelcome()
    fun input(data: String): String?
    fun showMenu(name: String): Int
    fun showStudentData(student: Student)
    fun updateStudentData(): Float
}