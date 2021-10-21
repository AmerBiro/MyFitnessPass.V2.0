package my.myfitness.myfitnesspass.ui

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import my.myfitness.myfitnesspass.R
import my.myfitness.myfitnesspass.databinding.FragmentBlankBinding
import my.myfitness.myfitnesspass.other.Status


@AndroidEntryPoint
class BlankFragment : BaseFragment(R.layout.fragment_blank) {

    private val viewModel: SignUpViewModel by viewModels()

    private var _binding: FragmentBlankBinding? = null
    private val binding get() = _binding!!

    private lateinit var view2: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBlankBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view2 = view

        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        subscribeToObservers()

        binding.buttonSignup.setOnClickListener {
            val email = binding.email.text.toString()
            val password = binding.password1.text.toString()
            val confirmedPassword = binding.password2.text.toString()
            viewModel.register(email, password, confirmedPassword)
        }
    }

    private fun subscribeToObservers() {
        viewModel.registerStatus.observe(viewLifecycleOwner, Observer { result ->
            result?.let {
                when(result.status) {
                    Status.SUCCESS -> {
                        binding.progressBar.visibility = View.GONE
                        showSnackBar(view2, result.data ?: "Successfully registered an account")
                    }
                    Status.ERROR -> {
                        binding.progressBar.visibility = View.GONE
                        showSnackBar(view2, result.message ?: "An unknown error occurred")
                    }
                    Status.LOADING -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }
                }
            }
        })
    }

}