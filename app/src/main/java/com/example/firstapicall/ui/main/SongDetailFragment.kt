package com.example.firstapicall.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.firstapicall.R
import com.example.firstapicall.databinding.FragmentMainBinding
import com.example.firstapicall.databinding.FragmentSongDetailBinding
import com.squareup.picasso.Picasso


class SongDetailFragment : Fragment() {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: FragmentSongDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSongDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val title = requireArguments().getString("title")
        val artist = requireArguments().getString("artist")
        val image = requireArguments().getString("image")

        binding.songDetailTitle.text = title
        binding.songDetailArtist.text = artist
        Picasso.get().load(image).into(binding.songDetailImg)

        binding.downloadBtn.setOnClickListener {
            Toast.makeText(requireContext(), "Downloading...", Toast.LENGTH_LONG).show()
        }

        binding.backBtn.setOnClickListener {
            findNavController().navigateUp()
        }

    }

    }