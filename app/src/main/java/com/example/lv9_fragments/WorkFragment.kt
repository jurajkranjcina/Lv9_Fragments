package com.example.lv9_fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.Fragment

class WorkFragment : Fragment() {
    private lateinit var work: Work
    private lateinit var titleField: EditText
    private lateinit var dateButton: Button
    private lateinit var doneCheckBox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        work = Work()
    }

    override fun OnCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_work, container, false)


        titleField = view.findViewById(R.id.work_title) as EditText
        dateButton = view.findViewById(R.id.work_date) as Button
        doneCheckBox = view.findViewById(R.id.work_done) as CheckBox


        dateButton.apply {
            text = work.date.toString()
            isEnabled = true
        }
        return view
    }

    override fun onStart() {
        super.onStart()
        val titleWatcher = object : TextWatcher {
            override fun beforeTextChanged(
                sequence: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(
                sequence: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {
                work.title = sequence.toString()
            }

            override fun afterTextChanged(p0: Editable?) {
                //This one tco
            }

        }

        titleField.addTextChangedListener(titleWatcher)

        doneCheckBox.apply {
            setOnCheckedChangeListener{_,isCheched ->
                work.isDone = isCheched
            }
        }


    }






}