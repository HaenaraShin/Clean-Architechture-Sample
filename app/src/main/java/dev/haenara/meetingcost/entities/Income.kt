package dev.haenara.meetingcost.entities

class Income(income : Int) {
    val hourIncome = income.toDouble() * 0.00047783
}