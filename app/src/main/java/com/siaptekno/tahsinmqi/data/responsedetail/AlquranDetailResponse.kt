package com.siaptekno.tahsinmqi.data.responsedetail

import com.google.gson.annotations.SerializedName

data class AlquranDetailResponse(

	@field:SerializedName("code")
	val code: Int,

	@field:SerializedName("data")
	val data: Data,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: String
)

data class Name(

	@field:SerializedName("translation")
	val translation: Translation,

	@field:SerializedName("short")
	val jsonMemberShort: String,

	@field:SerializedName("long")
	val jsonMemberLong: String,

	@field:SerializedName("transliteration")
	val transliteration: Transliteration
)

data class Text(

	@field:SerializedName("transliteration")
	val transliteration: Transliteration,

	@field:SerializedName("arab")
	val arab: String
)

data class Translation(

	@field:SerializedName("en")
	val en: String,

	@field:SerializedName("id")
	val id: String
)

data class VersesItem(

	@field:SerializedName("number")
	val number: Number,

	@field:SerializedName("meta")
	val meta: Meta,

	@field:SerializedName("translation")
	val translation: Translation,

	@field:SerializedName("tafsir")
	val tafsir: Tafsir,

	@field:SerializedName("text")
	val text: Text,

	@field:SerializedName("audio")
	val audio: Audio
)

data class Tafsir(

	@field:SerializedName("id")
	val id: String
)

data class Number(

	@field:SerializedName("inQuran")
	val inQuran: Int,

	@field:SerializedName("inSurah")
	val inSurah: Int
)

data class Meta(

	@field:SerializedName("hizbQuarter")
	val hizbQuarter: Int,

	@field:SerializedName("ruku")
	val ruku: Int,

	@field:SerializedName("manzil")
	val manzil: Int,

	@field:SerializedName("page")
	val page: Int,

	@field:SerializedName("sajda")
	val sajda: Sajda,

	@field:SerializedName("juz")
	val juz: Int
)

data class Audio(

	@field:SerializedName("secondary")
	val secondary: List<String>,

	@field:SerializedName("primary")
	val primary: String
)

data class Transliteration(

	@field:SerializedName("en")
	val en: String,

	@field:SerializedName("id")
	val id: String
)

data class Sajda(

	@field:SerializedName("obligatory")
	val obligatory: Boolean,

	@field:SerializedName("recommended")
	val recommended: Boolean
)

data class Revelation(

	@field:SerializedName("en")
	val en: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("arab")
	val arab: String
)

data class Id(

	@field:SerializedName("short")
	val jsonMemberShort: String,

	@field:SerializedName("long")
	val jsonMemberLong: String
)

data class Data(

	@field:SerializedName("number")
	val number: Int,

	@field:SerializedName("sequence")
	val sequence: Int,

	@field:SerializedName("numberOfVerses")
	val numberOfVerses: Int,

	@field:SerializedName("revelation")
	val revelation: Revelation,

	@field:SerializedName("name")
	val name: Name,

	@field:SerializedName("tafsir")
	val tafsir: Tafsir,

	@field:SerializedName("preBismillah")
	val preBismillah: Any,

	@field:SerializedName("verses")
	val verses: List<VersesItem>
)
