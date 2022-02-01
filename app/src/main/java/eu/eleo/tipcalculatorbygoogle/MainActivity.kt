package eu.eleo.tipcalculatorbygoogle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import eu.eleo.tipcalculatorbygoogle.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener { calculateTip() }
    }

    private fun calculateTip() {
        val stringInTextField = binding.costOfService.text.toString()
        val cost = stringInTextField.toDoubleOrNull()
        if (cost == null) {
            binding.tipResult.text = ""
            return
        }
        val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.option_fifteen -> 0.15
            R.id.option_eighteen -> 0.18
            else -> 0.20
        }
        var tip = tipPercentage * cost
        if (binding.roundUpSwitch.isChecked) {
            kotlin.math.ceil(tip)
        }
        fun displayTip(tip: Double) {
            val formattedTip = NumberFormat.getCurrencyInstance().format(0.0)
            binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
        }
    }
}