package com.example.myfirstapplication

object Constants {
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"
    fun getQuestions(): ArrayList<Questions>{ //the data class from questions dot kt is used for parameters for arrays hehe
        val ListOfQuestions = ArrayList<Questions>()

        val que1 = Questions(1, "The most handsome guy in the classroom?", R.drawable.q1,
            "Ysmael Noche",
            "Renz Jovenes",
            "Sir Arjean",
            "Rowan Romero",
            1
            )
        ListOfQuestions.add(que1)

        val que2 = Questions(2, "Who is the dean of CCS Department?", R.drawable.q2,
            "Sir Regie",
            "Mr. Ellana",
            "Regie Ellana",
            "Sir Ellana",
            1
        )
        ListOfQuestions.add(que2)

        val que3 = Questions(3, "Who created the android studio?", R.drawable.q3,
            "The maker",
            "The Inventor",
            "Ang s'yang may likha",
            "A team of engineers at Google",
            4
        )
        ListOfQuestions.add(que3)

        val que4 = Questions(4, "What year android studio was developed?", R.drawable.q4,
            "400 BCE",
            "2008",
            "200 AD",
            "2012",
            2
        )
        ListOfQuestions.add(que4)

        val que5 = Questions(5, "The chickser in the classroom?", R.drawable.q5,
            "Bernard Jr.",
            "Renz Jovenes",
            "Jerome Almenie",
            "Veejay Cruz",
            2
        )
        ListOfQuestions.add(que5)

        val que6 = Questions(6, "The shortest guy in the classroom?", R.drawable.q6,
            "Dale Alfaro",
            "Clyde Cahayag",
            "Errol Montoya",
            "Rakko Delos Santos",
            3
        )
        ListOfQuestions.add(que6)

        val que7 = Questions(7, "The tallest guy in the classroom?", R.drawable.q7,
            "Pj Fernandez",
            "Errol Montoya",
            "Reinald Marinay",
            "Laurence Balon",
            1
        )
        ListOfQuestions.add(que7)

        val que8 = Questions(8, "The smartest guy in the room?", R.drawable.q8,
            "Pj Fernandez",
            "John Mark Mayote",
            "Dale Alfaro",
            "Raj",
            2
        )
        ListOfQuestions.add(que8)

        val que9 = Questions(9, "Who made the song NAGHANAP?", R.drawable.q9,
            "Hev Abi",
            "Haring Manggi",
            "BINI",
            "Eroru",
            4
        )
        ListOfQuestions.add(que9)

        val que10 = Questions(10, "What would be the grade sir arjean will give to me?", R.drawable.q10,
            "UNO",
            "FLAT ONE",
            "Bagsak, pangit naman gawa eh",
            "1",
            1
        )
        ListOfQuestions.add(que10)


        return ListOfQuestions
    }
}
