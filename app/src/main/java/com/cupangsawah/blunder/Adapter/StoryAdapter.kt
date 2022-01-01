package com.cupangsawah.blunder.Adapter

import android.content.Context
import android.content.Intent
import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.cupangsawah.blunder.AddStoryActivity
import com.cupangsawah.blunder.MainActivity
import com.cupangsawah.blunder.Model.Story
import com.cupangsawah.blunder.Model.User
import com.cupangsawah.blunder.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.fragment_profile.view.*
import java.security.AccessController.getContext

class StoryAdapter (private val mContext: Context, private val mStory: List<Story>) :
RecyclerView.Adapter<StoryAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

       return if (viewType == 0)
        {
            val view = LayoutInflater.from(mContext).inflate(R.layout.add_story_item, parent, false)
            ViewHolder(view)
        }
        else{
            val view = LayoutInflater.from(mContext).inflate(R.layout.story_item, parent, false)
           ViewHolder(view)
        }
    }


    override fun getItemCount(): Int {
        return mStory.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val story = mStory[position]

        userInfo(holder, story.getUserId(), position)

        holder.itemView.setOnClickListener {
            val intent = Intent(mContext, AddStoryActivity::class.java)
            intent.putExtra("userid", story.getUserId())
            mContext.startActivity(intent)
        }
    }


    inner class ViewHolder(@NonNull itemView: View) : RecyclerView.ViewHolder(itemView){
        //StoryItem
        var story_image_seen: CircleImageView? = null
        var story_image: CircleImageView? = null
        var story_username: TextView? = null

        //AddStoryItem
        var story_plus_btn: ImageView? = null
        var addStory_text: TextView? = null


        init{
            //StoryItem.xml
            story_image_seen = itemView.findViewById(R.id.story_image_seen)
            story_image = itemView.findViewById(R.id.story_image)
            story_username = itemView.findViewById(R.id.story_username)

            //AddStoryItem
            story_plus_btn = itemView.findViewById(R.id.story_add)
            addStory_text = itemView.findViewById(R.id.add_story_text)

        }

    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0)
        {
            return 0
        }
        return 1
    }




    private fun userInfo(viewHolder: ViewHolder, userId: String, position: Int)
    {
        val usersRef = FirebaseDatabase.getInstance().getReference().child("Users").child(userId)
        usersRef.addValueEventListener(object : ValueEventListener
        {
            override fun onDataChange(p0: DataSnapshot) {

                if (p0.exists())
                {
                    val user = p0.getValue<User>(User::class.java)

//                    Picasso.get().load(user!!.getImage())
//                        .placeholder(R.drawable.profile)
//                        .into(viewHolder.story_image)

//                    Picasso.get().load(user!!.getImage())
//                        .placeholder(R.drawable.profile)
//                        .into(viewHolder.story_image)


                    if (position!=0)
                    {
                        Picasso.get().load(user!!.getImage()).placeholder(R.drawable.profile).into(viewHolder.story_image_seen)
                        viewHolder?.story_username!!.text = user.getUsername()
                    }



                }
            }

            override fun onCancelled(p0: DatabaseError) {

            }
        })
    }

}