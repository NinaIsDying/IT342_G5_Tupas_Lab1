package com.example.wildcatsden

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class SignInModal : DialogFragment() {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnContinue: Button
    private lateinit var tvSignUp: TextView
    private lateinit var tvError: TextView

    private var listener: SignInListener? = null

    interface SignInListener {
        fun onSignInSuccess()
        fun onSignUpClick()
        fun onModalDismiss()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = parentFragment as? SignInListener ?: context as? SignInListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.modal_signin, null)

        initViews(view)
        setupClickListeners()

        builder.setView(view)
        return builder.create()
    }

    private fun initViews(view: View) {
        etEmail = view.findViewById(R.id.etEmail)
        etPassword = view.findViewById(R.id.etPassword)
        btnContinue = view.findViewById(R.id.btnContinue)
        tvSignUp = view.findViewById(R.id.tvSignUp)
        tvError = view.findViewById(R.id.tvError)
    }

    private fun setupClickListeners() {
        btnContinue.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (validateInput(email, password)) {
                performSignIn(email, password)
            }
        }

        tvSignUp.setOnClickListener {
            dismiss()
            listener?.onSignUpClick()
        }
    }

    private fun validateInput(email: String, password: String): Boolean {
        tvError.visibility = View.GONE

        when {
            email.isEmpty() -> {
                showError("Email is required")
                return false
            }
            !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                showError("Please enter a valid email address")
                return false
            }
            password.isEmpty() -> {
                showError("Password is required")
                return false
            }
            password.length < 8 -> {
                showError("Password must be at least 8 characters")
                return false
            }
        }
        return true
    }

    private fun showError(message: String) {
        tvError.text = message
        tvError.visibility = View.VISIBLE
    }

    private fun performSignIn(email: String, password: String) {
        // TODO: Replace with actual API call
        // This is mock implementation
        btnContinue.isEnabled = false
        btnContinue.text = "Signing In..."

        // Simulate API call
        android.os.Handler(Looper.getMainLooper()).postDelayed({
            // Mock successful login
            if (email.contains("@") && password.length >= 8) {
                Toast.makeText(context, "Login successful", Toast.LENGTH_SHORT).show()
                dismiss()
                listener?.onSignInSuccess()
            } else {
                showError("Invalid email or password")
                btnContinue.isEnabled = true
                btnContinue.text = "Continue"
            }
        }, 1500)
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        listener?.onModalDismiss()
    }

    companion object {
        const val TAG = "SignInModal"
    }
}