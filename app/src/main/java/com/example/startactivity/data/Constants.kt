package com.example.startactivity.data

object Constants {
    fun provideQuestions(): List<Question> {
        val questions = mutableListOf<Question>()

        questions.add(
            Question(
                id = 0,
                "Uzbekistan",
                answers = listOf("Tashkent", "Nukus", "Moskva", "London"),
                correctAnswerId = 0
            )
        )

        questions.add(
            Question(
                id = 0,
                "Karakalpakstan",
                answers = listOf("Tashkent", "Nukus", "Moskva", "London"),
                correctAnswerId = 1
            )
        )

        questions.add(
            Question(
                id = 0,
                "Kazakhstan",
                answers = listOf("Tashkent", "Nukus", "Moskva", "Astana"),
                correctAnswerId = 3
            )
        )

        questions.add(
            Question(
                id = 0,
                "Kyrgyzstan",
                answers = listOf("Tashkent", "Nukus", "Bishkek", "London"),
                correctAnswerId = 2
            )
        )

        questions.add(
            Question(
                id = 0,
                "Turkmenistan",
                answers = listOf("Ashqabad", "Nukus", "Moskva", "London"),
                correctAnswerId = 0
            )
        )

        questions.add(
            Question(
                id = 0,
                "Afganistan",
                answers = listOf("Tashkent", "Nukus", "Moskva", "Kabul"),
                correctAnswerId = 3
            )
        )

        questions.add(
            Question(
                id = 0,
                "Tadjikistan",
                answers = listOf("Tashkent", "Dushanbe", "Moskva", "London"),
                correctAnswerId = 1
            )
        )

        questions.add(
            Question(
                id = 0,
                "USA",
                answers = listOf("Tashkent", "Nukus", "Washington", "London"),
                correctAnswerId = 2
            )
        )

        questions.add(
            Question(
                id = 0,
                "Latviya",
                answers = listOf("Beyrut", "Nukus", "Moskva", "London"),
                correctAnswerId = 0
            )
        )

        questions.add(
            Question(
                id = 0,
                "Russia",
                answers = listOf("Tashkent", "Nukus", "Moskva", "London"),
                correctAnswerId = 2
            )
        )

        return questions
    }
}