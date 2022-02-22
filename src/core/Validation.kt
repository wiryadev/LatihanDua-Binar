package core

object Validation {

    fun validateName(name: String?): Boolean {
        return if (name.isNullOrEmpty()) {
            false
        } else {
            name.length in 3..15
        }
    }

    fun validateAge(age: String?): Boolean {
        return if (age.isNullOrEmpty()) {
            false
        } else {
            try {
                age.toInt() >= 16
            } catch (e: NumberFormatException) {
                false
            }
        }
    }

    fun validateGpa(gpa: String?): Boolean {
        return if (gpa.isNullOrEmpty()) {
            false
        } else {
            try {
                gpa.toFloat() in 0.0..4.0
            } catch (e: NumberFormatException) {
                false
            }
        }
    }
}