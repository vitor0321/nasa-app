package com.nasa.nasaApp.view.resource

import cafe.adriel.lyricist.LyricistStrings

@LyricistStrings(languageTag = Locales.PT, default = false)
internal val StringsPt = Strings(
    components = Components(
        loading = "carregando...",
        error = "hummm... alguma coisa aconteceu!",
        astronomyPictureOfDay = "Foto do dia da Astronomia",
        discoverTheCosmos = """Descubra o cosmos! 
            |Cada dia uma foto diferente 
            |do nosso facinante universo é apresentada, 
            |junto com uma breve descrição escrita por 
            |um profisional astrônoma.""".trimMargin(),
        copyright = "Creditos e Copyright: ",
        video = "Video:  ",
        selectDate = "selecione uma data",
        cancel = "Cancelar",
        ok = "OK",
    ),
)
