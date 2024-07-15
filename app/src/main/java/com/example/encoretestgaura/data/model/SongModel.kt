package com.example.encoretestgaura.data.model

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

import org.simpleframework.xml.*


@Root(name = "feed", strict = false)
data class Feed @JvmOverloads constructor(
    @field: ElementList(inline = true, required = false)
    var itemList: List<Entry>? = null)

@Root(name = "entry", strict = false)
data class Entry @JvmOverloads constructor(
    @field:Element(name = "id", required = false)
    var id: Id? = null,
    @field:Element(name = "name", required = false)
    var name: String? = null,
    @field:Element(name = "artist", required = false)
    var artist: String? = null,
    @field:Element(name = "price", required = false)
    var price: String? = null,
    @field:Element(name = "releaseDate", required = false)
    var imReleaseDate: ReleaseDate? = null,
    @field:ElementList(inline = true, entry = "image", required = false)
    var imImage: List<ImImage>? = null,
    @field:Element(name = "rights", required = false)
    var rights: String? = null,

    )

@Root(name = "id", strict = false)
data class Id @JvmOverloads constructor(
    @field:Attribute(name = "id", required = false)
    var imId: String? = null
)

@Root(name = "im:image", strict = false)
data class ImImage @JvmOverloads constructor(
    @field:Attribute(name = "height", required = false)
    var height: String? = null,
    @field:Text(required = false)
    var content: String? = null
)

@Root(name = "im:releaseDate", strict = false)
data class ReleaseDate @JvmOverloads constructor(
    @field:Attribute(name = "label", required = false)
    var label: String? = null,
)



