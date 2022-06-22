package br.com.zup.minhamusicafavorita.album.repository

import br.com.zup.minhamusicafavorita.R
import br.com.zup.minhamusicafavorita.album.model.Album

class AlbumRepository {
    fun getListAlbum(): List<Album> {
        val listAlbum = mutableListOf<Album>()

        listAlbum.add(
            Album(
                R.drawable.high_voltage_acdc,
                "High Voltage",
                "High Voltage é o álbum de estreia da banda de rock australiana, AC/DC, lançado em 17 de fevereiro de 1975, apenas na Austrália.",
                "AC/DC",
                1975,
                "Albert Productions",
                "Columbia Records",
                "Disco",
                "Rock, Hard rock, Blues-rock"
            )
        )

        listAlbum.add(
            Album(
                R.drawable.tnt_acdc,
                "T.N.T.",
                "T.N.T. é o segundo álbum de estúdio da banda de rock australiana AC/DC.",
                "AC/DC",
                1976,
                "Albert Productions",
                "Columbia Records",
                "Disco",
                "Rock, Hard rock, Blues-rock"
            )
        )

        listAlbum.add(
            Album(
                R.drawable.dirty_deeds_done_dirt_cheap_acdc,
                "Dirty Deeds Done Dirt Cheap (1976)",
                "Dirty Deeds Done Dirt Cheap é o terceiro álbum de estúdio da banda de rock australiana AC/DC, lançado a 20 de setembro de 1976.",
                "AC/DC",
                1976,
                "Albert Productions",
                "Columbia Records",
                "Disco",
                "Rock, Hard rock, Blues-rock, Heavy metal"
            )
        )

        return listAlbum
    }
}