package app.adbx.torigoe.twitter

import android.provider.ContactsContract
import java.sql.Time
import java.util.*

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object TweetContent {

    /**
     * An array of sample (tweet) items.
     */
    val ITEMS: MutableList<TweetItem> = ArrayList()

    /**
     * A map of sample (tweet) items, by ID.
     */
    val ITEM_MAP: MutableMap<String, TweetItem> = HashMap()

    private val COUNT = 200

    init {
        // Add some sample items.
        for (i in 1..COUNT) {
            addItem(createTweetItem(i))
        }
    }

    private fun addItem(item: TweetItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }

    private fun createTweetItem(position: Int): TweetItem {
        return TweetItem(position.toString(),
                "user" + position,
                "username" + position,
                Date(1577804400),
                "Tweet " + position,
                100 + position,
                200 + position,
                300 + position,
                makeDetails(position))
    }

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(position)
        for (i in 0..position - 1) {
            builder.append("\nMore details information here.")
        }
        return builder.toString()
    }

    /**
     * A tweet item representing a piece of content.
     */
    data class TweetItem(val id: String,val userid : String ,val username : String,val date: Date ,val message: String,val reply: Int,val retweet: Int,val favorite: Int, val details: String) {
        override fun toString(): String = message
    }
}
