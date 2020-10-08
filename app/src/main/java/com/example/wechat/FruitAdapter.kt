package com.example.wechat

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class FruitAdapter(context: Context, resource: Int, objects: MutableList<Fruit>) :
    ArrayAdapter<Fruit>(context, resource, objects) {
    private val resourceId = resource

    inner class ViewHolder(
        val fruitImage: ImageView,
        val fruitTitle: TextView,
        val fruitContent: TextView,
        val fruitTime:TextView
    )

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val viewHolder: ViewHolder

        val view: View

        if (convertView == null) {
            //获取视图
            view = LayoutInflater.from(context).inflate(resourceId, parent, false)
            //获取图片
            val fruitImage: ImageView = view.findViewById(R.id.fruitImage)
            //获取文字
            val fruitTitle: TextView = view.findViewById(R.id.fruitTitle)
            val fruitContent: TextView = view.findViewById(R.id.fruitContent)
            //获取时间
            val fruitTime:TextView = view.findViewById(R.id.fruitTime)

            viewHolder = ViewHolder(fruitImage, fruitTitle, fruitContent,fruitTime)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val fruit = getItem(position)

        //把图片文字赋值到视图内
        if (fruit != null) {
            viewHolder.fruitImage.setImageResource(fruit.fruitImage)
            viewHolder.fruitTitle.text = fruit.fruitTitle
            viewHolder.fruitContent.text = fruit.fruitContent
            viewHolder.fruitTime.text = getTime()
        }
        return view
    }

    fun getTime(): String {
        val date = Date()
        val dateFormat = SimpleDateFormat("HH:mm:ss", Locale.CHINA)
        return dateFormat.format(date)
    }
}



