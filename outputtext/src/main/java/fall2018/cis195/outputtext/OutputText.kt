package fall2018.cis195.outputtext

/**
 * Created by arelin on 9/12/18.
 */

class OutputText {

    companion object{

        private val _operator: List<String> = listOf("+","-")
        private var _plus = false
        private var _minus = false

        fun createOutputText(items: List<String>): String {
            _plus = false
            _minus = false
            var currentValue = 0.0
            val sb = StringBuilder()
            for(item: String in items) {
                if(!(item in _operator)) {
                    sb.append(item)
                } else {
                    if(currentValue == 0.0) {
                        currentValue = sb.toString().toDouble()
                        sb.setLength(0)
                    }
                    else if(_plus) {
                        currentValue += sb.toString().toDouble()
                        sb.setLength(0)
                    } else {
                        currentValue -= sb.toString().toDouble()
                        sb.setLength(0)
                    }
                    if(item == "+") {
                        _plus = true
                        _minus = false
                    } else {
                        _minus = true
                        _plus = false
                    }
                }
            }
            if(_plus) {
                if(sb.length > 0) {
                    currentValue += sb.toString().toDouble()
                }
            } else if(_minus) {
                if(sb.length > 0) {
                    currentValue -= sb.toString().toDouble()
                }
            } else {
                currentValue = sb.toString().toDouble()
            }
            return currentValue.toString()
        }
    }

}