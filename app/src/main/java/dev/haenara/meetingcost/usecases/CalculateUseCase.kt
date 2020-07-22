package dev.haenara.meetingcost.usecases

import dev.haenara.meetingcost.entities.Income
import dev.haenara.meetingcost.entities.MeetingCost

class CalculateUseCase {
    fun execute(input : Input) : Output{
        if (input.income == 0) {
            // 에러 발생
            return Output.Fail("수입을 입력해주세요.")
        } else {
            val hourIncome = input.income.toHourIncome()
            val meetingCost = hourIncome.calculate(input.time)
            // 계산 성공
            return Output.Success(meetingCost)
        }

    }

    class Input(val income: Int,
                val time: Int)

    sealed class Output {
        class Success(val cost : Int) : Output()
        class Fail(val message : String) : Output()
    }

    /**
     * 시급으로 전환
     */
    fun Int.toHourIncome() = Income(this).hourIncome

    /**
     * 시급으로 회의 비용 계산
     */
    fun Double.calculate(time : Int) = MeetingCost(this, time).cost
}
