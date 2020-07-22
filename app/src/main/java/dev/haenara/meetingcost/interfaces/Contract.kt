package dev.haenara.meetingcost.interfaces

interface Contract {
    interface View : Contract {
        fun getIncome() : Int
        fun getTime() : Int
        fun showResult(cost : Int)
        fun showError(message : String)
    }
    interface Presenter : Contract {
        fun calculate()
    }
}