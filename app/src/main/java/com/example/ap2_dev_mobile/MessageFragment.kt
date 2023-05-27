import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.ap2_dev_mobile.R

class MessageFragment : Fragment() {

    companion object {
        private const val ARG_ERROR_MESSAGE = "errorMessage"

        fun newInstance(errorMessage: String): MessageFragment {
            val fragment = MessageFragment()
            val args = Bundle()
            args.putString(ARG_ERROR_MESSAGE, errorMessage)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar o layout do Fragment
        return inflater.inflate(R.layout.fragment_message, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configurar o TextView para exibir a mensagem de erro
        val errorMessageTextView = view.findViewById<TextView>(R.id.errorMessageTextView)
        val errorMessage = arguments?.getString(ARG_ERROR_MESSAGE)
        errorMessageTextView.text = errorMessage
        errorMessageTextView.setTextColor(Color.RED)
    }
}
