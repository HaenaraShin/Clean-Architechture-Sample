package dev.haenara.meetingcost.external

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import dev.haenara.meetingcost.R
import dev.haenara.meetingcost.interfaces.CalculatorPresenter
import dev.haenara.meetingcost.interfaces.Contract
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Contract.View {
    val presenter = CalculatorPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_confirm.setOnClickListener {
            // 비용 계산 시작
            presenter.calculate()
        }
    }

    override fun getIncome(): Int {
        return edt_income.text.toString().toInt()
    }

    override fun getTime(): Int {
        return edt_time.text.toString().toInt()
    }

    override fun showResult(cost: Int) {
        AlertDialog.Builder(this)
            .setTitle("결과")
            .setMessage("당신은 회의 비용은 ${cost}원 입니다.")
            .setPositiveButton("확인") { _, _ -> }
            .create()
            .show()
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
