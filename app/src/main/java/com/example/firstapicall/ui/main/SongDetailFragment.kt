package com.example.firstapicall.ui.main

import android.os.Bundle
import coil.load
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.firstapicall.databinding.FragmentSongDetailBinding


class SongDetailFragment : Fragment() {
    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var binding: FragmentSongDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSongDetailBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val trackId = requireArguments().getInt("trackId")

        viewModel.songs.observe(viewLifecycleOwner){ songs ->
            val song = songs.find { it.trackId == trackId }

            if (song != null){
                binding.songDetailArtist.text = song.artist
                binding.songDetailTitle.text = song.track
                binding.songDetailImg.load(song.artResource)
            }

        }


        binding.downloadBtn.setOnClickListener {
            Toast.makeText(requireContext(), "Downloading...", Toast.LENGTH_LONG).show()
        }

        binding.backBtn.setOnClickListener {
            findNavController().navigateUp()
        }

    }

    }