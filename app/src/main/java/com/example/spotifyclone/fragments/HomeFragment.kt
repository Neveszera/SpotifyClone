package com.example.spotifyclone.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spotifyclone.R
import com.example.spotifyclone.adapters.PlaylistAdapter
import com.example.spotifyclone.databinding.FragmentHomeBinding
import com.example.spotifyclone.models.Playlist

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        val playlists = listOf(
            Playlist("Brasil Sertanejo", R.drawable.sertanejo_image, "Os sucessos mais recentes e os clássicos do sertanejo que todo mundo ama."),
            Playlist("Pop Hits Brasil", R.drawable.pop_hits_image, "As músicas pop mais quentes do Brasil, com artistas que estão no topo das paradas."),
            Playlist("Indie Nacional", R.drawable.indie_nacional_image, "Uma seleção de músicas indie brasileiras, de novos talentos e bandas independentes."),
            Playlist("Electro Hits", R.drawable.electro_hits_image, "Os maiores sucessos da música eletrônica, desde os hits mais recentes até clássicos atemporais.")
        )

        val podcasts = listOf(
            Playlist("Corinthians em Debate", R.drawable.corinthians_image, "Tudo sobre o Corinthians: análises de jogos, entrevistas com jogadores e histórias marcantes do clube."),
            Playlist("Economia em Foco", R.drawable.economia_image, "Análises e debates sobre economia, finanças e o mercado global."),
            Playlist("Mundo Animal", R.drawable.reino_animal_image, "Descubra curiosidades e informações sobre a vida animal ao redor do mundo."),
        )

        val audiobooks = listOf(
            Playlist("Diário de um Banana:", R.drawable.diario_banana_image, "No terceiro livro da série, Greg Heffley enfrenta uma série de desafios enquanto tenta navegar pelas situações complicadas da escola e da vida em família. Uma leitura divertida e cheia de peripécias."),
            Playlist("A Revolução dos Robôs", R.drawable.robo_image, "Um olhar sobre a evolução da robótica e seu impacto no futuro do trabalho e da sociedade."),
        )

        val playlistAdapter = PlaylistAdapter(playlists)
        val podcastAdapter = PlaylistAdapter(podcasts)
        val audiobookAdapter = PlaylistAdapter(audiobooks)

        binding.recyclerViewPlaylists.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewPlaylists.adapter = playlistAdapter

        binding.recyclerViewPodcasts.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewPodcasts.adapter = podcastAdapter

        binding.recyclerViewAudiobooks.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewAudiobooks.adapter = audiobookAdapter

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
