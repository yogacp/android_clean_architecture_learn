package learn.clean_architecture.android.external.helper

import android.annotation.SuppressLint
import learn.clean_architecture.android.external.constant.AppConstant
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Yoga C. Pranata on 14/10/2018.
 * Android Engineer
 */
class Helper {
    /**
     * Convert date
     * @Return String
     */
    @SuppressLint("SimpleDateFormat")
    fun getDateString(dateString: String): String {
        val dateSplit = dateString.split("-")
        val sdf = SimpleDateFormat("yyyy-mm-dd", Locale.getDefault())
        val date = sdf.parse(dateString)
        val calendar = Calendar.getInstance()
        calendar.time = date

        val dayOfTheWeek = calendar.get(Calendar.DAY_OF_WEEK)
        val day = calendar.get(Calendar.DATE)
        val year = calendar.get(Calendar.YEAR)

        return "$day ${getIndoMonthString(dateSplit.get(1))} $year"
    }

    /**
     * Convert monthString to Indonesian
     */
    fun getIndoMonthString(monthString: String): String {
        return when(monthString) {
            "01" -> AppConstant.MONTH_NAME.MONTH_JAN
            "02" -> AppConstant.MONTH_NAME.MONTH_FEB
            "03" -> AppConstant.MONTH_NAME.MONTH_MAR
            "04" -> AppConstant.MONTH_NAME.MONTH_APR
            "05" -> AppConstant.MONTH_NAME.MONTH_MAY
            "06" -> AppConstant.MONTH_NAME.MONTH_JUNE
            "07" -> AppConstant.MONTH_NAME.MONTH_JULY
            "08" -> AppConstant.MONTH_NAME.MONTH_AUG
            "09" -> AppConstant.MONTH_NAME.MONTH_SEPT
            "10" -> AppConstant.MONTH_NAME.MONTH_OCT
            "11" -> AppConstant.MONTH_NAME.MONTH_NOV
            "12" -> AppConstant.MONTH_NAME.MONTH_DEC
            else -> ""
        }
    }
}