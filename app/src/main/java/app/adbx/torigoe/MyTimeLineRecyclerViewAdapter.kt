package app.adbx.torigoe

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


import app.adbx.torigoe.TimeLineFragment.OnListFragmentInteractionListener
import app.adbx.torigoe.twitter.TweetContent.TweetItem

import kotlinx.android.synthetic.main.fragment_timeline.view.*

/**
 * [RecyclerView.Adapter] that can display a [TweetItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class MyTimeLineRecyclerViewAdapter(
        private val mValues: List<TweetItem>,
        private val mListener: OnListFragmentInteractionListener?)
    : RecyclerView.Adapter<MyTimeLineRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as TweetItem
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_timeline, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.mIdView.text = item.id
        holder.mUserIdView.text = item.userid
        holder.mUserNameView.text = item.username
        holder.mMessageView.text = item.message
        holder.mTweetDateView.text = item.date.toString()
        holder.mReplyView.text = item.reply.toString()
        holder.mReTweetView.text = item.retweet.toString()
        holder.mFavoriteView.text = item.favorite.toString()

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView = mView.item_number
        val mUserIdView: TextView = mView.userid
        val mUserNameView: TextView = mView.username
        val mTweetDateView: TextView = mView.tweetdate
        val mMessageView: TextView = mView.message

        val mReplyView: TextView = mView.reply
        val mReTweetView: TextView = mView.retweet
        val mFavoriteView: TextView = mView.favorite

        override fun toString(): String {
            return super.toString() + " '" + mMessageView.text + "'"
        }
    }
}
