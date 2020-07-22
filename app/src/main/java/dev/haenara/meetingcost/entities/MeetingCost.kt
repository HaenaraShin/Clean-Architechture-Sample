package dev.haenara.meetingcost.entities

class MeetingCost (income : Double, hour : Int) {
    val cost = (income * hour.toDouble()).toInt()
}