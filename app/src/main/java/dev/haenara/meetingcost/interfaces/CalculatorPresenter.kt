package dev.haenara.meetingcost.interfaces

import dev.haenara.meetingcost.usecases.CalculateUseCase

class CalculatorPresenter(val view : Contract.View) : Contract.Presenter {
    val useCase = CalculateUseCase()

    override fun calculate() {
        val result = useCase.execute(
            CalculateUseCase.Input(
                view.getIncome(),
                view.getTime())
        )

        when (result) {
            is CalculateUseCase.Output.Success -> { view.showResult(result.cost) }
            is CalculateUseCase.Output.Fail -> { view.showError(result.message) }
        }
    }
}