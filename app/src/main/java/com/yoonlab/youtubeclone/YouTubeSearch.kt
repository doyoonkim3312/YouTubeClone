package com.yoonlab.youtubeclone

import com.google.gson.annotations.SerializedName

data class YouTubeSearch (
        @SerializedName ("kind") val kind: String,
        @SerializedName ("etag") val etag: String,
        @SerializedName ("nextPageToken") val nextPageToken: String,
        @SerializedName ("regionCode") val regionCode: String,
        @SerializedName ("pageInfo") val pageInfo: List<Info>,
        @SerializedName ("items") val items: List<Item>
        ) {
}
data class Info (
        @SerializedName ("totalResult") val totalResult: Int,
        @SerializedName ("resultsPerPage") val resultsPerPage: Int
        )
data class Item(
        @SerializedName ("kind") val kind: String,
        @SerializedName ("etag") val etag: String,
        @SerializedName ("id") val id: List<Id>,
        @SerializedName ("snippet") val snippet: List<Snippet>,
        @SerializedName ("thumbnails") val thumbnails: List<Thumbnail>,
        @SerializedName ("channelTitle") val channelTitle: String,
        @SerializedName ("publishTime") val publishTime: String

)
data class Id(
        @SerializedName ("kind") val kind: String,
        @SerializedName ("videoId") val videoId: String?
)
data class Snippet(
        @SerializedName ("publishedAt") val publishedAt: String,
        @SerializedName ("channelId") val channelId: String,
        @SerializedName ("title") val title: String,
        @SerializedName ("description") val description: String,
)
data class Thumbnail(
        @SerializedName ("default") val default: ThumbnailDetails,
        @SerializedName ("medium") val medium: ThumbnailDetails,
        @SerializedName ("high") val high: ThumbnailDetails

)
    data class ThumbnailDetails(
            @SerializedName ("url") val url: String,
            @SerializedName ("width") val width: Int?,
            @SerializedName ("height") val height: Int?
    )